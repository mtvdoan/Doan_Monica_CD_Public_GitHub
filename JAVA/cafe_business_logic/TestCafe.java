import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {

        CafeUtil appTest = new CafeUtil();
    /* 
        You will need add 1 line to this file to create an instance 
        of the CafeUtil class. 
        Hint: it will need to correspond with the variable name used below..
    */
        
        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        int numWeeks = 25; 
            //*Notice this int numWeeks? This is used for the Ninja Bonus */
        System.out.printf("Purchases needed by week %s: %s \n\n",numWeeks, appTest.getStreakGoal(numWeeks));
            //*if you remove 'numWeeks' it'll default to 10 instead because of the method overloading */
            //*printf: formatted output with System.outprintf().
                //*a method that can create formatted strings */
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        //* double data type usually used for decimals */
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("----- Display Menu Overload Test-----");
        ArrayList<String> items = new ArrayList<String>();
        items.add("drip coffee");
        items.add("cappuccino");
        items.add("latte");
        items.add("mocha");

        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.50);
        prices.add(3.50);
        prices.add(4.50);
        prices.add(3.50);
        appTest.displayMenu(items, prices);

        System.out.println("\n-----Price Chart of Products Test-----");
        int maxQuanity = 4;
        double price = 2.0;
        String product = "Columbian Coffee Grounds";
        appTest.printPriceChart(product, price, maxQuanity);
        


        //*This is the original version of 'Add Customer' */
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for(int i = 0; i <= 4; i++) {
        appTest.addCustomer(customers);
        System.out.println("\n");
        }


        // //*This is the NINJA BONUS version of 'Add Customer' */
        // System.out.println("\n----- Add Customer Test-----");
        // ArrayList<String> customers = new ArrayList<String>();
        // appTest.addCustomer(customers);
        // System.out.println("\n");
    }
}


