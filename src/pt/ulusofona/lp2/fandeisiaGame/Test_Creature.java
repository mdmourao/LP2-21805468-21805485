package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Test_Creature {
    @Test
    public void test_Getters(){
        Creature test = new Anao(1,"Anão",10,2,3,"Norte");
        assertEquals(1,test.getId());
        assertEquals(2,test.getX());
        assertEquals(3,test.getY());
        assertEquals("Norte",test.getOrientacao());
        assertEquals(1,test.getStepSize());
        assertEquals("Anão",test.getType());
        assertEquals(0,test.getNrPontos());
        assertEquals(10,test.getIdEquipa());
        assertEquals(1,test.getCusto());
        assertEquals("1 | Anão | 10 | 0 @ (2, 3) Norte",test.toString());

        test = new Elfo(2,"Elfo",20,1,4,"Este");
        assertEquals(2,test.getId());
        assertEquals(1,test.getX());
        assertEquals(4,test.getY());
        assertEquals("Este",test.getOrientacao());
        assertEquals(2,test.getStepSize());
        assertEquals("Elfo",test.getType());
        assertEquals(0,test.getNrPontos());
        assertEquals(20,test.getIdEquipa());
        assertEquals(5,test.getCusto());
        assertEquals("2 | Elfo | 20 | 0 @ (1, 4) Este",test.toString());

        test = new Gigante(3,"Gigante",10,2,5,"Sul");
        assertEquals(3,test.getId());
        assertEquals(2,test.getX());
        assertEquals(5,test.getY());
        assertEquals("Sul",test.getOrientacao());
        assertEquals(3,test.getStepSize());
        assertEquals("Gigante",test.getType());
        assertEquals(0,test.getNrPontos());
        assertEquals(10,test.getIdEquipa());
        assertEquals(5,test.getCusto());
        assertEquals("3 | Gigante | 10 | 0 @ (2, 5) Sul",test.toString());


        test = new Humano(4,"Humano",20,3,7,"Oeste");
        assertEquals(4,test.getId());
        assertEquals(3,test.getX());
        assertEquals(7,test.getY());
        assertEquals("Oeste",test.getOrientacao());
        assertEquals(2,test.getStepSize());
        assertEquals("Humano",test.getType());
        assertEquals(0,test.getNrPontos());
        assertEquals(20,test.getIdEquipa());
        assertEquals(3,test.getCusto());
        assertEquals("4 | Humano | 20 | 0 @ (3, 7) Oeste",test.toString());

        test = new Dragao(5,"Dragão",10,4,8,"Norte");
        assertEquals(5,test.getId());
        assertEquals(4,test.getX());
        assertEquals(8,test.getY());
        assertEquals("Norte",test.getOrientacao());
        assertEquals(3,test.getStepSize());
        assertEquals("Dragão",test.getType());
        assertEquals(0,test.getNrPontos());
        assertEquals(10,test.getIdEquipa());
        assertEquals(9,test.getCusto());
        assertEquals("5 | Dragão | 10 | 0 @ (4, 8) Norte",test.toString());
    }

    @Test
    public void test_move_45(){
        Creature test = new Elfo(1,"Elfo",10,0,0,"Sul");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(2,test.getY());
        test = new Elfo(1,"Elfo",10,0,2,"Norte");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(0,test.getY());
        test = new Elfo(1,"Elfo",10,0,0,"Este");
        test.move();
        assertEquals(2,test.getX());
        assertEquals(0,test.getY());
        test = new Elfo(1,"Elfo",10,2,0,"Oeste");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(0,test.getY());
        test = new Elfo(1,"Elfo",10,2,2,"Nordeste");
        test.move();
        assertEquals(4,test.getX());
        assertEquals(0,test.getY());

        test = new Elfo(1,"Elfo",10,2,0,"Sudeste");
        test.move();
        assertEquals(4,test.getX());
        assertEquals(2,test.getY());

        test = new Elfo(1,"Elfo",10,2,0,"Sudoeste");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(2,test.getY());

        test = new Elfo(1,"Elfo",10,2,2,"Noroeste");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(0,test.getY());
    }

    @Test
    public void test_move_90(){
        Creature test = new Humano(1,"Humano",10,0,0,"Sul");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(2,test.getY());
        test = new Humano(1,"Humano",10,0,2,"Norte");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(0,test.getY());
        test = new Humano(1,"Humano",10,0,0,"Este");
        test.move();
        assertEquals(2,test.getX());
        assertEquals(0,test.getY());
        test = new Humano(1,"Humano",10,2,0,"Oeste");
        test.move();
        assertEquals(0,test.getX());
        assertEquals(0,test.getY());
    }

    //TODO
    @Test
    public void test_gira_45(){

    }

    //TODO
    @Test
    public void test_gira_90(){

    }

    //TODO
    @Test
    public void test_checkSaltarPorCima(){

    }

    //TODO
    @Test
    public void test_imagens(){

    }
}