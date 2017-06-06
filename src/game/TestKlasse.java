import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
/**
 * 25.04.2017
 *
 * @author SWirries
 *         <p>
 *         This code is
 *         documentation enough
 */
public class TestKlasse extends Application{

//    public static void main(String[] args) {
//
//        /**
//         * Test der Logik ohne GUI
//         */
//
////        Spieler spieler1 = new Spieler("Spieler 1", FarbeT.BLAU);
////        Spieler spieler2 = new Spieler("Spieler 2", FarbeT.ROT);
//
////        System.out.println(spieler1);
////        System.out.println(spieler2);
//
////        ArrayList<Landschaftskarte> gelegtekarten = new ArrayList<>();
//
//        Stapel stapel = new Stapel();
//
////        Landschaftskarte start = stapel.generateLandschaftA();
////        Landschaftskarte la1 = stapel.generateLandschaftX();
////        System.out.println(la1);
////        Landschaftskarte la2 = generateLandschaftA();
//
////        start.addNeighbor(la1,HimmelsrichtungT.OST);
////        la2.addNeighbor(start, HimmelsrichtungT.SUED);
////        System.out.println("----------------------");
////
////        Landschaftskarte la3 = generateLandschaftI();
////        Landschaftskarte la4 = generateLandschaftG();
////        Landschaftskarte la5 = generateLandschaftN();
////        la3.addNeighbor(la4,HimmelsrichtungT.SUED);
////        la4.addNeighbor(la2,HimmelsrichtungT.SUED);
////        la4.addNeighbor(la5,HimmelsrichtungT.WEST);
//
//        /**
//         * Test Rotation
//         */
////        Landschaftskarte start = stapel.generateLandschaftD();
////        start.rotate();
////        start.rotate();
////        start.rotate();
////        start.rotate();
//
////        Landschaftskarte e = stapel.generateLandschaftE();
////        start.addNeighbor(e, HimmelsrichtungT.OST);
////        e.rotate(false,1);
////        System.out.println("-------------");
////        start.addNeighbor(e, HimmelsrichtungT.OST);
//
//        /**
//         * Test Strassen / Stadt abgeschlossen
//         */
//        //Strasse
////        Landschaftskarte start = stapel.generateLandschaftD();
////        Landschaftskarte a = stapel.generateLandschaftA();
////        Landschaftskarte l = stapel.generateLandschaftL();
////
////        start.addNeighbor(a, HimmelsrichtungT.NORD);
////        start.addNeighbor(l,HimmelsrichtungT.SUED);
////
////        start.getInformation();
////        a.getInformation();
////        l.getInformation();
//
//        //Stadt
////        Landschaftskarte start = stapel.generateLandschaftD();
////        Landschaftskarte c = stapel.generateLandschaftC();
////        Landschaftskarte h = stapel.generateLandschaftH();
////        Landschaftskarte e1 = stapel.generateLandschaftE();
////        Landschaftskarte e2 = stapel.generateLandschaftE();
////        Landschaftskarte e3 = stapel.generateLandschaftE();
////        Landschaftskarte f = stapel.generateLandschaftF();
////        Landschaftskarte n1 = stapel.generateLandschaftN();
////        Landschaftskarte n2 = stapel.generateLandschaftN();
////
////        start.addNeighbor(c, HimmelsrichtungT.OST);
////        e1.rotate(true, 2);
////        c.addNeighbor(e1, HimmelsrichtungT.NORD);//Oben
////        c.addNeighbor(e3, HimmelsrichtungT.SUED);//unten
////        c.addNeighbor(f, HimmelsrichtungT.OST);
//////
////        f.addNeighbor(n1, HimmelsrichtungT.OST);
//////        n1.getInformation();
//////        System.out.println("---");
////        n2.rotate(true, 2);
////        n2.addNeighbor(h, HimmelsrichtungT.OST);
//////        n2.getInformation();
////        n1.addNeighbor(n2, HimmelsrichtungT.NORD);
////        n2.getInformation();
//
//
//        /**
//         * Test Gefolgsmann setzen / brechnen
//         */
//        Spieler spieler1 = new Spieler("Spieler 1", FarbeT.BLAU);
//        Spieler spieler2 = new Spieler("Spieler 2", FarbeT.ROT);
//
//        //Stadt
////        Landschaftskarte start = stapel.generateLandschaftD();
////        Landschaftskarte c = stapel.generateLandschaftC();
////        Landschaftskarte h = stapel.generateLandschaftH();
////        Landschaftskarte e1 = stapel.generateLandschaftE();
////        Landschaftskarte e2 = stapel.generateLandschaftE();
////        Landschaftskarte e3 = stapel.generateLandschaftE();
////        Landschaftskarte f = stapel.generateLandschaftF();
////        Landschaftskarte n1 = stapel.generateLandschaftN();
////        Landschaftskarte n2 = stapel.generateLandschaftN();
////
////        //Mehre Gefolgsleute in einer Stadt
////        c.setGefolgsmann(spieler1.getFreienGeflogsmann());
////        n1.setGefolgsmann(spieler1.getFreienGeflogsmann());
////        n2.setGefolgsmann(spieler2.getFreienGeflogsmann());
////
////        start.addNeighbor(c, HimmelsrichtungT.OST);
////        e1.rotate(true, 2);
////        c.addNeighbor(e1, HimmelsrichtungT.NORD);//Oben
////        c.addNeighbor(e3, HimmelsrichtungT.SUED);//unten
////        c.addNeighbor(f, HimmelsrichtungT.OST);
//////
////        f.addNeighbor(n1, HimmelsrichtungT.OST);
////        n2.rotate(true, 2);
////        n2.addNeighbor(h, HimmelsrichtungT.OST);
////        n1.addNeighbor(n2, HimmelsrichtungT.NORD);
////        System.out.println(spieler1);
////        System.out.println(spieler2);
//
//        //Strasse
//        Landschaftskarte start = stapel.generateLandschaftD();
//        Landschaftskarte d = stapel.generateLandschaftD();
//        Landschaftskarte a1 = stapel.generateLandschaftA();
//        Landschaftskarte a2 = stapel.generateLandschaftA();
//        Landschaftskarte l = stapel.generateLandschaftL();
//
//        start.setGefolgsmann(spieler1.getFreienGeflogsmann());
//        start.addNeighbor(a1, HimmelsrichtungT.NORD);
////        a1.setGefolgsmann(spieler2.getFreienGeflogsmann());
//        start.addNeighbor(d,HimmelsrichtungT.SUED);
////        d.setGefolgsmann(spieler1.getFreienGeflogsmann());
//        a2.rotate(true,2);
//        d.addNeighbor(a2,HimmelsrichtungT.SUED);

//    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * Test der Logik
         */

