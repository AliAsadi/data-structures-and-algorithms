package algorithms.sort;

import java.util.Arrays;

/**
 * Created by Ali Asadi on 09/10/2021
 */
public class InsertionSort {

    static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int currentNum = arr[i];

            int sortedArraySize = i - 1;

            while (sortedArraySize >= 0 && currentNum <= arr[sortedArraySize]) {
                arr[sortedArraySize + 1] = arr[sortedArraySize]; //Move it to the prev index.
                sortedArraySize--;
            }

            arr[sortedArraySize + 1] = currentNum; // set the number in the right place and exist the loop.

        }

    }

    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
