package tao.contest.weekly.virtual187;

import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    class Point{
        int value;
        int index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        TreeSet<Point> ts = new TreeSet<>((x1, x2) -> x1.value == x2.value ? x1.index - x2.index : x1.value -x2.value);
        for (int i =0; i<nums.length; i++){
            ts.add(new Point(nums[i], i));
            if (ts.last().value - ts.first().value > limit){
          //      ts.
            }
        }
        //return Math.max(longestSeq, seq);
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,5,2};
        final int result = s.longestSubarray(nums, 9);
        System.out.println(result);

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        //tm.getOrDefault(curr, 0)
    }
}
