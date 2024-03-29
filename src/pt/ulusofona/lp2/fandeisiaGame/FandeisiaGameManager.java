package pt.ulusofona.lp2.fandeisiaGame;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FandeisiaGameManager {
    private List<Creature> creatures;
    private List<Treasure> treasures;
    private List<Hole> holes;
    private Team ldr10 = new Ldr10();
    private Team resistencia20 = new Resistencia20();
    private int currentTeamId;
    private int rows;
    private int columns;
    private int treasuresFound;
    private int numeroJogadas;
    private int numeroJogadasZero;
    private HashMap<Point, String> feiticos;
    private HashMap<Point, String> posicoesOcupadas;

    public FandeisiaGameManager() {
        creatures = new ArrayList<>();
        treasures = new ArrayList<>();
        holes = new ArrayList<>();
        treasuresFound = 0;
        numeroJogadas = 0;
        currentTeamId = 10;
        numeroJogadasZero = 0;
        feiticos = new HashMap<>();
        posicoesOcupadas = new HashMap<>();
    }

    public String[][] getCreatureTypes() {
        /*Deve retornar os tipos de criatura que existem no jogo e que podem ser
        escolhidos para os exércitos dos dois jogadores.*/
        String[][] creaturesString = new String[5][4];
        creaturesString[0][0] = "Anão";
        creaturesString[0][1] = "anao.png";
        creaturesString[0][2] = "1 casa (posição) de cada vez | 90º";
        creaturesString[0][3] = "1";

        creaturesString[1][0] = "Dragão";
        creaturesString[1][1] = "dragon.png";
        creaturesString[1][2] = "3 casas (posições) de cada vez\n ○ Pode-se mover na horizontal, na vertical e também nas diagonais";
        creaturesString[1][3] = "9";

        creaturesString[2][0] = "Elfo";
        creaturesString[2][1] = "elf.png";
        creaturesString[2][2] = "2 casas (posições) de cada vez\n Pode-se mover na horizontal, na vertical e nas diagonais";
        creaturesString[2][3] = "5";

        creaturesString[3][0] = "Gigante";
        creaturesString[3][1] = "giant.png";
        creaturesString[3][2] = "3 casas (posições) de cada vez\n Pode mover na horizontal e na vertical";
        creaturesString[3][3] = "5";

        creaturesString[4][0] = "Humano";
        creaturesString[4][1] = "human.png";
        creaturesString[4][2] = "2 casas de cada vez\n Pode-se mover na horizontal e na vertical";
        creaturesString[4][3] = "3";


        return creaturesString;
    }

    public String[][] getSpellTypes() {
        /*Deve retornar os tipos de feitiço que
        existem no jogo e que podem ser escolhidos
        por cada uma das equipas no decorrer do mesmo*/

        String[][] spellsString = new String[9][3];
        spellsString[0][0] = "EmpurraParaNorte";
        spellsString[0][1] = "Move a criatura 1 unidade para Norte.";
        spellsString[0][2] = "1";

        spellsString[1][0] = "EmpurraParaEste";
        spellsString[1][1] = "Move a criatura 1 unidade para Este.";
        spellsString[1][2] = "1";

        spellsString[2][0] = "EmpurraParaSul";
        spellsString[2][1] = "Move a criatura 1 unidade para Sul.";
        spellsString[2][2] = "1";

        spellsString[3][0] = "EmpurraParaOeste";
        spellsString[3][1] = "Move a criatura 1 unidade para Oeste.";
        spellsString[3][2] = "1";

        spellsString[4][0] = "ReduzAlcance";
        spellsString[4][1] = "Reduz o alcance da criatura: MIN (alcance original, 1)";
        spellsString[4][2] = "2";

        spellsString[5][0] = "DuplicaAlcance";
        spellsString[5][1] = "Aumenta o alcance da criatura para o dobro.";
        spellsString[5][2] = "3";

        spellsString[6][0] = "Congela";
        spellsString[6][1] = "A criatura alvo não se move neste turno.";
        spellsString[6][2] = "3";

        spellsString[7][0] = "Congela4Ever"; // AI
        spellsString[7][1] = "A criatura alvo não se move mais até ao final do jogo.";
        spellsString[7][2] = "10";

        spellsString[8][0] = "Descongela";
        spellsString[8][1] = "Inverte a aplicação de um Feitiço Congela4Ever.";
        spellsString[8][2] = "8";

        return spellsString;
    }

    public void toggleAI(boolean active) {

    }

    public Map<String, List<String>> getStatistics() {
        Map<String, List<String>> mapa = new HashMap<>();
        //as3MaisCarregadas
        List<String> maisCarregadas3 = creatures.stream()
                .filter((c) -> c.getTesourosEncontrados() > 0)
                .sorted((c1, c2) -> c2.getTesourosEncontrados() - c1.getTesourosEncontrados())
                .limit(3)
                .map((c) -> c.getId() + ":" + c.getTesourosEncontrados())
                .collect(Collectors.toList());

        mapa.put("as3MaisCarregadas", maisCarregadas3);

        //as5MaisRicas
        List<String> as5MaisRicas = creatures.stream()
                .sorted((c1, c2) -> c2.getTesourosEncontrados() - c1.getTesourosEncontrados())
                .sorted((c1, c2) -> c2.getPontos() - c1.getPontos())
                .limit(5)
                .map((c) -> c.getId() + ":" + c.getPontos() + ":" + c.getTesourosEncontrados())
                .collect(Collectors.toList());

        mapa.put("as5MaisRicas", as5MaisRicas);

        //osAlvosFavoritos
        List<String> osAlvosFavoritos = creatures.stream()
                .sorted((c1, c2) -> c2.getNrFeiticos() - c1.getNrFeiticos())
                .limit(3)
                .map((c) -> c.getId() + ":" + c.getIdEquipa() + ":" + c.getNrFeiticos())
                .collect(Collectors.toList());

        mapa.put("osAlvosFavoritos", osAlvosFavoritos);

        //as3MaisViajadas
        List<String> as3MaisViajadas = creatures.stream()
                .sorted((c1, c2) -> c2.getKms() - c1.getKms())
                .limit(3)
                .sorted((c1,c2)->c1.getKms() - c2.getKms())
                .map((c) -> c.getId() + ":" + c.getKms())
                .collect(Collectors.toList());

        mapa.put("as3MaisViajadas", as3MaisViajadas);

        //tiposDeCriaturaESeusTesouros
        List<String> tiposDeCriaturaESeusTesouros = new ArrayList<>();
        float nrDragao;
        float nrElfo;
        float nrHumano;
        float nrGigante;
        float nrAnao;

        nrAnao = creatures.stream()
                .filter((c) -> c instanceof Anao)
                .count();

        nrDragao = creatures.stream()
                .filter((c) -> c instanceof Dragao)
                .count();

        nrElfo = creatures.stream()
                .filter((c) -> c instanceof Elfo)
                .count();


        nrHumano = creatures.stream()
                .filter((c) -> c instanceof Humano)
                .count();

        nrGigante = creatures.stream()
                .filter((c) -> c instanceof Gigante)
                .count();


        Map<String, Long> map = creatures.stream()
                .collect(groupingBy(Creature::getType, counting()));

        Map<String, Integer> map2 = creatures.stream()
                .collect(groupingBy(Creature::getType, Collectors.summingInt(Creature::getTesourosEncontrados)));

        map.entrySet().stream()
                .sorted((e1, e2) -> (int) (e1.getValue() - e2.getValue()))
                .sorted((e1, e2) -> map2.get(e2.getKey()) - map2.get(e1.getKey()))
                .forEach((e) -> tiposDeCriaturaESeusTesouros.add(e.getKey() + ":" + e.getValue() + ":" + map2.get(e.getKey())));

        List<String> ordenar = new ArrayList<>();

        if (nrDragao == 0) {
            ordenar.add("Dragão:0:-1");
        }
        if (nrElfo == 0) {
            ordenar.add("Elfo:0:-1");
        }
        if (nrHumano == 0) {
            ordenar.add("Humano:0:-1");
        }
        if (nrGigante == 0) {
            ordenar.add("Gigante:0:-1");
        }
        if (nrAnao == 0) {
            ordenar.add("Anão:0:-1");
        }
        ordenar.stream()
                .sorted(String::compareTo)
                .forEach(tiposDeCriaturaESeusTesouros::add);

        mapa.put("tiposDeCriaturaESeusTesouros", tiposDeCriaturaESeusTesouros);

        return mapa;
    }

    public Map<String, Integer> createComputerArmy() {
        Random gerador = new Random();
        int qtdAnao = gerador.nextInt(10) + 1; // 1 a 10
        int qtdDragao = 1;
        int qtdElfo = gerador.nextInt(3) + 1; // 1 a 2
        int qtdGigante = 1;
        int qtdHumano = gerador.nextInt(4) + 1; // 1 a 3
        if (qtdAnao > 5) {
            qtdHumano += 2;
            qtdDragao = 0;
        }
        Map<String, Integer> army = new HashMap<>();
        army.put("Dragão", qtdDragao);
        army.put("Anão", qtdAnao);
        army.put("Elfo", qtdElfo);
        army.put("Gigante", qtdGigante);
        army.put("Humano", qtdHumano);
        return army;
    }

    public boolean enchant(int x, int y, String spellName) {
        Point p = new Point(x, y);
        /*Aplica o feitiço indicado à criatura que
        estiver nas coordenadas indicadas.
        Caso não seja possível aplicar o feitiço (por exemplo, nessas coordenadas não está uma criatura,
        ou esse feitiço iria levar a criatura para um buraco) deve retornar false.*/
        Creature creature = getCreature(x, y);
        if (creature == null) {
            return false;
        }
        if (feiticos.get(p) != null) {
            return false;
        }
        if (spellName == null) {
            return false;
        }
        if (spellName.equals("EmpurraParaNorte")) {
            if (y - 1 >= 0 && getType(x, y - 1) == null) {
                if (posicoesOcupadas.get(new Point(x, y - 1)) == null && removeMoedas(getCurrentTeamId(), valorFeitico("EmpurraParaNorte"))) {
                    feiticos.put(p, "EmpurraParaNorte");
                    posicoesOcupadas.put(new Point(x, y - 1), "EmpurraParaNorte");
                    creature.addnrFeiticos();
                    return true;
                }
            } else {
                return false;
            }
        }
        if (spellName.equals("EmpurraParaEste")) {
            if (x + 1 < columns && getType(x + 1, y) == null) {
                if (posicoesOcupadas.get(new Point(x + 1, y)) == null && removeMoedas(getCurrentTeamId(), valorFeitico("EmpurraParaEste"))) {
                    feiticos.put(p, "EmpurraParaEste");
                    posicoesOcupadas.put(new Point(x + 1, y), "EmpurraParaEste");
                    creature.addnrFeiticos();
                    return true;
                }
            } else {
                return false;
            }
        }
        if (spellName.equals("EmpurraParaSul")) {
            if (y + 1 < rows && getType(x, y + 1) == null) {
                if (posicoesOcupadas.get(new Point(x, y + 1)) == null && removeMoedas(getCurrentTeamId(), valorFeitico("EmpurraParaSul"))) {
                    feiticos.put(p, "EmpurraParaSul");
                    posicoesOcupadas.put(new Point(x, y + 1), "EmpurraParaSul");
                    creature.addnrFeiticos();
                    return true;
                }
            } else {
                return false;
            }
        }
        if (spellName.equals("EmpurraParaOeste")) {
            if (x - 1 >= 0 && getType(x - 1, y) == null) {
                if (posicoesOcupadas.get(new Point(x - 1, y)) == null && removeMoedas(getCurrentTeamId(), valorFeitico("EmpurraParaOeste"))) {
                    feiticos.put(p, "EmpurraParaOeste");
                    posicoesOcupadas.put(new Point(x - 1, y), "EmpurraParaOeste");
                    creature.addnrFeiticos();
                    return true;
                }
            } else {
                return false;
            }
        }
        if (spellName.equals("ReduzAlcance")) {
            Point p2 = creature.simulaMovimentoStepMinimo();
            if (getType(p2.x, p2.y) == null && removeMoedas(getCurrentTeamId(), valorFeitico("ReduzAlcance"))) {
                feiticos.put(p, "ReduzAlcance");
                creature.addnrFeiticos();
                return true;
            }
            return false;
        }
        if (spellName.equals("DuplicaAlcance")) {
            Point p2 = creature.simulaMovimentoDuplicado();
            if (p2.x >= rows || p2.y >= columns || p2.x < 0 || p2.y < 0) {
                return false;
            }
            if (getType(p2.x, p2.y) == null && removeMoedas(getCurrentTeamId(), valorFeitico("DuplicaAlcance"))) {
                feiticos.put(p, "DuplicaAlcance");
                creature.addnrFeiticos();
                return true;
            }
            return false;
        }
        if (spellName.equals("Congela")) {
            if (removeMoedas(getCurrentTeamId(), valorFeitico("Congela"))) {
                feiticos.put(p, "Congela");
                creature.addnrFeiticos();
                return true;
            }
            return false;
        }
        if (spellName.equals("Congela4Ever")) {
            if (!creature.isCongeladoForever() && removeMoedas(getCurrentTeamId(), valorFeitico("Congela4Ever"))) {
                feiticos.put(p, "Congela4Ever");
                creature.addnrFeiticos();
                return true;
            }
            return false;
        }
        if (spellName.equals("Descongela")) {
            if (creature.isCongeladoForever() && removeMoedas(getCurrentTeamId(), valorFeitico("Descongela"))) {
                feiticos.put(p, "Descongela");
                creature.addnrFeiticos();
                return true;
            }
            return false;
        }
        return false;
    }

    public void aplicarFeitico(int x, int y, String spellName) {
        Creature creature = getCreature(x, y);
        if (creature == null) {
            return;
        }
        if (spellName.equals("EmpurraParaNorte")) {
            if (getType(x, y - 1) == null) {
                creature.stepY(-1);
            }
        }
        if (spellName.equals("EmpurraParaEste")) {
            if (getType(x + 1, y) == null) {
                creature.stepX(1);
            }
        }
        if (spellName.equals("EmpurraParaSul")) {
            if (getType(x, y + 1) == null) {
                creature.stepY(1);
            }
        }
        if (spellName.equals("EmpurraParaOeste")) {
            if (getType(x - 1, y) == null) {
                creature.stepX(-1);
            }
        }
        if (spellName.equals("ReduzAlcance")) {
            creature.alcanceMinimo();
        }
        if (spellName.equals("DuplicaAlcance")) {
            creature.duplicaAlcance();
        }
        if (spellName.equals("Congela")) {
            creature.congela1Round();
        }
        if (spellName.equals("Congela4Ever")) {
            creature.congelaForever();
        }
        if (spellName.equals("Descongela")) {
            creature.descongelaForever();
        }
    }

    public int valorFeitico(String spellName) {
        if (spellName.equals("EmpurraParaNorte")) {
            return 1;
        }
        if (spellName.equals("EmpurraParaEste")) {
            return 1;
        }
        if (spellName.equals("EmpurraParaSul")) {
            return 1;
        }
        if (spellName.equals("EmpurraParaOeste")) {
            return 1;
        }
        if (spellName.equals("ReduzAlcance")) {
            return 2;
        }
        if (spellName.equals("DuplicaAlcance")) {
            return 3;
        }
        if (spellName.equals("Congela")) {
            return 3;
        }
        if (spellName.equals("Congela4Ever")) {
            return 10;
        }
        if (spellName.equals("Descongela")) {
            return 8;
        }
        return 0;
    }

    public String getSpell(int x, int y) {
        /*Retorna null ou o nome do feitiço está a ser aplicado à criatura na posição x,y*/
        Point p = new Point(x, y);
        return feiticos.get(p);
    }

    public int getCoinTotal(int teamID) {
        if (teamID == 10) {
            return ldr10.getMoedas();
        } else {
            return resistencia20.getMoedas();
        }
    }

    public int getCustoTotalCreaures(int teamID) {
        int coinTotal = 0;
        for (Creature c : creatures) {
            if (c.getIdEquipa() == teamID) {
                coinTotal += c.getCusto();
            }
        }
        return coinTotal;

    }

    public boolean saveGame(File fich) {
        /*Deve gravar o jogo actual para o ficheiro
        indicado no argumento.*/
        try {
            FileWriter writer = new FileWriter(fich);
            for (Creature c : creatures) {
                writer.write(c.toString() + "\n");
            }
            for (Treasure t : treasures) {
                writer.write(t.toString() + "\n");
            }
            for (Hole h : holes) {
                writer.write(h.toString() + "\n");
            }
            writer.write("\n");
            writer.write("Pontos10 " + ldr10.getScore() + "\n");
            writer.write("Pontos20 " + resistencia20.getScore() + "\n");
            writer.write("treasuresFound " + treasuresFound + "\n");
            writer.write("numeroJogadas " + numeroJogadas + "\n");
            writer.write("rows " + rows + "\n");
            writer.write("columns " + columns + "\n");
            writer.write("Moedas10 " + ldr10.getMoedas() + "\n");
            writer.write("Moedas20 " + resistencia20.getMoedas() + "\n");
            writer.write("currentTeamId " + currentTeamId + "\n");
            for (Creature c : creatures) {
                writer.write("C " + c.getX() + " " + c.getY() + " " + c.getTesourosGold() + " " + c.getTesourosSilver() + " " + c.getTesourosBronze() + " " + c.getTesourosEncontrados() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean loadGame(File fich) {
        clearAllData();
        InsufficientCoinsException.setTeam10Invalida(false);
        InsufficientCoinsException.setTeam20Invalida(false);
        Scanner scanner;
        ArrayList<String> conteudo = new ArrayList<>();
        String[] splitConteudo1;
        String[] splitConteudo2;
        String x1;
        String y1;
        int id;
        String tipo;
        int idEquipa;
        int pontos;
        int x;
        int y;
        String rdv;
        try {
            scanner = new Scanner(fich);
            while (scanner.hasNextLine()) {
                conteudo.add(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            return false;
        }
        for (String s : conteudo) {
            System.out.println(s);
            splitConteudo1 = s.split(" ", 7);
            if (splitConteudo1.length == 7 && !splitConteudo1[0].equals("C")) {
                splitConteudo2 = splitConteudo1[6].split(" ", 6);
                if (splitConteudo2[2].length() == 3) {
                    x1 = "" + splitConteudo2[2].charAt(1);
                } else {
                    x1 = "" + splitConteudo2[2].charAt(1) + splitConteudo2[2].charAt(2);
                }
                if (splitConteudo2[3].length() == 2) {
                    y1 = "" + splitConteudo2[3].charAt(0);
                } else {
                    y1 = "" + splitConteudo2[3].charAt(0) + splitConteudo2[3].charAt(1);
                }
                try {
                    id = Integer.parseInt(splitConteudo1[0]);
                    tipo = splitConteudo1[2];
                    idEquipa = Integer.parseInt(splitConteudo1[4]);
                    pontos = Integer.parseInt(splitConteudo2[0]);
                    x = Integer.parseInt(x1);
                    y = Integer.parseInt(y1);
                    rdv = splitConteudo2[4];
                } catch (NumberFormatException e) {
                    continue;
                }
                addCreaure(id, tipo, idEquipa, x, y, rdv, pontos);
            }
            if (splitConteudo1.length == 6) {
                if (splitConteudo1[4].length() == 3) {
                    x1 = "" + splitConteudo1[4].charAt(1);
                } else {
                    x1 = "" + splitConteudo1[4].charAt(1) + splitConteudo1[4].charAt(2);
                }
                if (splitConteudo1[5].length() == 2) {
                    y1 = "" + splitConteudo1[5].charAt(0);
                } else {
                    y1 = "" + splitConteudo1[5].charAt(0) + splitConteudo1[5].charAt(1);
                }
                try {
                    id = Integer.parseInt(splitConteudo1[0]);
                    tipo = splitConteudo1[2];
                    x = Integer.parseInt(x1);
                    y = Integer.parseInt(y1);
                } catch (NumberFormatException e) {
                    continue;
                }
                if (tipo.equals("hole")) {
                    addHole(id, x, y);
                } else {
                    addTreasure(id, tipo, x, y);
                }
            }
            if (splitConteudo1.length == 7 && splitConteudo1[0].equals("C")) {
                int bronze = 0;
                int silver = 0;
                int gold = 0;
                int encontrados = 0;
                try {
                    x = Integer.parseInt(splitConteudo1[1]);
                    y = Integer.parseInt(splitConteudo1[2]);
                    bronze = Integer.parseInt(splitConteudo1[5]);
                    silver = Integer.parseInt(splitConteudo1[4]);
                    gold = Integer.parseInt(splitConteudo1[3]);
                    encontrados = Integer.parseInt(splitConteudo1[6]);
                } catch (NumberFormatException e) {
                    continue;
                }
                Creature c = getCreature(x, y);
                if (c == null) {
                    continue;
                }
                c.setTesourosBronze(bronze);
                c.setTesourosGold(gold);
                c.setTesourosSilver(silver);
                c.setTesourosEncontrados(encontrados);
            }
            if (splitConteudo1.length == 2) {
                try {
                    switch (splitConteudo1[0]) {
                        case "Pontos10":
                            ldr10.setScore(Integer.parseInt(splitConteudo1[1]));
                            break;
                        case "Pontos20":
                            resistencia20.setScore(Integer.parseInt(splitConteudo1[1]));
                            break;
                        case "treasuresFound":
                            treasuresFound = Integer.parseInt(splitConteudo1[1]);
                            break;
                        case "numeroJogadas":
                            numeroJogadas = Integer.parseInt(splitConteudo1[1]);
                            break;
                        case "rows":
                            rows = Integer.parseInt(splitConteudo1[1]);
                            break;
                        case "columns":
                            columns = Integer.parseInt(splitConteudo1[1]);
                            break;
                        case "Moedas10":
                            ldr10.setMoedas(Integer.parseInt(splitConteudo1[1]));
                            InsufficientCoinsException.setMoedas10(getCustoTotalCreaures(10));
                            break;
                        case "Moedas20":
                            resistencia20.setMoedas(Integer.parseInt(splitConteudo1[1]));
                            InsufficientCoinsException.setMoedas20(getCustoTotalCreaures(20));
                            break;
                        case "currentTeamId":
                            currentTeamId = Integer.parseInt(splitConteudo1[1]);
                            break;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }
        return true;
    }

    public String whoIsLordEder() {
        /*Deve devolver o nome completo do ​Lord Éder.*/
        return "Ederzito António Macedo Lopes";
    }

    public int getNumberCreatures() {
        return creatures.size();
    }

    public int getNumberTreasures() {
        return treasures.size();
    }

    public int getNumberHoles() {
        return holes.size();
    }

    public void startGame(String[] content, int rows, int columns) throws InsufficientCoinsException {
        clearAllData();
       /* Deve inicializar as estruturas de dados relevantes para processar um jogo
       O array content irá descrever o conteúdo inicial do mundo (criaturas e
       tesouros), tendo para isso várias Strings. Cada String vai representar um objecto do mundo.
       Os argumentos rows e columns vão-nos indicar as dimensões do tabuleiro.*/
        ArrayList<String[]> creatureInfo = new ArrayList<>();
        ArrayList<String[]> treasureInfo = new ArrayList<>();
        ArrayList<String[]> holeInfo = new ArrayList<>();
        String[] infoFinalCreature;
        String[] infoFinalTreasure;
        String[] infoFinalHole;
        String[] split1;
        String[] split2;
        String[] split3;
        int count;
        for (String s : content) {
            split1 = s.split(",", 6);
            infoFinalCreature = new String[6];
            infoFinalTreasure = new String[4];
            infoFinalHole = new String[4];
            count = 0;
            if (split1.length == 6) {
                for (String s1 : split1) {
                    split2 = s1.split(" ", 6);
                    if (count == 0) {
                        infoFinalCreature[count] = split2[1];
                    } else {
                        infoFinalCreature[count] = split2[2];
                    }
                    count++;
                }
                creatureInfo.add(infoFinalCreature);
            }
            if (split1.length == 4 && (split1[1].equals(" type: bronze") || split1[1].equals(" type: gold") || split1[1].equals(" type: silver"))) {

                for (String s1 : split1) {
                    split3 = s1.split(" ", 4);
                    if (count == 0) {
                        infoFinalTreasure[count] = split3[1];
                    } else {
                        infoFinalTreasure[count] = split3[2];
                    }
                    count++;
                }
                treasureInfo.add(infoFinalTreasure);
            }

            if (split1.length == 4 && split1[1].equals(" type: hole")) {

                for (String s1 : split1) {
                    split3 = s1.split(" ", 4);
                    if (count == 0) {
                        infoFinalHole[count] = split3[1];
                    } else {
                        infoFinalHole[count] = split3[2];
                    }
                    count++;
                }
                holeInfo.add(infoFinalHole);
            }
        }

        for (String[] s1 : creatureInfo) {
            int id = 0;
            int teamId = 0;
            int x = 0;
            int y = 0;
            try {
                id = Integer.parseInt(s1[0]);
            } catch (NumberFormatException e) {
                continue;
            }

            String tipo = s1[1];
            try {
                teamId = Integer.parseInt(s1[2]);
            } catch (NumberFormatException e) {
                continue;
            }
            try {
                x = Integer.parseInt(s1[3]);
            } catch (NumberFormatException e) {
                continue;
            }
            try {
                y = Integer.parseInt(s1[4]);
            } catch (NumberFormatException e) {
                continue;
            }
            String orientation = s1[5];
            addCreaure(id, tipo, teamId, x, y, orientation);

        }
        for (String[] s2 : treasureInfo) {
            int id = 0;
            int x = 0;
            int y = 0;
            try {
                id = Integer.parseInt(s2[0]);
            } catch (NumberFormatException e) {
                continue;
            }
            String type = s2[1];
            try {
                x = Integer.parseInt(s2[2]);
            } catch (NumberFormatException e) {
                continue;
            }
            try {
                y = Integer.parseInt(s2[3]);
            } catch (NumberFormatException e) {
                continue;
            }
            addTreasure(id, type, x, y);
        }

        for (String[] s3 : holeInfo) {
            int id = 1;
            int x = 0;
            int y = 0;
            try {
                id = Integer.parseInt(s3[0]);
            } catch (NumberFormatException e) {
                continue;
            }
            try {
                x = Integer.parseInt(s3[2]);
            } catch (NumberFormatException e) {
                continue;
            }
            try {
                y = Integer.parseInt(s3[3]);
            } catch (NumberFormatException e) {
                continue;
            }
            addHole(id, x, y);
        }
        this.rows = rows;
        this.columns = columns;
        ordenarCreaturesById(this.creatures);

        if (getCustoTotalCreaures(10) > 50 && getCustoTotalCreaures(20) > 50) {
            InsufficientCoinsException.setMoedas10(getCustoTotalCreaures(10));
            InsufficientCoinsException.setMoedas20(getCustoTotalCreaures(20));
            InsufficientCoinsException.setTeam10Invalida(true);
            InsufficientCoinsException.setTeam20Invalida(true);
            throw new InsufficientCoinsException("Ambas as equipas não respeitaram o plafond.");
        }
        if (getCustoTotalCreaures(10) > 50) {
            InsufficientCoinsException.setMoedas10(getCustoTotalCreaures(10));
            InsufficientCoinsException.setMoedas20(getCustoTotalCreaures(20));
            InsufficientCoinsException.setTeam10Invalida(true);
            InsufficientCoinsException.setTeam20Invalida(false);
            throw new InsufficientCoinsException("A equipa LDR não respeitou o plafond.");
        }
        if (getCustoTotalCreaures(20) > 50) {
            InsufficientCoinsException.setMoedas10(getCustoTotalCreaures(10));
            InsufficientCoinsException.setMoedas20(getCustoTotalCreaures(20));
            InsufficientCoinsException.setTeam10Invalida(false);
            InsufficientCoinsException.setTeam20Invalida(true);
            throw new InsufficientCoinsException("A equipa RESISTENCIA não respeitou o plafond.");
        }
        ldr10.removeMoedas(getCustoTotalCreaures(10));
        resistencia20.removeMoedas(getCustoTotalCreaures(20));
    }

    public void addCreaure(int id, String tipo, int teamId, int x, int y, String orientation) {
        Creature creature = null;
        if (!(orientation.equals("Norte") || orientation.equals("Sul") || orientation.equals("Este") || orientation.equals("Oeste") || orientation.equals("Nordeste")
                || orientation.equals("Noroeste") || orientation.equals("Sudoeste") || orientation.equals("Sudeste"))) {
            return;
        }
        if (tipo.equals("Dragão")) {
            creature = new Dragao(id, tipo, teamId, x, y, orientation);
        }
        if (tipo.equals("Elfo")) {
            creature = new Elfo(id, tipo, teamId, x, y, orientation);
        }
        if (tipo.equals("Gigante")) {
            creature = new Gigante(id, tipo, teamId, x, y, orientation);
        }
        if (tipo.equals("Humano")) {
            creature = new Humano(id, tipo, teamId, x, y, orientation);
        }
        if (tipo.equals("Anão")) {
            creature = new Anao(id, tipo, teamId, x, y, orientation);
        }
        if (creature == null) {
            return;
        }
        creatures.add(creature);
    }

    public void addCreaure(int id, String tipo, int teamId, int x, int y, String orientation, int nrPontos) {
        Creature creature = null;
        if (tipo.equals("Dragão")) {
            creature = new Dragao(id, tipo, teamId, x, y, orientation, nrPontos);

        }
        if (tipo.equals("Elfo")) {
            creature = new Elfo(id, tipo, teamId, x, y, orientation, nrPontos);

        }
        if (tipo.equals("Gigante")) {
            creature = new Gigante(id, tipo, teamId, x, y, orientation, nrPontos);

        }
        if (tipo.equals("Humano")) {
            creature = new Humano(id, tipo, teamId, x, y, orientation, nrPontos);

        }
        if (tipo.equals("Anão")) {
            creature = new Anao(id, tipo, teamId, x, y, orientation, nrPontos);

        }
        if (creature == null) {
            return;
        }
        creatures.add(creature);
    }

    public void addTreasure(int id, String type, int x, int y) {
        Treasure treasure = null;
        if (type.equals("silver")) {
            treasure = new TreasureSilver(id, x, y);
        }
        if (type.equals("bronze")) {
            treasure = new TreasureBronze(id, x, y);
        }
        if (type.equals("gold")) {
            treasure = new TreasureGold(id, x, y);
        }
        if (treasure == null) {
            return;
        }
        treasures.add(treasure);
    }

    public void addHole(int id, int x, int y) {
        Hole hole = new Hole(id, x, y);
        holes.add(hole);
    }

    public void setInitialTeam(int teamId) {
        /*Indica qual das equipas vai jogar no primeiro turno do jogo.*/
        this.currentTeamId = teamId;
    }

    public boolean checkSaltarPorCima(Creature c) {
        if (c.getStepSize() == 1) {
            return true;
        }
        int x = c.getX();
        int y = c.getY();
        int step = 0;
        int xFinal = c.getX();
        int yFinal = c.getY();
        int stepTotal = c.getStepSize();
        int buracosPasseiPorCima = 0;
        int creaturesPasseiPorCima = 0;
        switch (c.getOrientacao()) {
            case "Este":
                xFinal += stepTotal;
                break;
            case "Oeste":
                xFinal -= stepTotal;
                break;
            case "Norte":
                yFinal -= stepTotal;
                break;
            case "Sul":
                yFinal += stepTotal;
                break;
            case "Nordeste":
                xFinal += stepTotal;
                yFinal -= stepTotal;
                break;
            case "Sudeste":
                xFinal += stepTotal;
                yFinal += stepTotal;
                break;
            case "Sudoeste":
                xFinal -= stepTotal;
                yFinal += stepTotal;
                break;
            case "Noroeste":
                xFinal -= stepTotal;
                yFinal -= stepTotal;
                break;
        }
        while (x != xFinal || y != yFinal) {
            switch (c.getOrientacao()) {
                case "Este":
                    x += 1;
                    break;
                case "Oeste":
                    x -= 1;
                    break;
                case "Norte":
                    y -= 1;
                    break;
                case "Sul":
                    y += 1;
                    break;
                case "Nordeste":
                    x += 1;
                    y -= 1;
                    break;
                case "Sudeste":
                    x += 1;
                    y += 1;
                    break;
                case "Sudoeste":
                    x -= 1;
                    y += 1;
                    break;
                case "Noroeste":
                    x -= 1;
                    y -= 1;
                    break;
            }
            if (getType(x, y) != null) {
                if (getType(x, y).equals("hole")) {
                    buracosPasseiPorCima++;
                } else {
                    // caso mt especifico que nao sei se deve ficar aqui.....
                    if (c.getType().equals("Gigante") && getType(x, y).equals("Gigante")) {
                        return false;
                    }
                    creaturesPasseiPorCima++;
                }
            }
        }
        if (c.possoSaltarPorcima(creaturesPasseiPorCima, buracosPasseiPorCima)) {
            return true;
        } else {
            return false;
        }
    }

    public void processTurn() {
        Random gerador = new Random();
        int team10apanhouTreasure = 0;
        int team20apanhouTreasure = 0;
        System.out.println("Estou a processar uma jogada");
        for (Creature c : creatures) {
            String spell = getSpell(c.getX(), c.getY());
            if (spell != null) {
                aplicarFeitico(c.getX(), c.getY(), getSpell(c.getX(), c.getY()));
            }
        }
        feiticos = new HashMap<>();
        posicoesOcupadas = new HashMap<>();
        ArrayList<Treasure> treasuresRemove = new ArrayList<>();
        for (Creature c : creatures) {
            for (Treasure t : treasures) {
                if (c.getX() == t.getX() && c.getY() == t.getY()) {
                    numeroJogadasZero = 0;
                    treasuresFound++;
                    addScore(c.getIdEquipa(), t.getPontos());
                    c.addTreasure(t);
                    treasuresRemove.add(t);
                    if (c.getIdEquipa() == 10) {
                        team10apanhouTreasure++;
                    } else {
                        team20apanhouTreasure++;
                    }
                }
            }
        }
        for (Treasure t : treasuresRemove) {
            treasures.remove(t);
        }
        numeroJogadas++;
        int step;
        for (Creature c : creatures) {
            if (c.isCongelado1Round()) {
                c.descongela1Round();
                continue;
            }
            if (c.isCongeladoForever()) {
                continue;
            }
            String orientacao = c.getOrientacao();
            step = c.getStepSize();
            switch (orientacao) {
                case "Este":
                    if (c.getX() + step < columns && (getType(c.getX() + step, c.getY()) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Oeste":
                    if (c.getX() - step >= 0 && (getType(c.getX() - step, c.getY()) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Norte":
                    if (c.getY() - step >= 0 && (getType(c.getX(), c.getY() - step) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Sul":
                    if ((c.getY() + step < rows) && (getType(c.getX(), c.getY() + step) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Nordeste":
                    if ((c.getX() + step < columns && c.getY() - step >= 0) && (getType(c.getX() + step, c.getY() - step) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Sudeste":
                    if ((c.getX() + step < columns && c.getY() + step < rows) && (getType(c.getX() + step, c.getY() + step) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Sudoeste":
                    if ((c.getX() - step >= 0 && c.getY() + step < rows) && (getType(c.getX() - step, c.getY() + step) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
                case "Noroeste":
                    if ((c.getX() - step >= 0 && c.getY() - step >= 0) && (getType(c.getX() - step, c.getY() - step) == null) && checkSaltarPorCima(c)) {
                        c.move();
                    } else {
                        c.gira();
                    }
                    break;
            }
            if (c.estouDuplicado() || c.estouReduzido()) {
                c.stepToStepDefault();
            }
        }
        numeroJogadasZero++;
        for (Creature c : creatures) {
            for (Treasure t : treasures) {
                if (c.getX() == t.getX() && c.getY() == t.getY()) {
                    numeroJogadasZero = 0;
                    treasuresFound++;
                    addScore(c.getIdEquipa(), t.getPontos());
                    c.addTreasure(t);
                    treasuresRemove.add(t);
                    if (c.getIdEquipa() == 10) {
                        team10apanhouTreasure++;
                    } else {
                        team20apanhouTreasure++;
                    }
                }
            }
        }

        if (team10apanhouTreasure > 0) {
            ldr10.addMoedas(2);
        } else {
            ldr10.addMoedas(1);
        }
        if (team20apanhouTreasure > 0) {
            resistencia20.addMoedas(2);
        } else {
            resistencia20.addMoedas(1);
        }
        for (Treasure t : treasuresRemove) {
            treasures.remove(t);
        }
        int currentTeamID = getCurrentTeamId();
        if (currentTeamID == 10) {
            setCurrentTeamId(20);
        } else {
            setCurrentTeamId(10);
        }
        feiticos = new HashMap<>();
        posicoesOcupadas = new HashMap<>();
    }

    public List<Creature> getCreatures() {
        /*Devolve uma lista com todos os objectos Creature que existem no jogo.*/
        return creatures;
    }

    public List<Treasure> getTreausres() {
        /*Devolve uma lista com todos os objectos Creature que existem no jogo.*/
        return treasures;
    }

    public List<Hole> getHoles() {
        /*Devolve uma lista com todos os objectos Creature que existem no jogo.*/
        return holes;
    }

    public boolean gameIsOver() {
        /*Deve devolver true caso já tenha sido alcançada uma das condições de paragem do jogo e false em caso contrário.*/
        if (treasures.size() == 0) {
            return true;
        }
        if (numeroJogadas == 15 && treasuresFound == 0) {
            return true;
        }
        if (numeroJogadasZero == 15) {
            return true;
        }
        int treasuresInGame = 0;
        for (Treasure t : treasures) {
            treasuresInGame += t.getPontos();
        }
        if (ldr10.getScore() + treasuresInGame < resistencia20.getScore()) {
            return true;
        }
        if (resistencia20.getScore() + treasuresInGame < ldr10.getScore()) {
            return true;
        }
        return false;
    }

    public List<String> getAuthors() {
        /*Devolve uma lista de Strings com os nomes dos autores do projecto.*/
        List<String> authors = new ArrayList<>();
        String evora = ">Gonçalo Evora 21805468 Aka: RØKT";
        String martim = ">Martim Mourão 21805485 Aka: Mike";
        String deisi = "LP2 Enunciado By: Bruno Cipriano, Rodrigo Correia, Pedro Alves";
        authors.add(evora);
        authors.add(martim);
        authors.add(deisi);
        return authors;
    }

    public List<String> getResults() {
        /*Devolve uma lista de Strings que representem os resultados do jogo, conforme descrito na secção dos
          “Resultados da execução …”. Este método não pode devolver null. Caso não calculem a informação
           respectiva, devem devolver uma lista vazia.*/
        ArrayList<String> results = new ArrayList<>();
        String welcome = "Welcome to FANDEISIA";
        String res = "";
        String ldrPontos = "LDR: " + ldr10.getScore();
        String resiPontos = "RESISTENCIA: " + resistencia20.getScore();
        String turnos = "Nr. de Turnos jogados: " + numeroJogadas;
        String hifen = "-----";
        String[] creAll = new String[creatures.size()];
        int count = 0;
        for (Creature c : creatures) {
            creAll[count] = c.getId() + " : " + c.getType() + " : " + c.numberTreasuresGold() + " : " + c.numberTreasuresSilver() + " : " + c.numberTreasuresBronze() + " : " + c.numberPoints();
            count++;
        }
        if (ldr10.getScore() == resistencia20.getScore()) {
            res = "Resultado: EMPATE";
            results.add(welcome);
            results.add(res);
            results.add(ldrPontos);
            results.add(resiPontos);
            results.add(turnos);
            results.add(hifen);
        }

        if (ldr10.getScore() > resistencia20.getScore()) {
            res = "Resultado: Vitória da equipa LDR";
            results.add(welcome);
            results.add(res);
            results.add(ldrPontos);
            results.add(resiPontos);
            results.add(turnos);
            results.add(hifen);
        }

        if (ldr10.getScore() < resistencia20.getScore()) {
            res = "Resultado: Vitória da equipa RESISTENCIA";
            results.add(welcome);
            results.add(res);
            results.add(resiPontos);
            results.add(ldrPontos);
            results.add(turnos);
            results.add(hifen);
        }
        for (String s : creAll) {
            results.add(s);
        }
        return results;
    }

    public int getElementId(int x, int y) {
        /*Deve devolver o ID do objecto/elemento que se encontra na posição indicada pelas coordenadas (x,y) passadas por
          argumento.*/
        for (Creature creature : creatures) {
            if (creature.getX() == x && creature.getY() == y) {
                return creature.getId();
            }
        }
        for (Treasure treasure : treasures) {
            if (treasure.getX() == x && treasure.getY() == y) {
                return treasure.getId();
            }
        }
        for (Hole h : holes) {
            if (h.getX() == x && h.getY() == y) {
                return h.getId();
            }
        }
        return 0;
    }

    public Creature getCreature(int x, int y) {
        /*Deve devolver o ID do objecto/elemento que se encontra na posição indicada pelas coordenadas (x,y) passadas por
          argumento.*/
        for (Creature creature : creatures) {
            if (creature.getX() == x && creature.getY() == y) {
                return creature;
            }
        }
        return null;
    }

    public String getType(int x, int y) {
        /*Deve devolver o type do objecto/elemento que se encontra na posição indicada pelas coordenadas (x,y) passadas por
          argumento.*/
        for (Creature creature : creatures) {
            if (creature.getX() == x && creature.getY() == y) {
                return creature.getType();
            }
        }
        for (Hole hole : holes) {
            if (hole.getX() == x && hole.getY() == y) {
                return hole.getType();
            }
        }
        return null;
    }

    public int getCurrentTeamId() {
        /*Deve devolver o ID da equipa que está activa no turno actual.*/
        return currentTeamId;
    }

    public void setCurrentTeamId(int id) {
        /*Deve devolver o ID da equipa que está activa no turno actual.*/
        this.currentTeamId = id;
    }

    public int getCurrentScore(int teamId) {
        /*Deve devolver o número actual de pontos da equipa que tem o ID teamID.*/
        if (teamId == 10) {
            return ldr10.getScore();
        }
        if (teamId == 20) {
            return resistencia20.getScore();
        }
        return 0;
    }

    public void addScore(int teamId, int valor) {
        if (teamId == 20) {
            resistencia20.addScore(valor);
        }
        if (teamId == 10) {
            ldr10.addScore(valor);
        }
    }

    public boolean removeMoedas(int teamId, int valor) {
        if (teamId == 20) {
            if (resistencia20.getMoedas() - valor < 0) {
                return false;
            }
            resistencia20.removeMoedas(valor);
            return true;
        }
        if (teamId == 10) {
            if (ldr10.getMoedas() - valor < 0) {
                return false;
            }
            ldr10.removeMoedas(valor);
            return true;
        }
        return false;
    }

    public Team getLdr10() {
        return ldr10;
    }

    public Team getResistencia20() {
        return resistencia20;
    }

    private void ordenarCreaturesById(List<Creature> creatures) {
        Creature[] ordenado = Ordenacao.ordenarCreatureById(creatures.toArray(new Creature[0]));
        this.creatures = new ArrayList<>();
        for (Creature c : ordenado) {
            this.creatures.add(c);
        }
    }

    public void clearAllData() {
        creatures = new ArrayList<>();
        treasures = new ArrayList<>();
        holes = new ArrayList<>();
        feiticos = new HashMap<>();
        ldr10 = new Ldr10();
        resistencia20 = new Resistencia20();
        numeroJogadas = 0;
        treasuresFound = 0;
        currentTeamId = 10;
        numeroJogadasZero = 0;
        feiticos = new HashMap<>();
        posicoesOcupadas = new HashMap<>();
        InsufficientCoinsException.setTeam10Invalida(false);
        InsufficientCoinsException.setTeam20Invalida(false);
    }
}