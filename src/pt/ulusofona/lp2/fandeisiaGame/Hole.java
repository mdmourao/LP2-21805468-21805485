package pt.ulusofona.lp2.fandeisiaGame;

public class Hole {
    protected int id;
    protected static final String TYPE = "hole";
    protected int x;
    protected int y;

    Hole(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return TYPE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImagePNG(){
        return "black-box.png";
    }

    @Override
    public String toString() {
        return id +" | " + TYPE + " @ (" + x + ", " + y + ")";
    }
}
