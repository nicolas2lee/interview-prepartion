package tao.contest.monthly.challenge202006;

import java.util.Arrays;

class Solution0605 {

    int[] w;
    double[] p;
    int sum=0;
    public Solution0605(int[] w) {
        this.w = w;
        this.p = new double[w.length];
        preprocessing();
    }

    public int pickIndex() {
        final double random = Math.random();
        int index = Arrays.binarySearch(p, random);
        if (index <0) index = -index-1;
        index = index > w.length-1 ? w.length-1 : index;
        return index;
    }

    public void preprocessing() {
        for (int i=0; i<w.length;i++) sum+=w[i];
        for (int i=0; i<w.length;i++) {
            if (i==0) p[i] = w[i]*1.0/sum;
            else {
                p[i] = p[i-1]+w[i]*1.0/sum;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {3, 14, 1, 7};
        Solution0605 s = new Solution0605(array);
        for (int i=0; i<100;i++){
            System.out.println(s.pickIndex());
        }
    }
}

/**
 * Your Solution0605 object will be instantiated and called as such:
 * Solution0605 obj = new Solution0605(w);
 * int param_1 = obj.pickIndex();
 */