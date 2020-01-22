package tao.data.structure.simple.unionfind;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "["+i+','+j+"]";
        }
    }
    Pair[][] father;
    int rowLength;
    int columnLength;
    public int numIslands(char[][] grid) {
        if (grid.length==0) return 0;
        father = new Pair[grid.length][grid[0].length];
        rowLength= grid.length;
        columnLength = grid[0].length;
        father = new Pair[rowLength][columnLength];
        for (int i=0; i<grid.length;i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j]=='0'){
                    father[i][j]= new Pair(-1, -1);
                }else father[i][j]=new Pair(i, j);
            }
        }
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (i+1<grid.length){
                    if (grid[i][j]==grid[i+1][j] && grid[i][j]=='1'){
                        union(i,j, i+1,j);
                    }
                }
                if (i-1 >0){
                    if (grid[i][j]==grid[i-1][j] && grid[i][j]=='1'){
                        union(i,j, i-1,j);
                    }
                }
                if (j+1<grid[0].length){
                    if (grid[i][j]==grid[i][j+1] && grid[i][j]=='1'){
                        union(i,j, i,j+1);
                    }
                }
                if (j-1>0){
                    if (grid[i][j]==grid[i][j-1] && grid[i][j]=='1'){
                        union(i,j, i,j-1);
                    }
                }
            }
        }
        List<Pair> result = new ArrayList<>();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                //System.out.print(father[i][j]);
                if (grid[i][j]!='0'){
                    Pair fatherPair = find(i, j);
                    if (fatherPair != new Pair(-1,-1)){
                        if (!result.contains(fatherPair)){
                            result.add(fatherPair);
                        }
                    }
                }
            }
            //System.out.println();
        }
        return result.size();
    }
    Pair find(int i, int j){
        Pair fatherPair = father[i][j];
        if (!fatherPair.equals(new Pair(i, j))){
            fatherPair = find(fatherPair.i, fatherPair.j);
        }
        return fatherPair;
    }

    void union(int i1, int j1, int i2, int j2){
        Pair firstFather = find(i1, j1);
        Pair secondFather = find(i2, j2);
        if (firstFather==secondFather) return;
        father[firstFather.i][firstFather.j]=secondFather;
    }

    public static void main(String[] args) {
     /*   char[][] map=
        {{'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}};*/
        char[][] map={};
        Solution solution= new Solution();
        final int result = solution.numIslands(map);
        System.out.println(result);
    }
}
