import java.util.ArrayList;

public class TestOrders {

    
    //* <===Test.java files should be the ones that have the 'public static void main(String[] args)' statement */
    public static void main(String[] args) {

        //? MENU ITEMS:
        //* <======This 'Item item# = new Item()' needs to be declared each time for a new item on the menu. */
        //* 'item#' here gets the information from the Item.java file.  The Item.java files simply tells what are the types of the variables.  (example: String name) */
        Item item1 = new Item(); 
        item1.name = "mocha";
        item1.price = 10;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 15;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 18;

        Item item4 = new Item();
        item4.name = "cappucino";
        item4.price = 100;


        //? ORDERS:

        Order order1 = new Order();
        order1.name = "Cinhuri";
        order1.items.add(item1);
        order1.items.add(item2);
        order1.items.add(item3);
        order1.total += item1.price;

        //*Cindhuri’s order is now ready. Update her status. */
        order1.ready = true;


        //*Add item1 to order2's item list and increment the order's total. */
        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.items.add(item1);
        order2.total += item1.price;

        //*Jimmy’s order is now ready. Update his status. */
        order2.ready = true;


        //*order3 ordered a cappucino. Add the cappuccino to their order list and to their tab. */
        Order order3 = new Order();
        order3.name = "Noah";
        order3.items.add(item4);  
        order3.total += item4.price;


        //*order4 added a latte. Update accordingly. */
        Order order4 = new Order();
        order4.name = "Sam";
        order4.items.add(item2);  

        //*Sam ordered more drinks - 2 lattes. Update their order as well. */
        order4.items.add(item2);
        order4.items.add(item2);

        //* 1 latte & 2 more lattes */
        order4.total = item2.price *3;
    

        // Order variables -- order1, order2 etc.

        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Thank you for your order, %s!\n", order1.name);
        System.out.printf("Your total for today is: $ %s\n", order1.total);
        System.out.printf("Ready?: %s\n", order1.ready);

        System.out.printf("\n\n");

        System.out.printf("Thank you for your order, %s!\n", order2.name);
        System.out.printf("Your total for today is: $ %s\n", order2.total);
        System.out.printf("Ready?: %s\n", order2.ready);

        System.out.printf("\n\n");

        System.out.printf("Thank you for your order, %s!\n", order3.name);
        System.out.printf("Your total for today is: $ %s\n", order3.total);
        System.out.printf("Ready?: %s\n", order3.ready);

        System.out.printf("\n\n");

        System.out.printf("Thank you for your order, %s!\n", order4.name);
        System.out.printf("Your total for today is: $ %s\n", order4.total);
        System.out.printf("Ready?: %s\n", order4.ready);
    }
}
