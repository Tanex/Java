package nu.tanex.program;

import nu.tanex.primetester.EratosthenesTester;
import nu.tanex.primetester.PrimeTester;
import nu.tanex.primetester.SimpleTester;

public class Main {
    public static void main(String[] args) {
        SimpleTester tester1 = new SimpleTester();
        EratosthenesTester tester2 = new EratosthenesTester(1000000);
        System.out.println(numPrimesBelow(100, tester1));
        printPrimes(100, tester1);
        System.out.println(numPrimesBelow(100, tester2));
        printPrimes(100, tester2);

    }

    public static void printPrimes(int max, PrimeTester tester) {
        for(int i = 0; i < max; i++){
            if(tester.isPrime(i))
                System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static int numPrimesBelow(int max, PrimeTester tester){
        int numPrimes = 0;
        for(int i = 0; i < max; i++){
            if(tester.isPrime(i))
                numPrimes++;
        }
        return numPrimes;
    }
}

