package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test_Creature {

    @Test
    public void test_01_toString() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        String toStringExpected = "1 | Criatura | 0 | 0 @ (1, 2) Norte";
        assertEquals(toStringExpected, creature.toString());
    }

    @Test
    public void test_02_getX() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        int expected = 1;
        assertEquals(expected, creature.getX());
    }

    @Test
    public void test_03_moveX_Este() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.moveX(1);
        int expected = 2;
        assertEquals(expected, creature.getX());
    }

    @Test
    public void test_04_moveX_Oeste() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.moveX(-1);
        int expected = 0;
        assertEquals(expected, creature.getX());
    }

    @Test
    public void test_05_moveY_Norte() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.moveY(-1);
        int expected = 1;
        assertEquals(expected, creature.getY());
    }

    @Test
    public void test_06_moveY_Sul() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.moveY(1);
        int expected = 3;
        assertEquals(expected, creature.getY());
    }

    @Test
    public void test_07_getY() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        int expected = 2;
        assertEquals(expected, creature.getY());
    }

    @Test
    public void test_08_moveX_moveY_getX_getY() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.moveX(2);
        creature.moveY(3);
        creature.moveX(-1);
        creature.moveY(-1);
        int expectedX = 2;
        int expectedY = 4;
        assertEquals(expectedX, creature.getX());
        assertEquals(expectedY, creature.getY());
    }

    @Test
    public void test_09_getId() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        int expected = 1;
        assertEquals(expected, creature.getId());
    }

    @Test
    public void test_10_getOrientacao() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        String expected = "Norte";
        assertEquals(expected, creature.getOrientacao());
    }

    @Test
    public void test_11_getTipo() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        String expected = "Criatura";
        assertEquals(expected, creature.getTipo());
    }

    @Test
    public void test_12_getImagePNG() {
        Creature creature = new Creature(1, "Criatura", 1, 1, 2, "Norte");
        String expectedN = "crazy_emoji_white_UP.png";
        assertEquals(expectedN, creature.getImagePNG());
        creature = new Creature(1, "Criatura", 1, 1, 2, "Sul");
        String expectedS = "crazy_emoji_white_DOWN.png";
        assertEquals(expectedS, creature.getImagePNG());
        creature = new Creature(1, "Criatura", 1, 1, 2, "Este");
        String expectedE = "crazy_emoji_white_RIGHT.png";
        assertEquals(expectedE, creature.getImagePNG());
        creature = new Creature(1, "Criatura", 1, 1, 2, "Oeste");
        String expectedO = "crazy_emoji_white_LEFT.png";
        assertEquals(expectedO, creature.getImagePNG());

        creature = new Creature(0, "Criatura", 0, 1, 2, "Norte");
        String expectedN0 = "crazy_emoji_black_UP.png";
        assertEquals(expectedN0, creature.getImagePNG());
        creature = new Creature(0, "Criatura", 0, 1, 2, "Sul");
        String expectedS0 = "crazy_emoji_black_DOWN.png";
        assertEquals(expectedS0, creature.getImagePNG());
        creature = new Creature(0, "Criatura", 0, 1, 2, "Este");
        String expectedE0 = "crazy_emoji_black_RIGHT.png";
        assertEquals(expectedE0, creature.getImagePNG());
        creature = new Creature(0, "Criatura", 0, 1, 2, "Oeste");
        String expectedO0 = "crazy_emoji_black_LEFT.png";
        assertEquals(expectedO0, creature.getImagePNG());

    }

    @Test
    public void test_13_addNrPontos() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.addNrPontos(2);
        creature.addNrPontos(1);
        creature.addNrPontos(1);
        int expected = 4;
        assertEquals(expected, creature.getNrPontos());
    }

    @Test
    public void test_14_setOrientacao() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        creature.setOrientacao("N");
        creature.setOrientacao("Sul");
        String expected = "Sul";
        assertEquals(expected, creature.getOrientacao());

        creature.setOrientacao("O");
        creature.setOrientacao("Oeste");
        expected = "Oeste";
        assertEquals(expected, creature.getOrientacao());

        creature.setOrientacao("Sul");
        expected = "Sul";
        assertEquals(expected, creature.getOrientacao());

        creature.setOrientacao("Norte");
        expected = "Norte";
        assertEquals(expected, creature.getOrientacao());

    }

    @Test
    public void test_15_getIdEquipa() {
        Creature creature = new Creature(1, "Criatura", 0, 1, 2, "Norte");
        int expected = 0;
        assertEquals(expected, creature.getIdEquipa());
        Creature creature2 = new Creature(1, "Criatura", 1, 1, 2, "Norte");
        int expected2 = 0;
        assertEquals(expected2, creature.getIdEquipa());
    }
}
