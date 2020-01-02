package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test_Treasure {
    @Test
    public void test_Getters() {
        Treasure testBronze = new TreasureBronze(-1, 1, 1);
        assertEquals(-1, testBronze.getId());
        assertEquals(1, testBronze.getX());
        assertEquals(1, testBronze.getY());
        assertEquals(1, testBronze.getPontos());
        assertEquals("Bronze", testBronze.getType());
        assertEquals("bronze-box.png", testBronze.getImagePNG());

        Treasure testSilver = new TreasureSilver(-2, 2, 2);
        assertEquals(-2, testSilver.getId());
        assertEquals(2, testSilver.getX());
        assertEquals(2, testSilver.getY());
        assertEquals(2, testSilver.getPontos());
        assertEquals("Silver", testSilver.getType());
        assertEquals("silver-box.png", testSilver.getImagePNG());

        Treasure testGold = new TreasureGold(-3, 3, 3);
        assertEquals(-3, testGold.getId());
        assertEquals(3, testGold.getX());
        assertEquals(3, testGold.getY());
        assertEquals(3, testGold.getPontos());
        assertEquals("Gold", testGold.getType());
        assertEquals("gold-box.png", testGold.getImagePNG());
    }
}
