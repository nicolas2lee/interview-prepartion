package tao.codeforces.normal.round644;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Solution4 {
    //1 2 3 4    4 2
    //1 2 3      3 1
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final long n = sc.nextLong();
            final long k = sc.nextLong();
            if (n<=k) System.out.println(1);
            else {
                long maxValue = (int) Math.sqrt(n);
                //if (maxValue*maxValue == n && maxValue<=k) System.out.println(n/maxValue);
                List<Long> arrays = new ArrayList<>();
                maxValue = maxValue <= k ? maxValue : k;
                for (long i=maxValue; i>0; i--){
                    if (n%i==0) {
                        arrays.add(i);
                        if (n/i <=k)
                            arrays.add(n/i);
                    }
                }
                Collections.sort(arrays);
                System.out.println(n/arrays.get(arrays.size()-1));
            }
        }
    }
}
