package tao.contest.biweekly.contest29;


class Solution1 {

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum =0;
        for (int s: salary){
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum+=s;
        }
        return (sum-min-max)*1.0/(salary.length-2);
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
    }

}

