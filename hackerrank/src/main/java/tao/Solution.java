import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'awardTopKHotels' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING positiveKeywords
     *  2. STRING negativeKeywords
     *  3. INTEGER_ARRAY hotelIds
     *  4. STRING_ARRAY reviews
     *  5. INTEGER k
     */
    static class HotelStat{
        int hotelId;
        int score;
        public HotelStat(int hotelId, int score){
            this.hotelId = hotelId;
            this.score =score;
        }
    }
    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        // Write your code here
        Set<String> positiveKeywordsArr = convertArrayToSet(positiveKeywords.toLowerCase().split(" "));
        Set<String> negativeKeywordsArr = convertArrayToSet(negativeKeywords.toLowerCase().split(" "));

        Map<Integer, HotelStat> map = new HashMap<>();
        for (int i=0; i<reviews.size(); i++){
            String review = reviews.get(i).replaceAll("[\\,.?!]", "").toLowerCase();
            String[] words =review.split(" ");
            Integer hotelId = hotelIds.get(i);
            for (int j=0; j<words.length;j++){
                String currentWord = words[j];
                HotelStat hotelStat = map.containsKey(hotelId) ?
                        map.get(hotelId): new HotelStat(hotelId, 0);
                if (positiveKeywordsArr.contains(currentWord)){
                    hotelStat.score+=3;
                    map.put(hotelId, hotelStat);
                }else if (negativeKeywordsArr.contains(currentWord)){
                    hotelStat.score -=1;
                    map.put(hotelId, hotelStat);
                }
            }
        }
        PriorityQueue<HotelStat> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            } else return o1.hotelId - o2.hotelId;
        });
        pq.addAll(map.values());
        List<Integer> res = new ArrayList<>();
        int nb=0;
        while(!pq.isEmpty()) {
            if (nb>k) break;
            res.add(pq.poll().hotelId);
            nb++;
        }
        return res;
    }

    public static Set<String> convertArrayToSet(String[] array) {
        Set<String> set = new HashSet<>();
        for (String t : array) {
            set.add(t);
        }
        return set;
    }

}