package tao.contest;

import java.util.Arrays;

class Solution1 {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] used = new int[chars.length];
        char[] resultArray = new char[chars.length];
        Arrays.sort(chars);
        int resultIndex=0;

        //resultArray[i]=chars[i];
        //char current = chars[i];
        //used[i]=1;
        //i++; resultIndex++;
        while (resultIndex<chars.length){
            //find small
            int left=0;
            char current= 'a';
            while(left<chars.length){
                if (used[left]==0){
                    current = chars[left];
                    resultArray[resultIndex++]= chars[left];
                    used[left]=1;
                    left++;
                    break;
                }else left++;
            }
            while(left<chars.length){
                if (used[left]==0 && chars[left]>current){
                    resultArray[resultIndex++]= chars[left];
                    current = chars[left];
                    used[left]=1;
                    left++;
                }else{left++;}
            }
            //find big part
            int right=chars.length-1;
            char currentR= 'a';
            while(right>=0){
                if (used[right]==0){
                    currentR = chars[right];
                    resultArray[resultIndex++]= chars[right];
                    used[right]=1;
                    right--;
                    break;
                }else right--;
            }
            while(right>=0){
                if (used[right]==0 && chars[right]<currentR){
                    resultArray[resultIndex++]= chars[right];
                    currentR = chars[right];
                    used[right]=1;
                    right--;
                }else{right--;}
            }
        }
        return new String(resultArray);
    }

    public static void main(String[] args) {
        Solution1 solution =new Solution1();
        final String result = solution.sortString("aaaabbbbcccc");
        System.out.println(result);
    }
}