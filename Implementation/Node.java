

public class Node<T> {

    public Node<T> next;
    private T Item;
    private T NextItem;
    private Node<T> nextNode = null;

    public Node(T Item) {

        this.Item = Item;
    }

    public Node(T Item, Node<T> nextNode){
        this.Item = Item;
        this.nextNode = nextNode;
    }

    public void setItem(T Item){

        this.Item=Item;
    }

    public T getItem()
    {
        // return Item stored in this node
        return Item;
    }
    public T getNextItem(){
        return NextItem;
    }

    public Node<T> getNextNode() {
        // get next node
        return this.nextNode;
    }

    public Node<T> setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
        return this.nextNode;
    }

}