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

    public int getId() {
        return this.id;
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

    public String toString() {
        return id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " (" + x + ", "+ y + ")" + orientacao;
    }

    public void addNrPontos(int pontosAdicionar){
        //numero de pontos corresponde a quantidade de tesouros encontrados pela criatura
        this.nrPontos += pontosAdicionar;
    }

}

