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
        if(startRichtung != HimmelsrichtungT.STOP && endRichtung != HimmelsrichtungT.STOP){
            return new HimmelsrichtungT[]{startRichtung,endRichtung};
        }else if(startRichtung != HimmelsrichtungT.STOP){
            return new HimmelsrichtungT[]{startRichtung};
        }else {
            return new HimmelsrichtungT[]{endRichtung};
        }

    }

    public void setStrasse(Strasse strasse) {
        this.strasse = strasse;
    }
}
