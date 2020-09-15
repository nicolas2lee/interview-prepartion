package tao.contest.biweekly.contest31;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public int numOfSubarrays(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum=0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                if (sum%2==1) list.add(sum);
            }
        }
        return list.size()%1000000007;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {100,100,99,99};
        final int result = s.numOfSubarrays(arr);   
        System.out.println(result);
    }
}

