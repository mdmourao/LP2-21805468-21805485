package pt.ulusofona.lp2.fandeisiaGame;

public class Gigante extends CreatureGira90 {
    public Gigante(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 5;
    }

    public Gigante(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 5;
        this.nrPontos = nrPontos;
    }

    public String getImagePNG() {
        return "giant.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }
}
