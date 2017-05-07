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
}
