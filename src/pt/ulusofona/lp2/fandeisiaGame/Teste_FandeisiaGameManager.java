package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Teste_FandeisiaGameManager {
    @Test
    public void test_01() {
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        test1.addCreaure(1,"Circulo Estranho",0,1,2,"Norte");
        test1.addTreasure(-1,1,1);
        test1.addCreaure(2,"Criatura Estranha",1,1,2,"Sul");
        test1.processTurn();
        System.out.println(test1.treasures.size());
    }
}
