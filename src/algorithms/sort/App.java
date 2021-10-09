package algorithms.sort;

/**
 * Created by Ali Asadi on 09/10/2021
 */
public class App {
    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        BubbleSort.sort(arr.clone());
        SelectionSort.sort(arr.clone());
        InsertionSort.sort(arr.clone());
    }
}
