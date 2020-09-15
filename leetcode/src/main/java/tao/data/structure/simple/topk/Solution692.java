package tao.data.structure.simple.topk;

import java.util.*;

class Solution692 {
    static class WordStat{
        String word;
        Integer count;

        public WordStat(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, WordStat> map = new HashMap<>();
        PriorityQueue<WordStat> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count != o2.count) {
                return o2.count - o1.count;
            } else return o1.word.compareTo(o2.word);
        });

        for (String word: words){
            if (map.containsKey(word)){
                final WordStat wordStat = map.get(word);
                wordStat.count+=1;
                map.put(word, wordStat);
            }else{
                map.put(word, new WordStat(word, 0));
            }
        }
        pq.addAll(map.values());
        List<String> result = new ArrayList<>();
        if (pq.size()>=k){
            for (int i=0; i<k;i++){
                final WordStat current = pq.poll();
                result.add(current.word);
            }
        }else{
            while (!pq.isEmpty()){
                final WordStat current = pq.poll();
                result.add(current.word);
            }
        }
        return result;

    }
}