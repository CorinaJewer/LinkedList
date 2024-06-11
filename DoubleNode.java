public class DoubleNode {
    
    private int value;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public DoubleNode getNext(){
        return next;
    }

    public void setNext(DoubleNode next){
        this.next = next;
    }

    public DoubleNode getPrev(){
        return prev;
    }

    public void setPrev(DoubleNode prev){
        this.prev = prev;
    }

}


// Represents an individual element in a Double LinkedList. It contains 3 fields, the value which is an integer that stores the data of the node & next which is a reference to the next node in the LinkedList & prev which is a reference to the prev node in the LinkedList. If the node is the 1st node, prev will be null. If the node is the last node, next will be null.