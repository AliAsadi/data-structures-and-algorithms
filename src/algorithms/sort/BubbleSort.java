package algorithms.sort;

import java.util.Arrays;

/**
 * Created by Ali Asadi on 08/10/2021
 */
public class BubbleSort {


    /**
     * In each loop, the larger number is moved to the last position, and the loop size is reduced (skip the sorted indexes).
     * **/
    static void sort(int[] arr) {
        int operations = 0;
        for (int skipIndexes = 0; skipIndexes < arr.length - 1; skipIndexes++) {
            operations++;
            for (int j = 0; j < arr.length - skipIndexes - 1; j++) { // --> Each time we loop we skip the last index (length - i)
                operations++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Bubble sort operations: " + operations);
    }

    //bonus - i tried to implement it using while.
    static void sortUsingWhile(int[] arr) {
        boolean sorted = false;
        int skipIndexes = 0;
        int operations = 0;

        while (!sorted) {
            operations++;
            sorted = true;
            for (int i = 1; i < arr.length - skipIndexes; i++) {
                operations++;
                if (arr[i] < arr[i - 1]) {
                    sorted = false;

                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            skipIndexes++;
        }

        System.out.println("Bubble sort operations: " + operations);
    }

    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        System.out.println(Arrays.toString(arr));

        sort(arr);
//        sortUsingWhile(arr);
        System.out.println(Arrays.toString(arr));

    }

}
