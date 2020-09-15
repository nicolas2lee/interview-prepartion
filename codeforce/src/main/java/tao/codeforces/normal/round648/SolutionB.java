package tao.codeforces.normal.round648;

import java.util.Scanner;


public class SolutionB {

    public static class Point{
        int value;
        int orignIndex;
        int type;

        public Point(int value, int orignIndex, int type) {
            this.value = value;
            this.orignIndex = orignIndex;
            this.type = type;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i=0; i<n; i++){
                b[i] = sc.nextInt();
                sum+=b[i];
            }
            boolean flag = true;
            if (sum == 0 || sum == n){
                for (int i=1; i<n; i++){
                    if (a[i]<a[i-1]){
                        flag= false;
                        break;
                    }
                }
                if (flag) System.out.println("Yes");
                else System.out.println("No");
            }else System.out.println("yes");
        }
    }
}

