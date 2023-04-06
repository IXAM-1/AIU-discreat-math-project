import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the message to be encrypted ");
        System.out.print("Please enter two prime numbers ");
        int Prime1 = input.nextInt();
        int Prime2 = input.nextInt();
        String message = input.next();
ArrayList<Integer> AsciiList = getAscii(message);

    }
    //This method turns the string into a list of ascii numbers to encrypt them in another method
    public static ArrayList <Integer> getAscii(String input){
        ArrayList <Integer> CharacterList = new ArrayList<>(); // initialize the list
        for (int i = 0;i<=input.length();i++){ // we use for loop to type cast the Characters into ascii and put them into the list
            CharacterList.add((int) input.charAt(i));
        }

        return CharacterList;
    }

}