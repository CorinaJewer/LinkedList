public class Node{

    private int value;
    private Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }
}

// Represents an individual element in a LinkedList. It contains 2 fields, the value which is an integer that stores the data of the node & next which is a reference to the next node in the LinkedList. If the node is the last node, next will be null.