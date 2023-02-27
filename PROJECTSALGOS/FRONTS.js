/*
? Monica Doan
LEARN PLATFORM: Fronts
Use classes, attributes, and methods in the JavaScript language for all challenges. Use only a single JavaScript file for this assignment. All examples are done in order, starting with a new instance of the SLL class.
////////////////////////////////////////////////////////////////////////////////////////////////
Add Front
Write a method that accepts a value and create a new node, assign it to the list head, and return a pointer to the new head node.
Examples:

SLL1 = new SLL()
SLL1.addFront(18) => Node { data: 18, next: null }
SLL1.addFront(5) => Node { data: 5, next: Node { data: 18, next: null } }
SLL1.addFront(73) => Node { data: 73, next: Node { data: 5, next: Node { data: 18, next: null } } }
*/
// class SLLNode {
//     //*Singly-linked list node class
//     constructor(val) {
//         this.value = val; //holds value for this node
//         this.next = null; //pointer to next node
//     }
// }
// class SLL {
//     //*The singly linked list class itself
//     constructor() {
//         //*Will start with no nodes
//         this.head = null; //Head points to first node.  A pointer to the first node of the list.
//     }
//     //*All methods built in your class go here:  (ex. addFrontMethod)
//     addFront(value) {
//         //Need to create node containing 'value'!  This defines instance of the SLL node class, pass in a value, Then you will need to connect to the existing
//         let newNode = new SLLNode(value);

//         //*How? Change the next attribute.  'This' is referring to SLLNode class
//         newNode.next = this.head;
//         this.head = newNode; //now head is pointing to the new node.
//         return this.head; //Or you can say return this;
//     }
// }

// let SLL1 = new SLL(); //create a new SLL1 empty list
// let value = 5;
// let value2 = 10;
// SLL1.addFront(value);
// SLL1.addFront(value2);
// console.log(SLL1); //What will this print?
// //! Prints:
// SLL {
//   head: SLLNode { value: 10, next: SLLNode { value: 5, next: null } }
// }

/*
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Remove Front
Write a method to remove the head node and return the new list head node. If the list is empty, return null.


Examples:

SLL1.removeFront() => Node { data: 5, next: Node { data: 18, next: null } }
SLL1.removeFront() => Node { data: 18, next: null }
*/

// class SLLNode {
//     //*Singly-linked list node class
//     constructor(val) {
//         this.value = val; //holds value for this node
//         this.next = null; //pointer to next node
//     }
// }
// class SLL {
//     //*The singly linked list class itself
//     constructor() {
//         //*Will start with no nodes
//         this.head = null; //Head points to first node.  A pointer to the first node of the list.
//     }
//     addFront(value) {
//         //*Need to create node containing 'value'!  This defines instance of the SLL node class, pass in a value, Then you will need to connect to the existing
//         let newNode = new SLLNode(value);

//         //*How? Change the next attribute.  'This' is referring to SLLNode class
//         newNode.next = this.head;
//         this.head = newNode; //now head is pointing to the new node.
//         return this.head; //Or you can say return this;
//     }
//     //*Remove a node from teh front of list
//     removeFront() {
//         if (this.head == null) {
//             //*if the list is empty, nothing to remove
//             return this.head;
//         }
//         let removeNode = this.head; //Have variable hold the node we'll remove
//         this.head = removeNode.next; //Moves the head of the list to the wnd node, which will become the new head when we're done
//         removeNode.next = null;
//         return this.head;
//     }
// }

// console.log("Results for the Remove Front Question: ")
// let SLL2 = new SLL();
// SLL2.removeFront();
// console.log(SLL2);
// //! Prints: SLL { head: null }

// let SLL3 = new SLL();
// SLL3.addFront(10);
// SLL3.addFront(5);
// console.log(SLL3);
// console.log("----------------------------------------------------------------");
//!Prints: 
// SLL {
//   head: SLLNode { value: 5, next: SLLNode { value: 10, next: null } }
// }

// SLL3.removeFront();
// console.log(SLL3);
// //! Prints: SLL { head: SLLNode { value: 10, next: null } }

/*
/////////////////////////////////////////////////////////////////////////////J////////////////////////////////////////////////////////////////////////////////////////////////

Front
Write a method to return the value (not the node) at the head of the list. If the list is empty, return null.
*/
class SLLNode {
    //Singly-linked list node class
    constructor(val) {
        this.value = val; //holds value for this node
        this.next = null; //pointer to next node
    }
}
class SLL {
    //The singly linked list class itself
    constructor() {
        //Will start with no nodes
        this.head = null; //Head points to first node.  A pointer to the first node of the list.
    }
    addFront(value) {
        //Need to create node containing 'value'!  This defines instance of the SLL node class, pass in a value, Then you will need to connect to the existing
        let newNode = new SLLNode(value);

        //How? Change the next attribute.  'This' is referring to SLLNode class
        newNode.next = this.head;
        this.head = newNode; //now head is pointing to the new node.
        return this.head; //Or you can say return this;
    }
    //Remove a node from teh front of list
    removeFront() {
        if (this.head == null) {
            //if the list is empty, nothing to remove
            return this.head;
        }
        let removeNode = this.head; //Have variable hold the node we'll remove
        this.head = removeNode.next; //Moves the head of the list to the wnd node, which will become the new head when we're done
        removeNode.next = null;
        return this.head;
    }

    //How to display the value of front?  Return the value at the front (head) of the list
    front() { 
        // return this.head.value;  //!This might cause a problem and return a TypeError (TypeError: Cannot read properties of null (reading 'value'))
        if(this.head == null) {
            return null;
        }
        else{
            //Ternary operator: condition ? value_if_true : value_if_false
            return this.head.value; //This will print out 'null'
        }
    }
}
console.log("Results for Front Question: ");
let SLL4 = new SLL();
console.log(SLL4.front());
//This is going to print out an error 'null'
SLL4.addFront(10);
console.log(SLL4.front());  //Should print out 10 since we shoved 10 in front with the addFront();
SLL4.addFront(5);
SLL4.addFront(3);


// Examples:

// SLL1.front() => 18
// SLL1.removeFront() => null
// SLL1.front() => null
/* */
