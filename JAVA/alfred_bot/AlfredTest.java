//! Required extension: 'Better Comments'

/**
 * * This file is used to compile the 'AlfredQuotes.java' file.
 * * This is also where we call/invoke AlfredQuotes methods from within this AlfredTest.java file.
 */

public class AlfredTest {
    /**
    ** This main method will always be the launch point for a Java application
    ** For now, we are using the main to test all our 
    ** AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        //? alfredBot is a variable of the class AlfredQuotes
            //? Creating an object of type 'AlfredQuotes' 
                //? Object 
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane", "morning");
        String testGuestGreetingSilly = alfredBot.guestGreeting("Pooper Face", "evening", "Beep-Boop-Beep!");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );
        
        // Print the greetings to test.
        System.out.println(testGreeting);
        
        // Uncomment these one at a time as you implement each method.
        System.out.println(testGuestGreeting);
        System.out.println(testGuestGreetingSilly);

        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        // System.out.println(notRelevantTest);
    }
}
