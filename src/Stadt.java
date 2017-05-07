import java.util.ArrayList;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Stadt {

    ArrayList<Stadtteil> stadtteile = new ArrayList<>();
    boolean abgeschlossen = false;
    boolean besetzt = false;

    public Stadt(ArrayList<Stadtteil> stadtteile) {
        this.stadtteile = stadtteile;
        for(Stadtteil s: stadtteile){
            s.setStadt(this);
        }
    }

    public Stadt (Stadtteil stadtteil){
        addStadteil(stadtteil);
    }

    public void addStadteil(Stadtteil stadtteil){
        stadtteile.add(stadtteil);
        stadtteil.setStadt(this);
    }

    public boolean removeStadtteil(Stadtteil stadtteil){
        try {
            stadtteile.remove(stadtteil);
            return true;
        }catch (Exception e){

        }
        return false;
    }

    public int getAnzahlStadtteile(){
        return stadtteile.size();
    }

    public int getTotalWert(){
        int totalWert = 0;
        //TODO anpassen mit mehren Gefolgsleuten und auf gleicher Karte
        for(Stadtteil s : stadtteile){
            totalWert += s.getWert();
        }
        if(abgeschlossen){
            totalWert *= 2;
        }

        return totalWert;
    }

    public boolean isBesetzt() {
        if(besetzt == false){
            for(Stadtteil s : stadtteile){
                boolean tempBesetzt = s.isBesetzt();
                if(tempBesetzt) besetzt = true; break;
            }
        }
        return besetzt;
    }

    public void checkAbgeschlossen(){
        //TODO Prüfen ob Abgeschlossen ist -> abgeschlossen = true
        //TODO Wert berechnen -> getTotalWert
        //TODO Wert auf Punktekonto des Spielers gutschreiben über Gefolgsmann. Berechnung bei mehreren Männern beachten!
        for(Stadtteil s: stadtteile){
            if(s.getBesetzer() != null) s.getBesetzer().getSpieler().addPunkte(getTotalWert());
        }
        //TODO Gefolgsleute wieder freigeben -> gefolgsmann.setRolle(RolleT.FREI)
    }

    public void setAbgeschlossen(boolean b){
        //TODO REMOVE
        /**
         * DebugOnly wird eigentlich nicht benötig
         */
        abgeschlossen = b;
    }


    public boolean isAbgeschlossen() {
        return abgeschlossen;
    }
}
