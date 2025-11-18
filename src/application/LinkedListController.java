package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class LinkedListController {
	
	private final int boxWidth=60;
	private final int boxHeight=40;
	private final int arrowLength=30;
	private final int padding=50;
	
    public void drawLinkedList(Canvas canvas, LinkedList1.Node head) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //get total no. of nodes
        int nodeCount=0;
        LinkedList1.Node temp=head;
        while(temp != null){
            nodeCount++;
            temp=temp.next;
        }
        
        //calculate total size needed(head, all nodes, arrows,null)
        double totalWidth=padding+60+ // "Head" text
                (nodeCount*(boxWidth+arrowLength)) + // All nodes and arrows
                60+ // "null" text
                padding;
        double totalHeight=padding+boxHeight+padding;
        
        canvas.setWidth(totalWidth);
        canvas.setHeight(totalHeight);
        
        gc.setFill(Color.web("#1e1e2f"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gc.setTextAlign(TextAlignment.CENTER);

        //setting drawing position
        int x=padding;
        int y=padding;
        
        // Draw "Head" pointer
        gc.setFill(Color.WHITE);
        gc.fillText("Head", x + 20, y + (boxHeight / 2) + 8);
        drawArrow(gc, x + 50, y + boxHeight / 2, x + 80, y + boxHeight / 2);
        x += 80; // Move x past "Head" and its arrow
        
        LinkedList1.Node current = head;

        while (current != null) {
        	
        		//draw the box
        		gc.setFill(Color.LIGHTBLUE);
            gc.fillRect(x, y, boxWidth, boxHeight);
            gc.setStroke(Color.BLACK);
            gc.strokeRect(x, y, boxWidth, boxHeight);

            gc.setFill(Color.BLACK);
            gc.fillText(String.valueOf(current.value), x + (boxWidth/2), y + 28);

            if (current.next != null) {
                drawArrow(gc, x+boxWidth, y+boxHeight/2, x+boxWidth+arrowLength, y +boxHeight/2);
            }
            x += boxWidth + arrowLength;
            current = current.next;
        }
    }
    private void drawArrow(GraphicsContext gc,double x1,double y1,double x2,double y2) {
    		gc.setStroke(Color.YELLOW);
        gc.setLineWidth(2);
        gc.strokeLine(x1, y1, x2, y2); // Arrow shaft
        
        // Arrowhead
        gc.strokeLine(x2 - 10, y2 - 10, x2, y2);
        gc.strokeLine(x2 - 10, y2 + 10, x2, y2);
    }
}

