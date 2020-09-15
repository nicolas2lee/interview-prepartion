package tao.data.structure.simple.slidingwindow;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * max sliding window
 *  239
 */
class SolutionMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int index =0;
        for (int i=0; i<nums.length;i ++){
            while (!dq.isEmpty() && i-dq.peekFirst()>=k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if (i>=k-1){
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        SolutionMax s = new SolutionMax();
        int[] nums= {1,3,1,2,0,5};
        final int[] result = s.maxSlidingWindow(nums, 3);
        Arrays.stream(result).forEach(System.out::println);
    }
}
