package tao.data.structure.simple.topk;

import java.util.*;

class Solution347 {
    static class NumberStat {
        Integer num;
        Integer count;

        public NumberStat(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, NumberStat> map = new HashMap<>();
        PriorityQueue<NumberStat> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.count - o1.count;
        });

        for (Integer num: nums){
            if (map.containsKey(num)){
                final NumberStat numberStat = map.get(num);
                numberStat.count+=1;
                map.put(num, numberStat);
            }else{
                map.put(num, new NumberStat(num, 0));
            }
        }
        pq.addAll(map.values());
        List<Integer> result = new ArrayList<>();
        if (pq.size()>=k){
            for (int i=0; i<k;i++){
                final NumberStat current = pq.poll();
                result.add(current.num);
            }
        }else{
            while (!pq.isEmpty()){
                final NumberStat current = pq.poll();
                result.add(current.num);
            }
        }
        return result;

    }
}