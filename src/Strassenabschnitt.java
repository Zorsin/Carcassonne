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
    }

    public Strasse getStrasse() {
        return strasse;
    }
}
