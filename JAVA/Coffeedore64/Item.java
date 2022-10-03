public class Item {
//! ITEM CLASS ATTRIBUTES (ALSO KNOWN AS MEMBER VARIABLES): -------------------------------------------------------------------------------------------------------------------------------------------------


    //*AKA Member variables */
    private String name;
    private double price;
    private int index;

//! ITEM CONSTRUCTORS: -------------------------------------------------------------------------------------------------------------------------------------------------

    //*Add a constructor to your Item class that takes a String name and  double price as arguments to set the name and price for that object on instantiation. */'
    //*Constructor (methods that has the same function name as the class itself.  (Item)):
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

//! ORDER SETTERS & GETTERS (aka MUTATORS & ACCESSORS): -------------------------------------------------------------------------------------------------------------------------------------------------
    //* Accessors & Mutators (Getters and Setters):
    //*Create getters and setters for all the member variables.

    //*Getter for Member Variable String name */
    public String getName(){
        return this.name;
    }

    //*Setter for Member Variable String name*/
    //*pass in the name to this */
    public void setName(String name){
        this.name = name;
    }

    //**Getter for Member Variable double price */
    public double getPrice(){
        return this.price;
    }

    //**Setter for Member Variable double price
    public void setPrice(double price){
        this.price = price;
    }


    //**Getter for Member Variable int index */
    public int getIndex(){
        return this.index;
    }

    //**Setter for Member Variable int index
    public void setIndex(int index){
        this.index = index;
    }
}


