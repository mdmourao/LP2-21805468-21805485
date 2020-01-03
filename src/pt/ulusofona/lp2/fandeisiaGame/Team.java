package pt.ulusofona.lp2.fandeisiaGame;

import java.util.List;

abstract public class Team {
    protected int id;
    protected int score;
    protected int moedas;

    Team() {
        moedas = 50;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addMoedas(int moedas) {
        this.moedas += moedas;
    }

    public void removeMoedas(int moedas) {
        this.moedas -= moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public int getScore() {
        return score;
    }

    public int getMoedas() {
        return moedas;
    }

    public int getId() {
        return id;
    }

    public void addScore(int valorAdicionar) {
        score += valorAdicionar;
    }


}

