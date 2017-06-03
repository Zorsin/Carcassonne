import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Wiese {

    ArrayList<Wiesenstueck> wiesenstuecke = new ArrayList<>();

    boolean abgeschlossen = false;
    boolean besetzt = false;

    public Wiese() {
        //nur zur Vermeidung von NullPointerEx
    }

    public Wiese(ArrayList<Wiesenstueck> wiesenstuecke) {
        this.wiesenstuecke = wiesenstuecke;
    }

    public Wiese(Wiesenstueck wiesenstueck) {
        wiesenstuecke.add(wiesenstueck);
    }

    public void addWiesenstueck(Wiesenstueck wiesenstueck){
        wiesenstuecke.add(wiesenstueck);
    }

    public boolean removeWiesenstuecke(Wiesenstueck wiesenstueck){
        try {
            wiesenstuecke.remove(wiesenstueck);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean contains(Wiesenstueck wiesenstueck){
        return wiesenstuecke.contains(wiesenstueck);
    }

    public int getAnzahlWiesenstuecke(){
        return wiesenstuecke.size();
    }

    public boolean isBesetzt() {
        if(besetzt == false){
            for(Wiesenstueck w : wiesenstuecke){
                boolean tempBesetzt = w.isBesetzt();
                if(tempBesetzt) besetzt = true; break;
            }
        }
        return besetzt;
    }

    public int getTotalWert(){
        int totalWert = 0;
        Set<Stadt> staete = new HashSet<>();
        for(Wiesenstueck stueck : wiesenstuecke){
            Stadtteil[] teile = stueck.getAngrenzendeStadteile();
            if(teile != null){
                for(Stadtteil std : teile){
                    //TODO Anpassen
                    if(std.getStadt().isAbgeschlossen()) staete.add(std.getStadt());
                }
            }
        }
        totalWert = staete.size();


        return totalWert;
    }

    public ArrayList<Wiesenstueck> getWiesenstuecke() {
        return wiesenstuecke;
    }

    private void checkAbgeschlossen(){
        //TODO Prüfen ob Abgeschlossen ist -> abgeschlossen = true
        //TODO Wert berechnen -> getTotalWert
        //TODO Wert auf Punktekonto des Spielers gutschreiben über Gefolgsmann. Berechnung bei mehreren Männern beachten!
        //TODO Gefolgsleute wieder freigeben -> gefolgsmann.setRolle(RolleT.FREI)
    }
}
