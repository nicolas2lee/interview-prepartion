package tao.codeforces.educational.round81;

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

    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int maxValue = sc.nextInt();
            if (maxValue%2 ==0) {
                final int nbOnes = maxValue / 2;
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<nbOnes;i++){
                    sb.append("1");
                }
                System.out.println(sb.toString());
            }else {
                final int nbOnes = (maxValue-3)/2;
                StringBuilder sb = new StringBuilder("7");
                for (int i=0; i<nbOnes;i++){
                    sb.append("1");
                }
                System.out.println(sb.toString());
            }
        }

    }
}
