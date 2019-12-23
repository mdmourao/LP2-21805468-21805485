package pt.ulusofona.lp2.fandeisiaGame;

import java.util.ArrayList;

abstract public class Creature {
    protected int id;
    protected String type;
    protected int idEquipa;
    protected int x;
    protected int y;
    protected int tesourosEncontrados;
    protected ArrayList<Treasure> treasures;
    protected int custo;
    protected  String orientacao;
    protected int stepSize;

    public Creature(int id, String type, int idEquipa, int x, int y, String orientacao, int stepSize) {
        this.id = id;
        this.type = type;
        this.idEquipa = idEquipa;
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
        this.stepSize = stepSize;
        treasures = new ArrayList<>();
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


    public void addTesourosEncontrados(int pontosAdicionar) {
        //numero de pontos corresponde a quantidade de tesouros encontrados pela criatura
        this.tesourosEncontrados += pontosAdicionar;
    }

    public int getTesourosEncontrados() {
        return tesourosEncontrados;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void addTreasure(Treasure t){
        treasures.add(t);
    }

    public int numberTreasuresGold (){
        int count = 0;
        for(Treasure t: treasures){
            if(t.getType().equals("Gold")){
                count++;
            }
        }
        return count;
    }

    public int numberTreasuresSilver (){
        int count = 0;
        for(Treasure t: treasures){
            if(t.getType().equals("Silver")){
                count++;
            }
        }
        return count;
    }

    public int numberTreasuresBronze (){
        int count = 0;
        for(Treasure t: treasures){
            if(t.getType().equals("Bronze")){
                count++;
            }
        }
        return count;
    }

    public int numberPoints(){
        int count = 0;
        for(Treasure t : treasures){
            count += t.getPontos();
        }
        return count;
    }
}



