package pt.ulusofona.lp2.fandeisiaGame;

public class Anao extends CreatureGira90 {
    public Anao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 1);
        custo = 1;
        tesourosEncontrados = 0;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 1;
    }

    public Anao(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 1);
        custo = 1;
        this.tesourosEncontrados = nrPontos;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 1;
    }

    public String getImagePNG() {
        switch (orientacao){
            case "Este":
                return "anao-este.png";
            case "Oeste":
                return "anao-oeste.png";
            case "Norte":
               return "anao-norte.png";
            case "Sul":
                return "anao-sul.png";
        }
        return "anao.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }

    public String getType(){
        return "Anão";
    }
}
