package application;

import java.util.Stack;

public class Stack1 {
    private Stack<Integer> stack;

    public Stack1() {
        stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack.pop();
    }
    public int peek() {
    	if(stack.isEmpty()) {
    		throw new IllegalStateException("Stack is empty");
    	}
    	return stack.peek();
    }

    public Stack<Integer> getStack() {
        return stack;
    }
}
