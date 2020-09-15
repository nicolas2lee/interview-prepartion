package tao.current;

public class OneGcd {

    public  int[] solve(long[] X, int[] Y){
        int[] result = new int[X.length];
        for (int cas=0; cas<X.length; cas++){
            int count=0;
            for (long i=X[cas]; i<X[cas]+Y[cas];i++){
                if (gcd(Y[cas], i)==1) count++;
            }
            result[cas]=count;
        }
        return result;
    }

    private long gcd(long a, long b) {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }

    public static void main(String[] args) {
        OneGcd o = new OneGcd();

        final int[] result = o.solve(new long[]{5, 3}, new int[]{3, 7});
        for (int x: result) {
            System.out.println(x);
        }
    }

}
