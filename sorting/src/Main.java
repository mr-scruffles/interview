/**
 * Created by ryan on 6/20/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Sorting algorithms!");

//
//        MergeSort mergeSort = new MergeSort();
//        String input = "987654321";
//        System.out.println(mergeSort.sort(input.toCharArray()));
//        input = "21";
//        System.out.println(mergeSort.sort(input.toCharArray()));
//        input = "1";
//        System.out.println(mergeSort.sort(input.toCharArray()));
//        input = "1234567890";
//        System.out.println(mergeSort.sort(input.toCharArray()));

        System.out.println("Quicksort");
        QuickSort quickSort = new QuickSort();
        String qInput = "987654321";
        System.out.println(quickSort.sort(qInput.toCharArray()));
    }
}
