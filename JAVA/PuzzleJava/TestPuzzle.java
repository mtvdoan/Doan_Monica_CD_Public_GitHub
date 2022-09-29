public class TestPuzzle {

    public static void main(String[] args){

        PuzzleJava appTest = new PuzzleJava();

        System.out.println("\n----- getTenRolls Test -----");
        int [] rolls = appTest.getTenRolls();
        for(int i = 0; i < rolls.length; i++){
            System.out.printf("I rolled a %s \n", rolls[i]);
        }

        System.out.println("\n------getRandomLetter Test----");
        System.out.println(appTest.getRandomLetter());

        System.out.println("\n------generatePassword Test----");
        System.out.println(appTest.generatePassword());

        System.out.println("\n------getNewPasswordSet Test----");
        int numOfPasswordsToGenerate = 8;
        String [] arrayOfPasswords = appTest.getNewPasswordSet(numOfPasswordsToGenerate);
        for (int i = 0; i < numOfPasswordsToGenerate; i++){
            System.out.println(arrayOfPasswords[i]);
        }

        System.out.println("\n----SENSEI BONUS-shuffleArray-INT-VERSION----");
        //* This is a random array we are passing into the function 'shuffleArray' */
        int[] array = {0,1,2,3,4,5,6,7}; //*<== */
        int[] shuffledArray = appTest.shuffleArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(shuffledArray[i]);
        }


        System.out.println("\n----SENSEI BONUS-shuffleArray-STRINGS-VERSION--");
        //* This is a random array we are passing into the function 'shuffleArray' */
        String[] arrayString = {"monica", "alex", "Adeline", "isaac", "ico", "pikachu", "monkeyDrills", "eevee", "ico-the-corgi"}; //*<== */
        String[] shuffledArrayString= appTest.shuffleArray(arrayString);
        for (int i = 0; i < arrayString.length; i++) {
            System.out.println(shuffledArrayString[i]);
        }
    }    
}
