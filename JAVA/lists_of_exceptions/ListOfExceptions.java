import java.util.ArrayList;
import java.util.Random;
import java.lang.reflect.Array;

public class ListOfExceptions{

    public static void main(String[] args) {
            
        ArrayList<Object> myList = new ArrayList<Object>(4);

        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
            } catch (Exception e) {
                System.out.printf("Oomf! Something went wrong at myList[%s]. \n The value is %s. \n This is the error message: %s \n\n", i, myList.get(i), e.getMessage());
            }
        }   
    }
}





/**
class OutOfGasException extends Exception{}

class UnreliableFriend {
    public boolean deliverMessage() throws OutOfGasException{
        Random r = new Random();
        boolean hasGas = r.nextBoolean();
        if (hasGas){
            return true;
        }
        throw new OutOfGasException();
    }
}

class DeliverMessage{
    public static void main(String[] args){
        UnreliableFriend friend = new UnreliableFriend();
        try{
            friend.deliverMessage();
            System.out.println("The message was delivered!");
        } catch (OutOfGasException e){
            System.out.println("Hey, uh, so, I ran out of gas..");
            // back-up plan here.
        }
    }
}



}
**/
