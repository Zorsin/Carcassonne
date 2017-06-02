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

    public void setWiese(Wiese wiese) {
        this.wiese = wiese;
    }

    public Wiesenstueck(HalbKantenT[] offeneHalbKanten, Stadtteil[] angrenzendeStadteile) {
        this.offeneHalbKanten = offeneHalbKanten;
        this.angrenzendeStadteile = angrenzendeStadteile;
        wiese = new Wiese(this);
    }

    public Stadtteil[] getAngrenzendeStadteile() {
        return angrenzendeStadteile;
    }

    public HalbKantenT[] getOffeneHalbKanten() {
        return offeneHalbKanten;
    }

}
