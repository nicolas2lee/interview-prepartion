package tao.contest.biweekly.contest31;

class Solution1 {
    public int countOdds(int low, int high) {
        int ans = (high - low) / 2;
        if (low%2==1 || high%2==1) ans+=1;
        return ans;
    }
}

