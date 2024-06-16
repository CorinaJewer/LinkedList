/**
 * Undo/Redo Functionality: In applications that support undo/redo functionality, a doubly linked list can be used to maintain a sequence of states. Each state change is stored as a node in the list, allowing easy navigation between previous and next states, enabling undoing and redoing of actions.
/**/

public class UndoRedoManager<T> {

    // Private inner class that represents the current state or snapshot of an object.
    private class Node{

        private T state;
        private Node next;
        private Node prev;
    
        private Node (T state){
            this.state = state;
        }
    }

    private Node currentState = null;

    public T undo(){
        if (currentState == null) {
            System.out.println("No state to undo.");
            return null;
        }
        //Get the previous state
        Node previousState = currentState.prev;
        if (previousState == null) {
             System.out.println("Reached the initial state.");
             return null;
        }else{ //Move current state pointer back in history
            currentState = previousState;  
        }
        return currentState.state; 
    }     

    public T redo(){
        if (currentState == null){
            System.out.println("No state to redo.");
            return null;
        }
        //Get the next state
        Node nextState = currentState.next;
        if (nextState == null){
            System.out.println("Already at most recent state.");
            return null;
        }else{ // Move current state pointer ahead in history
            currentState = currentState.next;
            currentState = nextState;
        }
        return currentState.state;
    }

    public void performAction (T newState){
        //create a new node for the new task
        Node newNode = new Node(newState);

        //Set the pointers for the new node
        newNode.prev = currentState;
        newNode.next = null;

        //Set newNode to end of list
        if(currentState !=null){
            currentState.next = newNode;
        }
        //NewNode is now current state and last node in list
        currentState = newNode;        
    }
  
    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.performAction("State 1");
        undoRedoManager.performAction("State 2");
        undoRedoManager.performAction("State 3");
        undoRedoManager.performAction("State 4");
        undoRedoManager.performAction("State 5");

        System.out.println();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
        undoRedoManager.redo();
        System.out.println("Current State: " + undoRedoManager.currentState.state);
    }
}