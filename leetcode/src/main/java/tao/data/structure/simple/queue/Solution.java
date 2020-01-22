package tao.data.structure.simple.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * Q: A ->
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        LinkedList<Character> queue1 = new LinkedList<Character>();
        for (int i=0; i<tasks.length; i++){
            queue1.add(tasks[i]);
        }
        int count =0;
        Character preivous = null;
        Character current = null;
        while(!queue1.isEmpty()){
            current = queue1.pop();
            count++;
            if (preivous == null) {
                preivous = current;
            } else {
            }

        }

        return count;
    }
}

