package tao.current;

public class ArraySorting {

    public int[] arraySort(int[] A) {
        for (int i=0; i<A.length-1;i++){
            if (A[i]>A[i+1]){
                if (i==0){
                    A[i]=1;
                } else{
                    A[i+1]=A[i];
                }
            }
        }
        return A;

    }

    public static void main(String[] args) {
        ArraySorting o = new ArraySorting();
        //final String result = o.operate("abracadabra", new int[]{-3});
        //System.out.println(result);
    }

}
