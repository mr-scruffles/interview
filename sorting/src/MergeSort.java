/**
 * Created by ryan on 6/20/17.
 */
public class MergeSort {

    public char[] sort(char[] array){

        if(array == null || array.length < 2) return array;

        char[] helper = new char[array.length];
        int left = 0;
        int right = array.length -1;

        sort(array, left, right, helper);

        return array;
    }

    public void sort(char[] array, int left, int right, char[] helper) {
        if (left == right) return;
        int mid = (left + right) / 2;

        sort(array, left, mid, helper);
        sort(array, mid+1, right, helper);

        merge(array, left, mid, right, helper);
    }

    public void merge(char[] array, int left, int mid, int right, char[] helper) {
        for(int i = left; i <= right; i++) {
            helper[i] = array[i];
        }

        int helperLeft = left;
        int helperRight = mid +1;
        int current = left;

        while (helperLeft <= mid && helperRight <= right) {
            if(helper[helperRight] < helper[helperLeft]){
                array[current] = helper[helperRight];
                helperRight++;

            } else {
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            current++;
        }
        // still have things left over from left, so append.
        if (helperLeft <= mid) {
            for(int i = helperLeft; i <= mid; i++) {
                array[current] = helper[i];
                current++;
            }
        }
    }
}
