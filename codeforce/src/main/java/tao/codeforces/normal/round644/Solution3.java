package tao.codeforces.normal.round644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution3 {
    //1 2 3 4    4 2
    //1 2 3      3 1

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            List<Integer> oddList = new ArrayList<>();
            List<Integer> evenList = new ArrayList<>();
            for (int i=0; i<n;i++){
                int cur = sc.nextInt();
                if (cur%2==0) evenList.add(cur);
                else oddList.add(cur);
            }
           // oddList.forEach(System.out::print);
            //System.out.println();
            //evenList.forEach(System.out::print);
            //System.out.println("========debug");
            if (oddList.size()%2==0) {System.out.println("YES");}
            else {
                boolean flag = false;
                for (int i=0; i<oddList.size();i++){
                    final Integer cur = oddList.get(i);
                    if (evenList.contains(cur+1) || evenList.contains(cur-1) ){
                        System.out.println("YES");
                        flag =true;
                        break;
                    }
                }
                if (!flag) System.out.println("NO");
            }
        }

    }
}
