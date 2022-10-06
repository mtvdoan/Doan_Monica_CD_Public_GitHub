package singly_linked_list;

public class SinglyLinkedList {
	//first node is 'head node'
    public Node head;
    public Node tail;
    public SinglyLinkedList() {
        // your code here
    	head = null;

    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
    	//this creates a new node called 'newNode'
    	//'newNode' will have whatever you are passing.  In this case you are passing int value.
        Node newNode = new Node(value);
        //You need to check when this is your first node
        if(head == null) {
            head = newNode;
        } else {
        	//what if it's not your first object? Not your first node?
            Node runner = head;
            
            //this checks the last element
            //this will travel until a null
            while(runner.next != null) {
            	//it's not null it will go to next
            	//jumps to next node and will stop when null at the end
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
    
   public Integer remove() {
        Node runner = head;
        int valToReturn;
        
        //check if the list is empty or not.
        if(head == null) {
        	//if empty...
        	return null;	
        } 
        
        //if the next value after the one before is 'empty' then valToReturn will hold that first value (head.value)
        if(head.next == null) {
            valToReturn = head.value;
            head = null;
            return valToReturn;
        }
        
        while(runner.next.next != null) {
            runner = runner.next;
        }
        
        valToReturn = runner.next.value;
        runner.next = null;
        return valToReturn;
   } 
    
   
    public void printValues() {
    	Node runner = head;
    	//need to travel between all nodes
    	while(runner.next != null) {
    		System.out.println(runner.value);
    		runner = runner.next;
    		
    	}
    	//need to do this because it won't print the last value when it's null.  so this needs to be written
    	System.out.println(runner.value);
    }
}