        Spieler spieler1 = new Spieler("Spieler 1", FarbeT.BLAU);
        Spieler spieler2 = new Spieler("Spieler 2", FarbeT.ROT);

//        System.out.println(spieler1);
//        System.out.println(spieler2);

//        ArrayList<Landschaftskarte> gelegtekarten = new ArrayList<>();

        Stapel stapel = new Stapel();

        /**
         * Welt
         */

        Landschaftskarte d = stapel.generateLandschaftD();
        Landschaftskarte e1 = stapel.generateLandschaftE();
        Landschaftskarte e2 = stapel.generateLandschaftE();
        Landschaftskarte e3 = stapel.generateLandschaftE();
        Landschaftskarte e4 = stapel.generateLandschaftE();
        Landschaftskarte n = stapel.generateLandschaftN();
        Landschaftskarte c = stapel.generateLandschaftC();
        Landschaftskarte f = stapel.generateLandschaftF();
        Landschaftskarte p = stapel.generateLandschaftP();
        Landschaftskarte w = stapel.generateLandschaftW();
        Landschaftskarte u1 = stapel.generateLandschaftU();
        Landschaftskarte u2 = stapel.generateLandschaftU();
        Landschaftskarte u3 = stapel.generateLandschaftU();
        Landschaftskarte a = stapel.generateLandschaftA();
        Landschaftskarte v1 = stapel.generateLandschaftV();
        Landschaftskarte v2 = stapel.generateLandschaftV();
        Landschaftskarte l = stapel.generateLandschaftL();
        Landschaftskarte i = stapel.generateLandschaftI();
        Landschaftskarte k = stapel.generateLandschaftK();

        System.out.println("Stadt 1");
        //Stadt 1
        d.addNeighbor(c,HimmelsrichtungT.OST);
        e1.rotate(true,2);
        c.addNeighbor(e1,HimmelsrichtungT.NORD);
        c.addNeighbor(e2, HimmelsrichtungT.SUED);
        c.addNeighbor(f,HimmelsrichtungT.OST);
        f.addNeighbor(p,HimmelsrichtungT.OST);
        n.rotate(true,2);
        p.addNeighbor(n, HimmelsrichtungT.NORD);
        e3.rotate(false,1);
        n.addNeighbor(e3,HimmelsrichtungT.OST);

        System.out.println("\nStraße 1");
        //Straße 1
        d.addNeighbor(u1,HimmelsrichtungT.SUED);
        u1.addNeighbor(l,HimmelsrichtungT.SUED);
        u1.addNeighbor(e2,HimmelsrichtungT.OST);

        System.out.println("\nKloster und Straße 2");
        //Kloster und Straße 2
        a.rotate(false,1);
        e2.addNeighbor(a,HimmelsrichtungT.OST);
        v1.rotate(true,1);
        a.addNeighbor(v1,HimmelsrichtungT.OST);
        v1.addNeighbor(p,HimmelsrichtungT.NORD);
        //TODO P und v1 koennen nicht verbunden werden
        p.getInformation();
        v1.getInformation();
        p.addNeighbor(w, HimmelsrichtungT.OST);
        w.addNeighbor(e3, HimmelsrichtungT.NORD);

