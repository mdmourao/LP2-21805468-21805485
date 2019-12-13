package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureSilver extends Treasure {
    TreasureSilver(int id, int x, int y){
        super(id, x, y);
    }

    public String getImagePNG(){
        return "box-mud.png";
    }

    @Override
    public String toString() {
        return id +" | " + "silver" + " @ (" + x + ", " + y + ")";
    }
}
