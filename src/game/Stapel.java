package game;

import javafx.scene.image.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * 02.06.2017
 *
 * @author SWirries
 */
public class Stapel {
    ArrayList<Landschaftskarte> landschaftskarten = new ArrayList<>();
    public static final Image imageA = new Image("images/A.png");
    public static final Image imageB = new Image("images/B.png");
    public static final Image imageC = new Image("images/C.png");
    public static final Image imageD = new Image("images/D.png");
    public static final Image imageE = new Image("images/E.png");
    public static final Image imageF = new Image("images/F.png");
    public static final Image imageG = new Image("images/G.png");
    public static final Image imageH = new Image("images/H.png");
    public static final Image imageI = new Image("images/I.png");
    public static final Image imageJ = new Image("images/J.png");
    public static final Image imageK = new Image("images/K.png");
    public static final Image imageL = new Image("images/L.png");
    public static final Image imageM = new Image("images/M.png");
    public static final Image imageN = new Image("images/N.png");
    public static final Image imageO = new Image("images/O.png");
    public static final Image imageP = new Image("images/P.png");
    public static final Image imageQ = new Image("images/Q.png");
    public static final Image imageR = new Image("images/R.png");
    public static final Image imageS = new Image("images/S.png");
    public static final Image imageT = new Image("images/T.png");
    public static final Image imageU = new Image("images/U.png");
    public static final Image imageV = new Image("images/V.png");
    public static final Image imageW = new Image("images/W.png");
    public static final Image imageX = new Image("images/X.png");

    public Stapel() {
        generateStapel();
        System.out.println("Ein Stapel mit "+landschaftskarten.size()+ " Langschaftskarten wurde erzeugt");
    }

    public Landschaftskarte getStartLandschaftskarte(){
        return generateLandschaftD();
    }

    public Landschaftskarte drawLandschaftskarte(){
        int size = landschaftskarten.size();
        Random random = new Random();

        int randomInt = random.nextInt(size);
        System.out.println("Random:"+randomInt);
        Landschaftskarte drawedKard = landschaftskarten.get(randomInt);
        landschaftskarten.remove(drawedKard);
        System.out.println(landschaftskarten.size());

        return  drawedKard;
    }

    private void generateStapel(){
        landschaftskarten.add(generateLandschaftA());
        landschaftskarten.add(generateLandschaftA());

        landschaftskarten.add(generateLandschaftB());
        landschaftskarten.add(generateLandschaftB());
        landschaftskarten.add(generateLandschaftB());
        landschaftskarten.add(generateLandschaftB());

        landschaftskarten.add(generateLandschaftC());

        landschaftskarten.add(generateLandschaftD());
        landschaftskarten.add(generateLandschaftD());
        landschaftskarten.add(generateLandschaftD());

        landschaftskarten.add(generateLandschaftE());
        landschaftskarten.add(generateLandschaftE());
        landschaftskarten.add(generateLandschaftE());
        landschaftskarten.add(generateLandschaftE());
        landschaftskarten.add(generateLandschaftE());

        landschaftskarten.add(generateLandschaftF());
        landschaftskarten.add(generateLandschaftF());

        landschaftskarten.add(generateLandschaftG());

        landschaftskarten.add(generateLandschaftH());
        landschaftskarten.add(generateLandschaftH());
        landschaftskarten.add(generateLandschaftH());

        landschaftskarten.add(generateLandschaftI());
        landschaftskarten.add(generateLandschaftI());

        landschaftskarten.add(generateLandschaftJ());
        landschaftskarten.add(generateLandschaftJ());
        landschaftskarten.add(generateLandschaftJ());

        landschaftskarten.add(generateLandschaftK());
        landschaftskarten.add(generateLandschaftK());
        landschaftskarten.add(generateLandschaftK());

        landschaftskarten.add(generateLandschaftL());
        landschaftskarten.add(generateLandschaftL());
        landschaftskarten.add(generateLandschaftL());

        landschaftskarten.add(generateLandschaftM());
        landschaftskarten.add(generateLandschaftM());

        landschaftskarten.add(generateLandschaftN());
        landschaftskarten.add(generateLandschaftN());
        landschaftskarten.add(generateLandschaftN());

        landschaftskarten.add(generateLandschaftO());
        landschaftskarten.add(generateLandschaftO());

        landschaftskarten.add(generateLandschaftP());
        landschaftskarten.add(generateLandschaftP());
        landschaftskarten.add(generateLandschaftP());

        landschaftskarten.add(generateLandschaftQ());

        landschaftskarten.add(generateLandschaftR());
        landschaftskarten.add(generateLandschaftR());
        landschaftskarten.add(generateLandschaftR());

        landschaftskarten.add(generateLandschaftS());
        landschaftskarten.add(generateLandschaftS());

        landschaftskarten.add(generateLandschaftT());

        for(int i = 0; i < 8; i++)
            landschaftskarten.add(generateLandschaftU());

        for(int i = 0; i< 9;i++)
            landschaftskarten.add(generateLandschaftV());

        landschaftskarten.add(generateLandschaftW());
        landschaftskarten.add(generateLandschaftW());
        landschaftskarten.add(generateLandschaftW());
        landschaftskarten.add(generateLandschaftW());

        landschaftskarten.add(generateLandschaftX());

    }

