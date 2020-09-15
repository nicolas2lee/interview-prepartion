package tao.codeforces.educational.round81;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 6 10
 * 010010 010010 010010
 */

public class Solution2 {

    public static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int cas = sc.nextInt();
        while (cas-- > 0){
            int n = sc.nextInt();
            int bal = sc.nextInt();
            final String str = sc.next();
            char[] charArray = str.toCharArray();
            int nb0 =0;
            int nb1 =0;
            for (int i=0; i<charArray.length;i++){
                if (charArray[i]=='0'){
                    nb0++;
                }else nb1++;
            }
            if (bal==0 && nb0-nb1 !=0){
                System.out.println(1);
            }else if (nb1-nb0 ==0){
                System.out.println(-1);
            }else if (nb0-nb1 <0){
                System.out.println(0);
            } else{
                int count=-1;
                final int nbRecycle = bal / (nb0 - nb1);
                if (bal%(nb0-nb1)==0){
                    count=1;
                }
                final List<Integer> possibleList = getPossibleList(charArray);
                for (int i=0; i<possibleList.size();i++){
                    if (bal-(nbRecycle-1)*(nb0 - nb1)== possibleList.get(i)){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }

    }

    private static List<Integer> getPossibleList(char[] charArray) {
        List<Integer> possibleValues = new ArrayList<>();
        int delt =0;
        for (int i=0; i<charArray.length;i++){
            if (charArray[i]=='0'){
                delt++;
            }else delt--;
            possibleValues.add(delt);
        }
        return possibleValues;
    }
}
