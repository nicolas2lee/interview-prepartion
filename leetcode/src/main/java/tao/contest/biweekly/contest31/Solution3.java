package tao.contest.biweekly.contest31;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public int numSplits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> leftMap = new HashMap<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final char cur = chars[i];
            if (map.containsKey(cur)) map.put(cur, map.get(cur)+1);
            else map.put(cur, 1);
        }
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            final char cur = chars[i];
            if (leftMap.containsKey(cur)) leftMap.put(cur, leftMap.get(cur)+1);
            else leftMap.put(cur, 1);

            if ( map.get(cur) <=1) map.remove(cur);
            else map.put(cur, map.get(cur)-1);

            if (leftMap.size() == map.size()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        String str = "aacaba";
        final int ans = s.numSplits(str);
        System.out.println(ans);
    }
}

