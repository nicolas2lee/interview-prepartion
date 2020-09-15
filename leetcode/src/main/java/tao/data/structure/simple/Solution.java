package tao.data.structure.simple;// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import java.util.*;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        Arrays.copyOf(states, states.length);
        int[] previous = Arrays.copyOf(states, states.length);
        int[] current = Arrays.copyOf(states, states.length);
        for (int i=0; i<days;i++){
            for (int j=0; j<previous.length;j++){
                if (j==0){
                    if (previous[j+1] == 0) {
                        current[j] = 0;
                    }else{
                        current[j] = 1;
                    }
                }else if (j==previous.length-1){
                    if (previous[j-1] == 0){
                        current[j]=0;
                    }else {
                        current[j] =1;
                    }
                }else {
                    current[j] = previous[j-1] == previous[j+1] ? 0:1;
                }
            }
            previous = Arrays.copyOf(current, current.length);
        }
        final ArrayList<Integer> result = new ArrayList<>();
        Arrays.stream(previous).forEach(result::add);
        return result;
    }


    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        int[] cells = {1,0,0,0,0,1,0,0};
        Solution solution = new Solution();
 //       final List<Integer> result = solution.cellCompete(cells, 1);
 //       result.forEach(System.out::println);

        for (int i=0; i<10;i++){
            for (int j=0; i-j>0 && i+j<10; j++){
                System.out.println('a' =='a');
                System.out.println(j);
            }
        }
    }
}