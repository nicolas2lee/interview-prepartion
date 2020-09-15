package tao.contest.monthly.challenge202006;

/**
 * https://github.com/tianyicui/pack/blob/master/V2.pdf
 */
class Solution0607 {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0; i<amount;i++){
            dp[0][i] =0;
        }
        for (int i=0; i<coins.length;i++){
            dp[i][0] = 1;
        }
        for (int i=1; i<=coins.length; i++){
            for (int j=1; j<=amount; j++){
                for (int k=0; j - k*coins[i-1]>=0; k++){
                    dp[i][j]+= dp[i-1][j-k*coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        Solution0607 s = new Solution0607();
        int[] arr = {1,2, 5};
        final int result = s.change(5, arr);
        System.out.println(result);
    }
}

/*
* 5, {1,2, 5}
*            0  1  2  3  4  5  (amount)
*  0(coins)  0  0  0  0  0  0
*  1(1)      1
*  2(2)      1
*  5(3)      1
*
*
* */
