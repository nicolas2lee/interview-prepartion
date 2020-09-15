package tao.contest.biweekly.contest28;


import java.util.Arrays;

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int[] interval = new int[houses.length-1];
        //when houses empty or only 1
        for (int i = 1; i < houses.length; i++) {
            interval[i-1] = houses[i]-houses[i-1];
        }
        int sum =0;
        if (k==1){
            int p = (houses[0] + houses[houses.length-1])/2;
            final int resultMiddle = calculateDist(p, houses);
            sum = Math.min(calculateDist(houses[houses.length / 2], houses), resultMiddle);
            sum = Math.min(calculateDist(houses[houses.length / 2+1], houses), sum);
            return sum;

        } else {
            int max =-1;
            for (int i = 0; i < interval.length ; i++) {
                if (interval[i] >max) {
                    max =interval[i];
                }
            }
            int[] newHouses = new int[houses.length-1];
            for (int i = 0; i < houses.length-2; i++) {
                newHouses[i] = houses[i];
            }
            sum+=minDistance(newHouses, k-1);
        }
        return sum;
    }


    private int calculateDist(int p, int[] houses) {
        int sum=0;
        for (int i = 0; i < houses.length; i++) {
            sum+= Math.abs(houses[i] - p );
        }
        return sum;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,3,6,7,13};
        final int result = s.minDistance(arr, 2);
        //10
        System.out.println(result);
    }

}

