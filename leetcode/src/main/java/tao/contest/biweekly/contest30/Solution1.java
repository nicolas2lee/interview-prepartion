package tao.contest.biweekly.contest30;

import java.util.Arrays;

class Solution1 {
    public int minDifference(int[] nums) {
        if (nums.length<=3) return 0;
        Arrays.sort(nums);
        // 3 big
        final int a = nums[nums.length - 4] - nums[0];
        // 2 big 1 small
        final int b = nums[nums.length - 3] - nums[1];

        // 1 big 2 small
        final int c = nums[nums.length - 2] - nums[2];
        // 3 small
        final int d = nums[nums.length - 1] - nums[3];
        return Math.min(Math.min(a, b), Math.min(c,d));

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        //final String result = s.reformatDate("20th Oct 2052");
        //System.out.println(result);
    }
}
/*
5 3 2 4

2 3 4 5
1 1 1

1,5,0,10,14
0 1 5 10 14

*/