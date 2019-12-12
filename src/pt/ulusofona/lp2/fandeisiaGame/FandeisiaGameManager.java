package pt.ulusofona.lp2.fandeisiaGame;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FandeisiaGameManager {
    List<Creature> creatures;
    List<Treasure> treasures;
    List<Hole> holes;
    Team ldr_0 = new LDR_0();
    Team resistencia_1 = new Resistencia_1();
    int initialTeamId;
    int currentTeamId;
    int rows;
    int columns;
    int treasuresFound;
    int plays;

    public FandeisiaGameManager() {
        creatures = new ArrayList<>();
        treasures = new ArrayList<>();
        holes = new ArrayList<>();
        treasuresFound = 0;
        plays = 0;

    }

    public String[][] getCreatureTypes() {
        /*Deve retornar os tipos de criatura que existem no jogo e que podem ser
        escolhidos para os exércitos dos dois jogadores.*/
        String[][] creaturesString = new String[5][4];
        creaturesString[0][0] = "Anao";
        creaturesString[0][1] = "crazy_emoji_black.png";
        creaturesString[0][2] = "1 casa (posição) de cada vez | 90º";
        creaturesString[0][3] = "1";

        creaturesString[1][0] = "Dragao";
        creaturesString[1][1] = "crazy_emoji_black.png";
        creaturesString[1][2] = "3 casas (posições) de cada vez\n ○ Pode-se mover na horizontal, na vertical e também nas diagonais";
        creaturesString[1][3] = "9";

        creaturesString[2][0] = "Elfo";
        creaturesString[2][1] = "crazy_emoji_black.png";
        creaturesString[2][2] = "2 casas (posições) de cada vez\n Pode-se mover na horizontal, na vertical e nas diagonais";
        creaturesString[2][3] = "5";

        creaturesString[3][0] = "Gigante";
        creaturesString[3][1] = "crazy_emoji_black.png";
        creaturesString[3][2] = "3 casas (posições) de cada vez\n Pode mover na horizontal e na vertical";
        creaturesString[3][3] = "5";

        creaturesString[4][0] = "Humano";
        creaturesString[4][1] = "crazy_emoji_black.png";
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

    //TODO (colocar mais inteligente)
    public Map<String, Integer> createComputerArmy() {
        Map<String, Integer> army = new HashMap<>();
        army.put("Dragao", 1);
        army.put("Anao", 1);
        army.put("Elfo", 1);
        army.put("Gigante", 1);
        army.put("Humano", 1);
        return army;
    }

    //TODO
    public boolean enchant(int x, int y, String spellName) {
        /*Aplica o feitiço indicado à criatura que
        estiver nas coordenadas indicadas.
        Caso não seja possível aplicar o feitiço (por exemplo, nessas coordenadas não está uma criatura,
        ou esse feitiço iria levar a criatura para um buraco) deve retornar false.*/
        return false;
    }

    //TODO
    public String getSpell(int x, int y) {
        /*Retorna null ou o nome do feitiço está a ser aplicado à criatura na posição x,y*/
        return "";
    }

    //TODO
    public int getCoinTotal(int teamID) {
        /*Deve devolver o número total de moedas
        fantásticas da equipa que tem o ID teamID.*/
        return 0;
    }

    //TODO
    public boolean saveGame(File fich) {
        /*Deve gravar o jogo actual para o ficheiro
        indicado no argumento.*/
        return false;
    }

    //TODO
    public boolean loadGame(File fich) {
        /*Deve começar um jogo a partir do ficheiro
        indicado no argumento.*/
        return false;
    }

    //TODO
    public String whoIsLordEder() {
        /*Deve devolver o nome completo do ​Lord Éder.*/
        return "";
    }

    public int getNumberCreatures() {
        return creatures.size();
    }

    //TODO aplicar os checks do plafond
    public int startGame(String[] content, int rows, int columns) {
        System.out.println("Recebemos esta String");
        for (String c : content) {
            System.out.println(c);
        }
        System.out.println("FIM");
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
            }
            String tipo = s1[1];
            try {
                teamId = Integer.parseInt(s1[2]);
            } catch (NumberFormatException e) {
            }
            try {
                x = Integer.parseInt(s1[3]);
            } catch (NumberFormatException e) {
            }
            try {
                y = Integer.parseInt(s1[4]);
            } catch (NumberFormatException e) {
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
            }
            String type = s2[1];
            try {
                x = Integer.parseInt(s2[2]);
            } catch (NumberFormatException e) {
            }
            try {
                y = Integer.parseInt(s2[3]);
            } catch (NumberFormatException e) {
            }
            addTreasure(id, type, x, y);
        }

        for (String[] s3 : holeInfo) {
            int id = 0;
            int x = 0;
            int y = 0;
            try {
                id = Integer.parseInt(s3[0]);
            } catch (NumberFormatException e) {
            }
            try {
                x = Integer.parseInt(s3[2]);
            } catch (NumberFormatException e) {
            }
            try {
                y = Integer.parseInt(s3[3]);
            } catch (NumberFormatException e) {
            }
            addHole(id, x, y);
        }

        this.rows = rows;
        this.columns = columns;
        ordenarCreaturesById(this.creatures);
        return 0;
    }

    public void addCreaure(int id, String tipo, int teamId, int x, int y, String orientation) {
        Creature creature = null;
        if (tipo.equals("Dragao")) {
            creature = new Dragao(id, tipo, teamId, x, y, orientation);
            System.out.println(creatures.size() + "  Adicionei um Dragao");
        }
        if (tipo.equals("Elfo")) {
            creature = new Elfo(id, tipo, teamId, x, y, orientation);
            System.out.println(creatures.size() + "  Adicionei um Elfo");
        }
        if (tipo.equals("Gigante")) {
            creature = new Gigante(id, tipo, teamId, x, y, orientation);
            System.out.println(creatures.size() + "  Adicionei um Gigante");
        }
        if (tipo.equals("Humano")) {
            creature = new Humano(id, tipo, teamId, x, y, orientation);
            System.out.println(creatures.size() + "  Adicionei um Humano");
        }
        if (tipo.equals("Anao")) {
            creature = new Anao(id, tipo, teamId, x, y, orientation);
            System.out.println(creatures.size() + "  Adicionei um Anao");
        }
        if (creature == null) {
            return;
        }
        creatures.add(creature);
    }

    public void addTreasure(int id, String type, int x, int y) {
        Treasure treasure = null;
        if (type.equals("silver")) {
            treasure = new TreasureSilver(id,x,y);
            System.out.println(treasures.size() + "  Adicionei um tesouro silver");
        }
        if (type.equals("bronze")) {
            treasure = new TreasureBronze(id,x,y);
            System.out.println(treasures.size() + "  Adicionei um tesouro bronze");
        }
        if (type.equals("gold")){
            treasure = new TreasureGold(id,x,y);
            System.out.println(treasures.size() + "  Adicionei um tesouro gold");
        }
        if(treasure == null){
            return;
        }
        treasures.add(treasure);
    }

    public void addHole(int id, int x, int y) {
        Hole hole = new Hole(id, x, y);
        System.out.println(holes.size() + "  Adicionei um buraco");
        holes.add(hole);
    }

    public void setInitialTeam(int teamId) {
        /*Indica qual das equipas vai jogar no primeiro turno do jogo.*/
        this.initialTeamId = teamId;
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
        while (x != xFinal && y != yFinal) {
            switch (c.getOrientacao()) {
                case "Este":
                    x += step;
                    break;
                case "Oeste":
                    x -= step;
                    break;
                case "Norte":
                    y -= step;
                    break;
                case "Sul":
                    y += step;
                case "Nordeste":
                    x += step;
                    y -= step;
                    break;
                case "Sudeste":
                    x += step;
                    y += step;
                    break;
                case "Sudoeste":
                    x -= step;
                    y += step;
                    break;
                case "Noroeste":
                    x -= step;
                    y -= step;
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
            step++;
        }
        if (c.possoSaltarPorcima(creaturesPasseiPorCima, buracosPasseiPorCima)) {
            return true;
        } else {
            return false;
        }
    }

    public void processTurn() {
        System.out.println("Estou a processar uma jogada");
        ArrayList<Treasure> treasuresRemove = new ArrayList<>();
        plays++;
        int step;
        for (Creature c : creatures) {
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
                    if (c.getY() + step < rows && (getType(c.getX(), c.getY() + step) == null) && checkSaltarPorCima(c)) {
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
                    if ((c.getX() - step >= 0 && c.getY() + step < columns) && (getType(c.getX() - step, c.getY() + step) == null) && checkSaltarPorCima(c)) {
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
        }
        for (Creature c : creatures) {
            for (Treasure t : treasures) {
                if (c.getX() == t.getX() && c.getY() == t.getY()) {
                    addScore(c.getIdEquipa(), 1);
                    treasuresFound++;
                    treasuresRemove.add(t);
                    c.addNrPontos(1);
                }
            }
        }
        for (Treasure t : treasuresRemove) {
            treasures.remove(t);
        }
        int currentTeamID = getCurrentTeamId();
        if (currentTeamID == 0) {
            setCurrentTeamId(1);
        } else {
            setCurrentTeamId(0);
        }

    }

    public List<Creature> getCreatures() {
        /*Devolve uma lista com todos os objectos Creature que existem no jogo.*/
        return creatures;
    }

    public boolean gameIsOver() {
        /*Deve devolver true caso já tenha sido alcançada uma das condições de paragem do jogo e false em caso contrário.*/
        if (treasures.size() == 0) {
            return true;
        }
        if (plays == 15 && treasuresFound == 0) {
            return true;
        }
        int treasuresInGame = 0;
        for (Treasure t : treasures) {
            treasuresInGame++;
        }
        if (ldr_0.getScore() + treasuresInGame < resistencia_1.getScore()) {
            return true;
        }
        if (resistencia_1.getScore() + treasuresInGame < ldr_0.getScore()) {
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
        String ldrPontos = "LDR: " + ldr_0.getScore();
        String resiPontos = "RESISTENCIA: " + resistencia_1.getScore();
        String turnos = "Nr. de Turnos jogados: " + plays;
        String hifen = "-----";
        String[] creAll = new String[creatures.size()];
        int count = 0;
        for (Creature c : creatures) {
            creAll[count] = c.getId() + " : " + c.getType() + " : " + c.getNrPontos();
            count++;
        }
        if (ldr_0.getScore() == resistencia_1.getScore()) {
            res = "Resultado: EMPATE";
            results.add(welcome);
            results.add(res);
            results.add(ldrPontos);
            results.add(resiPontos);
            results.add(turnos);
            results.add(hifen);
            for (String s : creAll) {
                results.add(s);
            }
        }

        if (ldr_0.getScore() > resistencia_1.getScore()) {
            res = "Resultado: Vitória da equipa LDR";
            results.add(welcome);
            results.add(res);
            results.add(ldrPontos);
            results.add(resiPontos);
            results.add(turnos);
            results.add(hifen);
            for (String s : creAll) {
                results.add(s);
            }
        }

        if (ldr_0.getScore() < resistencia_1.getScore()) {
            res = "Resultado: Vitória da equipa RESISTENCIA";
            results.add(welcome);
            results.add(res);
            results.add(resiPontos);
            results.add(ldrPontos);
            results.add(turnos);
            results.add(hifen);
            for (String s : creAll) {
                results.add(s);
            }
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
        return 0;
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
        if (teamId == 0) {
            return ldr_0.getScore();
        }
        if (teamId == 1) {
            return resistencia_1.getScore();
        }
        return 0;
    }

    public void addScore(int teamId, int valor) {
        if (teamId == 1) {
            resistencia_1.addScore(valor);
        }
        if (teamId == 0) {
            ldr_0.addScore(valor);
        }
    }

    private void ordenarCreaturesById(List<Creature> creatures) {
        Creature[] ordenado = Ordenacao.ordenarCreatureById(creatures.toArray(new Creature[0]));
        this.creatures = new ArrayList<>();
        for (Creature c : ordenado) {
            this.creatures.add(c);
        }
    }
}