    public Landschaftskarte generateLandschaftA(){
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
        Landschaftskarte landschaftskarte = new Landschaftskarte("A",new Wiesenstueck[]{w1},new Strassenabschnitt[]{str1},kloster);
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftB(){
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
        Landschaftskarte landschaftskarte = new Landschaftskarte("B",new Wiesenstueck[]{w1},kloster);
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftC(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{
                HimmelsrichtungT.NORD,
                HimmelsrichtungT.OST,
                HimmelsrichtungT.SUED,
                HimmelsrichtungT.WEST
        });
        Landschaftskarte landschaftskarte = new Landschaftskarte("C",new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftD(){

        /**
         * Für eine game.Landschaftskarte D
         */
        Stadtteil st1 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});

        HalbKantenT[] w1hk = {HalbKantenT.NordOst, HalbKantenT.SuedOst};
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{st1});
        HalbKantenT[] w2hk = {
                HalbKantenT.NordWest,
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued,
                HalbKantenT.WestNord};
        Wiesenstueck w2 = new Wiesenstueck(w2hk, null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.SUED);

        Landschaftskarte landschaftskarte = new Landschaftskarte("D",new Wiesenstueck[]{w1, w2},new Stadtteil[]{st1}, new Strassenabschnitt[]{s1});

        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftE(){
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

        Landschaftskarte landschaftskarte = new Landschaftskarte("E",new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftF(){
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

        Landschaftskarte landschaftskarte = new Landschaftskarte("F",new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftG(){
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

        Landschaftskarte landschaftskarte = new Landschaftskarte("G",new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftH(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
        Stadtteil stadtteil2 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst,
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil,stadtteil2});

        Landschaftskarte landschaftskarte = new Landschaftskarte("H",new Wiesenstueck[]{w1},
                new Stadtteil[]{stadtteil,stadtteil2});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftI(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.OST});
        Stadtteil stadtteil2 = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.SUED});

        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst,
                HalbKantenT.WestSued,
                HalbKantenT.WestNord
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil,stadtteil2});

        Landschaftskarte landschaftskarte = new Landschaftskarte("I",new Wiesenstueck[]{w1},
                new Stadtteil[]{stadtteil,stadtteil2});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftJ(){
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

        Landschaftskarte landschaftskarte = new Landschaftskarte("J",new Wiesenstueck[]{w1,w2},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftK(){
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

        Landschaftskarte landschaftskarte = new Landschaftskarte("K",new Wiesenstueck[]{w1,w2},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftL(){
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

        Landschaftskarte landschaftskarte = new Landschaftskarte("L",new Wiesenstueck[]{w1,w2,w3},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{str,str2,str3});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftM(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.OstNord,
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});


        Landschaftskarte landschaftskarte = new Landschaftskarte("M",new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftN(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.OstNord,
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});


        Landschaftskarte landschaftskarte = new Landschaftskarte("N",new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftO(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.OstNord,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        HalbKantenT[] w2hk = {
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.SUED);

        Landschaftskarte landschaftskarte = new Landschaftskarte("O",new Wiesenstueck[]{w1,w2},
                new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftP(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.OstNord,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        HalbKantenT[] w2hk = {
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.SUED);

        Landschaftskarte landschaftskarte = new Landschaftskarte("P",new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftQ(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        Landschaftskarte landschaftskarte = new Landschaftskarte("Q",new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftR(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.SuedOst,
                HalbKantenT.SuedWest
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        Landschaftskarte landschaftskarte = new Landschaftskarte("R",new Wiesenstueck[]{w1}, new Stadtteil[]{stadtteil});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftS(){
        Stadtteil stadtteil = new Stadtteil(true,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.SuedOst
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        HalbKantenT[] w2hk = {
                HalbKantenT.SuedWest
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);

        Landschaftskarte landschaftskarte = new Landschaftskarte("S",new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftT(){
        Stadtteil stadtteil = new Stadtteil(false,new HimmelsrichtungT[]{HimmelsrichtungT.NORD,HimmelsrichtungT.OST ,HimmelsrichtungT.WEST});

        HalbKantenT[] w1hk = {
                HalbKantenT.SuedOst
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,new Stadtteil[]{stadtteil});

        HalbKantenT[] w2hk = {
                HalbKantenT.SuedWest
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,new Stadtteil[]{stadtteil});

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);

        Landschaftskarte landschaftskarte = new Landschaftskarte("T",new Wiesenstueck[]{w1,w2}, new Stadtteil[]{stadtteil}, new Strassenabschnitt[]{s1});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftU(){
        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued,
                HalbKantenT.WestNord
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);

        HalbKantenT[] w2hk = {
                HalbKantenT.NordOst,
                HalbKantenT.OstNord,
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.SUED);

        Landschaftskarte landschaftskarte = new Landschaftskarte("U",new Wiesenstueck[]{w1,w2}, new Strassenabschnitt[]{s1});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftV(){
        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst,
                HalbKantenT.OstNord,
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);

        HalbKantenT[] w2hk = {
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.WEST);

        Landschaftskarte landschaftskarte = new Landschaftskarte("V",new Wiesenstueck[]{w1,w2}, new Strassenabschnitt[]{s1});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftW(){
        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.NordOst,
                HalbKantenT.OstNord,
                HalbKantenT.WestNord
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);

        HalbKantenT[] w2hk = {
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        HalbKantenT[] w3hk = {
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued
        };
        Wiesenstueck w3 = new Wiesenstueck(w3hk,null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.STOP);
        Strassenabschnitt s2 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);
        Strassenabschnitt s3 = new Strassenabschnitt(HimmelsrichtungT.WEST, HimmelsrichtungT.STOP);


        Landschaftskarte landschaftskarte = new Landschaftskarte("W",new Wiesenstueck[]{w1,w2,w3}, new Strassenabschnitt[]{s1,s2,s3});
        return landschaftskarte;
    }

    public Landschaftskarte generateLandschaftX(){
        HalbKantenT[] w1hk = {
                HalbKantenT.NordWest,
                HalbKantenT.WestNord
        };
        Wiesenstueck w1 = new Wiesenstueck(w1hk,null);

        HalbKantenT[] w2hk = {
                HalbKantenT.NordOst,
                HalbKantenT.OstNord
        };
        Wiesenstueck w2 = new Wiesenstueck(w2hk,null);

        HalbKantenT[] w3hk = {
                HalbKantenT.OstSued,
                HalbKantenT.SuedOst
        };
        Wiesenstueck w3 = new Wiesenstueck(w3hk,null);

        HalbKantenT[] w4hk = {
                HalbKantenT.SuedWest,
                HalbKantenT.WestSued
        };
        Wiesenstueck w4 = new Wiesenstueck(w4hk,null);

        Strassenabschnitt s1 = new Strassenabschnitt(HimmelsrichtungT.NORD, HimmelsrichtungT.STOP);
        Strassenabschnitt s2 = new Strassenabschnitt(HimmelsrichtungT.OST, HimmelsrichtungT.STOP);
        Strassenabschnitt s3 = new Strassenabschnitt(HimmelsrichtungT.SUED, HimmelsrichtungT.STOP);
        Strassenabschnitt s4 = new Strassenabschnitt(HimmelsrichtungT.WEST, HimmelsrichtungT.STOP);


        Landschaftskarte landschaftskarte = new Landschaftskarte("X",new Wiesenstueck[]{w1,w2,w3,w4}, new Strassenabschnitt[]{s1,s2,s3,s4});
        return landschaftskarte;
    }

}
