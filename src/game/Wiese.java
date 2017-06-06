import java.util.*;

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

    public void setPlayerPoints(){
        /**
         * in der Endwertung aufrufen
         * für alle Spieler und Gefolgsleute
         * Spieler.getAllGefolgsleute = RolleT.BAUER
         * Gefolgsmann.getGebiet().setPlayerPoints <- alle Bauern auf der gleichen Wiese werden entfern bzw FREI
         */

        HashMap<Spieler, Integer> gefolgsmannAnzahl = new HashMap<>();
        ArrayList<Gefolgsmann> besetzer = new ArrayList<>();
        int maxCount = 0;
        for(Wiesenstueck stueck: wiesenstuecke){
            if(stueck.getBesetzer() != null){
                Spieler spieler = stueck.getBesetzer().getSpieler();
                besetzer.add(stueck.getBesetzer());
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
//        System.out.println(gefolgsmannAnzahl);

        for (Gefolgsmann g : besetzer){
            g.setRolle(RolleT.FREI);
        }
    }
}
