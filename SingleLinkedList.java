import java.util.ArrayList;
import java.util.List;

public class SingleLinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    // Create LinkedList

    public Node createLinkedList(int nodeValue){
        Node node = new Node(nodeValue);
        this.head = node;
        this.tail = node;
        this.size = 1;
        return head;
    }
    
    // Add a new node at a particular index in a LinkedList

    // 1. Handle if List is empty
    // 2. Handle inserting at beginning
    // 3. Handle inserting at end
    // 4. Handle inserting elsewhere

    public void AddNodeWithLocation(int nodevalue, int location){
        Node node = new Node(nodevalue);
        if (head == null){ // No List
            createLinkedList(nodevalue); 
        }else if (location == 0){ // Add head Node
           node.setNext(head);
           head = node;
        }else if (location >= size){ // Add tail Node
            tail.setNext(node);
            tail = node;
        }else{  // Add middle node
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();
            }
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);           
        }
        size++;
    }

    // Delete a node at a particular index in a LinkedList

    // 1. Handle if List is empty
    // 2. Handle deletion of the head node
    // 3. Handle deletion of the tail node
    // 4. Handle deletion of a middle node

    public void deleteNodeWithLocation(int location){
        if (head == null){
            System.out.println("A Single LinkedList does not exist.");
        }else if (location == 0){ //Delete head node
            head = head.getNext();
            if (head == null) { 
                tail = null;
            }
        }else if (location >= size - 1){ // Delete tail node
            Node tempNode = head;
            while(tempNode.getNext() != tail){
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(null);
            tail = tempNode;            
        }else { // Delete a middle node
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(tempNode.getNext().getNext()); // bypassing node
        }
        size--;
    }

    public boolean searchNode (int nodeValue){
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.getValue() == nodeValue){
                    System.out.println("Found the node: " + tempNode.getValue() + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.println("A Single LinkedList does not exist.");
        return false;
    }

    public List<Integer> searchNodeList(int nodeValue) {
        List<Integer> locations = new ArrayList<>();
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.getValue() == nodeValue) {
                    System.out.println("Found the node value: " + tempNode.getValue() + " at location: " + i);
                    locations.add(i);                
                }                
                tempNode = tempNode.getNext();
            }
        }else {
            System.out.println("A Single LinkedList does not exist.");
        }
        return locations;
    }

    public void traverseLinkedList(){
        if (head == null){
            System.out.println("Single LinkedList does not exist.");
        }else{
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if (i != size - 1){
                    System.out.print(" -> ");
                }
            tempNode = tempNode.getNext();
            }           
        }
        System.out.print("\n");
    }

    @Override
    public String toString() {
        if (head == null) {
            return "null";
        }

        String result = "";
        Node current = head;
        while (current != null) {
            result += current.getValue() + " -> ";
            current = current.getNext();
        }
        return result;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.createLinkedList(4);
        System.out.println(list);
      
        list.AddNodeWithLocation(1,0);
        System.out.println(list);
        list.AddNodeWithLocation(2,1);
        System.out.println(list);
        list.AddNodeWithLocation(3,0);
        System.out.println(list);
        list.AddNodeWithLocation(4,2);
        System.out.println(list);

        list.searchNode(4);
        list.searchNodeList(4);
        
        list.traverseLinkedList(); 
        list.deleteNodeWithLocation(0);
        list.traverseLinkedList();
        list.deleteNodeWithLocation(4);
        list.traverseLinkedList();
        list.deleteNodeWithLocation(1);
        list.traverseLinkedList();        
    }
}

