package tao.contest.biweekly.contest31;

class Solution {
    public int minNumberOperations(int[] target) {
        int[] init = new int[target.length];
        int count=0;
        int cur=0;
        boolean start = true;
        while (!isOk(init, target)){
            cur++; count++;
            for (int i = 0; i < target.length; i++) {
                if (target[i]>=cur && start) init[i]++;
                else if (target[i]>=cur && !start) {
                    count++;
                    start=true;
                    init[i]++;
                } else {
                    start=false;
                }
            }
        }
        return count;
    }

    private boolean isOk(int[] init, int[] target) {
        for (int i = 0; i < init.length; i++) {
            if (init[i]!=target[i])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr ={1,2,3,2,1};
        final int ans = s.minNumberOperations(arr);
        System.out.println(ans);
    }
}

