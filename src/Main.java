import java.util.ArrayList;
import java.util.Scanner;
// UNFINISHED
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the message to be encrypted: ");
        String message = input.next();

        System.out.println();

        System.out.print("Please enter two prime numbers ");

        int Prime1 = input.nextInt();
        System.out.println();
        int Prime2 = input.nextInt();

        while (!arePrime(Prime1, Prime2)) {

            System.out.println("please enter a correct prime number");
            Prime1 = input.nextInt();
            Prime2 = input.nextInt();

        }
        System.out.println();
        System.out.println();
        // Generating 2 large prime numbers

        long lPrime1 = (long) Prime1 * Prime2;
        long lPrime2 = (long) (Prime1 - 1) * (Prime2 - 1);

        //getting coprime

        int e=findCoprimeWithPrime(lPrime2);


        //getting ascii list

        ArrayList<Integer> AsciiList = getAscii(message);


    }

    //This method turns the string into a list of ascii numbers to encrypt them in another method
    public static ArrayList<Integer> getAscii(String input) {
        ArrayList<Integer> CharacterList = new ArrayList<>(); // initialize the list
        for (int i = 0; i < input.length(); i++) { // we use for loop to type cast the Characters into ascii and put them into the list
            CharacterList.add((int) input.charAt(i));
        }

        return CharacterList;
    }

    public static boolean arePrime(int n, int a) {
        return isPrime(n) && isPrime(a);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    //getting coprime
    public static int findCoprimeWithPrime(long prime) {
        int n = 2; // start checking from 2
        while (gcd(n, prime) != 1) {
            n++; // increment n until gcd(n, prime) == 1
        }
        return n;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }
    public static int get5raD(long prime, int e) {
        double d = 0;
        int k = 0;
        while (true) {
            d = ((prime * k) + 1.0) / e;
            if (d == (int) d) {
                break;
            }
            k++;

        }
        return (int) d;
    }
}