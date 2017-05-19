/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Kloster extends Landschaftsteil {

    int filledFields = 1;

    private void checkAbgeschlossen(){
        //TODO Prüfen ob Abgeschlossen ist -> abgeschlossen = true
        //TODO Wert berechnen -> getTotalWert
        //TODO Wert auf Punktekonto des Spielers gutschreiben über Gefolgsmann. Berechnung bei mehreren Männern beachten!
        //TODO Gefolgsleute wieder freigeben -> gefolgsmann.setRolle(RolleT.FREI)
    }

    public void addFillFreeField(){
        if(filledFields <8) filledFields++;
    }

    @Override
    public int getWert() {
        return wert * filledFields;
    }
}
