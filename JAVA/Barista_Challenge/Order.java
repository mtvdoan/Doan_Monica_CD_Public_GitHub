import java.util.ArrayList;

public class Order {
//*This is where the class attributes go. */    

    //*AKA Member variables */
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to null
    


    //! ORDER CONSTRUCTORS: -------------------------------------------------------------------------------------------------------------------------------------------------
    //**No arguments, sets name to "Guest"
    public Order() {
        this.name = "Guest";

        //*initializes items as an empty list. */
        this.items = new ArrayList<Item>();
    }
    
    //*OVERLOADED CONSTRUCTOR
    //* Takes a name as an argument, sets name to this custom name. (this.name = name)
    //* Initializes items as an empty list.
    public Order(String name) {
        this.name = name;

        //*initializes items as an empty list. */
        this.items = new ArrayList<Item>();
    }

    //! ORDER GETTERS & SETTERS: -------------------------------------------------------------------------------------------------------------------------------------------------

    //**Getter for Member Variable String Name*/
    public String getName(){
        return this.name;
    }

    //**Setter for Member Variable String Name
    public void setName(String name){
        this.name = name;
    }

    //** for Member Variable boolean ready*/
    public void setReady(boolean ready){
        this.ready = ready;
    }

        //** for Member Variable boolean ready*/
    public boolean isReady(){
        return this.ready;
    }

    //**Getter for Member Variable ArrayLIst<Item> items*/
    public ArrayList<Item> getItems(){
        return this.items;
    }

    //**Setter for Member Variable ArrayLIst<Item> items
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
    
    //! ORDER METHODS: -------------------------------------------------------------------------------------------------------------------------------------------------

    //* Method 1: addItem
    //*Create a method called addItem  that takes an Item object as an argument and adds the item to the order's items array. No need to return anything.
    //*Hint: How do you get the price of a given item instance from outside the Item class?
    public void addItem(Item item){
        items.add(item);

    }

    //*Method 2: getStatus Message */
    //*Create a method called getStatusMessage that returns a String message. If the order is ready, return "Your order is ready.", if not, return "Thank you for waiting. Your order will be ready soon."
    public String getStatusMessage(){
        String messageReady = "Your order is ready!";
        String messageNotReady = "Thank you for waiting. Your order will be ready soon.";
        if(ready){
            return messageReady;
        }
        else{
            return messageNotReady;
        }
    }

    //*Method 3: getOrderTotal */
    //* Similar to the getOrderTotal method from the Cafe Business Logic assignment, create a method called getOrderTotal that sums together each of the item's prices, and returns the total amount. 
    //* Note: This time, you do not need to pass in a list of prices, because each item object in this order's items array has its own price, that you can access using a getter!
    public double getOrderTotal(){
        double totalCost = 0;

        for (int i = 0; i < getItems().size(); i++){
            Item item = getItems().get(i);
            totalCost += item.getPrice(); 
        }
        return totalCost;    
    }
    
    //*Method 4: display */
    //*Similar to the displayMenu function from the Cafe Business Logic assignment, create a method called display that prints out the order information like so: */

    //!Do not need to pass in because a function without anything passing in will automatically assume 'this...'.  In this case 'Order this' is being passed in the function 'public void display()' automatically.  It's implied as 'this' specific order#. */
    public void display(){
        System.out.printf("Customer name: %s\n", getName());
        for (int i = 0; i < getItems().size(); i++){
            Item item = getItems().get(i);
            System.out.printf("%s - %s\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: %s\n", getOrderTotal());
    } 
}
