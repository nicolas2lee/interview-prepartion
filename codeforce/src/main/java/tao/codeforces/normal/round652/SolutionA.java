package tao.codeforces.normal.round652;

import java.util.Scanner;


public class SolutionA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();

            if ((n-4)%4==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
