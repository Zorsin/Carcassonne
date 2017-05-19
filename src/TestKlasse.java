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

//        Spieler spieler1 = new Spieler("Spieler 1", FarbeT.BLAU);
//        Spieler spieler2 = new Spieler("Spieler 2", FarbeT.ROT);

//        System.out.println(spieler1);
//        System.out.println(spieler2);

        ArrayList<Landschaftskarte> gelegtekarten = new ArrayList<>();

        Landschaftskarte start = generateLandschaftK();
        Landschaftskarte l2 = generateLandschaftL();

        start.addNeighbor(l2,HimmelsrichtungT.NORD);
    }

    private static Landschaftskarte generateLandschaftA(){
        Kloster kloster = new Kloster();
        HalbKantenT[] w1hk = {
              HalbKantenT.NordOst,
              HalbKantenT.NordWest,
              HalbKantenT.OstNord,
              HalbKantenT.OstSued,
              HalbKantenT.SuedOst,
              HalbKantenT.SuedWest,
              HalbKantenT.WestSued,
              HalbKantenT.WestNord
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
        Strassenabschnitt str1 = new Strassenabschnitt(HimmelsrichtungT.SUED,HimmelsrichtungT.STOP);
        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},new Strassenabschnitt[]{str1},kloster);
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftB(){
        Kloster kloster = new Kloster();
        HalbKantenT[] w1hk = {
              HalbKantenT.NordOst,
              HalbKantenT.NordWest,
              HalbKantenT.OstNord,
              HalbKantenT.OstSued,
              HalbKantenT.SuedOst,
              HalbKantenT.SuedWest,
              HalbKantenT.WestSued,
              HalbKantenT.WestNord
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},kloster);
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftC(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{
                HimmelsrichtungT.NORD,
                HimmelsrichtungT.OST,
                HimmelsrichtungT.SUED,
                HimmelsrichtungT.WEST
            });
        Landschaftskarte landschaftskarte = new Landschaftskarte(new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftD(){

        /**
         * Für eine Landschaftskarte A (ohne Startkarte
         */
        Stadtteil st1 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});

        HalbKantenT[] w1hk = {HalbKantenT.NordOst, HalbKantenT.SuedOst};
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{st1});
        HalbKantenT[] w2hk = {HalbKantenT.NordWest, HalbKantenT.SuedWest,
                HalbKantenT.WestSued, HalbKantenT.WestNord};
        Wiesenstueck w2 = new Wiesenstueck(w2hk, null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.SUED);

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1, w2},new Stadtteil[]{st1}, new Strassenabschnitt[]{s1});

        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftE(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD});
        HalbKantenT[] w1hk = {
              HalbKantenT.OstNord,
              HalbKantenT.OstSued,
              HalbKantenT.SuedOst,
              HalbKantenT.SuedWest,
              HalbKantenT.WestSued,
              HalbKantenT.WestNord
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftF(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.OST,HimmelsrichtungT.WEST});
        HalbKantenT[] w1hk = {
          HalbKantenT.SuedOst,
          HalbKantenT.SuedWest
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        HalbKantenT[] w2hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst
            };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftG(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.SUED});

        HalbKantenT[] w1hk = {
          HalbKantenT.OstNord,
          HalbKantenT.OstSued
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        HalbKantenT[] w2hk = {
                HalbKantenT.WestSued,
                HalbKantenT.WestNord
            };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftH(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
        Stadtteil stadtteil2 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst,
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil,stadtteil2});

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},
                new Stadtteil[]{stadtteil,stadtteil2});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftI(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
        Stadtteil stadtteil2 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.SUED});

        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst,
                HalbKantenT.WestSued,
                HalbKantenT.WestNord
            };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil,stadtteil2});

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},
                new Stadtteil[]{stadtteil,stadtteil2});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftJ(){
        Strassenabschnitt str = new Strassenabschnitt(HimmelsrichtungT.OST,HimmelsrichtungT.SUED);

        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD});

        HalbKantenT[] w1hk = {
                HalbKantenT.OstNord,
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued,
                HalbKantenT.WestNord
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
        HalbKantenT[] w2hk = {
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftK(){
        Strassenabschnitt str = new Strassenabschnitt(HimmelsrichtungT.WEST,HimmelsrichtungT.NORD);

        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});

        HalbKantenT[] w1hk = {
                HalbKantenT.NordOst,
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
        HalbKantenT[] w2hk = {
                HalbKantenT.WestNord,
                HalbKantenT.NordWest
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str});
        return landschaftskarte;
    }

    private static Landschaftskarte generateLandschaftL(){
        Strassenabschnitt str = new Strassenabschnitt(HimmelsrichtungT.NORD,HimmelsrichtungT.STOP);
        Strassenabschnitt str2 = new Strassenabschnitt(HimmelsrichtungT.SUED,HimmelsrichtungT.STOP);
        Strassenabschnitt str3 = new Strassenabschnitt(HimmelsrichtungT.WEST,HimmelsrichtungT.STOP);

        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});

        HalbKantenT[] w1hk = {
                HalbKantenT.NordOst,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
        HalbKantenT[] w2hk = {
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
        HalbKantenT[] w3hk = {
                HalbKantenT.WestNord,
                HalbKantenT.NordWest
        };
        Wiesenstueck w3 = new Wiesenstueck(w3hk,null);

        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2,w3},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str,str2,str3});
        return landschaftskarte;
    }



}
