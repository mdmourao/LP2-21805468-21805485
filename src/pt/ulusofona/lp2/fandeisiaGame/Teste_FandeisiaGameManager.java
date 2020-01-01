package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.*;

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
    public void test_CriacaoDosObjetosContentComErros() {
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

        //ERROS:
        content[8] = "id: AA, type: Gigante, teamId: 20, x: 1, y: 4, orientation: Norte";
        content[9] = "id: 10, type: 12, teamId: 20, x: 1, y: 5, orientation: Sul";
        content[10] = "id: 11, type: Elfo, teamId: AA, x: 4, y: 1, orientation: Nordeste";
        content[11] = "id: 12, type: Elfo, teamId: 20, x: A, y: 2, orientation: Noroeste";
        content[12] = "id: 13, type: Elfo, teamId: 20, x: 4, y: B, orientation: Sudeste";
        content[13] = "id: 14, type: Elfo, teamId: 20, x: 4, y: 4, orientation: 1";

        //ERROS:
        content[14] = "id: -1, type: silver, x: A, y: 1";
        content[15] = "id: -2, type: ola, x: 2, y: 2";
        content[16] = "id: -3, type: gold, x: 2, y: B";
        content[19] = "id: -A, type: gold, x: 2, y: 3";

        //ERROS:
        content[17] = "id: -100, type: hole, x: 3, y: 1";
        content[18] = "id: -101, type: hole, x: A, y: 2";
        content[20] = "id: -103, type: hole, x: 3, y: B";

        tester.startGame(content, 6, 6);

        assertEquals("Tamanho Creatures", 8, tester.getNumberCreatures());
        assertEquals("Tamanho Treasures", 0, tester.getNumberTreasures());
        assertEquals("Tamanho Holes", 1, tester.getNumberHoles());

        List<Creature> creatures = tester.getCreatures();
        assertEquals("1 | Anão | 10 | 0 @ (0, 0) Este", creatures.get(0).toString());
        assertEquals("2 | Humano | 10 | 0 @ (0, 1) Este", creatures.get(1).toString());
        assertEquals("3 | Dragão | 10 | 0 @ (0, 2) Este", creatures.get(2).toString());
        assertEquals("4 | Gigante | 10 | 0 @ (0, 3) Este", creatures.get(3).toString());
        assertEquals("5 | Elfo | 10 | 0 @ (0, 4) Este", creatures.get(4).toString());
        assertEquals("6 | Anão | 20 | 0 @ (1, 1) Norte", creatures.get(5).toString());
        assertEquals("7 | Humano | 20 | 0 @ (1, 2) Sul", creatures.get(6).toString());
        assertEquals("8 | Dragão | 20 | 0 @ (1, 3) Oeste", creatures.get(7).toString());


        List<Hole> holes = tester.getHoles();
        assertEquals("-100 | hole @ (3, 1)", holes.get(0).toString());


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

    //TODO
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
        String[] content = new String[9];
        content[0] = "id: 1, type: Elfo, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: 2, type: Elfo, teamId: 20, x: 0, y: 1, orientation: Este";

        content[2] = "id: -1, type: gold, x: 2, y: 0";
        content[3] = "id: -2, type: bronze, x: 4, y: 1";
        content[4] = "id: -3, type: gold, x: 6, y: 1";

        content[5] = "id: -100, type: hole, x: 3, y: 1";
        content[6] = "id: -101, type: hole, x: 3, y: 2";
        content[7] = "id: -102, type: hole, x: 3, y: 3";
        content[8] = "id: -103, type: hole, x: 3, y: 4";
        tester.startGame(content, 10, 10);
        tester.processTurn();
        assertEquals(1 + " | " + "Elfo" + " | " + 10 + " | " + 1 + " @ (" + 2 + ", " + 0 + ") " + "Este", tester.getCreatures().get(0).toString());
        assertEquals(2 + " | " + "Elfo" + " | " + 20 + " | " + 0 + " @ (" + 2 + ", " + 1 + ") " + "Este", tester.getCreatures().get(1).toString());
        tester.processTurn();
        assertEquals(1 + " | " + "Elfo" + " | " + 10 + " | " + 1 + " @ (" + 4 + ", " + 0 + ") " + "Este", tester.getCreatures().get(0).toString());
        assertEquals(2 + " | " + "Elfo" + " | " + 20 + " | " + 1 + " @ (" + 4 + ", " + 1 + ") " + "Este", tester.getCreatures().get(1).toString());
        tester.processTurn();
        assertEquals(1 + " | " + "Elfo" + " | " + 10 + " | " + 1 + " @ (" + 6 + ", " + 0 + ") " + "Este", tester.getCreatures().get(0).toString());
        assertEquals(2 + " | " + "Elfo" + " | " + 20 + " | " + 2 + " @ (" + 6 + ", " + 1 + ") " + "Este", tester.getCreatures().get(1).toString());
    }

    //TODO
    @Test
    public void test_gameisOver() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[5];
        content[0] = "id: 1, type: Elfo, teamId: 10, x: 0, y: 0, orientation: Este";
        content[1] = "id: -1, type: gold, x: 2, y: 0";
        content[2] = "id: -2, type: bronze, x: 5, y: 5";
        content[3] = "id: -3, type: bronze, x: 6, y: 5";
        content[4] = "id: -4, type: bronze, x: 6, y: 5";

        tester.startGame(content, 10, 10);
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //1
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //2
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //3
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //4
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //5
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //6
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //7
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //8
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //9
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //10
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //11
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //12
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //13
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //14
        tester.processTurn();
        assertEquals(false, tester.gameIsOver());
        //15
        tester.processTurn();
        assertEquals(true, tester.gameIsOver());
    }

    //TODO
    @Test
    public void test_enchant() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[7];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este";
        // 00 10 20
        content[1] = "id: 2, type: Elfo, teamId: 20, x: 0, y: 8, orientation: Este";
        content[2] = "id: 2, type: Elfo, teamId: 20, x: 0, y: 1, orientation: Este";


        content[3] = "id: -100, type: hole, x: 2, y: 0";
        content[4] = "id: -101, type: hole, x: 12, y: 0";
        content[5] = "id: -102, type: hole, x: 3, y: 3";
        content[6] = "id: -103, type: hole, x: 3, y: 4";
        tester.startGame(content, 20, 20);
        assertEquals(false,tester.enchant(0, 0, "DuplicaAlcance"));
        assertEquals(false,tester.enchant(8, 0, "DuplicaAlcance"));
        assertEquals(true,tester.enchant(0, 1, "DuplicaAlcance"));
        assertEquals(false,tester.enchant(0, 1, "DuplicaAlcance"));
        assertEquals(true,tester.enchant(0, 8, "EmpurraParaEste"));
        assertEquals(false,tester.enchant(0, 8, "EmpurraParaSul"));
        tester.processTurn();
        assertEquals(1,tester.getElementId(1,0));


    }

    @Test
    public void test_getCreatureTypes() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        int count = 0;
        String[][] creatures = tester.getCreatureTypes();
        for(int i = 0;i < creatures.length; i++){
            for(int i1 = 0; i1 < creatures[i].length; i1++){
                if(creatures[i][i1].equals("Anão") ){
                    count++;
                }
                if(creatures[i][i1].equals("Dragão") ){
                    count++;
                }
                if(creatures[i][i1].equals("Elfo") ){
                    count++;
                }
                if(creatures[i][i1].equals("Gigante") ){
                    count++;
                }
                if(creatures[i][i1].equals("Humano") ){
                    count++;
                }
            }
        }
        assertEquals(5,count);
    }

    @Test
    public void test_getSpellTypes() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        int count = 0;
        String[][] creatures = tester.getSpellTypes();
        for(int i = 0;i < creatures.length; i++){
            for(int i1 = 0; i1 < creatures[i].length; i1++){
                if(creatures[i][i1].equals("EmpurraParaNorte") ){
                    count++;
                }
                if(creatures[i][i1].equals("EmpurraParaEste") ){
                    count++;
                }
                if(creatures[i][i1].equals("EmpurraParaSul") ){
                    count++;
                }
                if(creatures[i][i1].equals("EmpurraParaOeste") ){
                    count++;
                }
                if(creatures[i][i1].equals("ReduzAlcance") ){
                    count++;
                }
                if(creatures[i][i1].equals("DuplicaAlcance") ){
                    count++;
                }
                if(creatures[i][i1].equals("Congela") ){
                    count++;
                }
                if(creatures[i][i1].equals("Congela4Ever") ){
                    count++;
                }
                if(creatures[i][i1].equals("Descongela") ){
                    count++;
                }
            }
        }
        assertEquals(9,count);
    }

    @Test
    public void test_aplicarFeitico() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[14];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 1, y: 0, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 10, x: 2, y: 0, orientation: Este";
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 3, y: 3, orientation: Este";
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 4, y: 0, orientation: Este";
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 5, y: 0, orientation: Este";

        content[5] = "id: 6, type: Anão, teamId: 20, x: 1, y: 2, orientation: Norte";
        content[6] = "id: 7, type: Humano, teamId: 20, x: 2, y: 2, orientation: Sul";
        content[7] = "id: 8, type: Dragão, teamId: 20, x: 3, y: 2, orientation: Oeste";
        content[8] = "id: 9, type: Gigante, teamId: 20, x: 4, y: 2, orientation: Norte";
        content[9] = "id: 10, type: Elfo, teamId: 20, x: 5, y: 2, orientation: Sul";

        content[10] = "id: 11, type: Elfo, teamId: 20, x: 1, y: 6, orientation: Nordeste";
        content[11] = "id: 12, type: Elfo, teamId: 20, x: 2, y: 6, orientation: Noroeste";
        content[12] = "id: 13, type: Elfo, teamId: 20, x: 3, y: 6, orientation: Sudeste";
        content[13] = "id: 14, type: Elfo, teamId: 20, x: 4, y: 6, orientation: Sudoeste";
        tester.startGame(content, 15, 15);

        tester.aplicarFeitico(1,6,"EmpurraParaNorte");
        tester.aplicarFeitico(5,0,"EmpurraParaEste");
        tester.aplicarFeitico(4,6,"EmpurraParaSul");
        tester.aplicarFeitico(3,3,"EmpurraParaOeste");
        assertEquals(11,tester.getElementId(1,5));
        assertEquals(5,tester.getElementId(6,0));
        assertEquals(14,tester.getElementId(4,7));
        assertEquals(3,tester.getElementId(2,3));

        tester.aplicarFeitico(4,0,"ReduzAlcance");
        assertEquals(1,tester.getCreatures().get(3).getStepSize());

        tester.aplicarFeitico(3,6,"DuplicaAlcance");
        assertEquals(4,tester.getCreatures().get(12).getStepSize());

        tester.aplicarFeitico(2,0,"Congela");
        assertEquals(true,tester.getCreatures().get(1).isCongelado1Round());

        tester.aplicarFeitico(2,6,"Congela4Ever");
        assertEquals(true,tester.getCreatures().get(11).isCongeladoForever());

        tester.aplicarFeitico(2,6,"Descongela");
        assertEquals(false,tester.getCreatures().get(11).isCongeladoForever());
    }

    @Test
    public void test_valorFeitico() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        assertEquals(1,tester.valorFeitico("EmpurraParaNorte"));
        assertEquals(1,tester.valorFeitico("EmpurraParaEste"));
        assertEquals(1,tester.valorFeitico("EmpurraParaSul"));
        assertEquals(1,tester.valorFeitico("EmpurraParaOeste"));

        assertEquals(2,tester.valorFeitico("ReduzAlcance"));
        assertEquals(3,tester.valorFeitico("DuplicaAlcance"));
        assertEquals(3,tester.valorFeitico("Congela"));
        assertEquals(10,tester.valorFeitico("Congela4Ever"));
        assertEquals(8,tester.valorFeitico("Descongela"));

    }

    @Test
    public void test_getSpell() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[14];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 1, y: 0, orientation: Este";
        content[1] = "id: 2, type: Humano, teamId: 10, x: 2, y: 0, orientation: Este";
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 3, y: 3, orientation: Este";
        content[3] = "id: 4, type: Gigante, teamId: 10, x: 4, y: 0, orientation: Este";
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 5, y: 0, orientation: Este";

        content[5] = "id: 6, type: Anão, teamId: 20, x: 1, y: 2, orientation: Norte";
        content[6] = "id: 7, type: Humano, teamId: 20, x: 2, y: 2, orientation: Sul";
        content[7] = "id: 8, type: Dragão, teamId: 20, x: 3, y: 2, orientation: Oeste";
        content[8] = "id: 9, type: Gigante, teamId: 20, x: 4, y: 2, orientation: Norte";
        content[9] = "id: 10, type: Elfo, teamId: 20, x: 5, y: 2, orientation: Sul";

        content[10] = "id: 11, type: Elfo, teamId: 20, x: 1, y: 6, orientation: Nordeste";
        content[11] = "id: 12, type: Elfo, teamId: 20, x: 2, y: 6, orientation: Noroeste";
        content[12] = "id: 13, type: Elfo, teamId: 20, x: 3, y: 6, orientation: Sudeste";
        content[13] = "id: 14, type: Elfo, teamId: 20, x: 4, y: 6, orientation: Sudoeste";
        tester.startGame(content, 15, 15);

        assertTrue(tester.enchant(1, 6, "EmpurraParaNorte"));
        assertTrue(tester.enchant(5,0,"EmpurraParaEste"));
        assertTrue(tester.enchant(4,6,"EmpurraParaSul"));
        assertTrue(tester.enchant(3,3,"EmpurraParaOeste"));
        assertTrue(tester.enchant(4,0,"DuplicaAlcance"));
        assertTrue(tester.enchant(3,6,"ReduzAlcance"));
        assertTrue(tester.enchant(2,0,"Congela"));
        assertTrue(tester.enchant(2,6,"Congela4Ever"));
        assertEquals("EmpurraParaNorte",tester.getSpell(1,6));
        assertEquals("EmpurraParaEste",tester.getSpell(5,0));
        assertEquals("EmpurraParaSul",tester.getSpell(4,6));
        assertEquals("EmpurraParaOeste",tester.getSpell(3,3));
        assertEquals("DuplicaAlcance",tester.getSpell(4,0));
        assertEquals("ReduzAlcance",tester.getSpell(3,6));
        assertEquals("Congela",tester.getSpell(2,0));
        assertEquals("Congela4Ever",tester.getSpell(2,6));
        tester.processTurn();
        assertTrue(tester.enchant(2,6,"Descongela"));
    }

    @Test
    public void test_getCoinTotal() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: NAOEXISTE, teamId: 10, x: 0, y: 0, orientation: Este";
        tester.startGame(content,1,1);
        assertEquals(50,tester.getCoinTotal(10));
        assertEquals(50,tester.getCoinTotal(20));

        content = new String[11];
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
        tester.startGame(content,12,12);
        assertEquals(27,tester.getCoinTotal(10));
        assertEquals(26,tester.getCoinTotal(20));

        tester = new FandeisiaGameManager();
        content = new String[11];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Este"; //1
        content[1] = "id: 2, type: Anão, teamId: 10, x: 0, y: 1, orientation: Este"; //1
        content[2] = "id: 3, type: Dragão, teamId: 10, x: 0, y: 2, orientation: Este"; //9
        content[3] = "id: 4, type: Dragão, teamId: 10, x: 0, y: 3, orientation: Este"; //9
        content[4] = "id: 5, type: Elfo, teamId: 10, x: 0, y: 4, orientation: Este"; //5

        content[5] = "id: 1, type: Anão, teamId: 20, x: 0, y: 0, orientation: Este"; //1
        content[6] = "id: 2, type: Humano, teamId: 20, x: 0, y: 1, orientation: Este"; //3
        content[7] = "id: 3, type: Dragão, teamId: 20, x: 0, y: 2, orientation: Este"; //9
        content[8] = "id: 4, type: Gigante, teamId: 20, x: 0, y: 3, orientation: Este"; //5
        content[9] = "id: 5, type: Elfo, teamId: 20, x: 0, y: 4, orientation: Este"; //5
        content[10] = "id: 5, type: Elfo, teamId: 20, x: 0, y: 6, orientation: Este"; //5
        tester.startGame(content,12,12);
        assertEquals(25,tester.getCoinTotal(10));
        assertEquals(22,tester.getCoinTotal(20));

    }

    @Test
    public void test_whoIsLordEder() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        assertEquals("Ederzito António Macedo Lopes",tester.whoIsLordEder());
    }

    @Test
    public void test_getResults() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        String[] content = new String[12];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Sul";
        content[1] = "id: 2, type: Anão, teamId: 10, x: 2, y: 2, orientation: Sul";
        content[2] = "id: 3, type: Anão, teamId: 10, x: 4, y: 4, orientation: Sul";
        content[3] = "id: 4, type: Anão, teamId: 20, x: 6, y: 6, orientation: Sul";
        content[4] = "id: 5, type: Anão, teamId: 20, x: 8, y: 8, orientation: Sul";
        content[5] = "id: 6, type: Anão, teamId: 20, x: 10, y: 10, orientation: Sul";

        content[6] = "id: -1, type: silver, x: 0, y: 1";
        content[7] = "id: -2, type: bronze, x: 2, y: 3";
        content[8] = "id: -3, type: gold, x: 4, y: 5";

        content[9] = "id: -4, type: silver, x: 6, y: 7";
        content[10] = "id: -5, type: bronze, x: 8, y: 9";
        content[11] = "id: -6, type: gold, x: 10, y: 11";

        tester.startGame(content,12,12);
        tester.processTurn();
        assertEquals(0,tester.getTreausres().size());
        assertTrue(tester.gameIsOver());
        List<String> result = tester.getResults();
        assertEquals("Resultado: EMPATE",result.get(1));
        assertEquals("LDR: 6",result.get(2));
        assertEquals("RESISTENCIA: 6",result.get(3));
        assertEquals("Nr. de Turnos jogados: 1",result.get(4));

        assertEquals("1 : Anão : 0 : 1 : 0 : 2",result.get(6));
        assertEquals("2 : Anão : 0 : 0 : 1 : 1",result.get(7));
        assertEquals("3 : Anão : 1 : 0 : 0 : 3",result.get(8));

        assertEquals("4 : Anão : 0 : 1 : 0 : 2",result.get(9));
        assertEquals("5 : Anão : 0 : 0 : 1 : 1",result.get(10));
        assertEquals("6 : Anão : 1 : 0 : 0 : 3",result.get(11));

        tester = new FandeisiaGameManager();
        content = new String[12];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Sul";
        content[1] = "id: 2, type: Anão, teamId: 10, x: 2, y: 2, orientation: Sul";
        content[2] = "id: 3, type: Anão, teamId: 10, x: 4, y: 4, orientation: Sul";
        content[3] = "id: 4, type: Anão, teamId: 10, x: 6, y: 6, orientation: Sul";
        content[4] = "id: 5, type: Anão, teamId: 20, x: 8, y: 8, orientation: Sul";
        content[5] = "id: 6, type: Anão, teamId: 20, x: 10, y: 10, orientation: Sul";

        content[6] = "id: -1, type: silver, x: 0, y: 1";
        content[7] = "id: -2, type: bronze, x: 2, y: 3";
        content[8] = "id: -3, type: gold, x: 4, y: 5";

        content[9] = "id: -4, type: silver, x: 6, y: 7";
        content[10] = "id: -5, type: bronze, x: 8, y: 9";
        content[11] = "id: -6, type: gold, x: 10, y: 11";

        tester.startGame(content,12,12);
        tester.processTurn();
        assertEquals(0,tester.getTreausres().size());
        assertTrue(tester.gameIsOver());
        result = tester.getResults();
        assertEquals("Resultado: Vitória da equipa LDR",result.get(1));
        assertEquals("LDR: 8",result.get(2));
        assertEquals("RESISTENCIA: 4",result.get(3));
        assertEquals("Nr. de Turnos jogados: 1",result.get(4));

        assertEquals("1 : Anão : 0 : 1 : 0 : 2",result.get(6));
        assertEquals("2 : Anão : 0 : 0 : 1 : 1",result.get(7));
        assertEquals("3 : Anão : 1 : 0 : 0 : 3",result.get(8));

        assertEquals("4 : Anão : 0 : 1 : 0 : 2",result.get(9));
        assertEquals("5 : Anão : 0 : 0 : 1 : 1",result.get(10));
        assertEquals("6 : Anão : 1 : 0 : 0 : 3",result.get(11));

        tester = new FandeisiaGameManager();
        content = new String[12];
        content[0] = "id: 1, type: Anão, teamId: 10, x: 0, y: 0, orientation: Sul";
        content[1] = "id: 2, type: Anão, teamId: 10, x: 2, y: 2, orientation: Sul";
        content[2] = "id: 3, type: Anão, teamId: 20, x: 4, y: 4, orientation: Sul";
        content[3] = "id: 4, type: Anão, teamId: 20, x: 6, y: 6, orientation: Sul";
        content[4] = "id: 5, type: Anão, teamId: 20, x: 8, y: 8, orientation: Sul";
        content[5] = "id: 6, type: Anão, teamId: 20, x: 10, y: 10, orientation: Sul";

        content[6] = "id: -1, type: silver, x: 0, y: 1";
        content[7] = "id: -2, type: bronze, x: 2, y: 3";
        content[8] = "id: -3, type: gold, x: 4, y: 5";

        content[9] = "id: -4, type: silver, x: 6, y: 7";
        content[10] = "id: -5, type: bronze, x: 8, y: 9";
        content[11] = "id: -6, type: gold, x: 10, y: 11";

        tester.startGame(content,12,12);
        tester.processTurn();
        assertEquals(0,tester.getTreausres().size());
        assertTrue(tester.gameIsOver());
        result = tester.getResults();
        assertEquals("Resultado: Vitória da equipa RESISTENCIA",result.get(1));
        assertEquals("LDR: 3",result.get(3));
        assertEquals("RESISTENCIA: 9",result.get(2));
        assertEquals("Nr. de Turnos jogados: 1",result.get(4));

        assertEquals("1 : Anão : 0 : 1 : 0 : 2",result.get(6));
        assertEquals("2 : Anão : 0 : 0 : 1 : 1",result.get(7));
        assertEquals("3 : Anão : 1 : 0 : 0 : 3",result.get(8));

        assertEquals("4 : Anão : 0 : 1 : 0 : 2",result.get(9));
        assertEquals("5 : Anão : 0 : 0 : 1 : 1",result.get(10));
        assertEquals("6 : Anão : 1 : 0 : 0 : 3",result.get(11));

    }

    @Test
    public void test_getAuthors() {
        FandeisiaGameManager tester = new FandeisiaGameManager();
        List<String> authors = tester.getAuthors();
        assertEquals(">Gonçalo Evora 21805468 Aka: RØKT",authors.get(0));
        assertEquals(">Martim Mourão 21805485 Aka: Mike",authors.get(1));
        assertEquals("LP2 Enunciado By: Bruno Cipriano, Rodrigo Correia, Pedro Alves",authors.get(2));
    }

    @Test
    public void test_getElementId_getType() {
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
        assertEquals(1,tester.getElementId(0,0));
        assertEquals(2,tester.getElementId(0,1));
        assertEquals(3,tester.getElementId(0,2));
        assertEquals(4,tester.getElementId(0,3));
        assertEquals(5,tester.getElementId(0,4));
        assertEquals(6,tester.getElementId(1,1));
        assertEquals(7,tester.getElementId(1,2));
        assertEquals(8,tester.getElementId(1,3));
        assertEquals(9,tester.getElementId(1,4));
        assertEquals(10,tester.getElementId(1,5));
        assertEquals(11,tester.getElementId(4,1));
        assertEquals(12,tester.getElementId(4,2));
        assertEquals(13,tester.getElementId(4,3));
        assertEquals(14,tester.getElementId(4,4));

        assertEquals("Anão",tester.getType(0,0));
        assertEquals("Humano",tester.getType(0,1));
        assertEquals("Dragão",tester.getType(0,2));
        assertEquals("Gigante",tester.getType(0,3));
        assertEquals("Elfo",tester.getType(0,4));
        assertEquals("Anão",tester.getType(1,1));
        assertEquals("Humano",tester.getType(1,2));
        assertEquals("Dragão",tester.getType(1,3));
        assertEquals("Gigante",tester.getType(1,4));
        assertEquals("Elfo",tester.getType(1,5));
        assertEquals("Elfo",tester.getType(4,1));
        assertEquals("Elfo",tester.getType(4,2));
        assertEquals("Elfo",tester.getType(4,3));
        assertEquals("Elfo",tester.getType(4,4));

        assertEquals(-1,tester.getElementId(2,1));
        assertEquals(-2,tester.getElementId(2,2));
        assertEquals(-3,tester.getElementId(2,3));

        assertEquals(-100,tester.getElementId(3,1));
        assertEquals(-101,tester.getElementId(3,2));
        assertEquals(-102,tester.getElementId(3,3));
        assertEquals(-103,tester.getElementId(3,4));

        assertEquals("hole",tester.getType(3,1));
        assertEquals("hole",tester.getType(3,2));
        assertEquals("hole",tester.getType(3,3));
        assertEquals("hole",tester.getType(3,4));
    }

    @Test
    public void test_getCreature() {
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
        assertEquals(1,tester.getCreature(0,0).getId());
        assertEquals(2,tester.getCreature(0,1).getId());
        assertEquals(3,tester.getCreature(0,2).getId());
        assertEquals(4,tester.getCreature(0,3).getId());
        assertEquals(5,tester.getCreature(0,4).getId());
        assertEquals(6,tester.getCreature(1,1).getId());
        assertEquals(7,tester.getCreature(1,2).getId());
        assertEquals(8,tester.getCreature(1,3).getId());
        assertEquals(9,tester.getCreature(1,4).getId());
        assertEquals(10,tester.getCreature(1,5).getId());
        assertEquals(11,tester.getCreature(4,1).getId());
        assertEquals(12,tester.getCreature(4,2).getId());
        assertEquals(13,tester.getCreature(4,3).getId());
        assertEquals(14,tester.getCreature(4,4).getId());
    }

    @Test
    public void test_getCurrentTeamId() {
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
        tester.startGame(content,12,12);
        assertEquals(10,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(20,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(10,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(20,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(10,tester.getCurrentTeamId());
        tester.processTurn();
        assertTrue(tester.gameIsOver());

        tester = new FandeisiaGameManager();
        tester.startGame(content,12,12);
        tester.setCurrentTeamId(20);
        assertEquals(20,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(10,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(20,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(10,tester.getCurrentTeamId());
        tester.processTurn();
        assertFalse(tester.gameIsOver());
        assertEquals(20,tester.getCurrentTeamId());
        tester.processTurn();
        assertTrue(tester.gameIsOver());

    }

    //TODO
    @Test
    public void test_Scores() {
        
    }

    //TODO
    @Test
    public void test_removeMoedas() {

    }

    //TODO
    @Test
    public void test_clearAllData() {

    }

    //TODO test testar coins do random criar army computer IMPORTANTE
    //TODO feiticos nao podem ser aplicados testar
    //TODO testar coverage por favor
    //TODO test treasures
    //TODO test holes
    //TODO criatura a tentar ir para posição que ja tem creature nos feiticos
    //TODO alterar o load and save game


}

