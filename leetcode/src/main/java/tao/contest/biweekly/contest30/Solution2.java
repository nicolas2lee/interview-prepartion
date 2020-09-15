package tao.contest.biweekly.contest30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur+=nums[j];
                list.add(cur);
            }
        }
        //System.out.println(list.size());
        Collections.sort(list);
        //list.forEach(x-> System.out.print(x+","));
        //System.out.println();
        long sum=0l;
        for (int i = left-1; i < right; i++) {
            sum+=list.get(i);
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {1,2,3,4};
        final int result = s.rangeSum(arr, 4, 1, 5);
        System.out.println(result);
    }
}