package tao.data.structure.simple.string.longest.palindromic.string;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        char[] charArray = s.toCharArray();
        int max =0;
        int firstIndex=-1;
        for (int i=0; i<charArray.length;i++){
            //for odd
            int j=0;
            while (i+j < charArray.length && i-j>=0 && j<=i){
                if (charArray[i+j] != charArray[i-j]) break;
                j++;
            }
            j-=1;
            if (2*j+1> max){
                max = 2*j+1;
                firstIndex = i-j;
            }
            //for even
            int k=0;
            while (i+k < charArray.length && i-k-1>=0){
                if (charArray[i+k]!=charArray[i-1-k])break;
                k++;
            }
            k-=1;
            if (2*(k+1)> max){
                max = 2*(k+1);
                firstIndex = i-k-1;
            }
        }
        return s.substring(firstIndex, firstIndex+max);
    }

    public static void main(String[] args) {
/*        Solution solution = new Solution();
        final String result = solution.longestPalindrome("babad");
        System.out.println(result);
        Map<String, Integer> map = new HashMap<>();
        map.entrySet().forEach(x->x.getValue());
        for (Map.Entry<String, Integer> x: map.entrySet()){

        }*/
        String paragraph="a, a, a, a, b,b,b,c, c";
        String[] str = paragraph.replaceAll("[^a-zA-Z\\s]", " ").split(" ");
    }
}