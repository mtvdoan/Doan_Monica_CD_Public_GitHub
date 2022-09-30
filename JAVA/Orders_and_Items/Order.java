
import java.util.ArrayList;

//* Aside from Order class, we are creating another class called 'Order'
public class Order{  


    //*again you declare what type each object is.  'name' is a String, 'total' is an int; 'ready' is a boolean (true/false) */
    //* name defaults to null */
    public String name;  

    //*total defaults to 0 */
    public double total;

    //*ready defaults to false */
    public boolean ready;

    
    public ArrayList<Item> items = new ArrayList<Item>();

}
