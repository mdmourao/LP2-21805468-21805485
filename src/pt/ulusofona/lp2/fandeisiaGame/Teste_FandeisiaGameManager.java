package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Teste_FandeisiaGameManager {
    @Test
    public void test_goEste() {
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Este";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (2, 3) Este",test1.creatures.get(0).toString());
    }
    @Test
    public void test_goOeste() {
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Oeste";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (0, 3) Oeste",test1.creatures.get(0).toString());
    }
    @Test
    public void test_goNorte() {
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Norte";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (1, 2) Norte",test1.creatures.get(0).toString());
    }
    @Test
    public void test_goSul() {
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[1];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Sul";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (1, 4) Sul",test1.creatures.get(0).toString());
    }

    @Test
    public void test_turnNorte(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[2];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Oeste";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 0, y: 3, orientation: Sul";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (1, 3) Norte",test1.creatures.get(0).toString());
    }

    @Test
    public void test_turnSul(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[2];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Este";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 2, y: 3, orientation: Sul";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (1, 3) Sul",test1.creatures.get(0).toString());
    }

    @Test
    public void test_turnEste(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[2];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Norte";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 1, y: 2, orientation: Sul";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (1, 3) Este",test1.creatures.get(0).toString());
    }

    @Test
    public void test_idk(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[2];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 2, y: 4, orientation: Sul";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 2, y: 5, orientation: Norte";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (2, 4) Oeste",test1.creatures.get(0).toString());
        assertEquals("2 | Circulo | 0 | 0 @ (2, 5) Este",test1.creatures.get(1).toString());
    }

    @Test
    public void test_turnOeste(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[2];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Sul";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 1, x: 1, y: 4, orientation: Sul";
        test1.startGame(content,7,8);
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (1, 3) Oeste",test1.creatures.get(0).toString());
        assertEquals("2 | Circulo | 1 | 0 @ (1, 5) Sul",test1.creatures.get(1).toString());
        test1.processTurn();
        assertEquals("1 | Circulo | 0 | 0 @ (0, 3) Oeste",test1.creatures.get(0).toString());
        assertEquals("2 | Circulo | 1 | 0 @ (1, 6) Sul",test1.creatures.get(1).toString());
    }

    @Test
    public void test_tresure_1(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[3];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Norte";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 1, y: 4, orientation: Sul";
        content[2] = "id: -1, type: treasure, x: 1, y: 2";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals(0,test1.treasures.size());
        assertEquals(1,test1.creatures.get(0).getNrPontos());
    }

    @Test
    public void test_tresure_2(){
        FandeisiaGameManager test1 = new FandeisiaGameManager();
        String[] content = new String[3];
        content[0] = "id: 1, type: Circulo Estranho, teamId: 0, x: 1, y: 3, orientation: Norte";
        content[1] = "id: 2, type: Circulo Estranho, teamId: 0, x: 1, y: 4, orientation: Sul";
        content[2] = "id: -1, type: treasure, x: 1, y: 6";
        test1.startGame(content,6,8);
        test1.processTurn();
        assertEquals(1,test1.treasures.size());
    }
}
