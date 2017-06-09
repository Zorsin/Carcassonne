package ui;

import game.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;


/**
 * @author Micha Heiß
 */
public class Main extends Application{

    private Canvas canvas;
    private Boolean canvasAllowUserInput = false;
    private GraphicsContext c;
    private BorderPane root;
    private ArrayList<CanvasButton> canvasButtons = new ArrayList<>();
    private ArrayList<Landschaftskarte> gelegteLandschaftskarten = new ArrayList<>();
    private Landschaftskarte currentLKarte;
    private Spieler currentSpieler;
    private int currentSpielerIndex;
    private double currentLKartX, currentLKartY;
    private Stapel stapel;
    private Spieler[] spielers;

    private double dragStartX = 0, dragStartY = 0;

    //TODO verschieben nach Spielplan??
    private double originX = 0, originY = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        System.out.println("Jetzt weiß ich auch, warum Sie Köpfe haben, soll ich's sagen?");
//        System.out.println("Sie müssen dann das viele Stroh nicht in den Händen tragen.");


        primaryStage.setTitle("Carcassonne");
        CanvasPane canvasPane = new CanvasPane(4000, 4000);
        canvas = canvasPane.getCanvas();
        c = canvas.getGraphicsContext2D();

        root = new BorderPane(canvasPane);
        Scene scene = new Scene(root, 1200,800);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("css/styles.css");

