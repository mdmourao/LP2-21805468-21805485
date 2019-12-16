package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureBronze extends Treasure {
    TreasureBronze(int id, int x , int y){
        super(id, x ,y);
        this.pontos = 2;
    }

    public String getImagePNG(){
        return "box-mud.png";
    }

    @Override
    public String toString() {
        return id +" | " + "bronze" + " @ (" + x + ", " + y + ")";
    }
}
