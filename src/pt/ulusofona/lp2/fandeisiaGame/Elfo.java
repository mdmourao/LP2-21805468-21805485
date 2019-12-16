package pt.ulusofona.lp2.fandeisiaGame;

public class Elfo extends CreatureGira45 {
    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 2);
        custo = 5;
    }

    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 2);
        custo = 5;
        this.nrPontos = nrPontos;
    }


    public String getImagePNG() {
        return null;
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        if (numberCreatures > 0) {
            return false;
        }
        return true;
    }
}
