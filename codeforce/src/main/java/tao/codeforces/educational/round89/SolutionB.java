package tao.codeforces.educational.round89;

import java.util.Scanner;

public class SolutionB {

    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int cas = sc.nextInt();
        while (cas-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int m = sc.nextInt();
            int ll =-1;
            int rr =-1;
            for (int i = 0; i < m; i++) {
                int left = sc.nextInt();
                int right = sc.nextInt();
                if (i==0){
                    if (x>= left && x<= right) {
                        ll = left;
                        rr = right;
                    }
                }else{
                    if (ll>=0){
                        if (right>= ll && right<=rr && left< ll) ll =left;
                        else if (right>rr && left >= ll && left <=rr) rr =right;
                        else if (right>= rr && left <= ll){
                            ll =left; rr=right;
                        }
                    }else {
                        if (x>= left && x<= right) {
                            ll = left;
                            rr = right;
                        }
                    }

                }
               // System.out.println("ll="+ll+","+"rr="+rr);
            }
            System.out.println(rr-ll+1);
        }

    }
}
/*
100
100 5 3
4 6
3 7
2 8
100 5 2
4 6
1 2
100 5 2
4 6
7 8
100 5 2
1 2
2 3
100 5 2
6 7
7 8
100 5 2
3 5
4 8
100 5 3
1 2
4 10
5 9
100 20 2
1 2
2 3
100 20 2
1 2
5 21


*/