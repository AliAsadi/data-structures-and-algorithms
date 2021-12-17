package algorithms.sort;

import java.util.Arrays;

/**
 * Created by Ali Asadi on 09/10/2021
 *
 * Best for nearly sorted arrays.
 */
public class InsertionSort {

    /**
     * Time: Average: O(n^2) || Best: O(n)
     * Space: O(1)
     *
     * Q: WHEN TO USE?
     * A: When it comes to small datasets or data sets that are nearly sorted.
     * **/
    static void sort(int[] arr) {
        int operations = 0;
        for (int i = 1; i < arr.length; i++) {
            operations++;
            int currentNum = arr[i];

            int sortedArraySize = i - 1;

            while (sortedArraySize >= 0 && currentNum <= arr[sortedArraySize]) {
                operations++;
                arr[sortedArraySize + 1] = arr[sortedArraySize]; //Move it to the prev index.
                sortedArraySize--;
            }

            arr[sortedArraySize + 1] = currentNum; // set the number in the right place and exist the loop.

        }

        System.out.println("Insertion sort operations: " + operations);

    }

    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
