/**
 * 07.05.2017
 *
 * @author SWirries
 */
public class Spieler {
    String name;
    Gefolgsmann[] gefolgsleute = new Gefolgsmann[8];
    FarbeT farbe;
    int punkte;

    public Spieler(String name, FarbeT farbe) {
        this.name = name;
        this.farbe = farbe;
        generateGefolgsleute();
    }

    private void generateGefolgsleute(){
        for(int i = 0; i < 8; i++){
            gefolgsleute[i] = new Gefolgsmann(i,farbe,this);
        }
    }

    public Gefolgsmann[] getAllGefolgsleute(){
        return gefolgsleute;
    }

    public Gefolgsmann getFreienGeflogsmann(){
        for(Gefolgsmann g : gefolgsleute){
            if(g.getRolle() == RolleT.FREI) return g;
        }

        return null;
    }

    public String toString(){

        return name + " Farbe:"+farbe + " Punkte:"+punkte;
    }

    public void addPunkte(int punkte){
        this.punkte += punkte;
    }

}
