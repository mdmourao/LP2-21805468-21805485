package pt.ulusofona.lp2.fandeisiaGame;

import java.awt.*;

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
        kms += stepSize;
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

    public Point simulaMovimentoDuplicado() {
        int x1 = x;
        int y1 = y;
        switch (orientacao) {
            case "Este":
                x1 += stepSize * 2;
                break;
            case "Oeste":
                x1 -= stepSize * 2;
                break;
            case "Norte":
                y1 -= stepSize * 2;
                break;
            case "Sul":
                y1 += stepSize * 2;
                break;
        }
        return new Point(x1, y1);
    }

    public Point simulaMovimentoStepMinimo(){
        int x1 = x;
        int y1 = y;
        switch (orientacao) {
            case "Este":
                x1 += 1;
                break;
            case "Oeste":
                x1 -= 1;
                break;
            case "Norte":
                y1 -= 1;
                break;
            case "Sul":
                y1 += 1;
                break;
        }
        return new Point(x1, y1);
    }

    abstract public boolean possoSaltarPorcima(int numberCreatures, int numberHoles);


}
