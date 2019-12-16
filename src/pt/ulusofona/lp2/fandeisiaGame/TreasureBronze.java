package pt.ulusofona.lp2.fandeisiaGame;

public class TreasureBronze extends Treasure {
    TreasureBronze(int id, int x , int y){
        super(id, x ,y);
        this.pontos = 2;
    }

    @Override
    public String getImagePNG(){
        return "bronze-box.png";
    }

    @Override
    public String toString() {
        return id +" | " + "bronze" + " @ (" + x + ", " + y + ")";
    }
}
