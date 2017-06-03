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

        Stapel stapel = new Stapel();

//        Landschaftskarte start = stapel.generateLandschaftA();
//        Landschaftskarte la1 = stapel.generateLandschaftX();
//        System.out.println(la1);
//        Landschaftskarte la2 = generateLandschaftA();

//        start.addNeighbor(la1,HimmelsrichtungT.OST);
//        la2.addNeighbor(start, HimmelsrichtungT.SUED);
//        System.out.println("----------------------");
//
//        Landschaftskarte la3 = generateLandschaftI();
//        Landschaftskarte la4 = generateLandschaftG();
//        Landschaftskarte la5 = generateLandschaftN();
//        la3.addNeighbor(la4,HimmelsrichtungT.SUED);
//        la4.addNeighbor(la2,HimmelsrichtungT.SUED);
//        la4.addNeighbor(la5,HimmelsrichtungT.WEST);

        /**
         * Test Rotation
         */
//        Landschaftskarte start = stapel.generateLandschaftD();
//        start.rotate();
//        start.rotate();
//        start.rotate();
//        start.rotate();

//        Landschaftskarte e = stapel.generateLandschaftE();
//        start.addNeighbor(e, HimmelsrichtungT.OST);
//        e.rotate(false,1);
//        System.out.println("-------------");
//        start.addNeighbor(e, HimmelsrichtungT.OST);

        /**
         * Test Strassen / Stadt abgeschlossen
         */
        //Strasse
//        Landschaftskarte start = stapel.generateLandschaftD();
//        Landschaftskarte a = stapel.generateLandschaftA();
//        Landschaftskarte l = stapel.generateLandschaftL();
//
//        start.addNeighbor(a, HimmelsrichtungT.NORD);
//        start.addNeighbor(l,HimmelsrichtungT.SUED);
//
//        start.getInformation();
//        a.getInformation();
//        l.getInformation();

        //Stadt
        Landschaftskarte start = stapel.generateLandschaftD();
        Landschaftskarte c = stapel.generateLandschaftC();
        Landschaftskarte h = stapel.generateLandschaftH();
        Landschaftskarte e1 = stapel.generateLandschaftE();
        Landschaftskarte e2 = stapel.generateLandschaftE();
        Landschaftskarte e3 = stapel.generateLandschaftE();
        Landschaftskarte f = stapel.generateLandschaftF();
        Landschaftskarte n1 = stapel.generateLandschaftN();
        Landschaftskarte n2 = stapel.generateLandschaftN();

        start.addNeighbor(c, HimmelsrichtungT.OST);
        e1.rotate(true, 2);
        c.addNeighbor(e1, HimmelsrichtungT.NORD);//Oben
        c.addNeighbor(e3, HimmelsrichtungT.SUED);//unten
        c.addNeighbor(f, HimmelsrichtungT.OST);
//
        f.addNeighbor(n1, HimmelsrichtungT.OST);
//        n1.getInformation();
//        System.out.println("---");
        n2.rotate(true, 2);
        n2.addNeighbor(h, HimmelsrichtungT.OST);
//        n2.getInformation();
        n1.addNeighbor(n2, HimmelsrichtungT.NORD);
        n2.getInformation();
    }
