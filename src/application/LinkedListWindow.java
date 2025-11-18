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

public class LinkedListWindow {
    private LinkedList1 list = new LinkedList1(); 
    private LinkedListController controller = new LinkedListController();
    private Canvas canvas = new Canvas(); 

    public void show(Stage primaryStage) {
        Button addButton = new Button("Add");
        Button removeButton = new Button("Remove from front");
        Button headButton = new Button("View Head");
        Button updateButton = new Button("Update Value");
        TextField valueField1 = new TextField();
        TextField valueField2 = new TextField();
        TextField valueField3 = new TextField();
        Label titleLabel = new Label("Linked List Visualizer");
        Label definitionLabel = new Label("Definition: A Linked List is a Data structure that is not stored in contiguous memory locations");
        Label timeComplexityLabel = new Label("Time Complexity: Access element - O(n), Insertion - O(1), Deletion - O(n)");
        Label spaceComplexityLabel = new Label("Space Complexity: O(n)");

   
        VBox root1 = new VBox(5, titleLabel, definitionLabel, timeComplexityLabel, spaceComplexityLabel);
        root1.setPadding(new Insets(5));
        root1.setAlignment(Pos.TOP_CENTER);

        HBox controls1 = new HBox(5, new Label("Value:"), valueField1, addButton);
        controls1.setAlignment(Pos.CENTER);

        HBox controls2 = new HBox(5, removeButton, headButton);
        controls2.setAlignment(Pos.CENTER);

        HBox controls3 = new HBox(5, new Label("Enter Position"), valueField2, new Label("Enter new Value"), valueField3, updateButton);
        controls3.setAlignment(Pos.CENTER);

        VBox controlPanel = new VBox(5, controls1, controls2, controls3);
        controlPanel.setPadding(new Insets(1)); 
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.setPadding(new Insets(0, 0, 40, 0));

        ScrollPane canvaScrollPane = new ScrollPane();
        canvaScrollPane.setContent(canvas);
        
        BorderPane root=new BorderPane();
        root.setTop(root1);
        root.setCenter(canvaScrollPane);
        root.setBottom(controlPanel);

        addButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(valueField1.getText());
                list.add(value);
                controller.drawLinkedList(canvas, list.getHead());
                valueField1.clear();
            } 
            catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid integer.");
            }
        });

        removeButton.setOnAction(e -> {
            try {
                list.remove();
                controller.drawLinkedList(canvas, list.getHead());
            } 
            catch (IllegalStateException ex) {
                showAlert("List Underflow", "No elements to remove.");
            }
        });

        headButton.setOnAction(e -> {
            try {
                int headValue = list.viewHead();
                showAlert("Head Node", "Head value is: " + headValue);
            } 
            catch (IllegalStateException ex) {
                showAlert("Empty List", "No elements in the list.");
            }
        });

        updateButton.setOnAction(e -> {
            try {
                int position = Integer.parseInt(valueField2.getText());
                int newValue = Integer.parseInt(valueField3.getText());
                if (!list.updateData(position, newValue)) {
                    showAlert("Invalid Position", "Please enter a valid position.");
                }
                controller.drawLinkedList(canvas, list.getHead());
            } 
            catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter valid numbers.");
            }
        });

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("LinkedList Visualizer");
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
