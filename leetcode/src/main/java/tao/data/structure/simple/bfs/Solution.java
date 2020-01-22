package tao.data.structure.simple.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 207 impossible bfsti judge for a cycle
 */
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        final List<List<Integer>> graph = preprocessing(numCourses, prerequisites, degree);
        Queue<Integer> queue = new LinkedList<Integer>();

        int[] visited = new int[numCourses];

        for (int i=0; i<numCourses;i++){
            if (degree[i]==0){
                visited[i]=1;
                queue.add(i);
            }
        }
        if (queue.size() ==0) return false;
        while (!queue.isEmpty()){
            final Integer current = queue.poll();
            final List<Integer> adjVertices = graph.get(current);
            for (int i=0; i<adjVertices.size();i++){
                final Integer next = adjVertices.get(i);
                if (visited[next] == 0){
                    visited[next]=1;
                    queue.add(next);
                }else if (visited[next] == 1 || visited[next] == 2 ) return false;
            }
            visited[current] = 2;
        }
        return true;
    }

    private List<List<Integer>>  preprocessing(int numCourses, int[][] prerequisites, int[] degree) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for (int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<prerequisites.length;i++){
            Integer first = prerequisites[i][0];
            Integer second = prerequisites[i][1];

            graph.get(second).add(first);
            degree[first]++;
        }
        return graph;
    }
}
