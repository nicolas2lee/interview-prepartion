package tao.codeforces.normal.round648;

import java.util.Arrays;

public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int lengtha = A.length(); //6
        int lengthb = B.length(); //7
        if (lengtha == 0 || lengthb ==0) return 0;
        int[][] dp = new int[lengtha+1][lengthb+1];
        int max =-1;
        for (int i=1; i<= lengtha; i++){
            for (int j=1; j<= lengthb;j++){
                dp[i][j] = A.charAt(i-1)==B.charAt(j-1) ? dp[i-1][j-1] +1 : 0;
                max=Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        final int result = s.longestCommonSubstring("banana", "cianaic");
        System.out.println(result);
    }
}