        primaryStage.show();


        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                render();
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                render();
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.F11) {
                primaryStage.setFullScreen(true);
                primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
                primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
                render();
            }
        });
        primaryStage.maximizedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                render();
            }
        });


        /*
        events für canvas
         */

        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
            public void handle(MouseEvent event) {

                dragStartX = event.getSceneX();
                dragStartY = event.getSceneY();


            }
        });
        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                render();
                drawCardHover(event);
            }
        });
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double x = event.getSceneX();
                double y = event.getSceneY();

                double deltaX = x-dragStartX;
                double deltaY = y-dragStartY;

                originX += deltaX;
                originY += deltaY;

                // TODO change width and height from constant to 'Spielplan' values
                int width = 1920;
                int height = 1080;
                if(originX-width/2 > 50 || (originX+width/2) < (canvas.getWidth()-50)){
                    // reset
                    originX -= deltaX;
                }
                if(originY-height/2 > 50 || (originY+height/2) < (canvas.getHeight()-50)){
                    // reset
                    originY -= deltaY;
                }

                dragStartX += deltaX;
                dragStartY += deltaY;

                render();
            }
        });

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // compute canvasButtons
                boolean foundButton = false;
                for(CanvasButton cb : canvasButtons){
                    if(cb.isInside(event.getSceneX(), event.getSceneY())){ // TODO if not drag detected
                        switch (cb.getName()){
                            case "Rotate Left":
                                foundButton = true;
                                currentLKarte.rotate(false,1);

                                break;
                            case "Rotate Right":
                                foundButton = true;
                                currentLKarte.rotate(true,1);
                                break;
                        }
                        render();
                        break;
                    }
                }
                if(!foundButton){
//
                    if (canvasAllowUserInput) {
                        placeLKarte();
                    }

                    //TODO man kann nur auf der letzten Karte legen aktuell noch auf jeder
//                    for(Landschaftskarte landschaftskarte : gelegteLandschaftskarten){
//                        double x = event.getSceneX()-originX, y = event.getSceneY()-originY;
//                        double lx = landschaftskarte.getX()*landschaftskarte.getWidth(),
//                                ly = landschaftskarte.getY()*landschaftskarte.getHeight(),
//                                lw = landschaftskarte.getWidth(),
//                                lh = landschaftskarte.getHeight();
//
//                        if(squareContains(x,y,lx,ly,lw,lh)){
//
//                            landschaftskarte.setGefolgsmann(spielers[0].getFreienGeflogsmann());
//
//                        }
//
//                    }

                }
            }
        });

        // set origin to center
        originX = canvas.getWidth()/2;
        originY = canvas.getHeight()/2;

        //TODO anpassen
        canvasButtons.add(new CanvasButton(500,20,60,60, "images/rotate-left.png", "Rotate Left"));
        canvasButtons.add(new CanvasButton(700,20,60,60, "images/rotate-right.png", "Rotate Right"));

        /**
         * Start Karte und erster Zug
         */
        stapel  = new Stapel();
        Landschaftskarte startKarte = stapel.getStartLandschaftskarte();
        startKarte.setX(0);
        startKarte.setY(0);
        gelegteLandschaftskarten.add(startKarte);
        currentLKarte = stapel.drawLandschaftskarte();

        PlayerInputController playerInputController = new PlayerInputController(new AnchorPane(), this);

        do {
            playerInputController.showAndWait();
        } while (spielers == null);

        render();
    }

    public void render(){


            double width = canvas.getWidth();
            double height = canvas.getHeight();

            //TODO verschieben nach Spielplan
            int planWidth = 1920;
            int planHeight = 1080;

            // canvas background
            c.setFill(Color.WHEAT);
            c.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            // plan background
            //TODO verschieben nach Spielplan bzw. ändern nach spielplan.draw() o.ä.
//        c.setFill(Color.WHEAT);
//        c.fillRect(originX-(planWidth/2), originY-(planHeight/2), planWidth, planHeight);

            // TODO change to ClassObject.draw() o.ä.
            // startkarte
//        Images images = new Images("images");
//        c.drawImage(new Landschaftskarte().getImage(), originX,originY); // TODO anonymous Object

            //draw landschaftskarten

            for (Landschaftskarte lkarte : gelegteLandschaftskarten) {
                c.drawImage(lkarte.getImage(), lkarte.getX() * lkarte.getWidth() + originX,
                        lkarte.getY() * lkarte.getHeight() + originY);
            }

            //draw Gefolgsmann
            if(spielers != null) {
                for (Spieler spieler : spielers) {
                    for (Gefolgsmann gefolgsmann : spieler.getAllGefolgsleute()) {
                        if (gefolgsmann.getRolle() != RolleT.FREI && gefolgsmann.getAbsolutePosition() != null) {
                            c.drawImage(gefolgsmann.getImage(), gefolgsmann.getAbsolutePosition().getX() + originX,
                                    gefolgsmann.getAbsolutePosition().getY() + originY, 25, 24);
                            //                    System.out.println("Gefunden: "+gefolgsmann.getAbsolutePosition());
                        }

                    }
                }
            }

            //draw canvas Buttons
            for (CanvasButton cb : canvasButtons) {
                c.drawImage(cb.getImage(), cb.getX(), cb.getY(), cb.getWidth(), cb.getHeight());
            }
            //TODO Vorschau der aktuellen Karte
            //draw currentKarte
            c.drawImage(currentLKarte.getImage(), 600, 20, 60, 60);

    }

    public void drawCardHover(MouseEvent e){
        Image rotatedImage = currentLKarte.getImage();
        canvasAllowUserInput = false;
        for(Landschaftskarte landschaftskarte : gelegteLandschaftskarten) {

            double x = e.getSceneX()-originX, y = e.getSceneY()-originY;

            double lx = landschaftskarte.getX()*landschaftskarte.getWidth(), ly = landschaftskarte.getY()*landschaftskarte.getHeight(),
                lw = landschaftskarte.getWidth(), lh = landschaftskarte.getHeight();

//        System.out.println("zwischen " + (lx-lw) + " " + (ly-lh) + " und " + (lx+2*lw) + " " + (ly+2*lw));

            if (x > (lx - lw) && x < (lx + 2 * lw) && y > (ly - lh) && y < (ly + 2 * lh)) {

                boolean showKard = false;
                // karte darüber
                if (squareContains(x, y, lx, ly - lh, lw, lh)) {
                    currentLKartX = landschaftskarte.getX() + 0;
                    currentLKartY = landschaftskarte.getY() - 1;
                    showKard = true;
                    canvasAllowUserInput = true;
                } else if (squareContains(x, y, lx + lw, ly, lw, lh)) { // karte rechts
                    currentLKartX = landschaftskarte.getX() + 1;
                    currentLKartY = landschaftskarte.getY() - 0;
                    showKard = true;
                    canvasAllowUserInput = true;
                } else if (squareContains(x, y, lx, ly + lh, lw, lh)) { // karte unten
                    currentLKartX = landschaftskarte.getX() + 0;
                    currentLKartY = landschaftskarte.getY() + 1;
                    showKard = true;
                    canvasAllowUserInput = true;
                } else if (squareContains(x, y, lx - lw, ly, lw, lh)) { // karte links
                    currentLKartX = landschaftskarte.getX() - 1;
                    currentLKartY = landschaftskarte.getY() - 0;
                    showKard = true;
                    canvasAllowUserInput = true;
                }
                for(Landschaftskarte landschaftskarte2 : gelegteLandschaftskarten){
                    if (currentLKartX == landschaftskarte2.getX() && currentLKartY == landschaftskarte2.getY()) {
                        showKard = false;
                        canvasAllowUserInput = false;
                    }
                }
                if(spielers == null){
                    showKard =false;
                    canvasAllowUserInput = false;
                }
                if (showKard) c.drawImage(rotatedImage, currentLKartX*currentLKarte.getWidth()+originX,
                        currentLKartY*currentLKarte.getHeight()+originY);

            }
        }
    }

    private boolean squareContains(double x, double y, double sx, double sy, double w, double h){
        return x>sx && x<(sx+w) && y>sy && y<(sy+h);
    }

    private void placeLKarte(){
        Landschaftskarte nordKarte = null;
        Landschaftskarte ostKarte = null;
        Landschaftskarte suedKarte = null;
        Landschaftskarte westKarte = null;

        boolean bNord = true;
        boolean bOst = true;
        boolean bSued = true;
        boolean bWest = true;

        for(Landschaftskarte landschaftskarte : gelegteLandschaftskarten){
            if(landschaftskarte.getX() == currentLKartX && landschaftskarte.getY() == currentLKartY-1)
                nordKarte = landschaftskarte;
            if(landschaftskarte.getX() == currentLKartX+1 && landschaftskarte.getY() == currentLKartY)
                ostKarte = landschaftskarte;
            if(landschaftskarte.getX() == currentLKartX && landschaftskarte.getY() == currentLKartY+1)
                suedKarte = landschaftskarte;
            if(landschaftskarte.getX() == currentLKartX-1 && landschaftskarte.getY() == currentLKartY)
                westKarte = landschaftskarte;
        }
        if(nordKarte != null) bNord = currentLKarte.addNeighbor(nordKarte, HimmelsrichtungT.NORD, false);
        if(ostKarte != null) bOst = currentLKarte.addNeighbor(ostKarte, HimmelsrichtungT.OST, false);
        if(suedKarte != null) bSued = currentLKarte.addNeighbor(suedKarte, HimmelsrichtungT.SUED, false);
        if(westKarte != null) bWest = currentLKarte.addNeighbor(westKarte, HimmelsrichtungT.WEST, false);

        if(bNord && bOst && bSued && bWest){
            currentLKarte.setX(currentLKartX);
            currentLKarte.setY(currentLKartY);
            gelegteLandschaftskarten.add(currentLKarte);
            //Karte bzw Landschaftsteile miteinander Verbinden
            if(nordKarte != null) currentLKarte.addNeighbor(nordKarte, HimmelsrichtungT.NORD, true);
            if(ostKarte != null) currentLKarte.addNeighbor(ostKarte, HimmelsrichtungT.OST, true);
            if(suedKarte != null) currentLKarte.addNeighbor(suedKarte, HimmelsrichtungT.SUED, true);
            if(westKarte != null) currentLKarte.addNeighbor(westKarte, HimmelsrichtungT.WEST, true);

            currentLKarte.setGefolgsmann(currentSpieler.getFreienGeflogsmann());
            //Neue Karte zeihen
            currentLKarte = stapel.drawLandschaftskarte();
            //nächster Spieler
            int spielerIndex = (++currentSpielerIndex)%spielers.length;

            currentSpieler = spielers[spielerIndex];
            currentSpielerIndex = spielerIndex;
        }else {
            currentLKarte.getInformation();
            System.out.println(bNord + " " + bOst + " "+ bSued + " " +bWest);
            if(nordKarte != null){
                System.out.println("--NORD--");
                nordKarte.getInformation();
            }
            if(ostKarte != null){
                System.out.println("--OST--");
                ostKarte.getInformation();
            }
            if(suedKarte != null){
                System.out.println("--SUED--");
                suedKarte.getInformation();
            }
            if(westKarte != null){
                System.out.println("--WEST--");
                westKarte.getInformation();
            }
        }

    }

    public void setSpielers(Spieler[] spielers) {
        this.spielers = spielers;
        currentSpieler = spielers[0];
        currentSpielerIndex = 0;
    }
}
