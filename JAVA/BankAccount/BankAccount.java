import java.util.Random;


//*Create a BankAccount class. */
//*Users should not be able to set any of the attributes from the class. */
public class BankAccount {

    //*The class should have the following attributes: (double) checking balance, (double) savings balance. */
    private double checkingBalance;
    private double savingsBalance;

    //*Create a class member (static) that has the number of accounts created thus far. */
    private static int numberofAccountsCreated = 0;

    //*Create a class member (static) that tracks the total amount of money stored in every account created. */
    private static long totalBalanceOfAccounts;

    //*NINJA BONUS: Add the the following class attribute: account number. The type is up to you, can be a String or a Long or another type. */
    private long bankAccountNumber;

    //*NINJA BONUS: Create a private method that returns a random ten digit account number. */
    private static long generateAccountNumber(){
        //*final means you can't change */
        final int MAX_ACCOUNT_NUMBER_LENGTH = 10;
        Random random = new Random();
        long result = 0;
        for(int i = 0; i < MAX_ACCOUNT_NUMBER_LENGTH; i++){
            result *= 10;
            result += random.nextInt(10);
        }
        return result;
    }

    //*In the constructor, be sure to increment the account count. */
    //*NINJA BONUS: In the constructor, call the private method from above so that each user has a random ten digit account. */
    public BankAccount(){
        numberofAccountsCreated++;
        bankAccountNumber = generateAccountNumber();
    }

    public int getNumberOfAccountsCreated(){
        return numberofAccountsCreated;
    }

    //*Create a getter method for the user's checking account balance. */
    public double getCheckingBalance(){
        return checkingBalance;
    }

    //*Create a getter method for the user's saving account balance. */
    public double getSavingsBalance(){
        return savingsBalance;
    }

    //*Create a method that will allow a user to deposit money into either the CHECKING, be sure to add to total amount stored.*/
    public void depositChecking(double amountDepositChecking){
        checkingBalance += amountDepositChecking;
        totalBalanceOfAccounts += amountDepositChecking;
    }

    //*Create a method to withdraw money from one balance (CHECKING HERE). Do not allow them to withdraw money if there are insufficient funds. */
    public void withdrawChecking(double amountWithdrawChecking){
        if(checkingBalance >= amountWithdrawChecking){
            checkingBalance -= amountWithdrawChecking;
            totalBalanceOfAccounts -= amountWithdrawChecking;            
        }
    }

    //*Create a method that will allow a user to deposit money into SAVINGS, be sure to add to total amount stored.*/
    public void depositSavings(double amountDepositSavings){
        savingsBalance += amountDepositSavings;
        totalBalanceOfAccounts += amountDepositSavings;
    }

    //*Create a method to withdraw money from one balance (SAVINGS HERE). Do not allow them to withdraw money if there are insufficient funds. */
    public void withdrawSavings(double amountWithdrawSavings){
        if(savingsBalance >= amountWithdrawSavings){
            savingsBalance -= amountWithdrawSavings;
            totalBalanceOfAccounts -= amountWithdrawSavings;            
        }
    }

    //*Create a method to see the total money from the checking and saving. */
    public double totalBalanceOfAccounts(){
        return checkingBalance + savingsBalance;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }
                        

    

}
