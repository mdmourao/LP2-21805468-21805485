package pt.ulusofona.lp2.fandeisiaGame;

public class Gigante extends CreatureGira90 {
    public Gigante(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 5;
        tesourosEncontrados = 0;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 3;
    }

    public Gigante(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 3);
        custo = 5;
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
                    return "giant-este-L.png";
                case "Oeste":
                    return "giant-oeste-L.png";
                case "Norte":
                    return "giant-norte-L.png";
                case "Sul":
                    return "giant-sul-L.png";
            }
        }else{
            switch (orientacao) {
                case "Este":
                    return "giant-este-R.png";
                case "Oeste":
                    return "giant-oeste-R.png";
                case "Norte":
                    return "giant-norte-R.png";
                case "Sul":
                    return "giant-sul-R.png";
            }
        }
        return "giant.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }

    public String getType(){
        return "Gigante";
    }
}
