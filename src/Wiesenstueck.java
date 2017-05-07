import java.util.ArrayList;

/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Wiesenstueck extends Landschaftsteil {
    HalbKantenT[] offeneHalbKanten;
    Stadtteil[] angrenzendeStadteile;
    Wiese wiese;

    public Wiese getWiese() {
        return wiese;
    }

    public Wiesenstueck(HalbKantenT[] offeneHalbKanten, Stadtteil[] angrenzendeStadteile) {
        this.offeneHalbKanten = offeneHalbKanten;
        this.angrenzendeStadteile = angrenzendeStadteile;
    }

    public Stadtteil[] getAngrenzendeStadteile() {
        return angrenzendeStadteile;
    }
}
