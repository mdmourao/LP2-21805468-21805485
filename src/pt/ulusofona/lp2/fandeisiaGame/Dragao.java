package pt.ulusofona.lp2.fandeisiaGame;

public class Dragao extends CreatureGira45 {

    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 9;
        tesourosEncontrados = 0;
    }

    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 9;
        this.tesourosEncontrados = nrPontos;
    }

    public String getImagePNG() {
        switch (orientacao) {
            case "Este":
              return "dragon-este.png";
            case "Oeste":
                return "dragon-oeste.png";
            case "Norte":
                return "dragon-norte.png";
            case "Sul":
                return "dragon-sul.png";
            case "Nordeste":
                return "dragon-ne.png";
            case "Sudeste":
                return "dragon-se.png";
            case "Sudoeste":
                return "dragon-so.png";
            case "Noroeste":
                return "dragon-no.png";
        }
        return "dragon.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }


}
