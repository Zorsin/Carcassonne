package ui;

import game.Landschaftskarte;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

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

    private double dragStartX = 0, dragStartY = 0;

    //TODO verschieben nach Spielplan??
    private double originX = 0, originY = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Jetzt weiß ich auch, warum Sie Köpfe haben, soll ich's sagen?");
        System.out.println("Sie müssen dann das viele Stroh nicht in den Händen tragen.");


        primaryStage.setTitle("Carcassonne");
        CanvasPane canvasPane = new CanvasPane(1200, 800);
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
            @Override
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
                            case "rotate":
                                // TODO rotate card
                                System.out.println("rotate!");
                                foundButton = true;
                                break;
                        }
                        break;
                    }
                }
                if(!foundButton){
                    // TODO Landschaftskarte.add(new Landschaftskarte);
                }
            }
        });

        // set origin to center
        originX = canvas.getWidth()/2;
        originY = canvas.getHeight()/2;

        canvasButtons.add(new CanvasButton(500,50,50,50, "images/D.png", "rotate"));

        render();
    }

    public void render(){

        double width = canvas.getWidth();
        double height = canvas.getHeight();

        //TODO verschieben nach Spielplan
        int planWidth = 1920;
        int planHeight = 1080;

        // canvas background
        c.setFill(Color.BLUEVIOLET);
        c.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

        // plan background
        //TODO verschieben nach Spielplan bzw. ändern nach spielplan.draw() o.ä.
        c.setFill(Color.BLACK);
        c.fillRect(originX-(planWidth/2), originY-(planHeight/2), planWidth, planHeight);

        // TODO change to ClassObject.draw() o.ä.
        // startkarte
        Images images = new Images("images");
        c.drawImage(new Landschaftskarte().getImage(), originX,originY); // TODO anonymous Object


        // add canvas Buttons
        for (CanvasButton cb : canvasButtons){
            c.drawImage(cb.getImage(), cb.getX(), cb.getY(), cb.getWidth(), cb.getHeight());
        }

    }

    public void drawCardHover(MouseEvent e){
        // TODO method stub
        // TODO make cards hover when canvas is clickable

        // TODO delete
        Landschaftskarte l = new Landschaftskarte(); // bereits vorhandene Karte auf Spielfeld zum Testen

        double x = e.getSceneX()-originX, y = e.getSceneY()-originY;
        double lx = l.getX(), ly = l.getY(), lw = l.getWidth(), lh = l.getHeight();

//        System.out.println("zwischen " + (lx-lw) + " " + (ly-lh) + " und " + (lx+2*lw) + " " + (ly+2*lw));

        if(x > (lx-lw) && x < (lx+2*lw) && y > (ly-lh) && y < (ly + 2*lh)){

            double imageX, imageY;
            // karte darüber
            if(squareContains(x,y, lx, ly-lh, lw, lh)){
                imageX = lx;
                imageY = ly-lh;
                // TODO change to dynamic card width
                c.drawImage(new Image("images/A.png"), originX+imageX, originY+imageY);
            }else if(squareContains(x,y, lx+lw,ly,lw,lh)){ // karte rechts
                imageX = lx+lw;
                imageY = ly;
                // TODO change to dynamic card width
                c.drawImage(new Image("images/A.png"), originX+imageX, originY+imageY);
            }else if(squareContains(x,y, lx, ly+lh,lw,lh)){ // karte unten
                imageX = lx;
                imageY = ly+lh;
                // TODO change to dynamic card width
                c.drawImage(new Image("images/A.png"), originX+imageX, originY+imageY);
            }else if(squareContains(x,y,lx-lw,ly,lw,lh)){ // karte links
                imageX = lx-lw;
                imageY = ly;
                // TODO change to dynamic card width
                c.drawImage(new Image("images/A.png"), originX+imageX, originY+imageY);
            }


        }


    }

    private boolean squareContains(double x, double y, double sx, double sy, double w, double h){
        return x>sx && x<(sx+w) && y>sy && y<(sy+h);
    }

}
