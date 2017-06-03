/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Strassenabschnitt extends Landschaftsteil {
    private HimmelsrichtungT startRichtung;
    private HimmelsrichtungT endRichtung;
    private Strasse strasse;

    public Strassenabschnitt(HimmelsrichtungT startRichtung, HimmelsrichtungT endRichtung) {
        this.startRichtung = startRichtung;
        this.endRichtung = endRichtung;
        strasse = new Strasse(this);
    }

    public Strasse getStrasse() {
        return strasse;
    }

    public HimmelsrichtungT getStartRichtung() {
        return startRichtung;
    }

    public HimmelsrichtungT getEndRichtung() {
        return endRichtung;
    }

    public HimmelsrichtungT[] getHimmelsrichtungenT(){
        return new HimmelsrichtungT[]{startRichtung,endRichtung};
    }

    public void setStrasse(Strasse strasse) {
        this.strasse = strasse;
    }

    public void rotate(boolean direction){
        //TODO REMOVE
//        System.out.println("Strasse vorher: "+startRichtung + " " +endRichtung);
        startRichtung = direction ? startRichtung.next() : startRichtung.prev();
        endRichtung = direction ? endRichtung.next() : endRichtung.prev();
//        System.out.println("Strasse nachher: "+startRichtung + " " +endRichtung);

    }
}
