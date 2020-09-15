package tao.contest.monthly.challenge202006;
class Solution0606 {
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        boolean visited[] = new boolean[length];
        int[] count = new int[length];
        int[][] ans = new int[length][2];
        for (int i=0; i<length; i++) count[i] = people[i][1];
        for (int i=0; i<length; i++){
            int minIndex = -1;
            for (int j=0; j<length; j++){
                if (!visited[j] && people[j][1] <= i){
                    if (minIndex == -1) minIndex =j;
                    else {
                        if (count[j] < count[minIndex] || (count[j]  == count[minIndex] && people[j][0] < people[minIndex][0])){
                            minIndex =j;
                        }
                    }
                }
            }
            ans[i] = people[minIndex];
            visited[minIndex] = true;
            for (int j=0; j<length; j++){
                int num=0;
                if (!visited[j]){
                    if (people[j][0] <= ans[i][0]) count[j]--;
                }
                System.out.print(count[j]+",");
            }
            System.out.println();
        }
        return ans;

    }
}