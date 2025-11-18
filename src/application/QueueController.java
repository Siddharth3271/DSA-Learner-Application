package application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.Iterator;
import java.util.Queue;

public class QueueController {
	
	private final int boxWidth = 60;
	private final int boxHeight = 60;
	private final double spacing = 10;
    private final double padding = 50;
    private final double pointerAreaWidth=80;  //for front and rear pointer space
    
    public void drawQueue(Canvas canvas, Queue<Integer> queue) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        int queueSize=(queue!=null)?queue.size():0;
        
        double totalWidth=(padding*2)+(pointerAreaWidth*2)+(queueSize*boxWidth)+(queueSize-1)*spacing;
        
        if(queue.size()==0) {
        		totalWidth=400;
        }
        
        double totalHeight=(padding*2)+boxHeight+(pointerAreaWidth);
        canvas.setWidth(totalWidth);
        canvas.setHeight(totalHeight);
        
        gc.setFill(Color.web("#000000"));
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gc.setTextAlign(TextAlignment.CENTER);
        
        if (queue == null || queue.isEmpty()) {
            gc.setFill(Color.WHITE);
            gc.fillText("Queue is empty", totalWidth / 2, totalHeight / 2);
            return;
        }
        
        double startX = padding + pointerAreaWidth;
        double y = padding + pointerAreaWidth;  //leave space for front pointer
        
        int i = 0;
        Integer lastElement = null;
        
        //iterator to find the last element for the "Rear" pointer
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()) {
            lastElement = iterator.next();
        }

        for (int value : queue) {
        	
        		double x = startX + i * (boxWidth + spacing);
            gc.setFill(Color.OLIVE);
            gc.fillRect(x, y, boxWidth, boxHeight);

            gc.setStroke(Color.BLACK);
            gc.strokeRect(x, y, boxWidth, boxHeight);

            gc.setFill(Color.LIGHTGREEN);
            gc.fillText(String.valueOf(value), x + 20, y + 35);

            //Front pointer for the first element
            if(i == 0) {
                gc.setFill(Color.WHITE);
                gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                gc.fillText("Front", x + boxWidth / 2, y - 25); // Above the box
                drawArrow(gc, x + boxWidth / 2, y - 18, x + boxWidth / 2, y);
            }
            
            //Rear pointer for the last element
            if (value == lastElement && i == queueSize - 1){
                 gc.setFill(Color.WHITE);
                 gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                 gc.fillText("Rear", x + boxWidth / 2, y + boxHeight + 35); // Below the box
                 drawArrow(gc, x + boxWidth / 2, y + boxHeight + 20, x + boxWidth / 2, y + boxHeight);
            }
            
            i++;
        }
        
    }
    
    private void drawArrow(GraphicsContext gc, double x1, double y1, double x2, double y2) {
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(2);
        gc.strokeLine(x1, y1, x2, y2);

        double angle = Math.atan2(y2 - y1, x2 - x1);
        double arrowLength = 12;
        double arrowAngle = Math.toRadians(25);

        double xArrow1 = x2 - arrowLength * Math.cos(angle - arrowAngle);
        double yArrow1 = y2 - arrowLength * Math.sin(angle - arrowAngle);

        double xArrow2 = x2 - arrowLength * Math.cos(angle + arrowAngle);
        double yArrow2 = y2 - arrowLength * Math.sin(angle + arrowAngle);

        gc.strokeLine(x2, y2, xArrow1, yArrow1);
        gc.strokeLine(x2, y2, xArrow2, yArrow2);
    }

}
