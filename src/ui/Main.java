package ui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * @author Micha Heiß
 */
public class Main extends Application{

    Canvas canvas;
    GraphicsContext c;

    double dragStartX = 0, dragStartY = 0;

    //TODO verschieben nach Spielplan
    double originX = 0, originY = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Jetzt weiß ich auch, warum Sie Köpfe haben, soll ich's sagen?");
        System.out.println("Sie müssen dann das viele Stro nicht in den Händen tragen.");


        primaryStage.setTitle("Carcassonne");
        CanvasPane canvasPane = new CanvasPane(1200, 800);
        canvas = canvasPane.getCanvas();
        c = canvas.getGraphicsContext2D();

        BorderPane root = new BorderPane(canvasPane);
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

        // set origin to center
        originX = canvas.getWidth()/2;
        originY = canvas.getHeight()/2;

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


    }
}
