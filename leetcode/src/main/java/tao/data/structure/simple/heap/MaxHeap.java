package tao.data.structure.simple.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MaxHeap {
    public static void main(String[] args) {
        List<MaxNode> list = new ArrayList<>();
        list.add(new MaxNode(2));
        list.add(new MaxNode(1));
        list.add(new MaxNode(4));
        MaxHeap maxHeap = new MaxHeap();
        final List<MaxNode> list1 = maxHeap.maxHeapSort(list);
        list1.forEach(x -> System.out.println(x.val));
    }

    private List<MaxNode> maxHeapSort(List<MaxNode> list) {
        PriorityQueue<MaxNode> pq = new PriorityQueue<>();
        list.forEach(x-> pq.add(x));
        List<MaxNode> result = new ArrayList<>();
        while (!pq.isEmpty()){
           result.add( pq.poll());
        }
        return result;
    }
}