        System.out.println("\nStraße 3");
        //Straße 3
        w.addNeighbor(u2, HimmelsrichtungT.SUED);
        u2.addNeighbor(v1,HimmelsrichtungT.WEST);
        u2.addNeighbor(k,HimmelsrichtungT.SUED);
        u3.rotate(true,1);
        k.addNeighbor(u3,HimmelsrichtungT.WEST);
        v2.rotate(false,1);
        u3.addNeighbor(v2,HimmelsrichtungT.WEST);
        i.rotate(true,1);
        v2.addNeighbor(i, HimmelsrichtungT.WEST);

        System.out.println("Stadt 2");
        //Stadt 2
        l.addNeighbor(i,HimmelsrichtungT.OST);

        System.out.println("Stadt 3");
        //Stadt 3
        e4.rotate(false,1);
        k.addNeighbor(e4,HimmelsrichtungT.OST);
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
//        Landschaftskarte start = stapel.generateLandschaftD();
//        Landschaftskarte c = stapel.generateLandschaftC();
//        Landschaftskarte h = stapel.generateLandschaftH();
//        Landschaftskarte e1 = stapel.generateLandschaftE();
//        Landschaftskarte e2 = stapel.generateLandschaftE();
//        Landschaftskarte e3 = stapel.generateLandschaftE();
//        Landschaftskarte f = stapel.generateLandschaftF();
//        Landschaftskarte n1 = stapel.generateLandschaftN();
//        Landschaftskarte n2 = stapel.generateLandschaftN();
//
//        start.addNeighbor(c, HimmelsrichtungT.OST);
//        e1.rotate(true, 2);
//        c.addNeighbor(e1, HimmelsrichtungT.NORD);//Oben
//        c.addNeighbor(e3, HimmelsrichtungT.SUED);//unten
//        c.addNeighbor(f, HimmelsrichtungT.OST);
////
//        f.addNeighbor(n1, HimmelsrichtungT.OST);
////        n1.getInformation();
////        System.out.println("---");
//        n2.rotate(true, 2);
//        n2.addNeighbor(h, HimmelsrichtungT.OST);
////        n2.getInformation();
//        n1.addNeighbor(n2, HimmelsrichtungT.NORD);
//        n2.getInformation();


        /**
         * Test Gefolgsmann setzen / brechnen
         */


        //Stadt
//        Landschaftskarte start = stapel.generateLandschaftD();
//        Landschaftskarte c = stapel.generateLandschaftC();
//        Landschaftskarte h = stapel.generateLandschaftH();
//        Landschaftskarte e1 = stapel.generateLandschaftE();
//        Landschaftskarte e2 = stapel.generateLandschaftE();
//        Landschaftskarte e3 = stapel.generateLandschaftE();
//        Landschaftskarte f = stapel.generateLandschaftF();
//        Landschaftskarte n1 = stapel.generateLandschaftN();
//        Landschaftskarte n2 = stapel.generateLandschaftN();
//
//        //Mehre Gefolgsleute in einer Stadt
//        c.setGefolgsmann(spieler1.getFreienGeflogsmann());
//        n1.setGefolgsmann(spieler1.getFreienGeflogsmann());
//        n2.setGefolgsmann(spieler2.getFreienGeflogsmann());
//
//        start.addNeighbor(c, HimmelsrichtungT.OST);
//        e1.rotate(true, 2);
//        c.addNeighbor(e1, HimmelsrichtungT.NORD);//Oben
//        c.addNeighbor(e3, HimmelsrichtungT.SUED);//unten
//        c.addNeighbor(f, HimmelsrichtungT.OST);
////
//        f.addNeighbor(n1, HimmelsrichtungT.OST);
//        n2.rotate(true, 2);
//        n2.addNeighbor(h, HimmelsrichtungT.OST);
//        n1.addNeighbor(n2, HimmelsrichtungT.NORD);
//        System.out.println(spieler1);
//        System.out.println(spieler2);

        //Strasse
//        Landschaftskarte start = stapel.generateLandschaftD();
//        Landschaftskarte d = stapel.generateLandschaftD();
//        Landschaftskarte a1 = stapel.generateLandschaftA();
//        Landschaftskarte a2 = stapel.generateLandschaftA();
//        Landschaftskarte l = stapel.generateLandschaftL();
//
//        start.setGefolgsmann(spieler1.getFreienGeflogsmann());
//        start.addNeighbor(a1, HimmelsrichtungT.NORD);
//        a1.setGefolgsmann(spieler2.getFreienGeflogsmann());
//        start.addNeighbor(d,HimmelsrichtungT.SUED);
//        d.setGefolgsmann(spieler1.getFreienGeflogsmann());
//        a2.rotate(true,2);
//        d.addNeighbor(a2,HimmelsrichtungT.SUED);
    }
}