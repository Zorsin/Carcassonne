import java.util.ArrayList;

/**
 * 25.04.2017
 *
 * @author SWirries
 *         <p>
 *         This code is
 *         documentation enough
 */
public class TestKlasse {

    public static void main(String[] args) {

        /**
         * Test der Logik ohne GUI
         */

        Spieler spieler1 = new Spieler("Spieler 1", FarbeT.BLAU);
        Spieler spieler2 = new Spieler("Spieler 2", FarbeT.ROT);

        System.out.println(spieler1);
        System.out.println(spieler2);

        ArrayList<Landschaftskarte> gelegtekarten = new ArrayList<>();

        /**
         * Für eine Landschaftskarte
         */
        Stadtteil st1 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
        HalbKantenT[] w1hk = {HalbKantenT.NordOst, HalbKantenT.SuedOst};
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{st1});
        HalbKantenT[] w2hk = {HalbKantenT.NordWest, HalbKantenT.SuedWest,
                HalbKantenT.WestSued, HalbKantenT.WestNord};
        Wiesenstueck w2 = new Wiesenstueck(w2hk, null);
        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.SUED);

        Landschaftskarte l1 = new Landschaftskarte(new Wiesenstueck[]{w1, w2},new Stadtteil[]{st1}, new Strassenabschnitt[]{s1});

    }
}
