package pt.ulusofona.lp2.fandeisiaGame;

import java.awt.*;

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
    protected int stepSizeDefault;
    protected boolean congelado1Round = false;
    protected boolean congeladoForever = false;
    protected boolean duplicado = false;
    protected boolean reduzido = false;

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
        return id + " | " + type + " | " + idEquipa + " | " + tesourosEncontrados + " @ (" + x + ", " + y + ") " + orientacao;
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

    public void addTreasure(Treasure t) {
        if (t.getPontos() == 2) {
            tesourosSilver++;
        }
        if (t.getPontos() == 3) {
            tesourosGold++;
        }
        if (t.getPontos() == 1) {
            tesourosBronze++;
        }
        tesourosEncontrados++;
    }

    public int getTesourosSilver() {
        return tesourosSilver;
    }

    public int getTesourosGold() {
        return tesourosGold;
    }

    public int getTesourosBronze() {
        return tesourosBronze;
    }

    public int getTesourosEncontrados() {
        return tesourosEncontrados;
    }

    public void setTesourosEncontrados(int tesourosEncontrados) {
        this.tesourosEncontrados = tesourosEncontrados;
    }

    public void setTesourosSilver(int tesourosSilver) {
        this.tesourosSilver = tesourosSilver;
    }

    public void setTesourosGold(int tesourosGold) {
        this.tesourosGold = tesourosGold;
    }

    public void setTesourosBronze(int tesourosBronze) {
        this.tesourosBronze = tesourosBronze;
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
        return numberTreasuresBronze() + numberTreasuresSilver() * 2 + numberTreasuresGold() * 3;
    }

    public void stepX(int step) {
        x = x + step;
    }

    public void stepY(int step) {
        y = y + step;
    }

    public void alcanceMinimo() {
        reduzido = true;
        stepSize = 1;
    }

    public void duplicaAlcance() {
        stepSize = stepSize * 2;
        duplicado = true;
    }

    public boolean estouDuplicado() {
        return duplicado;
    }

    public boolean estouReduzido() {
        return reduzido;
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

    public void stepToStepDefault(){
        duplicado = false;
        reduzido = false;
        stepSize = stepSizeDefault;
    }

    abstract public Point simulaMovimentoDuplicado();

    abstract public Point simulaMovimentoStepMinimo();
}



