package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) {
        Button arrayButton = new Button("Array");
        Button stackButton = new Button("Stack");
        Button queueButton = new Button("Queue");
        Button linkedListButton = new Button("Linked List");
        Label label=new Label("Data Structure Visualizer");
        label.setAlignment(Pos.TOP_CENTER);
        arrayButton.setPrefSize(120,40);
        stackButton.setPrefSize(120,40);
        queueButton.setPrefSize(120,40);
        linkedListButton.setPrefSize(160,40);

        arrayButton.setOnAction(e -> {
            ArrayWindow arrayWindow = new ArrayWindow();
            Stage arrayStage = new Stage();
            arrayWindow.show(arrayStage);
        });

        stackButton.setOnAction(e -> {
            StackWindow stackWindow = new StackWindow();
            Stage stackStage = new Stage();
            stackWindow.show(stackStage);
        });

        queueButton.setOnAction(e -> {
            QueueWindow queueWindow = new QueueWindow();
        	Stage queueStage = new Stage();
            queueWindow.show(queueStage);
        });

        linkedListButton.setOnAction(e -> {
            LinkedListWindow linkedListWindow = new LinkedListWindow();
        	Stage List=new Stage();
            linkedListWindow.show(List);
        });
        VBox root = new VBox(10, label,arrayButton, stackButton, queueButton, linkedListButton);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
        Scene scene = new Scene(root, 500, 400);
        scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("DSA Learner - Main Menu");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
