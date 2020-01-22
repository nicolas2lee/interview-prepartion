package tao.data.structure.simple.topological.sort;

import java.util.*;

class Solution {

    private static final int[] EMPTY_ARRAY = {};

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        final List<List<Integer>> graph = preprocessing(numCourses, prerequisites, indegree);
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses;i++){
            if (indegree[i] == 0) queue.add(i);
        }
        int[] ans = new int[numCourses];
        int count=0;
        while (!queue.isEmpty()){
            final Integer current = queue.poll();
            ans[count++] = current;
            final List<Integer> adjVertices = graph.get(current);
            for (int i=0; i<adjVertices.size();i++){
                final Integer next = adjVertices.get(i);
                indegree[next]--;
                if (indegree[next] ==0)queue.add(next);
            }
        }
        if (count < numCourses-1) return EMPTY_ARRAY;
        return ans;
    }

    private List<List<Integer>>  preprocessing(int numCourses, int[][] prerequisites, int[] indegree) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for (int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<prerequisites.length;i++){
            Integer first = prerequisites[i][0];
            Integer second = prerequisites[i][1];

            graph.get(second).add(first);
            indegree[first]++;
        }
        return graph;
    }
}