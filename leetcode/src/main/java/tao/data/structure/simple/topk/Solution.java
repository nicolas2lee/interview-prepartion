package tao.data.structure.simple.topk;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    class WordStats{
        String word;
        int count;
        Set<Integer> indexs;
        public WordStats(String word, int count){
            this.word =word;
            this.count = count;
            this.indexs =new HashSet<>();
        }
    }
    public ArrayList<String> topNCompetitors(int numToys,
                                             int topToys,
                                             List<String> toys,
                                             int numQuotes,
                                             List<String> quotes) {
        // WRITE YOUR CODE HERE
        Set<String> toySet = new HashSet<>();
        toySet.addAll(toys);
        Map<String, WordStats> map = new HashMap<>();
        for (int i=0; i<numQuotes;i++){
            String review = quotes.get(i)
                    //.replaceAll("[\\?!,;.]", "")
                    .toLowerCase();
            String[] words =review.split(" ");
            for (int j=0; j<words.length;j++){
                String current = words[j];
                if (toySet.contains(current)){
                    WordStats stats = map.containsKey(current) ?
                            map.get(current): new WordStats(current,0);
                    stats.count++;
                    map.put(current, stats);
                }
            }
        }
        PriorityQueue<WordStats> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count != o2.count) {
                return o2.count - o1.count;
            } else return o1.word.compareTo(o2.word);
        });
        pq.addAll(map.values());
        ArrayList<String> res = new ArrayList<>();
        if (topToys > pq.size()){
            for (int i=0; i<numToys && !pq.isEmpty();i++){
                res.add(pq.poll().word);
            }
        }else{
            for (int i=0; i<pq.size();i++){
                res.add(pq.poll().word);
            }
        }
        return res;
    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> toys = new ArrayList<>(Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft"));
        List<String> quotes = new ArrayList<>(Arrays.asList("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"));
        final ArrayList<String> result = solution.topNCompetitors(6, 2, toys, 6, quotes);
        result.forEach(System.out::println);
    }
}