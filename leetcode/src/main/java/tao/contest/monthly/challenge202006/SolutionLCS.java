package tao.contest.monthly.challenge202006;

class SolutionLCS {
    public boolean isSubsequence(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        final int slength = s.length();
        final int tlength = t.length();
        if (slength > tlength) return false;
        int[][] dp = new int[slength+1][tlength+1];
        /**
         * dp[i][j] = the num of subsequence in ith position of s and jth position of t
         */
        for (int i = 0; i < slength; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < tlength; i++) {
            dp[0][i] = 0;
        }
        for (int i=1; i<=slength;i++){
            for (int j = 1; j <= tlength; j++) {
                if (schars[i-1] == tchars[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        //System.out.println(dp[slength][tlength]);
        return dp[slength][tlength] == slength;
    }

    public static void main(String[] args) {
        SolutionLCS s = new SolutionLCS();
        String ss = "abc";
        String t = "ahbgdc";
        final boolean result = s.isSubsequence(ss, t);
        System.out.println(result);
    }
}