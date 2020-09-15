package tao.data.structure.simple.tarjan;

import java.util.*;
import java.lang.*;
import java.io.*;

import static java.lang.Math.min;

/**
 *      10 15
 * 5 4 6 6 3 9 9 5 2 1 3 0 9 9 1 3 4 5 8 5 7 3 3 8 9 5 5 3 8 6
 */
class GFG {
    Integer[] dfn;
    Integer[] low;
    ArrayList<Integer>[] graph;
    boolean[] visited;
    Stack<Integer> stack;
    int count=1;

    public static void main (String[] args) {
        GFG gfg = new GFG();
        Scanner scanner = new Scanner(System.in);
        final int nbCase = scanner.nextInt();
        for (int cas=0; cas<nbCase;cas++){
            final int vertexs = scanner.nextInt();
            final int edges = scanner.nextInt();
            gfg.dfn = new Integer[vertexs];
            gfg.low = new Integer[vertexs];
            gfg.graph = new ArrayList[vertexs];
            for (int i=0; i< gfg.graph.length; i++){
                gfg.graph[i] = new ArrayList<>();
            }
            gfg.visited = new boolean[vertexs];

            for (int i=0; i<edges; i++){
                final int start = scanner.nextInt();
                final int end = scanner.nextInt();
                if (start!=end)
                    gfg.graph[start].add(end);
            }
            for (int i=0; i< vertexs; i++){
                if (!gfg.visited[i]){
                    gfg.stack = new Stack<>();
                    gfg.dfs(i);
                }
            }
            if (nbCase!=1)
            System.out.println();
        }
    }

    private void dfs(int current) {
        dfn[current] = low[current]  = count++;
        visited[current] = true;
        stack.add(current);
        final ArrayList<Integer> edgeList = graph[current];
        for(int i=0; i< edgeList.size(); i++){
            final Integer nextVertex = edgeList.get(i);
            if (!visited[nextVertex]){
                dfs(nextVertex);
                low[current] = min(low[current], low[nextVertex]);
            }else{
                if (stack.contains(nextVertex)){
                    low[current] = min(low[current], dfn[nextVertex]);
                }
            }
        }
        if (dfn[current] == low[current]){
            while (stack.peek()!=current){
                final Integer element = stack.pop();
                System.out.print(element+" ");
            }
            stack.pop();
            System.out.print(current+",");
        }
    }
}