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
        for(Wiesenstueck w : wiesenstuecke){
            Stadtteil[] teile = w.getAngrenzendeStadteile();
            if(teile != null){
                for(Stadtteil s : teile){
                    if(s.getStadt().isAbgeschlossen()) staete.add(s.getStadt());
                }
            }
        }



        return totalWert;
    }

    private void checkAbgeschlossen(){
        //TODO Prüfen ob Abgeschlossen ist -> abgeschlossen = true
        //TODO Wert berechnen -> getTotalWert
        //TODO Wert auf Punktekonto des Spielers gutschreiben über Gefolgsmann. Berechnung bei mehreren Männern beachten!
        //TODO Gefolgsleute wieder freigeben -> gefolgsmann.setRolle(RolleT.FREI)
    }
}
