import java.util.Arrays;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Landschaftskarte {
    Wiesenstueck[] wiesen;
    Stadtteil[] staedte;
    Strassenabschnitt[] strassen;
    Kloster kloster;

    public Landschaftskarte(Wiesenstueck[] wiesen, Kloster kloster) {
        this.wiesen = wiesen;
        this.kloster = kloster;
    }

    public Landschaftskarte(Wiesenstueck[] wiesen, Strassenabschnitt[] strassen, Kloster kloster) {
        this.wiesen = wiesen;
        this.strassen = strassen;
        this.kloster = kloster;
    }

    public Landschaftskarte(Stadtteil[] staedte) {
        this.staedte = staedte;
    }

    public Landschaftskarte(Wiesenstueck[] wiesen, Stadtteil[] staedte, Strassenabschnitt[] strassen) {
        this.wiesen = wiesen;
        this.staedte = staedte;
        this.strassen = strassen;
    }

    public Landschaftskarte(Wiesenstueck[] wiesen, Stadtteil[] staedte) {
        this.wiesen = wiesen;
        this.staedte = staedte;
    }

    public Landschaftskarte(Wiesenstueck[] wiesen, Strassenabschnitt[] strassen) {
        this.wiesen = wiesen;
        this.strassen = strassen;
    }

    public Wiesenstueck[] getWiesen() {
        return wiesen;
    }

    public void setWiesen(Wiesenstueck[] wiesen) {
        this.wiesen = wiesen;
    }

    public Stadtteil[] getStaedte() {
        return staedte;
    }

    public void setStaedte(Stadtteil[] staedte) {
        this.staedte = staedte;
    }

    public Strassenabschnitt[] getStrassen() {
        return strassen;
    }

    public void setStrassen(Strassenabschnitt[] strassen) {
        this.strassen = strassen;
    }

    public Kloster getKloster() {
        return kloster;
    }

    public void setKloster(Kloster kloster) {
        this.kloster = kloster;
    }

    public void addNeighbor(Landschaftskarte landschaftskarte, HimmelsrichtungT himmelsrichtungT){
        switch (himmelsrichtungT){
            case NORD:
                addNordNeighbor(landschaftskarte);
                break;
            case OST:
                break;
            case SUED:
                break;
            case WEST:
                break;
        }
    }

    private void addNordNeighbor(Landschaftskarte landschaftskarte){
        Wiesenstueck[] wiesenstuecke = landschaftskarte.getWiesen();
//        Strassenabschnitt[] strassenabschnitte = landschaftskarte.getStrassen();
//        Stadtteil[] stadtteile = landschaftskarte.getStaedte();
        Kloster kloster = landschaftskarte.getKloster();

        if(kloster != null) kloster.addFillFreeField();
        else System.out.println("Kloster NULL");

        //TODO man könnte davon ausgehen, dass nur richtig gelegt wird
        if(wiesenstuecke != null && wiesen != null){
            for(Wiesenstueck wsThis : wiesen){
                for(Wiesenstueck ws : wiesenstuecke){
                    boolean bSuedWest = Arrays.asList(ws.getOffeneHalbKanten()).indexOf(HalbKantenT.SuedWest) >= 0;
                    boolean bNordWest = Arrays.asList(wsThis.getOffeneHalbKanten()).indexOf(HalbKantenT.NordWest) >= 0;
                    boolean bSuedOst = Arrays.asList(ws.getOffeneHalbKanten()).indexOf(HalbKantenT.SuedOst) >= 0;
                    boolean bNordOst = Arrays.asList(wsThis.getOffeneHalbKanten()).indexOf(HalbKantenT.NordOst) >= 0;

                    if(bNordOst == bSuedOst && bNordWest == bSuedWest){
                        System.out.println("Wiesen passen!");
                    }else System.out.println("SW"+bSuedWest+" SO"+bSuedOst);
                }
            }
        }else System.out.println("Wiesen NULL");

    }
}
