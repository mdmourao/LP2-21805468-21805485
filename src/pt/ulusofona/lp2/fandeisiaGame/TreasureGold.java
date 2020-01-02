package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureGold extends Treasure {
    TreasureGold(int id, int x, int y){
        super(id,x,y);
        this.pontos = 3;

    }

    public String getImagePNG(){
        return "gold-box.png";
    }

    @Override
    public String toString() {
        return id +" | " + "gold" + " @ (" + x + ", " + y + ")";
    }
}
