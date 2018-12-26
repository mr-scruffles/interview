/**
 * Created by ryan on 10/2/17.
 */
public class PriorityQueue implements HeapQueue {

    private MinHeap heap;
    public PriorityQueue(){
        heap = new MinHeap();
    }

    @Override
    public void enqueue(Integer num) {
        heap.insert(num);
    }

    @Override
    public Integer remove() {
        return heap.poll();
    }

    @Override
    public void printQueue() {
        heap.printHeap();
    }
}
