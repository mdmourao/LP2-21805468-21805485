package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureSilver extends Treasure {
    TreasureSilver(int id, int x, int y){
        super(id, x, y);
        this.pontos = 1;
        type = "Silver";
    }

    public String getImagePNG(){
        return "silver-box.png";
    }

    @Override
    public String toString() {
        return id +" | " + "silver" + " @ (" + x + ", " + y + ")";
    }
}
