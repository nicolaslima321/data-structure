public class Node {
	public Node next;
	public Node previous;
	public Object item;
	
	Node(Object item) {
		this.item = item;
		this.next = null;
		this.previous = null;
	}

	Node(Object item, Node previous, Node next) {
		this.item = item;
		this.next = next;
		this.previous = previous;
	}

	Node(Object item, Node next) {
		this.item = item;
		this.next = next;
		this.previous = null;
	}
	
	public Node getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
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
