public class Node {
	public Node next;
	public Object item;
	
	Node(Object item) {
		this.item = item;
		this.next = null;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Object getItem() {
		return item;
	}
	
	public void setItem(Object item) {
		this.item = item;
	}
}
