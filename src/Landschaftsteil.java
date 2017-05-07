/**
 * 07.05.2017
 *
 * @author SWirries
 */
public abstract class Landschaftsteil {

    int wert = 1;
    Gefolgsmann besetzer;
    boolean besetzt = false;
    public int getWert() {
        return wert;
    }

    public Gefolgsmann getBesetzer() {
        return besetzer;
    }

    public void setBesetzer(Gefolgsmann besetzer) {
        this.besetzer = besetzer;
        besetzt = true;
    }

    public boolean isBesetzt() {
        return besetzt;
    }
}
