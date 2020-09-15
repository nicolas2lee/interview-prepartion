package tao.contest.biweekly.contest28;


class Solution1 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i=0; i< prices.length;i++){
            int minv = 0;
            for (int j=i+1; j<prices.length; j++){
                if (prices[j]<=prices[i]) {
                    minv = prices[j];
                    break;
                }
            }
            ans[i] =  prices[i] - minv;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {8,4,6,2,3};
        final int[] result = s.finalPrices(arr);
        for (int e : result) {
            System.out.print(e+",");
        }
    }

}

