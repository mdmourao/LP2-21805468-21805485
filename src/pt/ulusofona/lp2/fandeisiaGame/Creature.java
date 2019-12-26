package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;

abstract public class Creature {
    protected int id;
    protected String type;
    protected int idEquipa;
    protected int x;
    protected int y;
    protected int tesourosEncontrados;
    protected int tesourosSilver;
    protected int tesourosGold;
    protected int tesourosBronze;
    protected int custo;
    protected String orientacao;
    protected int stepSize;
    protected boolean congelado1Round = false;
    protected boolean congeladoForever = false;

    public Creature(int id, String type, int idEquipa, int x, int y, String orientacao, int stepSize) {
        this.id = id;
        this.type = type;
        this.idEquipa = idEquipa;
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
        this.stepSize = stepSize;
    }

    public String toString() {
        /* “<ID> | <Tipo> | <ID Equipa> | <Nr Pontos> @ (<x>, <y>) <Orientacão>” */

        String a = numberTreasuresSilver() + numberTreasuresBronze() + numberTreasuresGold() + "";
        return id + " | " + type + " | " + idEquipa + " | " + a + " @ (" + x + ", " + y + ") " + orientacao;
    }

    abstract public String getImagePNG();

    abstract public void gira();

    abstract public void move();

    abstract public boolean possoSaltarPorcima(int numberCreatures, int numberHoles);

    public int getStepSize() {
        return stepSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return this.id;
    }

    public String getOrientacao() {
        return this.orientacao;
    }

    public int getCusto() {
        return this.custo;
    }

    public String getType() {
        return this.type;
    }

    public void addTreasurePoints(Treasure t) {
        if(t.getType().equals("Silver")){
            tesourosSilver++;
        }
        if(t.getType().equals("Gold")){
            tesourosGold++;
        }
        if(t.getType().equals("Bronze")){
            tesourosBronze++;
        }
    }

    public void addTesourosEncontrados() {
        //numero de pontos corresponde a quantidade de tesouros encontrados pela criatura
        this.tesourosEncontrados++;
    }

    public int getTesourosEncontrados() {
        return tesourosEncontrados;
    }

    public int getIdEquipa() {
        return idEquipa;
    }


    public int numberTreasuresGold() {
        return tesourosGold;
    }

    public int numberTreasuresSilver() {
        return tesourosSilver;
    }

    public int numberTreasuresBronze() {
        return tesourosBronze;
    }

    public int numberPoints() {
        return numberTreasuresBronze() *2 + numberTreasuresSilver() + numberTreasuresGold()*3;
    }

    public void stepX(int step) {
        x = x + step;
    }

    public void stepY(int step) {
        y = y + step;
    }

    public void alcanceDefault() {
        stepSize = 1;
    }

    public void duplicaAlcance() {
        stepSize = stepSize * 2;
    }

    public void congela1Round() {
        congelado1Round = true;
    }

    public void descongela1Round() {
        congelado1Round = false;
    }

    public void congelaForever() {
        congeladoForever = true;
    }

    public void descongelaForever() {
        congeladoForever = false;
    }

    public boolean isCongelado1Round() {
        return congelado1Round;
    }

    public boolean isCongeladoForever() {
        return congeladoForever;
    }
}



