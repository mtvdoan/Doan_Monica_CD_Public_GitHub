public class BankAccountTest {
    public static void main(String[] args) {
        //*Create BankAccount #1 */
        BankAccount bA = new BankAccount();
        System.out.println("This is Account #: " + bA.getNumberOfAccountsCreated());
        System.out.println("Your new Account Number is: " + bA.getBankAccountNumber()); 
        System.out.println("The number of accounts you currently own is: " + bA.getNumberOfAccountsCreated());
        bA.depositChecking(100.00);
        System.out.println("You have this much in your Checking Account: " + bA.getCheckingBalance());
        bA.depositChecking(300.00);
        System.out.println("You have this much in your Savings Account: " + bA.getSavingsBalance());
        System.out.println("Your total balance is: " + bA.totalBalanceOfAccounts());

        System.out.println();

        bA.withdrawChecking(50.00);
        System.out.println("You have this much in your Checking Account: " + bA.getCheckingBalance());
        bA.withdrawSavings(50.00);
        System.out.println("You have this much in your Savings Account: " + bA.getSavingsBalance());
        System.out.println("Your total balance is: " + bA.totalBalanceOfAccounts());

        System.out.println();

        //*Create BankAccount #2 */
        BankAccount bA2 = new BankAccount();
        System.out.println("This is Account #: " + bA2.getNumberOfAccountsCreated());
        System.out.println("Your new Account Number is: " + bA2.getBankAccountNumber());
        bA2.depositChecking(200.00);
        System.out.println("You have this much in your Checking Account: " + bA2.getCheckingBalance());
        bA2.depositSavings(165.00);
        System.out.println("You have this much in your Savings Account: " + bA2.getSavingsBalance());
        System.out.println("Your total balance is: " + bA2.totalBalanceOfAccounts());

        System.out.println();

        bA2.withdrawChecking(50.00);
        System.out.println("You have this much in your Checking Account: " + bA2.getCheckingBalance());
        bA2.withdrawSavings(50.00);
        System.out.println("You have this much in your Savings Account: " + bA2.getSavingsBalance());
        System.out.println("Your total balance is: " + bA2.totalBalanceOfAccounts());

        System.out.println();

        //*Create BankAccount #3 */
        BankAccount bA3 = new BankAccount();
        System.out.println("This is Account #: " + bA3.getNumberOfAccountsCreated());
        System.out.println("Your new Account Number is: " + bA3.getBankAccountNumber());
        bA3.depositChecking(3000.00);
        System.out.println("You have this much in your Checking Account: " + bA3.getCheckingBalance());
        bA3.depositSavings(1205.00);
        System.out.println("You have this much in your Savings Account: " + bA3.getSavingsBalance());
        System.out.println("Your total balance is: " + bA3.totalBalanceOfAccounts());

        System.out.println();

        bA3.withdrawChecking(500.00);
        System.out.println("You have this much in your Checking Account: " + bA3.getCheckingBalance());
        bA3.withdrawSavings(850.00);
        System.out.println("You have this much in your Savings Account: " + bA3.getSavingsBalance());
        System.out.println("Your total balance is: " + bA3.totalBalanceOfAccounts());


        System.out.println();
        System.out.println();

        long sumGrandTotalForAll = (long) (bA.totalBalanceOfAccounts() + bA2.totalBalanceOfAccounts() + bA3.totalBalanceOfAccounts());
        System.out.println("The grand total of all accounts is: " + sumGrandTotalForAll);
    
    
    }


}
