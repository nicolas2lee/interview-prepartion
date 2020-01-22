package tao;

public class PrimeWithSubstring {

    public long findPrime(int n) {
        Integer MAX_DIGIT=12;
        if (isPrime(n))return n;
        int tmp = n;
        int count =1;
        while (tmp/10>0){
            tmp = tmp/10;
            count++;
        }
        int maxN = tmp%10;
        int[] lastDigitArray = {1,3,7,9};
        while (true) {
            for (int i = 1; i < maxN; i++) {
            /*    if (i < ) {
                    long value = i*(long)Math.pow(10, count)+n;
                    if (isPrime(value)) return value;
                } else {
                    Long value = testSuffix(n, count, lastDigitArray, i);
                    if (value != null) return value;
                }*/
            }
        }
    }

    private Long testSuffix(int n, int count, int[] lastDigitArray, int i) {
        for (int j=0; j<lastDigitArray.length;j++){
            long value = (i*(long)Math.pow(10, count)+n)*10 + lastDigitArray[j];
            if (isPrime(value)) return value;
        }
        return null;
    }

    private boolean isPrime(long n) {
        for (long i = Math.round(Math.floor(Math.sqrt(n))+0.5); i>=2;i--){
            if (n%i ==0) return false;
        }
        return true;
    }


}
