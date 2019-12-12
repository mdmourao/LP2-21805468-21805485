package pt.ulusofona.lp2.fandeisiaGame;

abstract public class Team {
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

    public void addScore(int valorAdicionar) {
        score += valorAdicionar;
    }
}

