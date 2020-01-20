package pt.ulusofona.lp2.fandeisiaGame;

public class Elfo extends CreatureGira45 {
    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 2);
        custo = 5;
        tesourosEncontrados = 0;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 2;
    }

    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 2);
        custo = 5;
        this.tesourosEncontrados = nrPontos;
        tesourosSilver = 0;
        tesourosGold = 0;
        tesourosBronze = 0;
        stepSizeDefault = 2;
    }


    public String getImagePNG() {
        if(idEquipa == 10) {
            switch (orientacao) {
                case "Este":
                    return "elf-este-L.png";
                case "Oeste":
                    return "elf-oeste-L.png";
                case "Norte":
                    return "elf-norte-L.png";
                case "Sul":
                    return "elf-sul-L.png";
                case "Nordeste":
                    return "elf-ne-L.png";
                case "Sudeste":
                    return "elf-se-L.png";
                case "Sudoeste":
                    return "elf-so-L.png";
                case "Noroeste":
                    return "elf-no-L.png";
            }
        }else{
            switch (orientacao) {
                case "Este":
                    return "elf-este-R.png";
                case "Oeste":
                    return "elf-oeste-R.png";
                case "Norte":
                    return "elf-norte-R.png";
                case "Sul":
                    return "elf-sul-R.png";
                case "Nordeste":
                    return "elf-ne-R.png";
                case "Sudeste":
                    return "elf-se-R.png";
                case "Sudoeste":
                    return "elf-so-R.png";
                case "Noroeste":
                    return "elf-no-R.png";
            }
        }
        return "elf.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        if (numberCreatures > 0) {
            return false;
        }
        return true;
    }

    public String getType(){
        return "Elfo";
    }
}
