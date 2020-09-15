package tao.contest.monthly.challenge202006;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution0613 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length ==0) return Collections.emptyList();
        if (nums.length ==1) return Collections.singletonList(nums[0]);
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        List<Integer> added =  new ArrayList<>();
        int max =-1;
        int maxIndex = -1;
        for (int i = 1; i <len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }
        //System.out.println(maxIndex);
        int curNum = max;
        int tmp = nums[maxIndex];
        for (int i= maxIndex; i >=0 ; i--) {
            if (tmp % nums[i]==0 && dp[i] == curNum) {
                added.add(nums[i]);
                tmp = nums[i];
                curNum--;
            }
        }
        return added;
    }

    public static void main(String[] args) {
        Solution0613 s = new Solution0613();
        //int[] nums={1,2,3};
        //int[] nums={3, 4, 8};
        //int[] nums={1};
        int[] nums={4, 8, 10, 240};
        final List<Integer> result = s.largestDivisibleSubset(nums);
        System.out.println(result);
    }
}