package pt.ulusofona.lp2.fandeisiaGame;

public class Humano extends CreatureGira90 {


    public Humano(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao,2);
        custo = 3;
    }

    public String getImagePNG(){
        return null;
    }

    public boolean possoSaltarPorcima(int numberCreatures, int numberHoles) {
        if (numberCreatures > 0 || numberHoles > 0) {
            return false;
        }
        return true;
    }

}
