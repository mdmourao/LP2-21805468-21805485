package pt.ulusofona.lp2.fandeisiaGame;

public class Humano extends CreatureGira90 {


    public Humano(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao,2);
        custo = 3;
        tesourosEncontrados = 0;
    }

    public Humano(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao,2);
        custo = 3;
        this.tesourosEncontrados = nrPontos;
    }


    public String getImagePNG(){
        switch (orientacao) {
            case "Este":
                return "human-este.png";
            case "Oeste":
                return "human-oeste.png";
            case "Norte":
                return "human-norte.png";
            case "Sul":
                return "human-sul.png";
        }
        return "human.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        if (numberCreatures > 0 || numberHoles > 0) {
            return false;
        }
        return true;
    }

}
