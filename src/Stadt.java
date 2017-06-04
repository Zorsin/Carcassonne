import java.util.*;

/**
 * 07.05.2017
 *
 * @author SWirries
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

    public void addStadteil(Stadtteil stadtteil, HimmelsrichtungT himmelsrichtungT){
        stadtteile.add(stadtteil);
        offeneStadtkanten.addAll(Arrays.asList(stadtteil.getOffeneKanten()));
//        switch (himmelsrichtungT){
//            case WEST:
//                offeneStadtkanten.remove(HimmelsrichtungT.WEST);
//                offeneStadtkanten.remove(HimmelsrichtungT.OST);
//                break;
//            case OST:
//                offeneStadtkanten.remove(HimmelsrichtungT.WEST);
//                offeneStadtkanten.remove(HimmelsrichtungT.OST);
//                break;
//            case SUED:
//                offeneStadtkanten.remove(HimmelsrichtungT.SUED);
//                offeneStadtkanten.remove(HimmelsrichtungT.NORD);
//                break;
//            case NORD:
//                offeneStadtkanten.remove(HimmelsrichtungT.SUED);
//                offeneStadtkanten.remove(HimmelsrichtungT.NORD);
//                break;
//        }

        checkAbgeschlossen();
    }

    public void replaceOffeneKanten(HimmelsrichtungT[] himTnach){
        offeneStadtkanten.clear();
        offeneStadtkanten.addAll(Arrays.asList(himTnach));
    }

    public void integrateStadt(Stadt stadt, HimmelsrichtungT himmelsrichtungT){
        //TODO REMOVE
        stadtteile.addAll(stadt.getStadtteile());
        for(Stadtteil element : stadt.getStadtteile()){
                 element.setStadt(this);
        }
//
//        for(HimmelsrichtungT t : offeneStadtkanten){
//            System.out.println("Vor "+t);
//        }
        offeneStadtkanten.addAll(stadt.getOffeneStadtkanten());
//        for(HimmelsrichtungT t : offeneStadtkanten){
//            System.out.println("Zwischen "+t);
//        }
//        System.out.println("Anzal1: "+offeneStadtkanten.size());
//        System.out.println(himmelsrichtungT);
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
//        for(HimmelsrichtungT t : offeneStadtkanten){
//            System.out.println("Nach "+t);
//        }
//        System.out.println("Anzal 2: "+offeneStadtkanten.size());

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
            System.out.println("Alle Kanten geschlossen");
            abgeschlossen = true;
            setPlayerPoints();
        }else{
            System.out.println("N:"+nordCount);
            System.out.println("O:"+ostCount);
            System.out.println("S:"+suedCount);
            System.out.println("W:"+westCout);
        }

    }

    private void setPlayerPoints(){
        if(abgeschlossen){

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
            //TODO REMOVE
            System.out.println(gefolgsmannAnzahl);

            for (Gefolgsmann g : besetzer){
                g.setRolle(RolleT.FREI);
            }
        }
    }

    public void setAbgeschlossen(boolean b){
        //TODO REMOVE
        /**
         * DebugOnly wird eigentlich nicht benötig
         */
        abgeschlossen = b;
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
