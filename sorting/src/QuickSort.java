/**
 * Created by ryan on 6/20/17.
 */
public class QuickSort {

    public char[] sort(char[] input) {

        sort(input, 0, input.length-1);

        return input;

    }

    public void sort(char[] input, int left, int right){
        int index = pivot(input, left, right);
        if(left < index - 1) {
            sort(input, left, index - 1);
        } else if(index < right) {
            sort(input, index, right);
        } else {
            return;
        }
    }
    public int pivot(char[] input, int left, int right) {
        int mid = (left + right) /2;

        while(left < right) {
            while (input[left] < input[mid]) left++;
            while (input[right] > input[mid]) right--;
            swap(input, left, right);
            left++;
            right--;
        }

        return left;

    }

    public void swap(char[] input, int left, int right){
        char tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }
}
