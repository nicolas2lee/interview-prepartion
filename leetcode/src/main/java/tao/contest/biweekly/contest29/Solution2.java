package tao.contest.biweekly.contest29;

class Solution2 {
    public int kthFactor(int n, int k) {
        for (int i=1; i<=n; i++){
            if (n%i==0){
                k--;
                if (k==0) return i;
            }
        }
        return -1;
    }
}
