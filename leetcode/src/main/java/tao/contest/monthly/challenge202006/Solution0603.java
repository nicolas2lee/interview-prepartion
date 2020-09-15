package tao.contest.monthly.challenge202006;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 *
 * 1859
 */

/**
 * 54 1 1
 * 118 4 1
 * 139 3 1
 * 184 3
 * 259 0 0
 * 448 1
 * 469 5 1
 * 577 5
 * 667 2 1
 * 770 0
 * 840 4
 * 926 2
 */
class Solution0603 {
    public class Edge{
        int a;
        int b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        List<Edge> edgeList= new ArrayList<>();
        final int n = costs.length;
        for (int i=0; i<costs.length;i++){
            final Edge edge = new Edge(costs[i][0], costs[i][1]);
            edgeList.add(edge);
        }
        edgeList.sort(Comparator.comparingInt(e -> e.a - e.b));
        int sum =0;
        for (int i=0; i<edgeList.size();i++){
            final Edge cur = edgeList.get(i);
            if (i<n/2)
                sum+= cur.a;
            else
                sum+=cur.b;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] cost = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        Solution0603 s = new Solution0603();
        final int result = s.twoCitySchedCost(cost);
        System.out.println(result);
    }
}