package nu.tanex.primetester;

public class SimpleTester implements PrimeTester{

    @Override
    public boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = (int)Math.sqrt(n); i > 1; i--){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
