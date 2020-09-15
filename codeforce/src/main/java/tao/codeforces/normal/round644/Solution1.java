package tao.codeforces.normal.round644;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2 -> 1
 * 3 -> 7
 * 4 -> 11
 * 5 -> 71
 * 6 -> 77, 111
 * 7 -> 771
 * 9 -> 777, 7111
 */
public class Solution1 {
    //1 2 3 4    4 2
    //1 2 3      3 1

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            int num[] = new int[n];
            for (int i=0; i<n;i++){
                num[i] = sc.nextInt();
            }
            Arrays.sort(num);
            int min=num[n-1];
            for (int i=0; i<n-1;i++){
                min =Math.min(num[i+1] -num[i], min);
            }
            System.out.println(min);
        }

    }
}
