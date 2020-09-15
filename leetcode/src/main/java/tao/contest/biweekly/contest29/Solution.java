package tao.contest.biweekly.contest29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 8
 * [[1,6],[2,7],[8,7],[2,5],[3,4]]
 * 3
 *
 *
 * 8
 * [[5,1],[3,4],[2,6],[3,6],[5,6],[6,8],[3,8],[5,8],[7,6],[7,4],[1,4],[8,4],[2,8]]
 * 2
 *
 * 5
 */
class Solution {
    static class Point{
        int val;
        int indegree;
        int outdegree;

        public Point(int val, int indegree, int outdegree) {
            this.val = val;
            this.indegree = indegree;
            this.outdegree = outdegree;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "val=" + val +
                    ", indegree=" + indegree +
                    ", outdegree=" + outdegree +
                    '}';
        }
    }
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        ArrayList[] map = new ArrayList[n];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList();
        }
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        //int[] outdegree = new int[n];
        for (int[] edge :
                dependencies) {
            map[edge[0]-1].add(edge[1]-1);
            indegree[edge[1]-1] += 1;
            outdegree[edge[0]-1]+=1;
        }
        int nbSemestre =0;
        List<Integer> doneVertex =  new ArrayList<>();
        while (doneVertex.size() < n){
            PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2)->{
                return o2.outdegree - o1.outdegree;
            });
            //find indegree 0
            for (int i = 0; i < indegree.length; i++) {
                if (!doneVertex.contains(i) && indegree[i]==0)  {
                    pq.add(new Point(i, indegree[i], outdegree[i]));
                }
            }
            List<Integer> zeroIndegreeVertex = new ArrayList<>();
            if (pq.size()< k){
                while (!pq.isEmpty()){
                    //final Object[] array =  pq.toArray();
                    //Arrays.stream(array).forEach(System.out::println);
                    final Point cur = pq.poll();
                    //System.out.print("cur:");
                    //System.out.println(cur);
                    zeroIndegreeVertex.add(cur.val);
                }
            }else{
                for (int i = 0; i < k; i++) {
                    //final Object[] array =  pq.toArray();
                    //Arrays.stream(array).forEach(System.out::println);
                    final Point cur = pq.poll();
                    //System.out.print("cur:");
                    //System.out.println(cur);
                    zeroIndegreeVertex.add(cur.val);
                    //doneVertex.add(pq.poll().val);
                }
            }
            //System.out.println("debug info:");
            //zeroIndegreeVertex.forEach(
            //        System.out::println
            //);
            doneVertex.addAll(zeroIndegreeVertex);
            //update nbsemestre
            //final int zeroIndegreeVertexSize = zeroIndegreeVertex.size();
            nbSemestre++;

            //nbSemestre+= k % zeroIndegreeVertexSize == 0 ? zeroIndegreeVertexSize/k: zeroIndegreeVertexSize/k+1;
            // remove edge & update indegree
            for (int vertex :
                    zeroIndegreeVertex) {
                final ArrayList<Integer> edgeList = map[vertex];
                for (int v :
                        edgeList) {
                    indegree[v]--;
                }
            }
        }
        return nbSemestre;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n=8;

        int[][] dep = {{5,1},{3,4},{2,6}, {3, 6}, {5,6}, {6,8},{3,8},{5,8},{7,6},{7,4},{1,4},{8,4},{2,8}};
        int k=2;
        final int result = s.minNumberOfSemesters(n, dep, k);
        System.out.println(result);
    }
}