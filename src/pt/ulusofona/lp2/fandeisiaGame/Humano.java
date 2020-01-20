package pt.ulusofona.lp2.fandeisiaGame;

public class Humano extends CreatureGira90 {


    public Humano(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao,2);
        custo = 3;
        tesourosEncontrados = 0;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 2;
    }

    public Humano(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao,2);
        custo = 3;
        this.tesourosEncontrados = nrPontos;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 2;
    }


    public String getImagePNG(){
        if(idEquipa == 10) {
            switch (orientacao) {
                case "Este":
                    return "human-este-L.png";
                case "Oeste":
                    return "human-oeste-L.png";
                case "Norte":
                    return "human-norte-L.png";
                case "Sul":
                    return "human-sul-L.png";
            }
        }else{
            switch (orientacao) {
                case "Este":
                    return "human-este-R.png";
                case "Oeste":
                    return "human-oeste-R.png";
                case "Norte":
                    return "human-norte-R.png";
                case "Sul":
                    return "human-sul-R.png";
            }
        }
        return "human.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        if (numberCreatures > 0 || numberHoles > 0) {
            return false;
        }
        return true;
    }

    public String getType(){
        return "Humano";
    }

}
