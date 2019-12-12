package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureBronze extends Treasure {
    TreasureBronze(int id, int x , int y){
        super(id, x ,y);
    }

    public String getImagePNG(){
        return "box-mud.png";
    }
}
