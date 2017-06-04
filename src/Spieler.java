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
        int frei = 0;
        int ritter = 0;
        int bauer = 0;
        int moench = 0;
        int wegelagerer = 0;
        for(Gefolgsmann gefolgsmann : gefolgsleute){
            switch (gefolgsmann.getRolle()){
                case FREI:
                    frei++;
                    break;
                case BAUER:
                    bauer++;
                    break;
                case MOENCH:
                    moench++;
                    break;
                case RITTER:
                    ritter++;
                    break;
                case WEGELAGERER:
                    wegelagerer++;
                    break;
            }
        }

        return name + " Farbe:"+farbe + " Punkte:"+punkte + " Frei:"+frei + " Ritter:"+ritter + " Bauer:"+ bauer +
                " Mönch:"+moench + " Wegelagerer:"+wegelagerer;
    }

    public void addPunkte(int punkte){
        this.punkte += punkte;
    }

}
