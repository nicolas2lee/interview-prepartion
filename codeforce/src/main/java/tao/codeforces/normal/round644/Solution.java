package tao.codeforces.normal.round644;

import java.util.Scanner;


public class Solution {
    //1 2 3 4    4 2
    //1 2 3      3 1
    static int[][] dir = {{0,1}, {0, -1}, {1,0}, {-1, 0} };

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i=0; i<n;i++){
                int row = sc.nextInt();
                for (int j=n-1; j>=0; j--){
                    map[i][j] = row %10;
                    row = row/10;
                }
            }
        /*    for (int i=0;i<n;i++){
                for (int j=0; j<n; j++)
                    System.out.print(map[i][j]);
                System.out.println();
            }*/
            boolean flag = false;
            for (int i=0; i<n;i++){
                for (int j=0; j<n; j++){
                    if (map[i][j]==1 && isAllZero(i, j, map)){
                        System.out.println("NO");
                        flag =true;
                        break;
                    }
                }
                if (flag)break;
            }
            if (!flag) System.out.println("YES");
        }
    }

    private static boolean isAllZero(int i, int j, int[][] map) {
        boolean isAllZero = true;
        for (int k=0; k<dir.length; k++){
            int ii= i+dir[k][0];
            int jj= j+dir[k][1];
            if (ii>=0 && ii<map.length && jj>=0 && jj<map[0].length){
                if (map[ii][jj]==1){
                    isAllZero = false;
                    break;
                }
            }
        }
        return isAllZero;
    }
}
