public class OrderTest {
    public static void main(String[] args){

        //! MENU ITEMS TO CHOOSE FROM: -------------------------------------------------------------------------------------------------------------------------------------------------

        Item item1 = new Item("Banana", 2);
        Item item2 = new Item("Human Meat", 200);
        Item item3 = new Item("Apple", 25);



        //! TASKS FROM LEARN PLATFORM: -------------------------------------------------------------------------------------------------------------------------------------------------

            //*Create 2 orders for unspecified guests (without specifying a name); */

            //*Create 3 orders using the overloaded constructor to give each a name for the order */

            //*Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1) */

            //*Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage()); */

            //*Implement the getOrderTotal method within the Order class (Technically this is already done in the display() in the Order.java file...) */
                //!I do not know why the Learn Platform for Coding Dojo is asking for this twice.  I didn't do this to reduce redundancy...

            //*Test the total by printing the return value like so: System.out.println(order1.getOrderTotal()); */
                //!I do not know why the Learn Platform for Coding Dojo is asking for this twice.  I didn't do this to reduce redundancy...

            //*Implement the display method within the Order class */
                //!I decided to just do the 'display()' since the getTotalPrice AND the customer name (getName()) */
        //?for unspecified guest by using the regular constructor for the function Order()
        Order order1 = new Order();
        order1.addItem(item1);
        order1.addItem(item3);
        order1.setReady(false);
        order1.display();
        System.out.println(order1.getStatusMessage());
        System.out.println();

        //?for unspecified guest by using the regular constructor for the function Order()
        Order order2 = new Order();
        order2.addItem(item2);
        order2.addItem(item1);
        order2.setReady(true);
        order2.display();
        System.out.println(order2.getStatusMessage());
        System.out.println();

        //? for specified guest by using the overloaded constructor for the function Order(String name) 
        Order order3 = new Order("Bob");
        order3.addItem(item3);
        order3.addItem(item1);
        order3.setReady(false);
        order3.display();
        System.out.println(order3.getStatusMessage());
        System.out.println();
        
        //? for specified guest by using the overloaded constructor for the function Order(String name)
        Order order4 = new Order("Steve");
        order4.addItem(item1);
        order4.addItem(item3);
        order4.setReady(false);
        order4.display();
        System.out.println(order4.getStatusMessage());
        System.out.println();

        //? for specified guest by using the overloaded constructor for the function Order(String name)
        Order order5 = new Order("Monica");
        order5.addItem(item3);
        order5.addItem(item3);
        order5.setReady(true);
        order5.display();
        System.out.println(order5.getStatusMessage());
        System.out.println();
    }
    
}
