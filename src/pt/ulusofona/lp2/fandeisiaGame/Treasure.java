package pt.ulusofona.lp2.fandeisiaGame;

public class Treasure {
    int id;
    final String type = "treasure";
    int x;
    int y;

    public Treasure(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getImagePNG(){
        return "box-mud.png";
    }

    public int getId(){
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
