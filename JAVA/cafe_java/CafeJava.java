public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly.";
        String readyMessage = ", your order is ready!";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.50;
        double dripCoffeePrice = 4.50;
        double lattePrice = 5.00;
        double cappuccinoPrice = 5.10;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        System.out.println(
            generalGreeting + 
            customer1 + '\n' + 
            customer1 + 
            readyMessage + '\n' + 
            displayTotalMessage + 
            dripCoffeePrice); 

        
        if (isReadyOrder4) {
            System.out.println(generalGreeting + 
            customer4 + 
            readyMessage + '\n' + 
            displayTotalMessage + 
            cappuccinoPrice);
        }
        

        System.out.println(
            generalGreeting + 
            customer2 + '\n' + 
            displayTotalMessage + 
            (lattePrice + lattePrice));


        if (isReadyOrder2){
            System.out.println(
            customer2 +
            readyMessage + '\n');
        }

        else {
            System.out.println(
                customer2 +
                pendingMessage);
        }
        

        if (isReadyOrder3) {
            System.out.println(generalGreeting + 
            customer3 + 
            readyMessage + '\n' + 
            displayTotalMessage + 
            cappuccinoPrice);
        }
        
        
        System.out.println(
            generalGreeting + 
            customer3 + '\n' +
            displayTotalMessage +
            (lattePrice - dripCoffeePrice));
    	// ** Your customer interaction print statements will go here ** //
    }
}
