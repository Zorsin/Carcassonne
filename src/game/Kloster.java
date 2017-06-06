package game;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Kloster extends Landschaftsteil {

    int filledFields = 1;

    private void setPlayerPoints(){
        if(filledFields == 8){
            besetzer.getSpieler().addPunkte(getWert());
            besetzer.setRolle(RolleT.FREI);
        }
    }

    public void addFillFreeField(){
        if(filledFields <8) filledFields++;
        if (filledFields == 8) setPlayerPoints();
    }



    @Override
    public int getWert() {
        return wert * filledFields;
    }

    @Override
    public String toString() {
        return "Kloster";
    }

    @Override
    public void setBesetzer(Gefolgsmann besetzer) {
        super.setBesetzer(besetzer);
        besetzer.setRolle(RolleT.MOENCH);
    }
}