//
//    private static Landschaftskarte generateLandschaftA(){
//        Kloster kloster = new Kloster();
//        HalbKantenT[] w1hk = {
//              HalbKantenT.NordOst,
//              HalbKantenT.NordWest,
//              HalbKantenT.OstNord,
//              HalbKantenT.OstSued,
//              HalbKantenT.SuedOst,
//              HalbKantenT.SuedWest,
//              HalbKantenT.WestSued,
//              HalbKantenT.WestNord
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
//        Strassenabschnitt str1 = new Strassenabschnitt(HimmelsrichtungT.SUED,HimmelsrichtungT.STOP);
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},new Strassenabschnitt[]{str1},kloster);
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftB(){
//        Kloster kloster = new Kloster();
//        HalbKantenT[] w1hk = {
//              HalbKantenT.NordOst,
//              HalbKantenT.NordWest,
//              HalbKantenT.OstNord,
//              HalbKantenT.OstSued,
//              HalbKantenT.SuedOst,
//              HalbKantenT.SuedWest,
//              HalbKantenT.WestSued,
//              HalbKantenT.WestNord
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},kloster);
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftC(){
//        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{
//                HimmelsrichtungT.NORD,
//                HimmelsrichtungT.OST,
//                HimmelsrichtungT.SUED,
//                HimmelsrichtungT.WEST
//            });
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftD(){
//
//        /**
//         * Für eine Landschaftskarte D
//         */
//        Stadtteil st1 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
//
//        HalbKantenT[] w1hk = {HalbKantenT.NordOst, HalbKantenT.SuedOst};
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{st1});
//        HalbKantenT[] w2hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued,
//                HalbKantenT.WestNord};
//        Wiesenstueck w2 = new Wiesenstueck(w2hk, null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.SUED);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1, w2},new Stadtteil[]{st1}, new Strassenabschnitt[]{s1});
//
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftE(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD});
//        HalbKantenT[] w1hk = {
//              HalbKantenT.OstNord,
//              HalbKantenT.OstSued,
//              HalbKantenT.SuedOst,
//              HalbKantenT.SuedWest,
//              HalbKantenT.WestSued,
//              HalbKantenT.WestNord
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftF(){
//        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.OST,HimmelsrichtungT.WEST});
//        HalbKantenT[] w1hk = {
//          HalbKantenT.SuedOst,
//          HalbKantenT.SuedWest
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.NordOst
//            };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftG(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.SUED});
//
//        HalbKantenT[] w1hk = {
//          HalbKantenT.OstNord,
//          HalbKantenT.OstSued
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.WestSued,
//                HalbKantenT.WestNord
//            };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftH(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
//        Stadtteil stadtteil2 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.NordOst,
//                HalbKantenT.SuedOst,
//                HalbKantenT.SuedWest
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil,stadtteil2});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},
//                new Stadtteil[]{stadtteil,stadtteil2});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftI(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
//        Stadtteil stadtteil2 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.SUED});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.NordOst,
//                HalbKantenT.WestSued,
//                HalbKantenT.WestNord
//            };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil,stadtteil2});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1},
//                new Stadtteil[]{stadtteil,stadtteil2});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftJ(){
//        Strassenabschnitt str = new Strassenabschnitt(HimmelsrichtungT.OST,HimmelsrichtungT.SUED);
//
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.OstNord,
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued,
//                HalbKantenT.WestNord
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//        HalbKantenT[] w2hk = {
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2},
//                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftK(){
//        Strassenabschnitt str = new Strassenabschnitt(HimmelsrichtungT.WEST,HimmelsrichtungT.NORD);
//
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordOst,
//                HalbKantenT.SuedOst,
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//        HalbKantenT[] w2hk = {
//                HalbKantenT.WestNord,
//                HalbKantenT.NordWest
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2},
//                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftL(){
//        Strassenabschnitt str = new Strassenabschnitt(HimmelsrichtungT.NORD,HimmelsrichtungT.STOP);
//        Strassenabschnitt str2 = new Strassenabschnitt(HimmelsrichtungT.SUED,HimmelsrichtungT.STOP);
//        Strassenabschnitt str3 = new Strassenabschnitt(HimmelsrichtungT.WEST,HimmelsrichtungT.STOP);
//
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordOst,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//        HalbKantenT[] w2hk = {
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//        HalbKantenT[] w3hk = {
//                HalbKantenT.WestNord,
//                HalbKantenT.NordWest
//        };
//        Wiesenstueck w3 = new Wiesenstueck(w3hk,null);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2,w3},
//                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str,str2,str3});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftM(){
//        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.OstNord,
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst,
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftN(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.OstNord,
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst,
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftO(){
//        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.OstNord,
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.SUED);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftP(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.OstNord,
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.SUED);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftQ(){
//        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.SuedOst,
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftR(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.SuedOst,
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftS(){
//        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftT(){
//        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});
//
//        HalbKantenT[] w1hk = {
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.SuedWest
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftU(){
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued,
//                HalbKantenT.WestNord
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.NordOst,
//                HalbKantenT.OstNord,
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.SUED);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Strassenabschnitt[]{s1});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftV(){
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.NordOst,
//                HalbKantenT.OstNord,
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.WEST);
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2}, new Strassenabschnitt[]{s1});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftW(){
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.NordOst,
//                HalbKantenT.OstNord,
//                HalbKantenT.WestNord
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        HalbKantenT[] w3hk = {
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued
//        };
//        Wiesenstueck w3 = new Wiesenstueck(w3hk,null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.STOP);
//        Strassenabschnitt s2 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);
//        Strassenabschnitt s3 = new Strassenabschnitt(HimmelsrichtungT.WEST, HimmelsrichtungT.STOP);
//
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2,w3}, new Strassenabschnitt[]{s1,s2,s3});
//        return landschaftskarte;
//    }
//
//    private static Landschaftskarte generateLandschaftX(){
//        HalbKantenT[] w1hk = {
//                HalbKantenT.NordWest,
//                HalbKantenT.WestNord
//        };
//        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);
//
//        HalbKantenT[] w2hk = {
//                HalbKantenT.NordOst,
//                HalbKantenT.OstNord
//        };
//        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);
//
//        HalbKantenT[] w3hk = {
//                HalbKantenT.OstSued,
//                HalbKantenT.SuedOst
//        };
//        Wiesenstueck w3 = new Wiesenstueck(w3hk,null);
//
//        HalbKantenT[] w4hk = {
//                HalbKantenT.SuedWest,
//                HalbKantenT.WestSued
//        };
//        Wiesenstueck w4 = new Wiesenstueck(w4hk,null);
//
//        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.STOP);
//        Strassenabschnitt s2 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.STOP);
//        Strassenabschnitt s3 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);
//        Strassenabschnitt s4 = new Strassenabschnitt(HimmelsrichtungT.WEST, HimmelsrichtungT.STOP);
//
//
//        Landschaftskarte landschaftskarte = new Landschaftskarte(new Wiesenstueck[]{w1,w2,w3,w4}, new Strassenabschnitt[]{s1,s2,s3,s4});
//        return landschaftskarte;
//    }

}
