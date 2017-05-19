import java.util.ArrayList;
import java.util.Arrays;

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

    public HalbKantenT[] getOffeneHalbKanten() {
        return offeneHalbKanten;
    }

    public boolean hasNordSeite(){
        boolean value = false;
        value = Arrays.asList(offeneHalbKanten).indexOf(HalbKantenT.NordOst) >= 0;

        return value;
    }
}
