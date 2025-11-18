package application;
public class LinkedList1{
    private Node head;

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        head = head.next;
    }

    public int viewHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty.");
        }
        return head.value;
    }
    public int checksize() {
    	if(head==null) {
    		return 0;
    	}
    	int size=0;
    	Node curr=head;
    	while(curr!=null) {
    		curr=curr.next;
    		size++;
    	}
    	return size;
    }
    public boolean updateData(int pos,int newdata) {
    	if (head == null) {
            return false;
        }
    	int size=checksize();
    	if (pos < 0 || pos >= size) { 
            return false; 
        }
    	Node current=head;
    	for (int i = 0; i < pos; i++) { 
            current = current.next;
        }
        current.value = newdata;
        return true;
    }

    public int[] getNodes() {
        int size = checksize();
        int[] values = new int[size];
        Node current = head;
        int index = 0;
        while (current != null) {
            values[index++] = current.value;
            current = current.next;
        }
        return values;
    }
    
    public Node getHead() {
        return head;
    }
}