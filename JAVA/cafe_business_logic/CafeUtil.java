import java.util.ArrayList;
import java.util.Locale;
import java.text.NumberFormat;

class CafeUtil {

//** Method 1: Get Streak Goal
/**int getStreakGoal()

Cafe Java wants to implement a reward system for customers who always buy more drinks than they did the week before. To calculate how many drinks they need after 10 weeks, write a method that sums together every consecutive integer from 1 to 10 and returns the sum. In other words, add 1 + 2 + 3.. and so on up to 10 and return the result.

Test your code before moving on! Don't forget to make an instance of your 
CafeUtil class to use in the test file. The number printed should be 55.

**Ninja Bonus:  Add a parameter, numWeeks so that an admin can change the number from 10 to whatever they want. 
*/


    public int getStreakGoal(){  //different signature
        return getStreakGoal(10);
    }

    //*Ninja Bonus: Admin can change numWeeks */
    public int getStreakGoal(int numWeeks){ //different signature
        int sum = 0;
        for(int week =1; week <= numWeeks; week++) {
            sum += week;

        }
        return sum;
    }
    

//**Method 2: double getOrderTotal(double[] prices)

/**Given an array of item prices from an order, sum all of the prices in the array and return the total. 

Don't forget to test your code! Find the lines of test code for this method in TestCafe.java and uncomment it before you compile and run.
*/

    public double getOrderTotal(double[] lineItems){
//**double keyword is data type that can store fractional #s 
//**double-precision.  Has an endless value range. Commonly used for decimal values */

        double orderTotalSum = 0;
        for (double price: lineItems) {
            orderTotalSum += price;
        }
        return orderTotalSum;
    }
    
/**
 * * Method 3: void displayMenu(ArrayList<String> menuItems)

Given an ArrayList of menu items (strings), print out each index and menu item. 

Sample output given an  ArrayList with the items "drip coffee",  "cappuccino",  "latte" and  "mocha"

0 drip coffee
1 cappuccino
2 latte
3 mochacopy
Re-cap of ArrayList Syntax:

String name = myArray.get(0); // to access an element in an ArrayList using an index
 */
    public void displayMenu(ArrayList<String> menuItems){

        for (int i = 0; i < menuItems.size(); i++){
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    } 

/**
 * *NINJA BONUS
 * *Let's overload the display menu! Given 2 arrays, an ArrayList of menu items (strings), and an ArrayList of prices (doubles) print a menu! 

However, first check:  if the arrays are not the same size, immediately return false.
    **need if statement
To print the menu, iterate from 0 to the last index. Each time through, print on the same line:
    **for loop

a.) The index, b.) The menu item at that index, and c.) The price at that index. 
Finally, return true.
    **return true

Sample output:
0 drip coffee -- $1.50
1 cappucino -- $3.50
2 latte -- $4.50
3 mocha -- $3.50 
 */
    public boolean displayMenu(ArrayList<String> items, ArrayList<Double> prices){
        NumberFormat formatPrice = NumberFormat.getCurrencyInstance(Locale.US);
        if(items.size() != prices.size()){
            return false;
        }
        for (int i = 0; i < items.size(); i++){
            System.out.printf("%s %s %s \n", i, items.get(i), formatPrice.format(prices.get(i)));
        }
        return true;
    } 

/**
 ** Method 4: addCustomer(ArrayList<String> customers)

Inside this method:

Print this string to the console: "Please enter your name:"
Then add this line of code to get user input from the terminal and store it in the variable  userName: 
String userName = System.console().readLine();copy
Next print the userName to the console, saying "Hello, [user name here]!"
Next print "There are ___ people in front of you" using the number for how many people are ahead of them (how many items already in the array)
Then, add the customer's name to the given customers list. And print the list.
No need to return anything.

Re-cap of ArrayList Syntax:
myArray.add("Heidi"); // to add an item to an ArrayList
*/

//*This is the original version of addCustomer method */
public void addCustomer(ArrayList<String> customers){
    System.out.println("Please enter your name: ");
    String userName = System.console().readLine();
    System.out.println("This is the username: " + userName);
    System.out.printf("There are %s people in front of you", customers.size());
    customers.add(userName);
}
/**
 * *MORE NINJA BONUSES
* *Given a product, price and a maxQuantity, create a method that prints the cost for buying 1, then the price for buying 2, then for 3.. and so on, up to the max. For example, if the product is "Columbian Coffee Grounds" with a price of 15.0 and maxQuantity of 3, you should print:
* *Columbian Coffee Grounds
    ** 1 - $15.00
    ** 2 - $30.00
    ** 3 - $45.00
**Tip: You can use the escape character \n within your string for line breaks.
**Sensei bonus:  Format the prices as currency. Hint: https://docs.oracle.com/javase/tutorial/java/data/numberformat.html

**enpai Bonus: Take $0.50 more off of the original price every time the quantity increases. Example: Given a $2.00 price and 4 max, where the prices would normally be $2, $4, $6 and $8, the discount would yield $2, $3.50, $5, and $6.50, progressively taking off $0.50, then $1, then $1.50 from the group tag price:
*/
    
    public void printPriceChart(String product, double price, int maxQuantity){
        NumberFormat formatPrice = NumberFormat.getCurrencyInstance(Locale.US);
        for (int q = 1; q <= maxQuantity; q++){
            System.out.printf("%s - %s \n", q, (formatPrice.format((q * price) - ((q-1) * 0.50))));
        }
    } 
    

    // //*This is the NINJA BONUS version of 'Add Customer' */
    // public void addCustomer(ArrayList<String> customers){
    //     while (true) {
    //         System.out.println("Please enter your name: ");
    //         String userName = System.console().readLine();

    //         if(userName.equalsIgnoreCase("q")){
    //             break;
    //         }

    //         else{
    //             System.out.println("This is the username: " + userName);
    //             System.out.printf("There are %s people in front of you\n\n", customers.size());
    //             customers.add(userName);
    //         }
    //     }
    // }
}


