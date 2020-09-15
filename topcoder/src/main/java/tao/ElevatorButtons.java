package tao;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorButtons {

    public int[] nextStops(int currentFloor, int currentDirection, int[] buttonsPressed) {
        final List<Integer> list = Arrays.stream(buttonsPressed)
                .boxed()
                .collect(Collectors.toList());
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(list);

        //Get back the array without duplicates
        Integer[] newArray = linkedHashSet.toArray(new Integer[] {});
        Arrays.sort(newArray);
        int[] result = new int[newArray.length];
        int k=0;

        if (currentDirection >0){
            int index =-1;
            for (int i=0; i<newArray.length;i++){
                if (newArray[i]>= currentFloor){
                    index = i;
                    break;
                }
            }
            for (int i=index; i<newArray.length;i++){
                result[k++] = newArray[i];
            }
            for (int i=index-1; i>=0;i--){
                result[k++] = newArray[i];
            }
        }else{
            int index =-1;
            for (int i=0; i<newArray.length;i++){
                if (newArray[i]<= currentFloor){
                    index = i;
                    break;
                }
            }
            for (int i=index; i>=0;i--){
                result[k++] = newArray[i];
            }
            for (int i=index+1; i<newArray.length;i++){
                result[k++] = newArray[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ElevatorButtons o = new ElevatorButtons();
        int[] arrays = {47, 47,47,47,47};
        int[] result = o.nextStops(10, -1, arrays);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
