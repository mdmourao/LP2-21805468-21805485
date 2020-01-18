package pt.ulusofona.lp2.fandeisiaGame;

public class InsufficientCoinsException extends Exception {
   static boolean team10Invalida = false;
    static boolean team20Invalida = false;
    static int moedas10;
    static int moedas20;

    public InsufficientCoinsException(String message) {
        super(message);
    }

     public boolean teamRequiresMoreCoins(int teamId) {
        if (teamId == 10) {
            return team10Invalida;
        } else {
            return team20Invalida;
        }
    }

     public int getRequiredCoinsForTeam(int teamId) {
        if (teamId == 10) {
            return moedas10;
        } else {
            return moedas20;
        }
    }

    static public void setTeam10Invalida(boolean team10Invalida) {
        InsufficientCoinsException.team10Invalida = team10Invalida;
    }

    static  public void setTeam20Invalida(boolean team20Invalida) {
        InsufficientCoinsException.team20Invalida = team20Invalida;
    }

    static  public void setMoedas10(int moedas10) {
        InsufficientCoinsException.moedas10 = moedas10;
    }

    static  public void setMoedas20(int moedas20) {
        InsufficientCoinsException.moedas20 = moedas20;
    }
}
