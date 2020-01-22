package tao.data.structure.simple.heap;


import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    /**
     * [4,2,1,3]
     */
    @Test
    public void case_1() {
        Solution.ListNode head = new Solution.ListNode(4);
        head.next = new Solution.ListNode(2);
        head.next.next = new Solution.ListNode(1);
        head.next.next.next = new Solution.ListNode(3);
        final Solution.ListNode result = solution.sortList(head);
        Solution.ListNode current = result;
        while (current!=null){
            System.out.println(current.val);
            current = current.next;

        }

    }
}