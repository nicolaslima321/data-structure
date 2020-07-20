import java.util.*;

class QueueTwoStacks {

    Stack<Integer> firstStack = new Stack<Integer>();
    Stack<Integer> secondtStack = new Stack<Integer>();

    public void enqueue(Integer element) {
        System.out.println("Enfileirando " + element);
        while (firstStack.size() > 0) {
            secondtStack.push(firstStack.pop());
        }
            firstStack.push(element);

        while (secondtStack.size() > 0)  {
            firstStack.push(secondtStack.pop());
        }
    }

    public int dequeue() {
        if (firstStack.size() == 0) {
            System.out.println("Fila vazia");
        }
        int element = firstStack.peek();
        
        System.out.println("Denfileirando " + element);

        firstStack.pop();

        return element;
    }

    public static void main(String args[]) {
        QueueTwoStacks classInstance = new QueueTwoStacks();
        classInstance.enqueue(1);
        classInstance.enqueue(75);
        classInstance.enqueue(10);
    }
}