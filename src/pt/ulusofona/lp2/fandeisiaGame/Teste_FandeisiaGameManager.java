package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Teste_FandeisiaGameManager {

    @Test
    public void test_CriacaoDosObjetosContent() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[21];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 10, x: 0, y: 1, orientation: Este";
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 0, y: 2, orientation: Este";
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 0, y: 3, orientation: Este";
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Este";

        content[5] = "id: 6, type: Anão, teamId: 20, x: 1, y: 1, orientation: Norte";
        content[6] = "id: 7, type: Humano, teamId: 20, x: 1, y: 2, orientation: Sul";
        content[7] = "id: 8, type: Dragão, teamId: 20, x: 1, y: 3, orientation: Oeste";
        content[8] = "id: 9, type: Gigante, teamId: 20, x: 1, y: 4, orientation: Norte";
        content[9] = "id: 10, type: Elfo, teamId: 20, x: 1, y: 5, orientation: Sul";
        content[10] = "id: 11, type: Elfo, teamId: 20, x: 4, y: 1, orientation: Nordeste";
        content[11] = "id: 12, type: Elfo, teamId: 20, x: 4, y: 2, orientation: Noroeste";
        content[12] = "id: 13, type: Elfo, teamId: 20, x: 4, y: 3, orientation: Sudeste";
        content[13] = "id: 14, type: Elfo, teamId: 20, x: 4, y: 4, orientation: Sudoeste";

        content[14] = "id: -1, type: silver, x: 2, y: 1";
        content[15] = "id: -2, type: bronze, x: 2, y: 2";
        content[16] = "id: -3, type: gold, x: 2, y: 3";

        content[17] = "id: -100, type: hole, x: 3, y: 1";
        content[18] = "id: -101, type: hole, x: 3, y: 2";
        content[19] = "id: -102, type: hole, x: 3, y: 3";
        content[20] = "id: -103, type: hole, x: 3, y: 4";

        tester.startGame(content, 6, 6);

        assertEquals("Tamanho Creatures", 14, tester.getNumberCreatures());
        assertEquals("Tamanho Treasures", 3, tester.getNumberTreasures());
        assertEquals("Tamanho Holes", 4, tester.getNumberHoles());

        List<Creature> creatures = tester.getCreatures();
        assertEquals("1 | Anão | 10 | 0 @ (0, 0) Este", creatures.get(0).toString());
        assertEquals("2 | Humano | 10 | 0 @ (0, 1) Este", creatures.get(1).toString());
        assertEquals("3 | Dragão | 10 | 0 @ (0, 2) Este", creatures.get(2).toString());
        assertEquals("4 | Gigante | 10 | 0 @ (0, 3) Este", creatures.get(3).toString());
        assertEquals("5 | Elfo | 10 | 0 @ (0, 4) Este", creatures.get(4).toString());
        assertEquals("6 | Anão | 20 | 0 @ (1, 1) Norte", creatures.get(5).toString());
        assertEquals("7 | Humano | 20 | 0 @ (1, 2) Sul", creatures.get(6).toString());
        assertEquals("8 | Dragão | 20 | 0 @ (1, 3) Oeste", creatures.get(7).toString());
        assertEquals("9 | Gigante | 20 | 0 @ (1, 4) Norte", creatures.get(8).toString());
        assertEquals("10 | Elfo | 20 | 0 @ (1, 5) Sul", creatures.get(9).toString());
        assertEquals("11 | Elfo | 20 | 0 @ (4, 1) Nordeste", creatures.get(10).toString());
        assertEquals("12 | Elfo | 20 | 0 @ (4, 2) Noroeste", creatures.get(11).toString());
        assertEquals("13 | Elfo | 20 | 0 @ (4, 3) Sudeste", creatures.get(12).toString());
        assertEquals("14 | Elfo | 20 | 0 @ (4, 4) Sudoeste", creatures.get(13).toString());

        List<Treasure> treasures = tester.getTreausres();
        assertEquals("-1 | silver @ (2, 1)", treasures.get(0).toString());
        assertEquals("-2 | bronze @ (2, 2)", treasures.get(1).toString());
        assertEquals("-3 | gold @ (2, 3)", treasures.get(2).toString());

        List<Hole> holes = tester.getHoles();
        assertEquals("-100 | hole @ (3, 1)", holes.get(0).toString());
        assertEquals("-101 | hole @ (3, 2)", holes.get(1).toString());
        assertEquals("-102 | hole @ (3, 3)", holes.get(2).toString());
        assertEquals("-103 | hole @ (3, 4)", holes.get(3).toString());


    }

    @Test
    public void test_Movimento90_Creature90() {
        //Caso Normal
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[4];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 1, orientation: Norte";
        content[1] = "id: 2, type: Anão, teamId: 10, x: 0, y: 3, orientation: Sul";
        content[2] = "id: 3, type: Anão, teamId: 20, x: 3, y: 3, orientation: Este";
        content[3] = "id: 4, type: Anão, teamId: 20, x: 2, y: 1, orientation: Oeste";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        List<Creature> creatures = tester.getCreatures();

        assertEquals("Caso Normal Norte", "1 | Anão | 10 | 0 @ (0, 0) Norte", creatures.get(0).toString());
        assertEquals("Caso Normal Sul", "2 | Anão | 10 | 0 @ (0, 4) Sul", creatures.get(1).toString());
        assertEquals("Caso Normal Este", "3 | Anão | 20 | 0 @ (4, 3) Este", creatures.get(2).toString());
        assertEquals("Caso Normal Oeste", "4 | Anão | 20 | 0 @ (1, 1) Oeste", creatures.get(3).toString());

        //Caso Rotação por ter criatura impedir movimento
        tester = new FandeisiaGameManager();

        content = new String[8];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 1, y: 1, orientation: Norte";
        content[1] = "id: 2, type: Anão, teamId: 10, x: 1, y: 0, orientation: Oeste";

        content[2] = "id: 3, type: Anão, teamId: 10, x: 3, y: 1, orientation: Sul";
        content[3] = "id: 4, type: Anão, teamId: 10, x: 3, y: 2, orientation: Este";

        content[4] = "id: 5, type: Anão, teamId: 10, x: 1, y: 4, orientation: Este";
        content[5] = "id: 6, type: Anão, teamId: 10, x: 2, y: 4, orientation: Este";

        content[6] = "id: 7, type: Anão, teamId: 10, x: 2, y: 3, orientation: Oeste";
        content[7] = "id: 8, type: Anão, teamId: 10, x: 1, y: 3, orientation: Oeste";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Rotacao Norte (obstaculo: Creature)", "1 | Anão | 10 | 0 @ (1, 1) Este", creatures.get(0).toString());
        assertEquals("Caso Rotacao Sul (obstaculo: Creature)", "3 | Anão | 10 | 0 @ (3, 1) Oeste", creatures.get(2).toString());
        assertEquals("Caso Rotacao Este (obstaculo: Creature)", "5 | Anão | 10 | 0 @ (1, 4) Sul", creatures.get(4).toString());
        assertEquals("Caso Rotacao Oeste (obstaculo: Creature)", "7 | Anão | 10 | 0 @ (2, 3) Norte", creatures.get(6).toString());

        //Caso Rotação por ter hole impedir movimento
        tester = new FandeisiaGameManager();

        content = new String[8];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 1, y: 1, orientation: Norte";
        content[1] = "id: -100, type: hole, x: 1, y: 0";

        content[2] = "id: 2, type: Anão, teamId: 10, x: 3, y: 1, orientation: Sul";
        content[3] = "id: -101, type: hole, x: 3, y: 2";

        content[4] = "id: 3, type: Anão, teamId: 10, x: 1, y: 4, orientation: Este";
        content[5] = "id: -102, type: hole, x: 2, y: 4";

        content[6] = "id: 4, type: Anão, teamId: 10, x: 2, y: 3, orientation: Oeste";
        content[7] = "id: -103, type: hole, x: 1, y: 3";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Rotacao Norte (obstaculo: Hole)", "1 | Anão | 10 | 0 @ (1, 1) Este", creatures.get(0).toString());
        assertEquals("Caso Rotacao Sul (obstaculo: Hole)", "2 | Anão | 10 | 0 @ (3, 1) Oeste", creatures.get(1).toString());
        assertEquals("Caso Rotacao Este (obstaculo: Hole)", "3 | Anão | 10 | 0 @ (1, 4) Sul", creatures.get(2).toString());
        assertEquals("Caso Rotacao Oeste (obstaculo: Hole)", "4 | Anão | 10 | 0 @ (2, 3) Norte", creatures.get(3).toString());

        //Margens Rotação
        tester = new FandeisiaGameManager();

        content = new String[4];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Norte";
        content[1] = "id: 2, type: Anão, teamId: 10, x: 1, y: 5, orientation: Sul";
        content[2] = "id: 3, type: Anão, teamId: 10, x: 4, y: 2, orientation: Este";
        content[3] = "id: 4, type: Anão, teamId: 10, x: 0, y: 3, orientation: Oeste";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Margem Norte", "1 | Anão | 10 | 0 @ (0, 0) Este", creatures.get(0).toString());
        assertEquals("Caso Margem Sul", "2 | Anão | 10 | 0 @ (1, 5) Oeste", creatures.get(1).toString());
        assertEquals("Caso Margem Este", "3 | Anão | 10 | 0 @ (4, 2) Sul", creatures.get(2).toString());
        assertEquals("Caso Margem Oeste", "4 | Anão | 10 | 0 @ (0, 3) Norte", creatures.get(3).toString());

    }

    @Test
    public void test_Movimento45_Creature45() {
        //Caso Normal
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[8];

        content[0] = "id: 1, type: Elfo, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Elfo, teamId: 10, x: 2, y: 1, orientation: Oeste";
        content[2] = "id: 3, type: Elfo, teamId: 20, x: 5, y: 0, orientation: Sul";
        content[3] = "id: 4, type: Elfo, teamId: 20, x: 6, y: 2, orientation: Norte";

        content[4] = "id: 5, type: Elfo, teamId: 10, x: 2, y: 4, orientation: Nordeste";
        content[5] = "id: 6, type: Elfo, teamId: 10, x: 2, y: 5, orientation: Sudeste";
        content[6] = "id: 7, type: Elfo, teamId: 10, x: 4, y: 5, orientation: Sudoeste";
        content[7] = "id: 8, type: Elfo, teamId: 10, x: 6, y: 5, orientation: Noroeste";


        tester.startGame(content, 8, 8);
        tester.processTurn();
        List<Creature> creatures = tester.getCreatures();

        assertEquals("Caso Normal Norte", "4 | Elfo | 20 | 0 @ (6, 0) Norte", creatures.get(3).toString());
        assertEquals("Caso Normal Sul", "3 | Elfo | 20 | 0 @ (5, 2) Sul", creatures.get(2).toString());
        assertEquals("Caso Normal Este", "1 | Elfo | 10 | 0 @ (2, 0) Este", creatures.get(0).toString());
        assertEquals("Caso Normal Oeste", "2 | Elfo | 10 | 0 @ (0, 1) Oeste", creatures.get(1).toString());
        assertEquals("Caso Normal Nordeste", "5 | Elfo | 10 | 0 @ (4, 2) Nordeste", creatures.get(4).toString());
        assertEquals("Caso Normal Sudeste", "6 | Elfo | 10 | 0 @ (4, 7) Sudeste", creatures.get(5).toString());
        assertEquals("Caso Normal Sudoeste", "7 | Elfo | 10 | 0 @ (2, 7) Sudoeste", creatures.get(6).toString());
        assertEquals("Caso Normal Noroeste", "8 | Elfo | 10 | 0 @ (4, 3) Noroeste", creatures.get(7).toString());

        tester = new FandeisiaGameManager();
        content = new String[8];

        content[0] = "id: 1, type: Elfo, teamId: 10, x: 7, y: 1, orientation: Este";
        content[1] = "id: 2, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Oeste";
        content[2] = "id: 3, type: Elfo, teamId: 10, x: 0, y: 7, orientation: Sul";
        content[3] = "id: 4, type: Elfo, teamId: 10, x: 0, y: 0, orientation: Norte";

        content[4] = "id: 5, type: Elfo, teamId: 10, x: 7, y: 0, orientation: Nordeste";
        content[5] = "id: 6, type: Elfo, teamId: 10, x: 7, y: 7, orientation: Sudeste";
        content[6] = "id: 7, type: Elfo, teamId: 10, x: 1, y: 7, orientation: Sudoeste";
        content[7] = "id: 8, type: Elfo, teamId: 10, x: 1, y: 0, orientation: Noroeste";


        tester.startGame(content, 8, 8);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Margem Norte", "4 | Elfo | 10 | 0 @ (0, 0) Nordeste", creatures.get(3).toString());
        assertEquals("Caso Margem Sul", "3 | Elfo | 10 | 0 @ (0, 7) Sudoeste", creatures.get(2).toString());
        assertEquals("Caso Margem Este", "1 | Elfo | 10 | 0 @ (7, 1) Sudeste", creatures.get(0).toString());
        assertEquals("Caso Margem Oeste", "2 | Elfo | 10 | 0 @ (0, 4) Noroeste", creatures.get(1).toString());
        assertEquals("Caso Margem Nordeste", "5 | Elfo | 10 | 0 @ (7, 0) Este", creatures.get(4).toString());
        assertEquals("Caso Margem Sudeste", "6 | Elfo | 10 | 0 @ (7, 7) Sul", creatures.get(5).toString());
        assertEquals("Caso Margem Sudoeste", "7 | Elfo | 10 | 0 @ (1, 7) Oeste", creatures.get(6).toString());
        assertEquals("Caso Margem Noroeste", "8 | Elfo | 10 | 0 @ (1, 0) Norte", creatures.get(7).toString());

        tester = new FandeisiaGameManager();
        content = new String[8];

        content[0] = "id: 1, type: Elfo, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Elfo, teamId: 10, x: 2, y: 0, orientation: Sul";
        content[2] = "id: 3, type: Elfo, teamId: 10, x: 2, y: 2, orientation: Oeste";
        content[3] = "id: 4, type: Elfo, teamId: 10, x: 0, y: 2, orientation: Norte";

        content[4] = "id: 5, type: Elfo, teamId: 10, x: 5, y: 6, orientation: Nordeste";
        content[5] = "id: 6, type: Elfo, teamId: 10, x: 7, y: 4, orientation: Sudoeste";
        content[6] = "id: 7, type: Elfo, teamId: 10, x: 5, y: 4, orientation: Sudeste";
        content[7] = "id: 8, type: Elfo, teamId: 10, x: 7, y: 6, orientation: Noroeste";


        tester.startGame(content, 8, 8);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Rotacao Este (obstaculo: Creature)", "1 | Elfo | 10 | 0 @ (0, 0) Sudeste", creatures.get(0).toString());
        assertEquals("Caso Rotacao Sul (obstaculo: Creature)", "2 | Elfo | 10 | 0 @ (2, 0) Sudoeste", creatures.get(1).toString());
        assertEquals("Caso Rotacao Oeste (obstaculo: Creature)", "3 | Elfo | 10 | 0 @ (2, 2) Noroeste", creatures.get(2).toString());
        assertEquals("Caso Rotacao Norte (obstaculo: Creature)", "4 | Elfo | 10 | 0 @ (0, 2) Nordeste", creatures.get(3).toString());

        assertEquals("Caso Rotacao Nordeste (obstaculo: Creature)", "5 | Elfo | 10 | 0 @ (5, 6) Este", creatures.get(4).toString());
        assertEquals("Caso Rotacao Sudoeste (obstaculo: Creature)", "6 | Elfo | 10 | 0 @ (7, 4) Oeste", creatures.get(5).toString());
        assertEquals("Caso Rotacao Sudeste (obstaculo: Creature)", "7 | Elfo | 10 | 0 @ (5, 4) Sul", creatures.get(6).toString());
        assertEquals("Caso Rotacao Noroeste (obstaculo: Creature)", "8 | Elfo | 10 | 0 @ (7, 6) Norte", creatures.get(7).toString());

        tester = new FandeisiaGameManager();
        content = new String[16];

        content[0] = "id: 1, type: Elfo, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Elfo, teamId: 10, x: 0, y: 2, orientation: Sul";
        content[2] = "id: 3, type: Elfo, teamId: 10, x: 2, y: 1, orientation: Oeste";
        content[3] = "id: 4, type: Elfo, teamId: 10, x: 2, y: 4, orientation: Norte";

        content[4] = "id: 5, type: Elfo, teamId: 10, x: 3, y: 2, orientation: Nordeste";
        content[5] = "id: 6, type: Elfo, teamId: 10, x: 6, y: 4, orientation: Sudoeste";
        content[6] = "id: 7, type: Elfo, teamId: 10, x: 3, y: 0, orientation: Sudeste";
        content[7] = "id: 8, type: Elfo, teamId: 10, x: 6, y: 6, orientation: Noroeste";

        content[8] = "id: -100, type: hole, x: 2, y: 0";
        content[9] = "id: -101, type: hole, x: 0, y: 4";
        content[10] = "id: -102, type: hole, x: 0, y: 1";
        content[11] = "id: -103, type: hole, x: 2, y: 2";
        content[12] = "id: -104, type: hole, x: 5, y: 0";
        content[13] = "id: -105, type: hole, x: 4, y: 6";
        content[14] = "id: -106, type: hole, x: 5, y: 2";
        content[15] = "id: -107, type: hole, x: 4, y: 4";

        tester.startGame(content, 8, 8);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Rotacao Este (obstaculo: Hole)", "1 | Elfo | 10 | 0 @ (0, 0) Sudeste", creatures.get(0).toString());
        assertEquals("Caso Rotacao Sul (obstaculo: Hole)", "2 | Elfo | 10 | 0 @ (0, 2) Sudoeste", creatures.get(1).toString());
        assertEquals("Caso Rotacao Oeste (obstaculo: Hole)", "3 | Elfo | 10 | 0 @ (2, 1) Noroeste", creatures.get(2).toString());
        assertEquals("Caso Rotacao Norte (obstaculo: Hole)", "4 | Elfo | 10 | 0 @ (2, 4) Nordeste", creatures.get(3).toString());

        assertEquals("Caso Rotacao Nordeste (obstaculo: Hole)", "5 | Elfo | 10 | 0 @ (3, 2) Este", creatures.get(4).toString());
        assertEquals("Caso Rotacao Sudoeste (obstaculo: Hole)", "6 | Elfo | 10 | 0 @ (6, 4) Oeste", creatures.get(5).toString());
        assertEquals("Caso Rotacao Sudeste (obstaculo: Hole)", "7 | Elfo | 10 | 0 @ (3, 0) Sul", creatures.get(6).toString());
        assertEquals("Caso Rotacao Noroeste (obstaculo: Hole)", "8 | Elfo | 10 | 0 @ (6, 6) Norte", creatures.get(7).toString());


    }

    @Test
    public void test_plafondCreatures() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[11];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este"; //1
        content[1] = "id: 2, type: Humano, teamId: 10, x: 0, y: 1, orientation: Este"; //3
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 0, y: 2, orientation: Este"; //9
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 0, y: 3, orientation: Este"; //5
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Este"; //5

        content[5] = "id: 1, type: Anão, teamId: 20, x: 0, y: 0, orientation: Este"; //1
        content[6] = "id: 2, type: Humano, teamId: 20, x: 0, y: 1, orientation: Este"; //3
        content[7] = "id: 3, type: Dragão, teamId: 20, x: 0, y: 2, orientation: Este"; //9
        content[8] = "id: 4, type: Gigante, teamId: 20, x: 0, y: 3, orientation: Este"; //5
        content[9] = "id: 5, type: Elfo, teamId: 20, x: 0, y: 4, orientation: Este"; //5
        content[10] = "id: 5, type: Anão, teamId: 20, x: 0, y: 6, orientation: Este"; //1

        assertEquals("Return Start Game, caso normal", 0, tester.startGame(content, 6, 6));

        assertEquals("Custo creatures Respeitado, normal (id:10)", 23, tester.getCustoTotalCreaures(10));
        assertEquals("Custo creatures Respeitado, normal (id: 20)", 24, tester.getCustoTotalCreaures(20));

        tester = new FandeisiaGameManager();
        content = new String[23];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este"; //1
        content[1] = "id: 2, type: Anão, teamId: 10, x: 0, y: 1, orientation: Este"; //1
        content[2] = "id: 3, type: Anão, teamId: 10, x: 0, y: 2, orientation: Este"; //1
        content[3] = "id: 4, type: Anão, teamId: 10, x: 0, y: 3, orientation: Este"; //1
        content[4] = "id: 5, type: Humano, teamId: 10, x: 0, y: 4, orientation: Este"; //3
        content[5] = "id: 6, type: Humano, teamId: 10, x: 0, y: 5, orientation: Este"; //3
        content[6] = "id: 7, type: Dragão, teamId: 10, x: 1, y: 0, orientation: Este"; //9
        content[7] = "id: 8, type: Dragão, teamId: 10, x: 1, y: 1, orientation: Este"; //9
        content[8] = "id: 9, type: Dragão, teamId: 10, x: 1, y: 2, orientation: Este"; //9
        content[9] = "id: 10, type: Gigante, teamId: 10, x: 1, y: 3, orientation: Este"; //5
        content[10] = "id: 11, type: Elfo, teamId: 10, x: 1, y: 4, orientation: Este"; //5
        content[11] = "id: 12, type: Elfo, teamId: 10, x: 1, y: 5, orientation: Este"; //5

        content[12] = "id: 13, type: Anão, teamId: 20, x: 2, y: 0, orientation: Este"; //1
        content[13] = "id: 14, type: Humano, teamId: 20, x: 2, y: 1, orientation: Este"; //3
        content[14] = "id: 15, type: Dragão, teamId: 20, x: 2, y: 2, orientation: Este"; //9
        content[15] = "id: 16, type: Gigante, teamId: 20, x: 2, y: 3, orientation: Este"; //5
        content[16] = "id: 17, type: Elfo, teamId: 20, x: 2, y: 4, orientation: Este"; //5
        content[17] = "id: 18, type: Anão, teamId: 20, x: 2, y: 5, orientation: Este"; //1
        content[18] = "id: 19, type: Dragão, teamId: 20, x: 3, y: 1, orientation: Este"; //9
        content[19] = "id: 20, type: Dragão, teamId: 20, x: 3, y: 2, orientation: Este"; //9
        content[20] = "id: 21, type: Gigante, teamId: 20, x: 3, y: 3, orientation: Este"; //5
        content[21] = "id: 22, type: Gigante, teamId: 20, x: 3, y: 4, orientation: Este"; //5
        content[22] = "id: 23, type: Gigante, teamId: 20, x: 3, y: 5, orientation: Este"; //5


        assertEquals("Return Start Game, caso nenhum respeita", 1, tester.startGame(content, 6, 6));

        tester = new FandeisiaGameManager();
        content = new String[17];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este"; //1
        content[1] = "id: 2, type: Anão, teamId: 10, x: 0, y: 1, orientation: Este"; //1
        content[2] = "id: 3, type: Anão, teamId: 10, x: 0, y: 2, orientation: Este"; //1
        content[3] = "id: 4, type: Anão, teamId: 10, x: 0, y: 3, orientation: Este"; //1
        content[4] = "id: 5, type: Humano, teamId: 10, x: 0, y: 4, orientation: Este"; //3
        content[5] = "id: 6, type: Humano, teamId: 10, x: 0, y: 5, orientation: Este"; //3
        content[6] = "id: 7, type: Dragão, teamId: 10, x: 1, y: 0, orientation: Este"; //9
        content[7] = "id: 8, type: Dragão, teamId: 10, x: 1, y: 1, orientation: Este"; //9
        content[8] = "id: 9, type: Dragão, teamId: 10, x: 1, y: 2, orientation: Este"; //9
        content[9] = "id: 10, type: Gigante, teamId: 10, x: 1, y: 3, orientation: Este"; //5
        content[10] = "id: 11, type: Elfo, teamId: 10, x: 1, y: 4, orientation: Este"; //5
        content[11] = "id: 12, type: Elfo, teamId: 10, x: 1, y: 5, orientation: Este"; //5

        content[12] = "id: 13, type: Anão, teamId: 20, x: 2, y: 0, orientation: Este"; //1
        content[13] = "id: 14, type: Humano, teamId: 20, x: 2, y: 1, orientation: Este"; //3
        content[14] = "id: 15, type: Dragão, teamId: 20, x: 2, y: 2, orientation: Este"; //9
        content[15] = "id: 16, type: Gigante, teamId: 20, x: 2, y: 3, orientation: Este"; //5
        content[16] = "id: 17, type: Elfo, teamId: 20, x: 2, y: 4, orientation: Este"; //5


        assertEquals("Return Start Game, caso id 10 não respeita", 2, tester.startGame(content, 6, 6));

        tester = new FandeisiaGameManager();
        content = new String[18];

        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este"; //1
        content[1] = "id: 2, type: Anão, teamId: 10, x: 0, y: 1, orientation: Este"; //1
        content[2] = "id: 3, type: Anão, teamId: 10, x: 0, y: 2, orientation: Este"; //1
        content[3] = "id: 4, type: Anão, teamId: 10, x: 0, y: 3, orientation: Este"; //1
        content[4] = "id: 5, type: Humano, teamId: 10, x: 0, y: 4, orientation: Este"; //3
        content[5] = "id: 6, type: Humano, teamId: 10, x: 0, y: 5, orientation: Este"; //3
        content[6] = "id: 7, type: Dragão, teamId: 10, x: 1, y: 0, orientation: Este"; //9

        content[7] = "id: 13, type: Anão, teamId: 20, x: 2, y: 0, orientation: Este"; //1
        content[8] = "id: 14, type: Humano, teamId: 20, x: 2, y: 1, orientation: Este"; //3
        content[9] = "id: 15, type: Dragão, teamId: 20, x: 2, y: 2, orientation: Este"; //9
        content[10] = "id: 16, type: Gigante, teamId: 20, x: 2, y: 3, orientation: Este"; //5
        content[11] = "id: 17, type: Elfo, teamId: 20, x: 2, y: 4, orientation: Este"; //5
        content[12] = "id: 18, type: Anão, teamId: 20, x: 2, y: 5, orientation: Este"; //1
        content[13] = "id: 19, type: Dragão, teamId: 20, x: 3, y: 1, orientation: Este"; //9
        content[14] = "id: 20, type: Dragão, teamId: 20, x: 3, y: 2, orientation: Este"; //9
        content[15] = "id: 21, type: Gigante, teamId: 20, x: 3, y: 3, orientation: Este"; //5
        content[16] = "id: 22, type: Gigante, teamId: 20, x: 3, y: 4, orientation: Este"; //5
        content[17] = "id: 23, type: Gigante, teamId: 20, x: 3, y: 5, orientation: Este"; //5

        assertEquals("Return Start Game, caso id 20 não respeita", 3, tester.startGame(content, 6, 6));

    }

    @Test
    public void test_checkSaltarPorCimaGigante() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Gigante, teamId: 10, x: 2, y: 3, orientation: Este";

        tester.startGame(content, 8, 8);
        List<Creature> c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima normal", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[3];
        content[0] = "id: 1, type: Gigante, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: -100, type: hole, x: 3, y: 3";
        content[2] = "id: -101, type: hole, x: 4, y: 3";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 2 holes", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[3];
        content[0] = "id: 1, type: Gigante, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 20, x: 3, y: 3, orientation: Sul";
        content[2] = "id: 3, type: Elfo, teamId: 20, x: 4, y: 3, orientation: Sul";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 2 creatures", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[3];
        content[0] = "id: 1, type: Gigante, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: 2, type: Gigante, teamId: 20, x: 3, y: 3, orientation: Sul";
        content[2] = "id: 3, type: Elfo, teamId: 20, x: 4, y: 3, orientation: Sul";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima tem um gigante", false, tester.checkSaltarPorCima(c.get(0)));


    }

    @Test
    public void test_checkSaltarPorCimaHumano() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Humano, teamId: 10, x: 2, y: 3, orientation: Este";

        tester.startGame(content, 8, 8);
        List<Creature> c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima normal", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[2];
        content[0] = "id: 1, type: Humano, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: -100, type: hole, x: 3, y: 3";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 1 hole", false, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[2];
        content[0] = "id: 1, type: Humano, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: 2, type: Elfo, teamId: 20, x: 3, y: 3, orientation: Sul";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 1 creature", false, tester.checkSaltarPorCima(c.get(0)));

    }

    @Test
    public void test_checkSaltarPorCimaAnao() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 2, y: 3, orientation: Este";

        tester.startGame(content, 8, 8);
        List<Creature> c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima normal", true, tester.checkSaltarPorCima(c.get(0)));
    }

    @Test
    public void test_checkSaltarPorCimaElfo() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Elfo, teamId: 10, x: 2, y: 3, orientation: Este";

        tester.startGame(content, 8, 8);
        List<Creature> c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima normal", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[2];
        content[0] = "id: 1, type: Elfo, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: -100, type: hole, x: 3, y: 3";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima 1 hole", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[2];
        content[0] = "id: 1, type: Elfo, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 20, x: 3, y: 3, orientation: Sul";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 1 creature", false, tester.checkSaltarPorCima(c.get(0)));
    }

    @Test
    public void test_checkSaltarPorCimaDragao() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Dragão, teamId: 10, x: 2, y: 3, orientation: Este";

        tester.startGame(content, 8, 8);
        List<Creature> c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima normal", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[3];
        content[0] = "id: 1, type: Dragão, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: -100, type: hole, x: 3, y: 3";
        content[2] = "id: -101, type: hole, x: 4, y: 3";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 2 holes", true, tester.checkSaltarPorCima(c.get(0)));

        tester = new FandeisiaGameManager();
        content = new String[3];
        content[0] = "id: 1, type: Dragão, teamId: 10, x: 2, y: 3, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 20, x: 3, y: 3, orientation: Sul";
        content[2] = "id: 3, type: Elfo, teamId: 20, x: 4, y: 3, orientation: Sul";

        tester.startGame(content, 8, 8);
        c = tester.getCreatures();
        assertEquals("test_checkSaltarPorCima com 2 creatures", true, tester.checkSaltarPorCima(c.get(0)));

    }

    @Test
    public void test_saveGameANDLoadGame() throws IOException {
        File file = new File("C:\\Users\\marti\\IdeaProjects\\LP2-21805468-21805485\\File\\test.txt");

        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[19];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 10, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 10, x: 0, y: 11, orientation: Este";
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 0, y: 2, orientation: Este";
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 0, y: 3, orientation: Este";
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Este";

        content[5] = "id: 6, type: Anão, teamId: 20, x: 1, y: 1, orientation: Norte";
        content[6] = "id: 7, type: Humano, teamId: 20, x: 1, y: 2, orientation: Sul";
        content[7] = "id: 8, type: Dragão, teamId: 20, x: 1, y: 3, orientation: Oeste";
        content[8] = "id: 9, type: Gigante, teamId: 20, x: 1, y: 4, orientation: Norte";
        content[9] = "id: 10, type: Elfo, teamId: 20, x: 1, y: 5, orientation: Sul";
        content[10] = "id: 11, type: Elfo, teamId: 20, x: 4, y: 1, orientation: Nordeste";
        content[11] = "id: 12, type: Elfo, teamId: 20, x: 4, y: 2, orientation: Noroeste";
        content[12] = "id: 13, type: Elfo, teamId: 20, x: 4, y: 3, orientation: Sudeste";
        content[13] = "id: 14, type: Elfo, teamId: 20, x: 4, y: 4, orientation: Sudoeste";

        content[14] = "id: -1, type: gold, x: 0, y: 11";
        content[15] = "id: -2, type: bronze, x: 2, y: 2";
        content[16] = "id: -3, type: gold, x: 2, y: 3";

        content[17] = "id: -102, type: hole, x: 3, y: 1";
        content[18] = "id: -103, type: hole, x: 3, y: 2";
        tester.startGame(content, 12, 12);
        tester.processTurn();
        tester.saveGame(file);
        System.out.println("File:");
        tester.loadGame(file);
    }

    @Test
    public void test_StringApanharTreasures() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[17];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 10, x: 0, y: 8, orientation: Este";
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 0, y: 2, orientation: Este";
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 0, y: 3, orientation: Este";
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Este";

        content[5] = "id: 6, type: Anão, teamId: 20, x: 1, y: 1, orientation: Norte";
        content[6] = "id: 7, type: Humano, teamId: 20, x: 1, y: 2, orientation: Sul";
        content[7] = "id: 8, type: Dragão, teamId: 20, x: 1, y: 3, orientation: Oeste";
        content[8] = "id: 9, type: Gigante, teamId: 20, x: 1, y: 4, orientation: Norte";
        content[9] = "id: 10, type: Elfo, teamId: 20, x: 1, y: 5, orientation: Sul";

        content[10] = "id: -1, type: gold, x: 1, y: 0";
        content[11] = "id: -2, type: bronze, x: 2, y: 0";
        content[12] = "id: -3, type: gold, x: 2, y: 3";

        content[13] = "id: -100, type: hole, x: 3, y: 1";
        content[14] = "id: -101, type: hole, x: 3, y: 2";
        content[15] = "id: -102, type: hole, x: 3, y: 3";
        content[16] = "id: -103, type: hole, x: 3, y: 4";
        tester.startGame(content, 10, 10);
        tester.processTurn();
        assertEquals(1 + " | " + "Anão" + " | " + 10 + " | " + 1 + " @ (" + 1 + ", " + 0 + ") " + "Este",tester.getCreatures().get(0).toString());
        tester.processTurn();
        tester.processTurn();
        assertEquals(1 + " | " + "Anão" + " | " + 10 + " | " + 2 + " @ (" + 3 + ", " + 0 + ") " + "Este",tester.getCreatures().get(0).toString());

    }
}
