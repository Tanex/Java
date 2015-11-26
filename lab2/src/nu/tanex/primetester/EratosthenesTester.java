package nu.tanex.primetester;

public class EratosthenesTester implements PrimeTester {

    private boolean[] numberList;
    private int sieveSize;

    public EratosthenesTester(){
        this(100);
    }

    public EratosthenesTester(int sieveSize){
        this.sieveSize = sieveSize;
        createSieve();
        sievePrimes();
    }

    private void createSieve()    {
        numberList = new boolean[sieveSize + 1];
        numberList[0] = numberList[1] = false;
        for(int i = 2; i <= sieveSize; i++)
            numberList[i] = true;
    }

    private void sievePrimes(){
        for(int i = 2; i <= sieveSize; i++){
            if(numberList[i]){
                for(int j = i+i; j <= sieveSize; j += i){
                    numberList[j] = false;
                }
            }
        }
    }

    @Override
    public boolean isPrime(int n) {
        if(n > sieveSize)
            return false;
        return numberList[n];
    }
}
