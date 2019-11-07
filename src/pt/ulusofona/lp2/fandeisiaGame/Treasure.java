package pt.ulusofona.lp2.fandeisiaGame;

public class Treasure {
    String id;
    final String type = "treasure";
    int x;
    int y;

    public Treasure(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

}
