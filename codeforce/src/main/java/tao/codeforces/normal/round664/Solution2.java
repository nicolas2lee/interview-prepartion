package tao.codeforces.normal.round664;

import java.util.Scanner;

/**
 * 5 01010
 */
public class Solution2 {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited;
    static Point[] ans;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int starti = sc.nextInt();
        int startj = sc.nextInt();
        visited = new boolean[n][m];
        ans = new Point[n*m];
        dfs(starti-1, startj-1,n, m, 1);
        for (Point p : ans) {
            int xx = p.x+1;
            int yy = p.y+1;
            System.out.println(xx+" "+yy);
        }

    }

    private static boolean dfs(int i, int j, int n, int m, int step) {
        visited[i][j]=true;
        ans[step-1]=new Point(i, j);
        if (step>=n*m) {
            return true;
        }

        boolean result = false;
        for (int r=0; r<n;r++){
            if (!visited[r][j]) {
                result= dfs(r, j, n, m, step+1);
                if (result) return true;
                visited[r][j] = false;
            }
            //ans[step] = null;
        }
        for (int c=0; c<m;c++){
            if (!visited[i][c]) {
                result= dfs(i, c, n, m, step+1);
                if (result) return true;
                visited[i][c] = false;
                //ans[step] = null;
            }
        }
        return false;
    }

    private static boolean checkOk(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) return false;
            }
        }
        return true;
    }

}
