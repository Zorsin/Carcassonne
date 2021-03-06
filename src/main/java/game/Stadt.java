package game;

import java.util.*;

/**
 * 07.05.2017
 *
 * @author SWirries MHeiß
 */
public class Stadt {

    ArrayList<Stadtteil> stadtteile = new ArrayList<>();
    boolean abgeschlossen = false;
    boolean besetzt = false;
    ArrayList<HimmelsrichtungT> offeneStadtkanten = new ArrayList<>();

    public Stadt() {
        //nur zur Vermeidung von NullPointerEx
    }

    public Stadt(ArrayList<Stadtteil> stadtteile) {
        this.stadtteile = stadtteile;
    }

    public Stadt (Stadtteil stadtteil){
       stadtteile.add(stadtteil);
       offeneStadtkanten.addAll(Arrays.asList(stadtteil.getOffeneKanten()));
    }

    public void addStadteil(Stadtteil stadtteil){
        stadtteile.add(stadtteil);
        offeneStadtkanten.addAll(Arrays.asList(stadtteil.getOffeneKanten()));

        checkAbgeschlossen();
    }

    /**
     * Ersetzt alle Offenen Kanten
     * @param himTnach
     */
    public void replaceOffeneKanten(HimmelsrichtungT[] himTnach){
        offeneStadtkanten.clear();
        offeneStadtkanten.addAll(Arrays.asList(himTnach));
    }

    /**
     * Fügt die Städte beim Legen der L'Karte (connectStaedte)
     * @param stadt
     * @param himmelsrichtungT
     */
    public void integrateStadt(Stadt stadt, HimmelsrichtungT himmelsrichtungT){
        stadtteile.addAll(stadt.getStadtteile());
        for(Stadtteil element : stadt.getStadtteile()){
                 element.setStadt(this);
        }
        offeneStadtkanten.addAll(stadt.getOffeneStadtkanten());
        /**
         * Entfernt offene Kanten um die Stadt abzuschließen
         */
        switch (himmelsrichtungT){
            case WEST:
                offeneStadtkanten.remove(HimmelsrichtungT.WEST);
                offeneStadtkanten.remove(HimmelsrichtungT.OST);
                break;
            case OST:
                offeneStadtkanten.remove(HimmelsrichtungT.OST);
                offeneStadtkanten.remove(HimmelsrichtungT.WEST);
                break;
            case SUED:
                offeneStadtkanten.remove(HimmelsrichtungT.SUED);
                offeneStadtkanten.remove(HimmelsrichtungT.NORD);
                break;
            case NORD:
                offeneStadtkanten.remove(HimmelsrichtungT.NORD);
                offeneStadtkanten.remove(HimmelsrichtungT.SUED);
                break;
        }
        checkAbgeschlossen();

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

    /**
     * Berechnet den Wert der Stadt
     * @return
     */
    public int getTotalWert(){
        int totalWert = 0;
        Set<Landschaftskarte> landschaftskarteSet = new HashSet<>();
        for(Stadtteil s : stadtteile){
            if(!landschaftskarteSet.contains(s.getLandschaftskarte())){
                landschaftskarteSet.add(s.getLandschaftskarte());
                totalWert += s.getWert();
            }
        }
        if(abgeschlossen){
            totalWert *= 2;
        }

        return totalWert;
    }

    /**
     * Prüft ob die Stadt besetzt ist
     * @return
     */
    public boolean isBesetzt() {
        if(!besetzt){
            for(Stadtteil s : stadtteile){
                boolean tempBesetzt = s.isBesetzt();
                if(tempBesetzt){
                    besetzt = true;
                    break;
                }

            }
        }
        return besetzt;
    }

    /**
     * Prüft ob die Stadt abgeschlossen ist, wenn ja bekommt der Spieler seine Punkte
     */
    public void checkAbgeschlossen(){

        int nordCount = 0;
        int ostCount = 0;
        int suedCount  = 0;
        int westCout = 0;
        for(HimmelsrichtungT himT : offeneStadtkanten){
            if (himT == HimmelsrichtungT.NORD) nordCount++;
            if (himT == HimmelsrichtungT.OST) ostCount++;
            if (himT == HimmelsrichtungT.SUED) suedCount++;
            if (himT == HimmelsrichtungT.WEST) westCout++;
        }

        if(nordCount == 0 && ostCount == 0 && suedCount == 0 && westCout == 0){
            abgeschlossen = true;
            setPlayerPoints();
        }

    }

    /**
     * Setzt dem Spieler seine Punkte
     */
    public void setPlayerPoints(){
            HashMap<Spieler, Integer> gefolgsmannAnzahl = new HashMap<>();
            ArrayList<Gefolgsmann> besetzer = new ArrayList<>();
            int maxCount = 0;
            for(Stadtteil sdt: stadtteile){
                if(sdt.getBesetzer() != null){
                    Spieler spieler = sdt.getBesetzer().getSpieler();
                    besetzer.add(sdt.getBesetzer());
                    int count = 0;

                    if(gefolgsmannAnzahl.containsKey(spieler)){
                        count = gefolgsmannAnzahl.get(spieler);
                        count++;
                        gefolgsmannAnzahl.replace(spieler,count);
                    }else{
                        count = 1;
                        gefolgsmannAnzahl.put(spieler,count);
                    }
                    if(maxCount < count) maxCount = count;
                }
            }
            int points = getTotalWert();
            for(Map.Entry entry : gefolgsmannAnzahl.entrySet()){
                if((int)entry.getValue() == maxCount) ((Spieler)entry.getKey()).addPunkte(points);
            }

            for (Gefolgsmann g : besetzer){
                g.setRolle(RolleT.FREI);
            }
    }

    public boolean contains(Stadtteil stadtteil){
        return stadtteile.contains(stadtteil);
    }

    public ArrayList<Stadtteil> getStadtteile() {
        return stadtteile;
    }

    public boolean isAbgeschlossen() {
        return abgeschlossen;
    }

    public ArrayList<HimmelsrichtungT> getOffeneStadtkanten() {
        return offeneStadtkanten;
    }
}
