package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Strasse {

    ArrayList<Strassenabschnitt> strassenabschnitte = new ArrayList<>();
    boolean abgeschlossen = false;
    boolean besetzt = false;

    public Strasse() {
        //nur zur Vermeidung von NullPointerEx
    }

    public Strasse(ArrayList<Strassenabschnitt> strassenabschnitte) {
        this.strassenabschnitte = strassenabschnitte;
    }

    public Strasse(Strassenabschnitt strassenabschnitt) {
        strassenabschnitte.add(strassenabschnitt);
    }

    public void addStrassenabschnitt(Strassenabschnitt strassenabschnitt){
        strassenabschnitte.add(strassenabschnitt);
        checkAbgeschlossen();
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
        int stopCount = 0;
        for(Strassenabschnitt str : strassenabschnitte){
            boolean hasStop =  Arrays.asList(str.getHimmelsrichtungenT()).indexOf(HimmelsrichtungT.STOP) >=0;
            if (hasStop) stopCount++;
            if (stopCount >= 2) {
                abgeschlossen = true;
//                System.out.println("Strasse abgeschlossen");
                setPlayerPoints();
                break;
            }
        }
//        if (!abgeschlossen) System.out.println("nicht abgeschlossen");

    }

    private void setPlayerPoints(){
        if(abgeschlossen){

            HashMap<Spieler, Integer> gefolgsmannAnzahl = new HashMap<>();
            ArrayList<Gefolgsmann> besetzer = new ArrayList<>();
            int maxCount = 0;
            for(Strassenabschnitt str: strassenabschnitte){
                if(str.getBesetzer() != null){
                    Spieler spieler = str.getBesetzer().getSpieler();
                    besetzer.add(str.getBesetzer());
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
            //TODO REMOVE
//            System.out.println(gefolgsmannAnzahl);

            for (Gefolgsmann g : besetzer){
                g.setRolle(RolleT.FREI);
            }
        }
    }

    public ArrayList<Strassenabschnitt> getStrassenabschnitte() {
        return strassenabschnitte;
    }

    public boolean contains(Strassenabschnitt strassenabschnitt){
        return strassenabschnitte.contains(strassenabschnitt);
    }

    public boolean isAbgeschlossen() {
        return abgeschlossen;
    }
}
