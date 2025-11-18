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

public class StackWindow {
    private Stack1 st = new Stack1(); 
    private StackController controller = new StackController(); 
    private Canvas canvas = new Canvas(); 

    public void show(Stage primaryStage) {

        Button pushButton = new Button("Push");
        Button popButton = new Button("Pop");
        Button peekButton = new Button("Peek");
        TextField valueField = new TextField();
        
        Label titleLabel = new Label("Stack Visualizer");
	    Label definitionLabel = new Label("Definition: A data structure which follows the principle of last in first out");
	    Label timeComplexityLabel = new Label("T.C.: Access top element - O(1), Insertion - O(1), Deletion - O(1)");
	    Label spaceComplexityLabel = new Label("S.C.: O(n)");
	    
	    VBox root1 = new VBox(4, titleLabel, definitionLabel, timeComplexityLabel, spaceComplexityLabel);
	    root1.setPadding(new Insets(10));
	    root1.setAlignment(Pos.TOP_CENTER);
        
        HBox controls1 = new HBox(10, new Label("Value:"), valueField, pushButton);
        controls1.setAlignment(Pos.CENTER_LEFT);
        HBox controls2 = new HBox(10, popButton, peekButton);
        controls2.setAlignment(Pos.CENTER_LEFT);
        
        
        VBox controlPanel = new VBox(10, controls1,controls2);
        controlPanel.setPadding(new Insets(20));
        controlPanel.setAlignment(Pos.CENTER);
        
        ScrollPane canvasScrollPane = new ScrollPane();
        canvasScrollPane.setContent(canvas);
        
        BorderPane root = new BorderPane();
        root.setTop(root1);
        root.setCenter(canvasScrollPane);
        root.setBottom(controlPanel);
     
        pushButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(valueField.getText());
                st.push(value);
                controller.drawStack(canvas, st.getStack());
                valueField.clear();
            } 
            catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid integer.");
            }
        });

        popButton.setOnAction(e -> {
            try {
                st.pop();
                controller.drawStack(canvas, st.getStack());
            } 
            catch (IllegalStateException ex) {
                showAlert("Stack Underflow", "No elements to pop.");
            }
        });

        peekButton.setOnAction(e -> {
            if (st == null) {
                showAlert("Stack Not Initialized", "Please perform some operations first.");
                return;
            }
            try {
                int val = st.peek();
                showAlert("Top Value", "Top value is: " + val);
            } 
            catch (IllegalStateException ex) {
                showAlert("Stack Underflow", "No elements in the stack.");
            }
        });

        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stack Visualizer");
        primaryStage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
        primaryStage.show();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
