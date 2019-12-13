package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class Teste_FandeisiaGameManager {

    @Test
    public void test_CriacaoDosObjetosContent() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[19];
        content[0] = "id: 1, type: Anao, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 10, x: 0, y: 1, orientation: Este";
        content[2] = "id: 3, type: Dragao, teamId: 10, x: 0, y: 2, orientation: Este";
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 0, y: 3, orientation: Este";
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Este";

        content[5] = "id: 6, type: Anao, teamId: 20, x: 1, y: 1, orientation: Norte";
        content[6] = "id: 7, type: Humano, teamId: 20, x: 1, y: 2, orientation: Sul";
        content[7] = "id: 8, type: Dragao, teamId: 20, x: 1, y: 3, orientation: Oeste";
        content[8] = "id: 9, type: Gigante, teamId: 20, x: 1, y: 4, orientation: Norte";
        content[9] = "id: 10, type: Elfo, teamId: 20, x: 1, y: 5, orientation: Sul";
        content[10] = "id: 11, type: Elfo, teamId: 20, x: 4, y: 1, orientation: Nordeste";
        content[11] = "id: 12, type: Elfo, teamId: 20, x: 4, y: 2, orientation: Noroeste";
        content[12] = "id: 13, type: Elfo, teamId: 20, x: 4, y: 3, orientation: Sudeste";
        content[13] = "id: 14, type: Elfo, teamId: 20, x: 4, y: 4, orientation: Sudoeste";

        content[14] = "id: -1, type: silver, x: 2, y: 1";
        content[15] = "id: -2, type: bronze, x: 2, y: 2";
        content[16] = "id: -3, type: gold, x: 2, y: 3";

        content[17] = "id: -102, type: hole, x: 3, y: 1";
        content[18] = "id: -103, type: hole, x: 3, y: 2";

        tester.startGame(content, 6, 6);

        assertEquals("Tamanho Creatures", 14, tester.getNumberCreatures());
        assertEquals("Tamanho Treasures", 3, tester.getNumberTreasures());
        assertEquals("Tamanho Holes", 2, tester.getNumberHoles());

        List<Creature> creatures = tester.getCreatures();
        assertEquals("1 | Anao | 10 | 0 @ (0, 0) Este", creatures.get(0).toString());
        assertEquals("2 | Humano | 10 | 0 @ (0, 1) Este", creatures.get(1).toString());
        assertEquals("3 | Dragao | 10 | 0 @ (0, 2) Este", creatures.get(2).toString());
        assertEquals("4 | Gigante | 10 | 0 @ (0, 3) Este", creatures.get(3).toString());
        assertEquals("5 | Elfo | 10 | 0 @ (0, 4) Este", creatures.get(4).toString());
        assertEquals("6 | Anao | 20 | 0 @ (1, 1) Norte", creatures.get(5).toString());
        assertEquals("7 | Humano | 20 | 0 @ (1, 2) Sul", creatures.get(6).toString());
        assertEquals("8 | Dragao | 20 | 0 @ (1, 3) Oeste", creatures.get(7).toString());
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
        assertEquals("-102 | hole @ (3, 1)", holes.get(0).toString());
        assertEquals("-103 | hole @ (3, 2)", holes.get(1).toString());


    }

    @Test
    public void test_Movimento90_Creature90() {
        //Caso Normal
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[4];

        content[0] = "id: 1, type: Anao, teamId: 10, x: 0, y: 1, orientation: Norte";
        content[1] = "id: 2, type: Anao, teamId: 10, x: 0, y: 3, orientation: Sul";
        content[2] = "id: 3, type: Anao, teamId: 20, x: 3, y: 3, orientation: Este";
        content[3] = "id: 4, type: Anao, teamId: 20, x: 2, y: 1, orientation: Oeste";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        List<Creature> creatures = tester.getCreatures();

        assertEquals("Caso Normal Norte", "1 | Anao | 10 | 0 @ (0, 0) Norte", creatures.get(0).toString());
        assertEquals("Caso Normal Sul", "2 | Anao | 10 | 0 @ (0, 4) Sul", creatures.get(1).toString());
        assertEquals("Caso Normal Este", "3 | Anao | 20 | 0 @ (4, 3) Este", creatures.get(2).toString());
        assertEquals("Caso Normal Oeste", "4 | Anao | 20 | 0 @ (1, 1) Oeste", creatures.get(3).toString());

        //Caso Rotação por ter criatura impedir movimento
        tester = new FandeisiaGameManager();

        content = new String[8];

        content[0] = "id: 1, type: Anao, teamId: 10, x: 1, y: 1, orientation: Norte";
        content[1] = "id: 2, type: Anao, teamId: 10, x: 1, y: 0, orientation: Oeste";

        content[2] = "id: 3, type: Anao, teamId: 10, x: 3, y: 1, orientation: Sul";
        content[3] = "id: 4, type: Anao, teamId: 10, x: 3, y: 2, orientation: Este";

        content[4] = "id: 5, type: Anao, teamId: 10, x: 1, y: 4, orientation: Este";
        content[5] = "id: 6, type: Anao, teamId: 10, x: 2, y: 4, orientation: Este";

        content[6] = "id: 7, type: Anao, teamId: 10, x: 2, y: 3, orientation: Oeste";
        content[7] = "id: 8, type: Anao, teamId: 10, x: 1, y: 3, orientation: Oeste";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Rotacao Norte (obstaculo: Creature)", "1 | Anao | 10 | 0 @ (1, 1) Este", creatures.get(0).toString());
        assertEquals("Caso Rotacao Sul (obstaculo: Creature)", "3 | Anao | 10 | 0 @ (3, 1) Oeste", creatures.get(2).toString());
        assertEquals("Caso Rotacao Este (obstaculo: Creature)", "5 | Anao | 10 | 0 @ (1, 4) Sul", creatures.get(4).toString());
        assertEquals("Caso Rotacao Oeste (obstaculo: Creature)", "7 | Anao | 10 | 0 @ (2, 3) Norte", creatures.get(6).toString());

        //Caso Rotação por ter hole impedir movimento
        tester = new FandeisiaGameManager();

        content = new String[8];

        content[0] = "id: 1, type: Anao, teamId: 10, x: 1, y: 1, orientation: Norte";
        content[1] = "id: -100, type: hole, x: 1, y: 0";

        content[2] = "id: 2, type: Anao, teamId: 10, x: 3, y: 1, orientation: Sul";
        content[3] = "id: -101, type: hole, x: 3, y: 2";

        content[4] = "id: 3, type: Anao, teamId: 10, x: 1, y: 4, orientation: Este";
        content[5] = "id: -102, type: hole, x: 2, y: 4";

        content[6] = "id: 4, type: Anao, teamId: 10, x: 2, y: 3, orientation: Oeste";
        content[7] = "id: -103, type: hole, x: 1, y: 3";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Rotacao Norte (obstaculo: Hole)", "1 | Anao | 10 | 0 @ (1, 1) Este", creatures.get(0).toString());
        assertEquals("Caso Rotacao Sul (obstaculo: Hole)", "2 | Anao | 10 | 0 @ (3, 1) Oeste", creatures.get(1).toString());
        assertEquals("Caso Rotacao Este (obstaculo: Hole)", "3 | Anao | 10 | 0 @ (1, 4) Sul", creatures.get(2).toString());
        assertEquals("Caso Rotacao Oeste (obstaculo: Hole)", "4 | Anao | 10 | 0 @ (2, 3) Norte", creatures.get(3).toString());

        //Margens Rotação
        tester = new FandeisiaGameManager();

        content = new String[4];

        content[0] = "id: 1, type: Anao, teamId: 10, x: 0, y: 0, orientation: Norte";
        content[1] = "id: 2, type: Anao, teamId: 10, x: 1, y: 5, orientation: Sul";
        content[2] = "id: 3, type: Anao, teamId: 10, x: 4, y: 2, orientation: Este";
        content[3] = "id: 4, type: Anao, teamId: 10, x: 0, y: 3, orientation: Oeste";

        tester.startGame(content, 6, 5);
        tester.processTurn();
        creatures = tester.getCreatures();

        assertEquals("Caso Margem Norte", "1 | Anao | 10 | 0 @ (0, 0) Este", creatures.get(0).toString());
        assertEquals("Caso Margem Sul", "2 | Anao | 10 | 0 @ (1, 5) Oeste", creatures.get(1).toString());
        assertEquals("Caso Margem Este", "3 | Anao | 10 | 0 @ (4, 2) Sul", creatures.get(2).toString());
        assertEquals("Caso Margem Oeste", "4 | Anao | 10 | 0 @ (0, 3) Norte", creatures.get(3).toString());

    }

}
