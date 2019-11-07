package pt.ulusofona.lp2.fandeisiaGame;

public class Creature {
    int id;
    String tipo;
    int idEquipa;
    int x;
    int y;
    String orientacao;

    public int getId() {
        return id;
    }

    public String getImagePNG() {
        return null;
    }

    public String toString() {
        return id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " (" + x + ", "+ y + ")" + orientacao;
    }
}

