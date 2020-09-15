package tao.contest.weekly.virtual187;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1436 {

    public String destCity(List<List<String>> paths) {
        final Map<String, Integer> outDegrees = buildGraph(paths);
        for (Map.Entry<String, Integer> e : outDegrees.entrySet()) {
            if (e.getValue() == 0){
                return e.getKey();
            }
        }
        return "";
    }

    private Map<String, Integer> buildGraph(List<List<String>> paths) {
        Map<String, Integer> outDegrees = new HashMap<>();
        paths.forEach(path -> {
            final String src = path.get(0);
            final String dst = path.get(1);
            if (outDegrees.containsKey(src)){
                final Integer val = outDegrees.get(src);
                outDegrees.put(src, val+1);
            }else {
                outDegrees.put(src, 1);
            }
            if (!outDegrees.containsKey(dst))
                outDegrees.put(dst, 0);
        });
        return outDegrees;
    }

}