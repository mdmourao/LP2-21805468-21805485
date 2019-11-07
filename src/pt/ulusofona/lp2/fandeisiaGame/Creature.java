package pt.ulusofona.lp2.fandeisiaGame;

public class Creature {
    int id;
    String tipo;
    int idEquipa;
    int x;
    int y;
    int nrPontos;
    int custo;
    String orientacao;
    String descricao;

    public Creature(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        this.id = id;
        this.tipo = tipo;
        this.idEquipa = idEquipa;
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
        nrPontos = 0;
    }

    public String toString() {
        return id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " (" + x + ", " + y + ")" + orientacao;
    }

    public int getX() {
        return x;
    }

    public void moveX(int step) {
        this.x += step;
    }

    public int getY() {
        return y;
    }

    public void moveY(int step) {
        this.y += step;
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

    public String getTipo() {
        return this.tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getImagePNG() {
        return null;
    }

    public void addNrPontos(int pontosAdicionar) {
        //numero de pontos corresponde a quantidade de tesouros encontrados pela criatura
        this.nrPontos += pontosAdicionar;
    }

    public boolean setOrientacao(String orientacao){
        if(orientacao.equals("N") || orientacao.equals("S") || orientacao.equals("E") || orientacao.equals("O")){
            this.orientacao = orientacao;
            return true;
        }else {
            return false;
        }
    }

    public int getIdEquipa(){
        return idEquipa;
    }

}

