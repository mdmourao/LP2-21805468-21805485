package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;
import java.util.List;

public class FandeisiaGameManager {
    List<Creature> creatures;
    List<Treasure> treasures;
    int scoreLDR_0;
    int score_RESISTENCIA_1;
    int initialTeamId;
    int currentTeamId;

    public FandeisiaGameManager() {
        creatures = new ArrayList<>();
        treasures = new ArrayList<>();
        scoreLDR_0 = 0;
        score_RESISTENCIA_1 = 0;
        treasuresFound = 0;
        plays = 0;
    }

    public String[][] getCreatureTypes() {
        /*Deve retornar os tipos de criatura que existem no jogo e que podem ser
        escolhidos para os exércitos dos dois jogadores.*/
        String[][] creaturesString = new String[getNumberCreatures()][4];
        int count = 0;
        for (Creature c : creatures) {
            creaturesString[count][0] = c.getTipo();
            creaturesString[count][1] = c.getImagePNG();
            creaturesString[count][2] = c.getDescricao();
            creaturesString[count][3] = c.getDescricao();
            count++;
        }
        return creaturesString;
    }

    public int getNumberCreatures() {
        return creatures.size();
    }

    public void startGame(String[] content, int rows, int columns) {
       /* Deve inicializar as estruturas de dados relevantes para processar um jogo
       O array content irá descrever o conteúdo inicial do mundo (criaturas e
       tesouros), tendo para isso várias Strings. Cada String vai representar um objecto do mundo.
       Os argumentos rows e columns vão-nos indicar as dimensões do tabuleiro.*/
        ArrayList<String[]> creatureInfo = new ArrayList<>();
        ArrayList<String[]> treasureInfo = new ArrayList<>();
        String[] infoFinalCreature;
        String[] infoFinalTreasure;
        String[] split1;
        String[] split2;
        String[] split3;
        int count = 0;
        for (String s : content) {
            split1 = s.split(",", 6);
            infoFinalCreature = new String[6];
            infoFinalTreasure = new String[4];
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
            if (split1.length == 4) {
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
    }

    public void addCreaure(int id, String tipo, int teamId, int x, int y, String orientation) {
        Creature creature = new Creature(id, tipo, teamId, x, y, orientation);
        creatures.add(creature);
    }

    public void setInitialTeam(int teamId) {
        /*Indica qual das equipas vai jogar no primeiro turno do jogo.*/

    }

    public void processTurn() {
        /*Deve processar um turno do jogo considerando a equipa actual. Inclui o movimento das criaturas.*/

    }

    public List<Creature> getCreatures() {
        /*Devolve uma lista com todos os objectos Creature que existem no jogo.*/
        return null;
    }

    public boolean gameIsOver() {
        /*Deve devolver true caso já tenha sido alcançada uma das condições de paragem do jogo e false em caso contrário.*/
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
        if (scoreLDR_0 == score_RESISTENCIA_1) {
            /* eventualmente ia acrescentar \n a estas strings... */
            String welcome = "Welcome to FANDEISIA";
            String res = "EMPATE";
            String ldrPontos = "LDR: " + scoreLDR_0;
            String resPontos = "RESISTENCIA: " + score_RESISTENCIA_1;
            String turnos = "Nr. de Turnos jogados: ";
            String hifen = "-----";
        }

        if (scoreLDR_0 > score_RESISTENCIA_1) {
            String welcome = "Welcome to FANDEISIA";
            String res = "Vitória da equipa LDR";
            String ldrPontos = "LDR: " + scoreLDR_0;
            String resPontos = "RESISTENCIA: " + score_RESISTENCIA_1;
            String turnos = "Nr. de Turnos jogados: " ;
            String hifen = "-----";
        }

        if (scoreLDR_0 < score_RESISTENCIA_1) {
            String vitoriaLDR = "Welcome to FANDEISIA\n" +
                    "Vitória da equipa RESISTENCIA\n" +
                    "LDR: " + scoreLDR_0 + "\n" +
                    "RESISTENCIA: " + score_RESISTENCIA_1 + "\n" +
                    "Nr. de Turnos jogados: \n" +
                    "-----\n";
            /*falta merdas pq acho que ainda faltam algumas variáveis. Compara com os de cima e diz qual é que te agrada mais (aposto que é este para não tar a repetir código que é horrível)*/
        }
        return results;
    }

    public int getElementId(int x, int y) {
        /*Deve devolver o ID do objecto/elemento que se encontra na posição indicada pelas coordenadas (x,y) passadas por
          argumento.*/
        return 0;
    }

    public int getCurrentTeamId() {
        /*Deve devolver o ID da equipa que está activa no turno actual.*/
        return currentTeamId;
    }

    public int getCurrentScore(int teamId) {
        /*Deve devolver o número actual de pontos da equipa que tem o ID teamID.*/
        return 0;
    }

}

