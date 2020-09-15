package tao;

public class MemoryGame {
    public  long countSteps(int N, int seed){
        Integer[] integers = generateLocation(N, seed);
        while (true){

        }
    }

    private Integer[] generateLocation(int n, int seed) {
        Integer[] location = new Integer[2*n];
        for (int i=0; i<2*n;i++){
            location[i] =i/2;
        }
        int state = seed;
        for (int i=2*n-1;i>=0;i--){
            int j = state %(i+1);
            swap(i,j, location);
            final double pow = Math.pow(2, 31);
            state = (state * 1103515245 + 12345) % (int) pow;
        }
        return location;
    }

    private void swap(int i, int j, Integer[] location) {
        Integer tmp = null;
        tmp = location[i];
        location[i] = location[j];
        location[j] = tmp;
    }
}
