package pt.ulusofona.lp2.fandeisiaGame;

abstract public class Treasure {
    protected int id;
    protected int x;
    protected int y;
    protected int pontos;

    public Treasure(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    abstract public String getImagePNG();


    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPontos() {
        return pontos;
    }

}
