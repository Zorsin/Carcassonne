import java.util.ArrayList;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Strasse {

    ArrayList<Strassenabschnitt> strassenabschnitte = new ArrayList<>();
    boolean abgeschlossen = false;
    boolean besetzt = false;

    public Strasse(ArrayList<Strassenabschnitt> strassenabschnitte) {
        this.strassenabschnitte = strassenabschnitte;
    }

    public Strasse(Strassenabschnitt strassenabschnitt) {
        strassenabschnitte.add(strassenabschnitt);
    }

    public void addStrassenabschnitt(Strassenabschnitt strassenabschnitt){
        strassenabschnitte.add(strassenabschnitt);
    }

    public boolean removeStrassenabschnitt(Strassenabschnitt strassenabschnitt){
        try {
            strassenabschnitte.remove(strassenabschnitt);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    public int getAnzahlStrassenabschnitte(){
        return strassenabschnitte.size();
    }

    public int getTotalWert(){
        int totalWert = 0;
        //TODO anpassen mit mehren Gefolgsleuten und auf gleicher Karte
        for(Strassenabschnitt s: strassenabschnitte){
            totalWert += s.getWert();
        }
        return totalWert;
    }

    public boolean isBesetzt() {
        if(besetzt == false){
            for(Strassenabschnitt s: strassenabschnitte){
                boolean tempBesetzt = s.isBesetzt();
                if(tempBesetzt) besetzt = true; break;
            }
        }
        return besetzt;
    }

    private void checkAbgeschlossen(){
        //TODO Prüfen ob Abgeschlossen ist -> abgeschlossen = true
        //TODO Wert berechnen -> getTotalWert
        //TODO Wert auf Punktekonto des Spielers gutschreiben über Gefolgsmann. Berechnung bei mehreren Männern beachten!
        //TODO Gefolgsleute wieder freigeben -> gefolgsmann.setRolle(RolleT.FREI)
    }
}
