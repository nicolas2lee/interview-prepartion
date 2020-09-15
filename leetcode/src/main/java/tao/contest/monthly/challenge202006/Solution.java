package tao.contest.monthly.challenge202006;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    static int[][] dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    static class Point{
        int i;
        int j;
        char val;

        public Point(int i, int j, char val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int colLength = board[0].length;
        for (int i = 0; i < board.length; i++) {
            if (i==0 || i==board.length-1){
                for (int j = 0; j < colLength; j++) {
                    if (board[i][j] == 'O'){
                        bfs(i, j, board);
                    }
                }
            }else {
                if (board[i][0] == 'O') bfs(i, 0, board);
                if (board[i][board[0].length-1] == 'O')bfs(i, board[0].length-1, board);
            }
        }
 /*       for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }*/
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] ='X';
                else if (board[i][j] == '$')  board[i][j] ='O';
            }
        }
    }

    private void bfs(int i, int j, char[][] board) {
        LinkedList<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        q.add(new Point(i, j, board[i][j]));
        board[i][j] = '$';
        visited[i][j] = true;
        while (!q.isEmpty()){
            Point cur = q.pop();
            for (int k = 0; k < dir.length; k++) {
                int row = cur.i + dir[k][0];
                int col = cur.j + dir[k][1];
                if (row >=0 && row <board.length && col >=0 && col<board[0].length
                        && !visited[row][col] && board[row][col]=='O'){
                    q.push(new Point(row, col, board[row][col]));
                    board[row][col] = '$';
                    visited[row][col] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};
        s.solve(board);
    }
}