package game;

import java.awt.*;

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
//        System.out.println("game.Strasse vorher: "+startRichtung + " " +endRichtung);
        startRichtung = direction ? startRichtung.next() : startRichtung.prev();
        endRichtung = direction ? endRichtung.next() : endRichtung.prev();
//        System.out.println("game.Strasse nachher: "+startRichtung + " " +endRichtung);

    }

    @Override
    public void setBesetzer(Gefolgsmann besetzer) {
        super.setBesetzer(besetzer);
        besetzer.setRolle(RolleT.WEGELAGERER);
    }

    @Override
    public String toString() {
        String himmelsRichtung = "{";
        himmelsRichtung += " " + startRichtung;
        himmelsRichtung += " " + endRichtung;
        himmelsRichtung += "}";

        return "Stassenabschnitt " + himmelsRichtung;
    }
    private void getGefolgsmannPositionAufStrasse(){

        // erster enum (NORD,...)

        // Nord: 1/2widht, 1/4height
        // OST: 3/4widht, 1/2height

    }
}
