/*
    Monica Doan
    Assignment: User
    Objectives:
        Practice creating a class and making instances from it
        Practice accessing the methods and attributes of different instances
        If you've been following along, you're going to utilize the User class we've been discussing for this assignment.

        For this assignment, we'll add some functionality to the User class:

        makeWithdrawal(amount) - have this method decrease the user's balance by the amount specified
        displayBalance() - have this method print the user's name and account balance to the terminal
        eg. "User: Guido van Rossum, Balance: $150
        BONUS: transferMoney(otherUser, amount) - have this method decrease the user's balance by the amount and add that amount to other otherUser's balance
        Create a file with the User class, including the constructor and makeDeposit methods

        Add a makeWithdrawal method to the User class

        Add a displayBalance method to the User class

        Create 3 instances of the User class

        Have the first user make 3 deposits and 1 withdrawal and then display their balance

        Have the second user make 2 deposits and 2 withdrawals and then display their balance

        Have the third user make 1 deposits and 3 withdrawals and then display their balance

        BONUS: Add a transferMoney method; have the first user transfer money to the third user and then print both users' balances
 */

class User {
    //Attributes
    constructor(owner, accountBalance) {
        this.owner = owner;
        this.accountBalance = accountBalance;
    };
    //methods
    makeDeposit(amount) {
        //takes a parameter this is the amount of the deposit
        this.accountBalance += amount;
    };
    makeWithdrawal(amount){
        this.accountBalance -= amount;
    }

    displayBalance(){
        this.accountBalance = accountBalance;
    }
    
    displayOwner(){
        console.log(name);
    }

    //Bonus
    transferMoney(otherUser,amount){
        this.accountBalance -= amount;
        otherUser.accountBalance += amount;
    }
};

//Samples of how methods are called

//Creates new User
const firstUser = new User("Monica Doan", 500 )
const otherUser = new User("Alex Ames", 500);

//User firstUser makes $100 deposit to accountBalance of $500
firstUser.makeDeposit(100)

//User firstUser makes $50 withdraw
firstUser.makeWithdrawal(50)

firstUser.transferMoney(otherUser, 100);
//Monica: $550 - $100
// Transfer $100 to 'otherUser' account of $500 (Now otherUser, Michael, has $600)

//Show Monica's account balance.
console.log(firstUser.accountBalance)	
//$450

console.log(otherUser.accountBalance);
//$600
console.log(otherUser.accountBalance);

//Display name of otherUser
console.log(otherUser.owner);

//Display name of firstUser
console.log(firstUser.owner);
