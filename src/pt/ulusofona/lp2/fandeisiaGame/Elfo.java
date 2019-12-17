package pt.ulusofona.lp2.fandeisiaGame;

public class Elfo extends CreatureGira45 {
    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao, 2);
        custo = 5;
    }

    public Elfo(int id, String tipo, int idEquipa, int x, int y, String orientacao, int nrPontos) {
        super(id, tipo, idEquipa, x, y, orientacao, 2);
        custo = 5;
        this.nrPontos = nrPontos;
    }


    public String getImagePNG() {
        switch (orientacao) {
            case "Este":
                return "elf-este.png";
            case "Oeste":
                return "elf-oeste.png";
            case "Norte":
                return "elf-norte.png";
            case "Sul":
                return "elf-sul.png";
            case "Nordeste":
                return "elf-ne.png";
            case "Sudeste":
                return "elf-se.png";
            case "Sudoeste":
                return "elf-so.png";
            case "Noroeste":
                return "elf-no.png";
        }
        return "elf.png";
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        if (numberCreatures > 0) {
            return false;
        }
        return true;
    }
}
