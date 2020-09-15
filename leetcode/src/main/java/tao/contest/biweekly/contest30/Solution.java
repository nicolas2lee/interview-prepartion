package tao.contest.biweekly.contest30;

class Solution {
    boolean ok =false;
    public boolean winnerSquareGame(int n) {
        ok=false;
        final int maxNum = (int) Math.sqrt(n);
        int step=0;
        int cur=0;
        dfs(cur, maxNum, step, n);
        return ok;
    }

    private void dfs(int cur, int maxNum, int step, int n) {
        if (cur>n) return;
        if (cur==n && step%2==1){
            ok = true;
        }
        for (int i = 1; i <= maxNum; i++) {
            dfs(cur+i*i, maxNum, step+1, n);
        }
    }


    public static void main(String[] args) {
        //8
        Solution s = new Solution();
        final boolean result = s.winnerSquareGame(2);
        System.out.println(result);
    }

}

/**
 1 4 1 1 1

 1 to sqrt(n) find a path with odd steps
 */