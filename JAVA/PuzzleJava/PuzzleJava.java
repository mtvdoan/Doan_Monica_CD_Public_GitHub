import java.util.Random;

class PuzzleJava {

/**
 * * Method 1: getTenRolls
 * *Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
 */
    public int [] getTenRolls(){
        Random rnd = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(20);
        }
        return arr;
    }

/**
 * * Method 2: getRandomLetter
 * Write a method that will:

Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values). 
Generate a random index between 0-25, and use it to pull a random letter out of the array.
Return the random letter.
 * 
 */
    public String getRandomLetter(){
        String[] alphabetArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int i = new Random().nextInt(alphabetArray.length);
        return alphabetArray[i];
    }

/**
 * * Method 3: generatePassword
 * Write a method that uses the previous method to create a random string of eight characters, and return that string.
 */
    public String generatePassword(){
        String randomPassword = "";
        for(int i = 0; i < 8; i++){
            randomPassword += getRandomLetter();
        }
        return randomPassword;
    }

/**
 * * Method 4: getNewPasswordSet
 * Write a method that takes an int length as an argument and creates an array of random eight character words. The array should be the length passed in as an int.
 */
    public String[] getNewPasswordSet(int length) {
    
        String[] arrayOfPasswords = new String[length];
        for(int i = 0; i < length; i++){
            arrayOfPasswords[i] = generatePassword();

        }
        return arrayOfPasswords;

    }

/**
 * *Method 5: SENSEI BONUS! shuffleArray
 * Write a method that takes an array and mixes up all the values in a pseudo-random way. Hint: use random indexes within the array, and swap values repeatedly. 
 */
    public int[] shuffleArray(int[] array){
        Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
        return array;
    }

/**
 * *Added another method for String[] arrays
 */
        public String[] shuffleArray(String[] array){
        Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			String temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
        return array;

    }
    
}