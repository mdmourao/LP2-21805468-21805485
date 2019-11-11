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
        /* “<ID> | <Tipo> | <ID Equipa> | <Nr Pontos> @ (<x>, <y>) <Orientacão>” */

        return id + " | " + tipo + " | " + idEquipa + " | " + nrPontos + " @ (" + x + ", " + y + ") " + orientacao;
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
        //pode ser necessario colocar as imagens a variar consoante o tipo da creatura
        if(getIdEquipa() == 0 ){
            if(getOrientacao().equals("Norte")){
                return "crazy_emoji_black_UP.png";
            }
            if(getOrientacao().equals("Este")){
                return "crazy_emoji_black_RIGHT.png";
            }
            if(getOrientacao().equals("Sul")){
                return "crazy_emoji_black_DOWN.png";
            }
            if(getOrientacao().equals("Oeste")){
                return "crazy_emoji_black_LEFT.png";
            }
        }
        if(getIdEquipa() == 1){
            if(getOrientacao().equals("Norte")){
                return "crazy_emoji_white_UP.png";
            }
            if(getOrientacao().equals("Este")){
                return "crazy_emoji_white_RIGHT.png";
            }
            if(getOrientacao().equals("Sul")){
                return "crazy_emoji_white_DOWN.png";
            }
            if(getOrientacao().equals("Oeste")){
                return "crazy_emoji_white_LEFT.png";
            }
        }
        return null;
    }

    public void addNrPontos(int pontosAdicionar) {
        //numero de pontos corresponde a quantidade de tesouros encontrados pela criatura
        this.nrPontos += pontosAdicionar;
    }

    public int getNrPontos(){
        return nrPontos;
    }


    public boolean setOrientacao(String orientacao){
        if(orientacao.equals("Norte") || orientacao.equals("Sul") || orientacao.equals("Este") || orientacao.equals("Oeste")){
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

