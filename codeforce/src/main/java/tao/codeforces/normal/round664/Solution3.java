package tao.codeforces.normal.round664;

import java.util.Scanner;

/**
 * 5 01010
 */
public class Solution3 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] narr= new int[n];
        int m = sc.nextInt();
        int[] marr= new int[m];
        for (int i = 0; i < n; i++) {
            narr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            marr[i]=sc.nextInt();
        }
        int ans =0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int cur = narr[i] & marr[j];
                min = Math.min(min, cur);
            }
            if (i==0) ans=min;
            else ans = ans | min;
        }

        System.out.println(ans);

    }


}
