package application;
import java.util.LinkedList;
import java.util.Queue;
public class Queue1 {
	private Queue<Integer> qu = new LinkedList<>();
	
	public Queue1() {
        qu = new LinkedList<>();
    }
	public void push(int value) {
		qu.add(value);
	}
	
	public int peek() {
		if(qu.isEmpty()) {
			throw new IllegalStateException("Queue is Empty!");
		}
		return qu.peek();
	}
	
	public int remove() {
		if(qu.isEmpty()) {
			throw new IllegalStateException("Queue is Empty!");
		}
		return qu.remove();
	}
	
	public Queue<Integer> getQueue() {
        return qu;
    }
	
}
