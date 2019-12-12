package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureGold extends Treasure {
    TreasureGold(int id, int x, int y){
        super(id,x,y);
    }

    public String getImagePNG(){
        return "box-mud.png";
    }
}
