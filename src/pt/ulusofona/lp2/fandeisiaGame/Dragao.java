package pt.ulusofona.lp2.fandeisiaGame;

public class Dragao extends CreatureGira45 {

    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 9;
        tesourosEncontrados = 0;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 3;
    }

    public Dragao(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 9;
        this.tesourosEncontrados = nrPontos;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 3;
    }

    public String getImagePNG() {
        if(idEquipa == 10) {
            switch (orientacao) {
                case "Este":
                    return "dragon-este-L.png";
                case "Oeste":
                    return "dragon-oeste-L.png";
                case "Norte":
                    return "dragon-norte-L.png";
                case "Sul":
                    return "dragon-sul-L.png";
                case "Nordeste":
                    return "dragon-ne-L.png";
                case "Sudeste":
                    return "dragon-se-L.png";
                case "Sudoeste":
                    return "dragon-so-L.png";
                case "Noroeste":
                    return "dragon-no-L.png";
            }
        }else{
            switch (orientacao) {
                case "Este":
                    return "dragon-este-R.png";
                case "Oeste":
                    return "dragon-oeste-R.png";
                case "Norte":
                    return "dragon-norte-R.png";
                case "Sul":
                    return "dragon-sul-R.png";
                case "Nordeste":
                    return "dragon-ne-R.png";
                case "Sudeste":
                    return "dragon-se-R.png";
                case "Sudoeste":
                    return "dragon-so-R.png";
                case "Noroeste":
                    return "dragon-no-R.png";
            }
        }
        return "dragon.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }

    public String getType(){
        return "Dragão";
    }


}
