import java.util.ArrayList;

//*create a new class called CoffeeKiosk */
public class CoffeeKiosk {

    //*Member variables: ArrayList<Item> menu ,ArrayList<Order> orders */
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    //*Constructor - no params, initializes items and orders to empty arrays.
    public CoffeeKiosk() {
        //*initializes items & order as an empty list */
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();

    }

    //**Create a method that lets an admin add menu items manually, using what you now know about getting user input.
    public void addMenuItemByInput() {

        System.out.println("Please enter an menu item name or q to quit:");
        String itemName = System.console().readLine();

        System.out.println("Please enter a price for that item or q to quit:");
        String itemPrice = System.console().readLine();
        
    // Write a while loop to collect all user's order items
        while(!itemName.equals("q")) {
            double price = Double.parseDouble(itemPrice);
            addMenuItem(itemName, price);

            System.out.println("Please enter an menu item name or q to quit:");
            itemName = System.console().readLine();

            System.out.println("Please enter a price for that item or q to quit:");
            itemPrice = System.console().readLine();
        }
    }
    
    //** The addMenuItem method should create a new item object with the given name and price.
    //** Add the new Item object to the menu items array.
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);

        // **The new menu item itself will also need to be assigned an index property. The value should be its position, its index, in the menu array.
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }

    //*Now with an array of items you can display the menu without needing separate arrays of names and prices! 
    //**The displayMenu method should display all of the items from the menu array like so: */
    //*Note that Item is a class and a type.
    //**menu is an array declared above and I want to loop through that array */
    public void displayMenu() {
        for(int i=0; i<menu.size(); i++){
            Item item = menu.get(i);
            System.out.printf("%s %s -- %s\n\n", item.getIndex(), item.getName(), item.getPrice());
        }
    }

    public void newOrder() {
        //**Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order. Press Enter to pick an item from the Menu:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order newOrder = new Order (name);
        displayMenu();
        orders.add(newOrder);
        
        
        //** Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit and get your bill:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            int index = Integer.parseInt(itemNumber);
            Item item = menu.get(index);
            newOrder.addItem(item);

            System.out.println("Please enter a menu item index or q to quit and get your bill:");
            itemNumber = System.console().readLine();
        
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }

        //*note: calling a function on an object */
        newOrder.display();
        // After you have collected their order, print the order details 
        // as the example below. You may use the order's display method.
    }
    public static void main(String[] args){
        CoffeeKiosk newCoffeeKiosk = new CoffeeKiosk();
        
        newCoffeeKiosk.addMenuItem("Orange", 10);
        newCoffeeKiosk.addMenuItem("Banana", 24);
        newCoffeeKiosk.addMenuItem("Pineapple", 100);
        newCoffeeKiosk.addMenuItemByInput();
        newCoffeeKiosk.newOrder();
    }
}
