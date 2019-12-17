package pt.ulusofona.lp2.fandeisiaGame;

public class Anao extends CreatureGira90 {
    public Anao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 1);
        custo = 1;
    }

    public Anao(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 1);
        custo = 1;
        this.nrPontos = nrPontos;
    }

    public String getImagePNG() {
        return "anao.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }
}
