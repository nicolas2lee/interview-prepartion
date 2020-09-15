package tao.codeforces.normal.round652;

import java.util.Scanner;

/**
 * 5 01010
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            final String str = sc.next();
            final char[] chars = str.toCharArray();
            int start1 = -1;
            int end0 =-1;
            for (int i = 0; i <n; i++) {
                if (chars[i] == '1')  {
                    start1 =i;
                    break;
                }
            }
            for (int i = n-1; i >=0; i--) {
                if (chars[i] == '0')  {
                    end0 =i;
                    break;
                }
            }
            //System.out.println("start1: "+start1+ " endO: "+end0 );
            if (start1 == -1 || end0 == -1) System.out.println(str);
            else if (start1>end0) System.out.println(str);
            else if (end0-start1 == n-1) System.out.println("0");
            else{
                StringBuilder sb = new StringBuilder();
                if (start1==0) sb.append('0');
                else sb.append("00");
                for (int i = 1; i < n-end0; i++) {
                    sb.append('1');
                }
                //sb.append("1");
                System.out.println(sb.toString());
            }

        }
    }

}
