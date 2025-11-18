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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ArrayWindow{
	private Array1 array = null;
    private ArrayController controller = new ArrayController();
    private Canvas canvas = new Canvas();
    public void show(Stage primaryStage) {
        BorderPane root = new BorderPane();
//        root.setBottom(canvas);
        Label titleLabel = new Label("Array Visualizer");
        Label definitionLabel = new Label("Definition: An array is a collection of items stored at contiguous memory locations.");
        Label timeComplexityLabel = new Label("Time Complexity: Access - O(1), Insertion - O(n), Deletion - O(n)");
        Label spaceComplexityLabel = new Label("Space Complexity: O(n)");
        VBox root1 = new VBox(10, titleLabel, definitionLabel, timeComplexityLabel, spaceComplexityLabel);
        root1.setPadding(new Insets(20));
        root1.setAlignment(Pos.TOP_CENTER);
        root.setTop(root1);
        
        
        Label sizeLabel = new Label("Enter array size:");
        sizeLabel.setFont(new Font(20));
        TextField sizeField = new TextField();
        sizeField.setPrefSize(150, 20);
        Button setSizeButton = new Button("Set Size");
        setSizeButton.setPrefSize(120, 20);
        HBox sizeControls = new HBox(10, sizeLabel, sizeField, setSizeButton);
        sizeControls.setAlignment(Pos.CENTER);
        
        
        Label insertLabel = new Label("Value to insert:");
        insertLabel.setFont(new Font(20));
        TextField valueField = new TextField();
        valueField.setPrefSize(150, 20);
        Button insertButton = new Button("Insert");
        insertButton.setPrefSize(100, 20);
        HBox insertControls = new HBox(10, insertLabel, valueField, insertButton);
        insertControls.setAlignment(Pos.CENTER);
        
        
        Label deleteLabel = new Label("Index to delete:");
        TextField deleteField = new TextField();
        deleteLabel.setFont(new Font(20));
        deleteField.setPrefSize(150, 20);
        Button deleteButton = new Button("Delete");
        deleteButton.setPrefSize(100, 20);
        HBox deleteControls = new HBox(10, deleteLabel, deleteField, deleteButton);
        deleteControls.setAlignment(Pos.CENTER);
        
        Label replaceLabel1 = new Label("Index to replace:");
        Label replaceLabel2 = new Label("Value to replace:");
        replaceLabel1.setFont(new Font(20));
        replaceLabel2.setFont(new Font(20));
        TextField replaceField1 = new TextField();
        TextField replaceField2 = new TextField();
        replaceField1.setPrefSize(150, 20);
        replaceField2.setPrefSize(150, 20);
        Button replaceButton = new Button("Replace");
        replaceButton.setPrefSize(100, 20);
        HBox replaceControls1 = new HBox(10, replaceLabel1, replaceField1);
        HBox replaceControls2 = new HBox(10, replaceLabel2, replaceField2, replaceButton);
        replaceControls1.setAlignment(Pos.CENTER);
        replaceControls2.setAlignment(Pos.CENTER);
       
        VBox controlPanel = new VBox(10,sizeControls, insertControls,deleteControls,replaceControls1,replaceControls2);
        controlPanel.setPadding(new Insets(10));
        controlPanel.setAlignment(Pos.TOP_CENTER);
        
        //putting the controls at the bottom of the window
        root.setBottom(controlPanel);
        controlPanel.setPadding(new Insets(10, 20, 20, 20));

        ScrollPane canvasScrollPane = new ScrollPane();
	    canvasScrollPane.setContent(canvas);
	    
//	    canvasScrollPane.setFitToWidth(true);
//	    canvasScrollPane.setFitToHeight(true);
//	    canvas.widthProperty().bind(canvasScrollPane.widthProperty());
//	    canvas.heightProperty().bind(canvasScrollPane.heightProperty());

        setSizeButton.setOnAction(e -> {
            try {
                int size = Integer.parseInt(sizeField.getText());
                array = new Array1(size);
                controller.drawArray(canvas, array.getArray(),array.getCurrentSize());
                showAlert1("Message","Array is setted to have "+size+" blocks");
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid number for the array size.");
            }
        });

        insertButton.setOnAction(e -> {
            if (array == null) {
                showAlert("Array Not Initialized", "Please set the array size first.");
                return;
            }
            try {
                int value = Integer.parseInt(valueField.getText());
                if (!array.insert1(value)) {
                    showAlert("Segmentation Fault", "Cannot insert. Array size exceeded.");
                }
                controller.drawArray(canvas, array.getArray(),array.getCurrentSize());
            } 
            catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid number to insert.");
            }
        });

        deleteButton.setOnAction(e -> {
            if (array == null) {
                showAlert("Array Not Initialized", "Please set the array size first.");
                return;
            }
            try {
                int index = Integer.parseInt(deleteField.getText());
                if (!array.delete1(index)) {
                    showAlert("Invalid Operation", "Index out of bounds.");
                }
                controller.drawArray(canvas, array.getArray(),array.getCurrentSize());
            } 
            catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid index to delete.");
            }
        });
        
        replaceButton.setOnAction(e -> {
            if (array == null) {
                showAlert("Array Not Initialized", "Please set the array size first.");
                return;
            }
            try {
            	int index=Integer.parseInt(replaceField1.getText());
                int value = Integer.parseInt(replaceField2.getText());
                if (!array.replace1(index,value)) {
                    showAlert("Invalid index!","Please enter valid index");
                }
                controller.drawArray(canvas, array.getArray(),array.getCurrentSize());
            } 
            catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Please enter a valid number to insert.");
            }
        });
      
        //put the canvas (inside its scroll pane) in the center
        root.setCenter(canvasScrollPane);
        Scene scene = new Scene(root, 700, 700);
        scene.getStylesheets().add(getClass().getResource("application1.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Array Visualizer");
        primaryStage.show();
        primaryStage.setResizable(false);
//        canvasScrollPane.setStyle("-fx-background: radial-gradient(center 50% 50%, radius 50%, purple, blue);");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    private void showAlert1(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
