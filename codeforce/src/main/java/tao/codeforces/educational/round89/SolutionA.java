package tao.codeforces.educational.round89;

import java.util.Scanner;

public class SolutionA {

    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int cas = sc.nextInt();
        while (cas-- > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            //awlays a <b
            if (a>b){
                int tmp =a;
                a =b;
                b=tmp;
            }
            if (a >b/2) System.out.println((a+b)/3);
            else System.out.println(Math.min(b/2, a));
        }

    }
}
