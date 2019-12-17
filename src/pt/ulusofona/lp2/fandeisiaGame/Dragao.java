package pt.ulusofona.lp2.fandeisiaGame;

public class Dragao extends CreatureGira45 {

    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 9;
    }

    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 9;
        this.nrPontos = nrPontos;
    }

    public String getImagePNG() {
        return "dragon.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }


}
