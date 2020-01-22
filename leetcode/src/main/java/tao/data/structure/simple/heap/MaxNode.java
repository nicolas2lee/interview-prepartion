package tao.data.structure.simple.heap;

class MaxNode implements Comparable<MaxNode>{
    int val;

    public MaxNode(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(MaxNode o) {
        return o.val - val;
    }
}
