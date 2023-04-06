import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;
// WORKING

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the message to be encrypted: ");
        String message = input.next();

        System.out.println();

        System.out.print("Please enter two prime numbers ");
        int Prime1, Prime2;
        Prime1 = input.nextInt();
        System.out.println();
        Prime2 = input.nextInt();

        while (!arePrime(Prime1, Prime2)) {

            System.out.println("please enter a correct prime number");
            Prime1 = input.nextInt();
            Prime2 = input.nextInt();

        }

        System.out.println();
        System.out.println();
        int n =  Prime1 * Prime2;
        int m =  (Prime1 - 1) * (Prime2 - 1);

        //getting coprime

        int e =findCoprimeWithPrime(m);
        int d = getInverseD(m,e);
        System.out.println("Public keys are "+e+" and "+n);
        // Generating 2 large prime numbers
        System.out.println(d);
        System.out.println(n);
        System.out.println(e);


        //getting ascii list

        ArrayList<Integer> asciiList = getAscii(message);
        ArrayList<Double> encryptedList = new ArrayList<>();
        for (Integer ascii : asciiList) {
            encryptedList.add((double)modPow(ascii, e, n));
        }


        System.out.println("Encrypted message:");
        for (double encrypted : encryptedList) {
            char chr = (char) encrypted;
            System.out.print(chr);
        }
        System.out.println();

        System.out.println("Decrypted message:");
        for (double encrypted : encryptedList) {
            int decrypted = modPow((int) encrypted, d, n);
            char chr = (char) decrypted;
            System.out.print(chr);
        }





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
    public static int findCoprimeWithPrime(int prime) {
        int n = 2; // start checking from 2
        while (gcd(n, prime) != 1) {
            n++; // increment n until gcd(n, prime) == 1
        }
        return n;
    }

    public static long gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);

    }
    public static int getInverseD(int prime, int e) {
        double d;
        int k = 0;
        while (true) {
            d = ((prime * k) + 1.0) / e;
            if (d ==  (int) d) {
                break;
            }
            k++;

        }
        return (int)d;
    }
    public static int modPow(int base, int exp, int modulus) {
        return BigInteger.valueOf(base).modPow(BigInteger.valueOf(exp), BigInteger.valueOf(modulus)).intValue();
    }
}