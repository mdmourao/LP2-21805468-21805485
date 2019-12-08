package pt.ulusofona.lp2.fandeisiaGame;

public class Gigante extends CreatureGira90 {
    public Gigante(int id, String tipo, int idEquipa, int x, int y, String orientacao) {
        super(id, tipo, idEquipa, x, y, orientacao,3);
    }

    public String getImagePNG(){
        return null;
    }
}
