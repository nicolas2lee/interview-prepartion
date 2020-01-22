package tao.data.structure.simple.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
class SolutionStack {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<List<Integer>> graph = preprocessing(numCourses, prerequisites);


        boolean flag = true;
        for (int i=0; i<numCourses;i++){
            final boolean result = dfs(i, graph, numCourses);
            flag = flag && result;
        }
        return flag;
    }

    private boolean dfs(Integer source, List<List<Integer>> graph, int numCourses) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] visited = new int[numCourses];
        visited[source] =1;
        stack.add(source);

        while (!stack.isEmpty()){
            final Integer current = stack.peek();
            visited[current] = 1;
            boolean pushedInotStack = false;
            final List<Integer> adjVertices = graph.get(current);
            for (int i=0; i<adjVertices.size();i++){
                final Integer next = adjVertices.get(i);
                if (visited[next] == 0){
                    stack.push(next);
                    pushedInotStack = true;
                    break;
                }else {
                    if (visited[next] ==1) {
                        return false;
                    }
                }
            }
            if (!pushedInotStack) {
                visited[current] = 2;
                stack.pop();
            }

        }
        return true;
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