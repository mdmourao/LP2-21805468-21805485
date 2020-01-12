package pt.ulusofona.lp2.fandeisiaGame;

import java.awt.*;

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
                break;
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
        kms += stepSize;
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
            case "Nordeste":
                x1 += stepSize * 2;
                y1 -= stepSize * 2;
                break;
            case "Sudeste":
                x1 += stepSize * 2;
                y1 += stepSize * 2;
                break;
            case "Sudoeste":
                x1 -= stepSize * 2;
                y1 += stepSize * 2;
                break;
            case "Noroeste":
                x1 -= stepSize * 2;
                y1 -= stepSize * 2;
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
            case "Nordeste":
                x1 += 1;
                y1 -= 1;
                break;
            case "Sudeste":
                x1 += 1;
                y1 += 1;
                break;
            case "Sudoeste":
                x1 -= 1;
                y1 += 1;
                break;
            case "Noroeste":
                x1 -= 1;
                y1 -= 1;
                break;
        }
        return new Point(x1, y1);
    }

    abstract public boolean possoSaltarPorcima(int numberCreatures, int numberHoles);
}
