
import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringStackImpl<T> implements StringStack<T> {

    private Node<T> head = null;
    int count = 0;

   // @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T item) {
        this.head = new Node<T>(item, head);
        this.count++;
    }

    //@Override
    public T pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T S = this.head.getItem();
            if (this.head.getNextNode() == null) {
                this.head = null;
            } else {
                Node<T> T = this.head.getNextNode();
                this.head = T;
            }
            count--;
            return S;
        }
    }

    //@Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T S = this.head.getItem();
            return S;
        }
    }

   // @Override
    public void printStack(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("The stack is Empty.");
        } else {
            Node<T> currentNode = this.head;
            while (currentNode != null) {
                System.out.println(currentNode.getItem());
                currentNode = currentNode.getNextNode();
            }
        }
    }

    //@Override
    public int size() {
        if (isEmpty()) {
            this.count = 0;
        }
        return this.count;
    }


}
