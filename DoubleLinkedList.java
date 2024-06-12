public class DoubleLinkedList {
    
   private DoubleNode head;
   private DoubleNode tail;
   private int size;

   public DoubleNode createDoubleLinkedList(int nodeValue){
        DoubleNode doubleNode = new DoubleNode(nodeValue);
        this.head = doubleNode;
        this.tail = doubleNode;
        this.size = 1;
        return head;
    }
    // Add a DoubleNode at a particular index in a Double LinkedList
   public void addDoubleNodeWithLocation(int nodeValue, int location){
        DoubleNode newNode = new DoubleNode(nodeValue);
        if (head == null){
           createDoubleLinkedList(nodeValue);
           return;
        }else if(location == 0){ 
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }else if(location >= size){
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }else{
            DoubleNode tempNode = head;
            int index = 0;
            while (index < location - 1){
                tempNode = tempNode.getNext();
                index++;
            }
            newNode.setNext(tempNode.getNext());
            newNode.setPrev(tempNode);
            tempNode.getNext().setPrev(newNode);
            tempNode.setNext(newNode);
        }
        size++;
   }

   // Traverse a Double LinkedList
   public void traverseDoubleLinkedList(){
        if (head == null) {
            System.out.println("DLL does not exist.");
        } else {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.getValue());
                if (i != size -1) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.print("\n");
    }

    // Reverse Traverse a Double LinkedList
    public void reverseTraverseDoubleLinkedList(){
        if (head == null){
            System.out.println("DLL does not exist.");
        }else{
            DoubleNode tempNode = tail;
            while(tempNode != null){
                System.out.print(tempNode.getValue());
                if (tempNode.getPrev() != null){
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.getPrev();
            }
        }
        System.out.print("\n");
    }

    // Search for the first instance of a value in a Double LinkedList
    public boolean searchDoubleNode (int nodeValue){
        if (head != null) {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.getValue() == nodeValue){
                    System.out.println("Found the node: " + tempNode.getValue() + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.getNext();
            }
        }
        System.out.println("A DLL does not exist.");
        return false;
    }

    // Delete a DoubleNode at a particular index in a LinkedList
    public void deleteDoubleNodeWithLocation(int location){
        if (head == null){
            System.out.println("DLL does not exist.");
        }else if(location == 0){ // Delete head DoubleNode
            head = head.getNext();
            if (head != null){
                head.setPrev(null);
            }else{
                tail = null;
            }
        }else if (location >= size - 1){ // Delete tail DoubleNode
            tail = tail.getPrev();
            if(tail != null){
                tail.setNext(null);
            }else{
                head = null;
            }
        }else{  // Delete a middle DoubleNode
            DoubleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext();
            }
            DoubleNode doubleNodeToDelete = tempNode.getNext();
            tempNode.setNext(doubleNodeToDelete.getNext());
            if (doubleNodeToDelete.getNext() != null){
                doubleNodeToDelete.getNext().setPrev(tempNode);
            }
        }
        size--;
    }

    // Delete a Double LinkedList
    public void deleteLinkedList() {
        DoubleNode tempNode = head;
        while (tempNode != null){
            DoubleNode nextNode = tempNode.getNext();
            tempNode.setNext(null);
            tempNode.setPrev(null);
            tempNode = nextNode;
        }
        head = null;
        tail = null;
        size = 0;
        System.out.println("The Double LinkedList has been deleted.");
    }
    
    @Override
    public String toString() {
        if (head == null) {
            return "null";
        }

        String result = "";
        DoubleNode current = head;
        while (current != null) {
            result += current.getValue() + " <-> ";
            current = current.getNext();
        }
        return result;
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        System.out.println();

        doubleLinkedList.createDoubleLinkedList(7);
        System.out.println(doubleLinkedList);

        doubleLinkedList.addDoubleNodeWithLocation(14,1);
        doubleLinkedList.addDoubleNodeWithLocation(28, 3);
        doubleLinkedList.addDoubleNodeWithLocation(21, 2);
        doubleLinkedList.traverseDoubleLinkedList();
        doubleLinkedList.reverseTraverseDoubleLinkedList();
        doubleLinkedList.searchDoubleNode(7);
        doubleLinkedList.deleteDoubleNodeWithLocation(1);
        doubleLinkedList.traverseDoubleLinkedList();
        doubleLinkedList.deleteLinkedList();
        doubleLinkedList.traverseDoubleLinkedList();
    }
}
