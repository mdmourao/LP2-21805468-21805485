package pt.ulusofona.lp2.fandeisiaGame;

import java.util.List;

abstract public class Team {
    int id;
    int score;
    int moedas;

    Team() {
        moedas = 50;
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

