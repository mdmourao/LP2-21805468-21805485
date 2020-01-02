package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test_Hole {
    @Test
    public void test_Getter() {
        Hole testHole = new Hole(-101, 5, 5);
        assertEquals(-101, testHole.getId());
        assertEquals("hole", testHole.getType());
        assertEquals(5, testHole.getX());
        assertEquals(5, testHole.getY());
        assertEquals("black-box.png", testHole.getImagePNG());
        assertEquals(testHole.getId() + " | " + testHole.getType() + " @ (" + testHole.getX() + ", " + testHole.getY() + ")", testHole.toString());
    }
}
