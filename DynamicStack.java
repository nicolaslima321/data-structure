public class DynamicStack {
	
	private Node latest = null;
	private int length = 0;
	
	public Node peek() {
		System.out.println("Ultimo elemento: " + this.latest);
		return this.latest;
	}
	
	public void push(Object item) {
		Node node = new Node(item);
		
		if(this.isEmpty()){
			this.latest = node;
	        this.length++;
        }
	    else{
	        node.setNext(this.latest);
            this.latest = node;
	        this.length++;
        }
	}
	
	public Node pop() {
		if(this.isEmpty()){
			System.out.println("Nao e possivel remover a ultima posicao se a pilha estiver vazia");
			return null;
        }
	    else{
	    	Node temp = this.latest; 
	    	this.latest = this.latest.getNext();
            this.length--;
            System.out.println("Removendo " + temp);
            return temp;
        }
	}
	
	public int size() {
		return this.length;
	}
	
	public boolean isEmpty() {
		return (this.length == 0);
	}
	
	public static void main(String[] args) {
		DynamicStack dynamicStack = new DynamicStack();
		
		System.out.println("Empilhando 1");
		dynamicStack.push(1);
		System.out.println("Empilhando 60");
		dynamicStack.push(60);
		System.out.println("Empilhando 22");
		dynamicStack.push(22);
		System.out.println("Empilhando 52");
		dynamicStack.push(52);
		dynamicStack.pop();
	}

}
