package tao.data.structure.simple.heap;

import java.util.PriorityQueue;

class Solution {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode currentNode = head;
        while(currentNode !=null){
            pq.add(currentNode.val);
            currentNode=currentNode.next;
        }
        ListNode finalhead = null;
        ListNode tmp = null;
        while (!pq.isEmpty()){
            final Integer current = pq.poll();
            if (tmp == null) {
                finalhead = new ListNode(current);
                tmp = finalhead;
            }
            else {
                tmp.next = new ListNode(current);
                tmp = tmp.next;
            }
        }
        return finalhead;
    }
}
