/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pathtransitiondemo;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author usu2dam
 */
public class PathTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Pane root = new Pane();
        Rectangle rectangle = new Rectangle(20, 40);
        rectangle.setFill(Color.ORANGE);
        //El rectángulo se desconfigura si no especifico la posición del círculo
        Circle circle = new Circle(150, 125, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        
        root.getChildren().addAll(circle,rectangle);
        
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(circle);
        path.setNode(rectangle);
        path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.play();
        
        circle.setOnMousePressed(e -> path.pause());
        circle.setOnMouseReleased(e -> path.play());
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("PathTransition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
