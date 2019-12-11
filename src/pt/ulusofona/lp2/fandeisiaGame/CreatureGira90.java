package pt.ulusofona.lp2.fandeisiaGame;

abstract public class CreatureGira90 extends Creature {

    public CreatureGira90(int id, String tipo, int idEquipa, int x, int y, String orientacao, int stepSize) {
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
                break;
        }
    }

    public void gira() {
        switch (orientacao) {
            case "Este":
                orientacao = "Sul";
                break;
            case "Oeste":
                orientacao = "Norte";
                break;
            case "Norte":
                orientacao = "Este";
                break;
            case "Sul":
                orientacao = "Oeste";
                break;
        }
    }

    abstract public boolean possoSaltarPorcima(int numberCreatures, int numberHoles);


}
