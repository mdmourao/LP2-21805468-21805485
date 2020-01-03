package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class Test_Team {

    @Test
    public void test_Get_Set(){
        Team test = new Ldr10();
        assertEquals(50,test.getMoedas());
        assertEquals(10,test.getId());
        assertEquals(0,test.getScore());
        Team test2 = new Resistencia20();
        assertEquals(50,test2.getMoedas());
        assertEquals(20,test2.getId());
        assertEquals(0,test2.getScore());

    }
}
