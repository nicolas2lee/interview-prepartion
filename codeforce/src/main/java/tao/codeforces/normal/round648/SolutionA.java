package tao.codeforces.normal.round648;

import java.util.Scanner;

/**
 * https://codeforces.com/blog/entry/78504
 */
public class SolutionA {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            final int m = sc.nextInt();
            int[][] map = new int[n][m];
            for (int i=0; i<n; i++){
                for (int j=0; j<m;j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int row = 0;
            for(int i=0; i<n;i++){
                boolean flag = false;
                for (int j=0; j<m;j++){
                    if (map[i][j] ==1){
                        flag =true;
                        break;
                    }
                }
                row+= flag ? 0: 1;
            }
            int col = 0;
            for(int i=0; i<m;i++){
                boolean flag = false;
                for (int j=0; j<n;j++){
                    if (map[j][i] ==1){
                        flag =true;
                        break;
                    }
                }
                col+= flag ? 0: 1;
            }
            final int result = Math.min(row, col);
            if (result%2 ==0)
                System.out.println("Vivek");
            else System.out.println("Ashish");
        }
    }
}
