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
        switch (orientacao) {
            case "Este":
                return "giant-este.png";
            case "Oeste":
                return "giant-oeste.png";
            case "Norte":
                return "giant-norte.png";
            case "Sul":
                return "giant-sul.png";
        }
        return "giant.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        return true;
    }
}
