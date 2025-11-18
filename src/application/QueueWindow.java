package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QueueWindow {
    private Queue1 queue = new Queue1();
    private QueueController controller = new QueueController();
    private Canvas canvas = new Canvas();
    
    	public void show(Stage primaryStage) {
    	    Button addButton = new Button("Add");
    	    Button removeButton = new Button("Remove");
    	    Button peekButton = new Button("Peek");
    	    Label titleLabel = new Label("Queue Visualizer");
    	    Label definitionLabel = new Label("Definition: A Queue is a data structure which follows the principle of first in first out");
    	    Label timeComplexityLabel = new Label("Time Complexity: Access front element - O(1), Insertion - O(1), Deletion - O(1)");
    	    Label spaceComplexityLabel = new Label("Space Complexity: O(n)");
    	    VBox root1 = new VBox(10, titleLabel, definitionLabel, timeComplexityLabel, spaceComplexityLabel);
    	    root1.setPadding(new Insets(10));
    	    root1.setAlignment(Pos.TOP_CENTER);
    	    TextField valueField = new TextField();

    	    HBox controls1 = new HBox(10, new Label("Value:"), valueField, addButton);
    	    controls1.setAlignment(Pos.CENTER);
    	    HBox controls2 = new HBox(10, removeButton, peekButton);
    	    controls2.setAlignment(Pos.CENTER);

    	    VBox controlPanel = new VBox(10, controls1, controls2);
    	    controlPanel.setPadding(new Insets(10,20,20,20));
    	    controlPanel.setAlignment(Pos.CENTER);

    	    ScrollPane canvasScrollPane = new ScrollPane();
    	    canvasScrollPane.setContent(canvas);
    	   

    	    BorderPane root = new BorderPane();
    	    root.setTop(root1);
    	    root.setCenter(canvasScrollPane);
    	    root.setBottom(controlPanel);
    	    
 
    	    addButton.setOnAction(e -> {
    	        try {
    	            int value = Integer.parseInt(valueField.getText());
    	            queue.push(value);
    	            controller.drawQueue(canvas, queue.getQueue());
    	            valueField.clear();
    	        } 
    	        catch (NumberFormatException ex) {
    	            showAlert("Invalid Input", "Please enter a valid integer.");
    	        }
    	    });

    	    removeButton.setOnAction(e -> {
    	        try {
    	            queue.remove();
    	            controller.drawQueue(canvas, queue.getQueue());
    	        } 
    	        catch (IllegalStateException ex) {
    	            showAlert("Queue Underflow", "No elements to remove.");
    	        }
    	    });

    	    peekButton.setOnAction(e -> {
    	        try {
    	            int val = queue.peek();
    	            showAlert("Front Value", "Front value is: " + val);
    	        } 
    	        catch (IllegalStateException ex) {
    	            showAlert("Queue Underflow", "No elements in the queue.");
    	        }
    	    });

    	    root.setStyle("-fx-background: radial-gradient(center 50% 50%, radius 50%, purple, blue);");
    	    Scene scene = new Scene(root, 800, 600);
    	    scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
    	    primaryStage.setScene(scene);
    	    primaryStage.setTitle("Queue Visualizer");
    	    primaryStage.setResizable(false);
    	    primaryStage.show();
    	}



    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
