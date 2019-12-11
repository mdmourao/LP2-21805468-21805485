package pt.ulusofona.lp2.fandeisiaGame;

abstract public class CreatureGira45 extends Creature {

    public CreatureGira45(int id, String tipo, int idEquipa, int x, int y, String orientacao, int stepSize) {
        super(id, tipo, idEquipa, x, y, orientacao, stepSize);
    }

    abstract public String getImagePNG();

    public void move() {
        switch (orientacao) {
            case "Este":
                x += stepSize;
                break;
            case "Oeste":
                x -= stepSize;
                break;
            case "Norte":
                y -= stepSize;
                break;
            case "Sul":
                y += stepSize;

            case "Nordeste":
                x += stepSize;
                y -= stepSize;
                break;
            case "Sudeste":
                x += stepSize;
                y += stepSize;
                break;
            case "Sudoeste":
                x -= stepSize;
                y += stepSize;
                break;
            case "Noroeste":
                x -= stepSize;
                y -= stepSize;
                break;
        }
    }

    public void gira() {
        switch (orientacao) {
            case "Norte":
                orientacao = "Nordeste";
                break;
            case "Nordeste":
                orientacao = "Este";
                break;
            case "Este":
                orientacao = "Sudeste";
                break;
            case "Sudeste":
                orientacao = "Sul";
                break;
            case "Sul":
                orientacao = "Sudoeste";
                break;
            case "Sudoeste":
                orientacao = "Oeste";
                break;
            case "Oeste":
                orientacao = "Noroeste";
                break;
            case "Noroeste":
                orientacao = "Norte";
                break;
        }
    }

    abstract public boolean possoSaltarPorcima(int numberCreatures, int numberHoles);
}
