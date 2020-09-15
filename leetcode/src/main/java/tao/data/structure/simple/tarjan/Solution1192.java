package tao.data.structure.simple.tarjan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution1192 {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    Integer[] dfn;
    Integer[] low;
    Stack<Integer> stack;
    Integer count =1;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        dfn = new Integer[n];
        low = new Integer[n];
        visited=new boolean[n];
        graph = new ArrayList[n];
        for (int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i< connections.size();i++){
            List<Integer> con = connections.get(i);
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        stack = new Stack<>();
        dfs(0, -1);
        return result;
    }

    public void dfs(int current, int parent){
        dfn[current]=low[current]=count++;
        visited[current] = true;
        stack.add(current);
        for (int i=0; i<graph[current].size(); i++){
            Integer nextVertex = graph[current].get(i);
            if (!visited[nextVertex]){
                dfs(nextVertex, current);
                low[current] = Math.min(low[current], low[nextVertex]);
                if (low[nextVertex]>dfn[current]){
                    result.add(Arrays.asList(current, nextVertex));
                }
            }else{
                if (stack.contains(nextVertex) && nextVertex!=parent){
                    low[current] = Math.min(low[current], dfn[nextVertex]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1192 s = new Solution1192();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(0,1));
        input.add(Arrays.asList(1,2));
        input.add(Arrays.asList(2,0));
        input.add(Arrays.asList(1,3));
        final List<List<Integer>> result = s.criticalConnections(4, input);
        result.forEach(System.out::println);
    }
}