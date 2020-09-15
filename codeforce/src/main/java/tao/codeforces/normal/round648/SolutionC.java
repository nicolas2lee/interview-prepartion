package tao.codeforces.normal.round648;

import java.util.Scanner;

/**
 * 5 4 3 2 1
 * 1 2 3 4 5
 * 1
 *
 * 1 3 2 4
 * 4 2 3 1
 */
public class SolutionC {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        final int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        a[n] = a[0];
        for (int i=0; i<n; i++){
            b[i] = sc.nextInt();
        }
        b[n] = b[0];
        int[][] dp = new int[n+2][n+2];
        for(int i = 1; i <= a.length; i++){
            for(int j = 1; j <= b.length; j++) {
                if (a[i-1] == b[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        int length = dp[n+1][n+1];
        if (length>n) System.out.println(n);
        else System.out.println(length);

    }
}
