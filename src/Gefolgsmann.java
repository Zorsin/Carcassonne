/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Gefolgsmann {
    int id;
    FarbeT farbe;
    RolleT rolle;
    AusrichtungT ausrichtung;
    Spieler spieler;
    Landschaftsteil gebiet;

    public Gefolgsmann(int id, FarbeT farbe, Spieler spieler){
        this.id = id;
        this.farbe = farbe;
        this.spieler = spieler;

        rolle = RolleT.FREI;
        ausrichtung = AusrichtungT.STEHEND;
    }

    public Gefolgsmann(int id, FarbeT farbe, Spieler spieler, RolleT rolle, AusrichtungT ausrichtung){
        this.id = id;
        this.farbe = farbe;
        this.spieler = spieler;

        this.rolle = rolle;
        this.ausrichtung = ausrichtung;
    }

    public int getId() {
        return id;
    }

    public FarbeT getFarbe() {
        return farbe;
    }

    public Spieler getSpieler() {
        return spieler;
    }

    public RolleT getRolle() {
        return rolle;
    }

    public void setRolle(RolleT rolle) {
        this.rolle = rolle;
    }

    public AusrichtungT getAusrichtung() {
        return ausrichtung;
    }

    public void setAusrichtung(AusrichtungT ausrichtung) {
        this.ausrichtung = ausrichtung;
    }

    public Landschaftsteil getGebiet() {
        return gebiet;
    }

    public void setGebiet(Landschaftsteil gebiet) {
        this.gebiet = gebiet;
        gebiet.setBesetzer(this);
    }
}
