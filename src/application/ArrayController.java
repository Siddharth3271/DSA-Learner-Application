package application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class ArrayController {
    public void drawArray(Canvas canvas, int[] array,int currSize) {
  
    		if(array==null) {
    			canvas.setWidth(0);
    			canvas.setHeight(0);
    			return;
    		}
    	
    		GraphicsContext gc = canvas.getGraphicsContext2D();
      
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        int boxWidth = 50;
        int boxHeight = 50;
        int spacing=10;
        int startX = 20;
        int startY = 20;
        int indexLabelHeight=30;
        
        //calculating total size needed
        double totalWidth=startX+(array.length*(boxWidth+spacing))+startX-spacing;
        double totalHeight=startY+boxHeight+indexLabelHeight+startY;
        
        canvas.setWidth(totalWidth);
        canvas.setHeight(totalHeight);
        gc.setFill(Color.web("#2c003e"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        for (int i = 0; i < currSize; i++) {
            double currentX=startX+i*(boxWidth+spacing);
            
            if(i<currSize) {
            	    gc.setFill(Color.YELLOW);
                gc.fillRect(currentX, startY, boxWidth, boxHeight);

                gc.setStroke(Color.BLACK);
                gc.strokeRect(currentX, startY, boxWidth, boxHeight);
                gc.setFill(Color.DARKRED);
                String value=String.valueOf(array[i]);
                
                //center the text in box
                gc.setTextAlign(TextAlignment.CENTER);
                gc.fillText(value, currentX+boxWidth/2, startY + 32);
            }
            else {
            		gc.setFill(Color.LIGHTGRAY);
                gc.fillRect(currentX, startY, boxWidth, boxHeight);
                gc.setStroke(Color.DARKGRAY);
                gc.strokeRect(currentX, startY, boxWidth, boxHeight);
            }
            
            //index label
            gc.setFill(Color.WHITE); // Set color for index text
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
            gc.fillText(String.valueOf(i), currentX + boxWidth / 2, startY + boxHeight + 20);
        }
    }
}
