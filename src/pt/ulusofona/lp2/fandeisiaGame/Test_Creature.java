package pt.ulusofona.lp2.fandeisiaGame;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class Test_Creature {
    @Test
    public void test_Getters() {
        Creature test = new Anao(1, "Anão", 10, 2, 3, "Norte");
        assertEquals(1, test.getId());
        assertEquals(2, test.getX());
        assertEquals(3, test.getY());
        assertEquals("Norte", test.getOrientacao());
        assertEquals(1, test.getStepSize());
        assertEquals("Anão", test.getType());
        assertEquals(0, test.getTesourosEncontrados());
        assertEquals(10, test.getIdEquipa());
        assertEquals(1, test.getCusto());
        assertEquals("1 | Anão | 10 | 0 @ (2, 3) Norte", test.toString());

        test = new Elfo(2, "Elfo", 20, 1, 4, "Este");
        assertEquals(2, test.getId());
        assertEquals(1, test.getX());
        assertEquals(4, test.getY());
        assertEquals("Este", test.getOrientacao());
        assertEquals(2, test.getStepSize());
        assertEquals("Elfo", test.getType());
        assertEquals(0, test.getTesourosEncontrados());
        assertEquals(20, test.getIdEquipa());
        assertEquals(5, test.getCusto());
        assertEquals("2 | Elfo | 20 | 0 @ (1, 4) Este", test.toString());

        test = new Gigante(3, "Gigante", 10, 2, 5, "Sul");
        assertEquals(3, test.getId());
        assertEquals(2, test.getX());
        assertEquals(5, test.getY());
        assertEquals("Sul", test.getOrientacao());
        assertEquals(3, test.getStepSize());
        assertEquals("Gigante", test.getType());
        assertEquals(0, test.getTesourosEncontrados());
        assertEquals(10, test.getIdEquipa());
        assertEquals(5, test.getCusto());
        assertEquals("3 | Gigante | 10 | 0 @ (2, 5) Sul", test.toString());


        test = new Humano(4, "Humano", 20, 3, 7, "Oeste");
        assertEquals(4, test.getId());
        assertEquals(3, test.getX());
        assertEquals(7, test.getY());
        assertEquals("Oeste", test.getOrientacao());
        assertEquals(2, test.getStepSize());
        assertEquals("Humano", test.getType());
        assertEquals(0, test.getTesourosEncontrados());
        assertEquals(20, test.getIdEquipa());
        assertEquals(3, test.getCusto());
        assertEquals("4 | Humano | 20 | 0 @ (3, 7) Oeste", test.toString());

        test = new Dragao(5, "Dragão", 10, 4, 8, "Norte");
        assertEquals(5, test.getId());
        assertEquals(4, test.getX());
        assertEquals(8, test.getY());
        assertEquals("Norte", test.getOrientacao());
        assertEquals(3, test.getStepSize());
        assertEquals("Dragão", test.getType());
        assertEquals(0, test.getTesourosEncontrados());
        assertEquals(10, test.getIdEquipa());
        assertEquals(9, test.getCusto());
        assertEquals("5 | Dragão | 10 | 0 @ (4, 8) Norte", test.toString());
    }

    @Test
    public void test_move_45() {
        Creature test = new Elfo(1, "Elfo", 10, 0, 0, "Sul");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(2, test.getY());
        test = new Elfo(1, "Elfo", 10, 0, 2, "Norte");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(0, test.getY());
        test = new Elfo(1, "Elfo", 10, 0, 0, "Este");
        test.move();
        assertEquals(2, test.getX());
        assertEquals(0, test.getY());
        test = new Elfo(1, "Elfo", 10, 2, 0, "Oeste");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(0, test.getY());
        test = new Elfo(1, "Elfo", 10, 2, 2, "Nordeste");
        test.move();
        assertEquals(4, test.getX());
        assertEquals(0, test.getY());

        test = new Elfo(1, "Elfo", 10, 2, 0, "Sudeste");
        test.move();
        assertEquals(4, test.getX());
        assertEquals(2, test.getY());

        test = new Elfo(1, "Elfo", 10, 2, 0, "Sudoeste");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(2, test.getY());

        test = new Elfo(1, "Elfo", 10, 2, 2, "Noroeste");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(0, test.getY());
    }

    @Test
    public void test_move_90() {
        Creature test = new Humano(1, "Humano", 10, 0, 0, "Sul");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(2, test.getY());
        test = new Humano(1, "Humano", 10, 0, 2, "Norte");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(0, test.getY());
        test = new Humano(1, "Humano", 10, 0, 0, "Este");
        test.move();
        assertEquals(2, test.getX());
        assertEquals(0, test.getY());
        test = new Humano(1, "Humano", 10, 2, 0, "Oeste");
        test.move();
        assertEquals(0, test.getX());
        assertEquals(0, test.getY());
    }

    @Test
    public void test_gira_45() {
        Creature test = new Elfo(1, "Elfo", 10, 1, 2, "Norte");
        assertEquals("Norte", test.getOrientacao());
        test.gira();
        assertEquals("Nordeste", test.getOrientacao());
        test.gira();
        assertEquals("Este", test.getOrientacao());
        test.gira();
        assertEquals("Sudeste", test.getOrientacao());
        test.gira();
        assertEquals("Sul", test.getOrientacao());
        test.gira();
        assertEquals("Sudoeste", test.getOrientacao());
        test.gira();
        assertEquals("Oeste", test.getOrientacao());
        test.gira();
        assertEquals("Noroeste", test.getOrientacao());
        test.gira();
        assertEquals("Norte", test.getOrientacao());
    }

    @Test
    public void test_gira_90() {
        Creature test = new Humano(1, "Humano", 10, 1, 2, "Norte");
        assertEquals("Norte", test.getOrientacao());
        test.gira();
        assertEquals("Este", test.getOrientacao());
        test.gira();
        assertEquals("Sul", test.getOrientacao());
        test.gira();
        assertEquals("Oeste", test.getOrientacao());
        test.gira();
        assertEquals("Norte", test.getOrientacao());
    }

    @Test
    public void test_checkSaltarPorCima() {
        Creature test = new Anao(1, "Anão", 10, 1, 2, "Norte");
        assertTrue(test.possoSaltarPorcima(0, 0));
        assertTrue(test.possoSaltarPorcima(1, 1));
        assertTrue(test.possoSaltarPorcima(1, 0));
        assertTrue(test.possoSaltarPorcima(0, 1));
        test = new Dragao(1, "Dragão", 10, 1, 2, "Norte");
        assertTrue(test.possoSaltarPorcima(0, 0));
        assertTrue(test.possoSaltarPorcima(0, 2));
        assertTrue(test.possoSaltarPorcima(2, 0));
        assertTrue(test.possoSaltarPorcima(1, 1));
        assertTrue(test.possoSaltarPorcima(0, 1));
        assertTrue(test.possoSaltarPorcima(1, 0));
        test = new Elfo(1, "Elfo", 10, 1, 2, "Norte");
        assertTrue(test.possoSaltarPorcima(0, 0));
        assertFalse(test.possoSaltarPorcima(1, 0));
        assertTrue(test.possoSaltarPorcima(0, 1));
        test = new Gigante(1, "Gigante", 10, 1, 2, "Norte");
        assertTrue(test.possoSaltarPorcima(0, 0));
        assertTrue(test.possoSaltarPorcima(0, 2));
        assertTrue(test.possoSaltarPorcima(2, 0));
        assertTrue(test.possoSaltarPorcima(1, 1));
        assertTrue(test.possoSaltarPorcima(0, 1));
        assertTrue(test.possoSaltarPorcima(1, 0));
        test = new Humano(1, "Humano", 10, 1, 2, "Norte");
        assertTrue(test.possoSaltarPorcima(0, 0));
        assertFalse(test.possoSaltarPorcima(1, 0));
        assertFalse(test.possoSaltarPorcima(0, 1));


    }

    @Test
    public void test_imagens() {
        Creature test = new Anao(1, "Anão", 10, 1, 2, "Norte");
        assertEquals("anao-norte.png", test.getImagePNG());
        test.gira();
        assertEquals("anao-este.png", test.getImagePNG());
        test.gira();
        assertEquals("anao-sul.png", test.getImagePNG());
        test.gira();
        assertEquals("anao-oeste.png", test.getImagePNG());
        test.gira();
        assertEquals("anao-norte.png", test.getImagePNG());

        test = new Dragao(1, "Dragão", 10, 1, 2, "Norte");
        assertEquals("dragon-norte.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-ne.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-este.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-se.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-sul.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-so.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-oeste.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-no.png", test.getImagePNG());
        test.gira();
        assertEquals("dragon-norte.png", test.getImagePNG());

        test = new Elfo(1, "Elfo", 10, 1, 2, "Norte");
        assertEquals("elf-norte.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-ne.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-este.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-se.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-sul.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-so.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-oeste.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-no.png", test.getImagePNG());
        test.gira();
        assertEquals("elf-norte.png", test.getImagePNG());

        test = new Gigante(1, "Gigante", 10, 1, 2, "Norte");
        assertEquals("giant-norte.png", test.getImagePNG());
        test.gira();
        assertEquals("giant-este.png", test.getImagePNG());
        test.gira();
        assertEquals("giant-sul.png", test.getImagePNG());
        test.gira();
        assertEquals("giant-oeste.png", test.getImagePNG());
        test.gira();
        assertEquals("giant-norte.png", test.getImagePNG());

        test = new Humano(1, "Humano", 10, 1, 2, "Norte");
        assertEquals("human-norte.png", test.getImagePNG());
        test.gira();
        assertEquals("human-este.png", test.getImagePNG());
        test.gira();
        assertEquals("human-sul.png", test.getImagePNG());
        test.gira();
        assertEquals("human-oeste.png", test.getImagePNG());
        test.gira();
        assertEquals("human-norte.png", test.getImagePNG());

        test = new Anao(1, "Anão", 10, 1, 2, "");
        assertEquals("anao.png",test.getImagePNG());

        test = new Dragao(1, "Dragão", 10, 1, 2, "");
        assertEquals("dragon.png",test.getImagePNG());

        test = new Elfo(1, "Elfo", 10, 1, 2, "");
        assertEquals("elf.png",test.getImagePNG());

        test = new Gigante(1, "Gigante", 10, 1, 2, "");
        assertEquals("giant.png",test.getImagePNG());

        test = new Humano(1, "Humano", 10, 1, 2, "");
        assertEquals("human.png",test.getImagePNG());

    }

    @Test
    public void test_toString() {
        Creature test = new Anao(1, "Anão", 10, 1, 2, "Norte", 11);
        assertEquals("1 | Anão | 10 | 11 @ (1, 2) Norte", test.toString());
        test = new Dragao(2, "Dragão", 20, 2, 3, "Sul", 12);
        assertEquals("2 | Dragão | 20 | 12 @ (2, 3) Sul", test.toString());
        test = new Elfo(3, "Elfo", 10, 3, 2, "Este", 13);
        assertEquals("3 | Elfo | 10 | 13 @ (3, 2) Este", test.toString());
        test = new Gigante(4, "Gigante", 10, 4, 4, "Oeste", 14);
        assertEquals("4 | Gigante | 10 | 14 @ (4, 4) Oeste", test.toString());
        test = new Humano(5, "Humano", 20, 5, 5, "Norte", 15);
        assertEquals("5 | Humano | 20 | 15 @ (5, 5) Norte", test.toString());
    }

    @Test
    public void test_addNrPontos() {
        Creature test = new Anao(1, "Anão", 10, 1, 2, "Norte", 11);
        test.addTesourosEncontrados();
        assertEquals("1 | Anão | 10 | 12 @ (1, 2) Norte", test.toString());
        test = new Dragao(2, "Dragão", 20, 2, 3, "Sul", 12);
        test.addTesourosEncontrados();
        assertEquals("2 | Dragão | 20 | 13 @ (2, 3) Sul", test.toString());
        test = new Elfo(3, "Elfo", 10, 3, 2, "Este", 13);
        test.addTesourosEncontrados();
        assertEquals("3 | Elfo | 10 | 14 @ (3, 2) Este", test.toString());
        test = new Gigante(4, "Gigante", 10, 4, 4, "Oeste", 14);
        test.addTesourosEncontrados();
        assertEquals("4 | Gigante | 10 | 15 @ (4, 4) Oeste", test.toString());
        test = new Humano(5, "Humano", 20, 5, 5, "Norte", 15);
        test.addTesourosEncontrados();
        assertEquals("5 | Humano | 20 | 16 @ (5, 5) Norte", test.toString());
    }


}