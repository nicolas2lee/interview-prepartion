package tao.codeforces.normal.round664;

import java.util.Scanner;

/**
 * 5 01010
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            int nbOdd = 0;
            nbOdd += r%2==0 ? 0: 1;
            nbOdd += g%2==0 ? 0: 1;
            nbOdd += b%2==0 ? 0: 1;
            if (r==0 || g==0 || b==0){
                nbOdd += w%2==0 ? 0: 1;
                if (nbOdd>1) System.out.println("No");
                else System.out.println("Yes");
            }else {
                if ((nbOdd==1 && w%2==1) || (nbOdd==2 && w%2==0)) System.out.println("No");
                else System.out.println("Yes");
            }
        }
    }

}
