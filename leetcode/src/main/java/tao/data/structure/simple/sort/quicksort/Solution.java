package tao.data.structure.simple.sort.quicksort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> sortArray(int[] nums) {
        quicksort(0, nums.length-1, nums);
        return Arrays.stream(nums).boxed()
                .collect(Collectors.toList());
    }

    void quicksort(int start, int end, int[] nums){
        if (start>=end) return;
        int i=start, j=end, pivot = nums[(j+i)/2];

        while (i<=j){
            while (nums[i] < pivot && i <= j) i++ ;
            while (nums[j] > pivot && i <= j) j-- ;
            if (i<=j){
                int tmp = nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;
                j--;
            }
        }
        quicksort(start, j, nums);
        quicksort(i, end, nums);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,1,1,2,0,0};
        solution.sortArray(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}