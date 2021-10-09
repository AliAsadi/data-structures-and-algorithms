package algorithms.sort;

import java.util.Arrays;

/**
 * Created by Ali Asadi on 08/10/2021
 */
public class SelectionSort {


    static void sort(int[] arr) {
        int operations = 0;
        for (int i = 0; i < arr.length; i++) {
            operations++;

            int minIdx = i;

            for (int j = i; j < arr.length; j++) {
                operations++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        System.out.println("Selection sort operations: " + operations);
    }

    public static void main(String[] args) {
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));


    }
}
