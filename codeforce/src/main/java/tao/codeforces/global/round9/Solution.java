package tao.codeforces.global.round9;

import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution {
    static int[][] dir = {{0,1}, {0, -1}, {1,0}, {-1, 0} };
    static class Point{
        int r;
        int c;
        int count;

        public Point(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cas = sc.nextInt();
        while (cas-- > 0){
            final int n = sc.nextInt();
            final int m = sc.nextInt();
            int[][] map = new int[n][m];
            PriorityQueue<Point> pq =new PriorityQueue<>((o1, o2)->o2.count-o1.count);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int val = sc.nextInt();
                    map[i][j] = val;
                    if (val!=0) {
                        pq.add(new Point(i, j, val));
                    }
                }
            }
            boolean isPossible = true;
            while(!pq.isEmpty()){
                final int res = checkMap(map);
                if (res ==-1) {
                    isPossible=false; break;
                }else if (res==1){
                    break;
                }
                final Point cur = pq.poll();
            }
        }
    }

    private static int checkMap(int[][] map) {
        for (int i = 0; i <map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 4) return -1;
                if (map[i][j]>0){
                    int count=0;
                    for (int k = 0; k < dir.length; k++) {
                        final int r = i + dir[k][0];
                        final int c = i + dir[k][1];
                        if (r>=0 && r<map.length && c>=0 && c<map[0].length){
                            if (map[r][c]>0) count++;
                        }
                    }
                    if (map[i][j]!=count) return 0;
                }
            }
        }
        return 1;
    }
}
