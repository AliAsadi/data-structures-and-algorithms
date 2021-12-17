package algorithms.sort;

/**
 * Created by Ali Asadi on 09/10/2021
 */
public class App {
    public static void main(String[] args) {
        //Random
        int[] random = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 453, 345, 123, 345234, 112, 5, 1283, 4, 453, 345, 123, 345234, 112, 5, 1, 1, 5, 6, 12, 0, 44, 6, 2, 1, 5, 63, 87, 283, 4, 453, 345, 123, 345234, 112, 5, 1, 1, 5, 6, 12, 0, 44, 6, 2, 1, 5, 636, 2, 1, 5, 63, 87, 283, 4, 453, 345, 123, 345234, 112, 5, 1, 1, 5, 6, 12, 0, 44, 6, 2, 1, 5, 63, 87, 283, 4, 453, 345, 123, 345234, 112, 5, 1, 1, 5, 6, 12, 0, 44, 6, 2, 1, 5, 63, 87, 283, 4, 453, 345, 123, 345234, 112, 5, 1, 1, 5, 6, 12, 0, 44, 6, 2, 1, 5, 63, 87, 283, 4, 453, 345, 123, 345234, 112, 5, 1, 1, 5, 6, 12, 0};
        System.out.println("Random");
        System.out.println("########################");
        BubbleSort.sort(random.clone());
        SelectionSort.sort(random.clone());
        InsertionSort.sort(random.clone());
        MergeSort.sortAndPrintOperationsNum(random.clone());

        //Nearly sorted
        int[] nearlySorted = {1, 2, 6, 2, 7, 8, 10, 20, 40, 55, 56, 57, 58, 58, 67, 68, 61, 2, 12, 13, 14, 15, 16, 17, 18, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
        System.out.println("\nNearly sorted");
        System.out.println("########################");
        BubbleSort.sort(nearlySorted.clone());
        SelectionSort.sort(nearlySorted.clone());
        InsertionSort.sort(nearlySorted.clone());
        MergeSort.sortAndPrintOperationsNum(nearlySorted.clone());
    }
}
