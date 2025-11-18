package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.Stack;

public class StackController {
	private final double blockWidth = 80; 
    private final double blockHeight = 50;
    private final double padding=50;
    public void drawStack(Canvas canvas, Stack<Integer> stack) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        int stackSize=(stack!=null)?stack.size():0;
        
        double totalHeight=(stackSize*blockHeight)+(padding*2)+20;
        double totalWidth=blockWidth+(padding*2)+80;  //80 for top pointer
        
        canvas.setWidth(totalWidth);
        canvas.setHeight(totalHeight);
        
//        gc.setFill(Color.BLACK);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.web("#1e1e2f"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        double startX = padding+80; 
        double baseY = totalHeight - padding;

        //base of stack
        gc.setStroke(Color.WHITE);
        gc.setLineWidth(3);
        gc.strokeLine(startX - 20, baseY, startX + blockWidth + 20, baseY);
        
        if(stack==null) {
        		return;
        }
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gc.setTextAlign(TextAlignment.CENTER);
        
        int index = 0;
        for (Integer value : stack) {
                double yPos = (baseY-blockHeight) - (index*blockHeight);
                
                //draw the block
                gc.setFill(Color.ANTIQUEWHITE); 
                gc.fillRect(startX, yPos, blockWidth, blockHeight);
                gc.setStroke(Color.BLACK);
                gc.strokeRect(startX, yPos, blockWidth, blockHeight);

                //value
                gc.setFill(Color.BROWN);
                gc.fillText(String.valueOf(value), startX + blockWidth / 4, yPos + blockHeight / 2 + 8);

                if(index==stackSize-1) {
                		gc.setFill(Color.WHITE);
                		gc.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                		gc.fillText("Top ->", startX-45, yPos+blockHeight/2+8);
                }
                index++;
        }
    }
}
