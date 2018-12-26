
import java.util.ArrayList;

// i    parent
// 2i   left
// 2i+1 right
public class MinHeap {

    private ArrayList<Integer> heap;

    private int getLeftChildIndex(int parentIdx) { return (2*parentIdx); }
    private int getRightChildIndex(int parentIdx) { return (2*parentIdx +1); }
    private int getParentIndex(int childIndex) {return childIndex / 2; }

    private boolean hasLeftChild(int parentIdx){
        try {
            return heap.get(getLeftChildIndex(parentIdx)) != null;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean hasRightChild(int parentIdx){
        try {
            return heap.get(getRightChildIndex(parentIdx)) != null;
        } catch (Exception e) {
            return false;
        }
    }
    private boolean hasParent(int childIdx) {
        try {
            return heap.get(getParentIndex(childIdx)) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private Integer getLeft(int parentIdx) {
        if(hasLeftChild(parentIdx)) {
            return heap.get(getLeftChildIndex(parentIdx));
        }
        return null;
    }
    private Integer getRight(int parentIdx) {
        if(hasRightChild(parentIdx)) {
            return heap.get(getRightChildIndex(parentIdx));
        }
        return null;
    }
    private Integer getParent(int childIdx) {
        if(hasParent(childIdx)) {
            return heap.get(getParentIndex(childIdx));
        }
        return null;
    }

    private Integer getCurrentValue(int idx) {
        try{
            return heap.get(idx);
        } catch (Exception e) {
            return null;
        }
    }

    public MinHeap(){
        heap = new ArrayList<>();
        heap.add(null);
    }

    // Add to end of array.
    // HeapifyUp
    public MinHeap insert(int num) {

        heap.add(num);
        heapifyUp();

        return this;
    }


    // Return top value
    // Swap end with root
    // HeapifyDown
    public Integer poll(){
        Integer returnValue = getCurrentValue(1);

        if(returnValue == null) return null;

        swapValues(1, heap.size()-1);
        heap.remove(heap.size()-1);
        heapifyDown();
        return returnValue;
    }

    private void heapifyDown() {

        int parentIdx = 1;
        while(hasLeftChild(parentIdx)){
            Integer smallest = getLeftChildIndex(parentIdx);

            if(hasRightChild(parentIdx) && getRight(parentIdx) < getLeft(parentIdx)) {
                smallest = getRightChildIndex(parentIdx);
            }

            if(getCurrentValue(smallest) < getCurrentValue(parentIdx)) {
                swapValues(smallest, parentIdx);
            } else {
                break;
            }
            parentIdx = smallest;
        }
    }

    private void heapifyUp() {
        int childIdx = heap.size() -1;

        while(hasParent(childIdx)) {
            Integer parent = getParent(childIdx);
            Integer child = getCurrentValue(childIdx);
            if(child != null && parent > child ) {
                swapValues(childIdx, getParentIndex(childIdx));
                childIdx = getParentIndex(childIdx);
            } else {
                break;
            }
        }
    }

    private void swapValues(int index1, int index2){
        int tmp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tmp);
    }

    public void printHeap() {
        for(Integer num : heap) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
