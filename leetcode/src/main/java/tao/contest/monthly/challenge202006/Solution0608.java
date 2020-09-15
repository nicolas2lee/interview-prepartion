package tao.contest.monthly.challenge202006;

/**
 * https://github.com/tianyicui/pack/blob/master/V2.pdf
 */
class Solution0608 {
    public boolean isPowerOfTwo(int n) {
        if (n<0) return false;
        final char[] str = Integer.toBinaryString(n).toCharArray();
        int num=0;
        for (int i=0; i<str.length; i++){
            num+= str[i] == '1' ? 1:0;
        }
        return num==1;
    }
}
