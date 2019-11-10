package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Teste_FandeisiaGameManager {
    @Test
    public void test_01() {
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[3];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 6, y: 5, orientation: Norte";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 8, y: 4, orientation: Oeste";
        content[2] ="id: -1, type: treasure, x: 6, y: 4";
        test1.startGame(content,6,8);
        test1.processTurn();
        System.out.println(test1.creatures.get(0).x);
        System.out.println(test1.creatures.get(0).y);
        System.out.println(test1.creatures.get(1).x);
        System.out.println(test1.creatures.get(1).y);
        System.out.println(test1.treasures.size());
    }
}
