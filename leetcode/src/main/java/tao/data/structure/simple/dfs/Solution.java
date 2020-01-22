package tao.data.structure.simple.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * AC
 *
 * dfs all vertex
 * since it is possible in below case:
 *
 *        0
 * 5 ->        -> 1
 *        <-
 *        +
 *   4 <- 6 -> 2
 *
 */
class Solution {

    boolean flag = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> graph = preprocessing(numCourses, prerequisites);
        int[] visited = new int[numCourses];


        for (int i=0; i<numCourses;i++){
            dfs(i, graph, visited);
        }
        return flag;
    }

    private void dfs(Integer current, List<List<Integer>> graph, int[] visited) {
        visited[current] =1;
        final List<Integer> adjVertices = graph.get(current);
        for (int i=0; i<adjVertices.size();i++){
            final Integer next = adjVertices.get(i);
            if (visited[next] == 0){
                dfs(next, graph, visited);
            }else {
                if (visited[next] ==1) {
                    flag=false;
                    return;
                }
            }
        }
        visited[current] =2 ;
    }

    private List<List<Integer>>  preprocessing(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for (int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<prerequisites.length;i++){
            Integer first = prerequisites[i][0];
            Integer second = prerequisites[i][1];

            graph.get(second).add(first);
        }
        return graph;
    }
}