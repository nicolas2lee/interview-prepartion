package tao.contest.weekly.virtual187;

class Solution1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int left = -1;
        int min = nums.length;
        for (int i=0; i<nums.length;i++){
            if (nums[i]==1){
                if (left == -1){
                    left =i;
                }else if (left != -1){
                    min = Math.min(min, i-left-1);
                    left = i;
                }
            }
        }
        return min >=k;
    }

    public static void main(String[] args) {
        Solution1437 s = new Solution1437();
        final int[] nums = {1, 0, 0, 1, 0, 1};
        final boolean result = s.kLengthApart(nums, 2);
        System.out.println(result);
    }
}