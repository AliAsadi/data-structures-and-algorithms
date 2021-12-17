package algorithms.sort;

import java.util.Arrays;

/**
 * Created by Ali Asadi on 11/10/2021
 */
public class MergeSort {
    public static int operations = 0;

    static void sortAndPrintOperationsNum(int[] arr) {
        operations = 0;
        sort(arr);
        System.out.println("MergeSort operations: " + operations);
    }

    /**
     * Time: O(n log(n))
     * Space: O(n)
     *
     * Q: WHEN TO USE?
     * A: When it comes to large datasets and you don't care about space complexity.
     * **/
    static int[] sort(int[] arr) {
        if (arr.length == 1) return arr;

        int size = arr.length;
        int mid = size / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, size);

        leftArr = sort(leftArr);
        rightArr = sort(rightArr);

        int mergedArraySize = leftArr.length + rightArr.length;
        int[] mergedArray = new int[mergedArraySize];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < mergedArraySize; i++) {
            operations++;
            if (isBothArraysStillHaveValues(leftIndex, rightIndex, leftArr, rightArr)) { // There is value in the both array sides
                if (leftArr[leftIndex] < rightArr[rightIndex]) {
                    mergedArray[i] = leftArr[leftIndex++];
                } else {
                    mergedArray[i] = rightArr[rightIndex++];
                }
            } else if (isArrayStillHaveValue(leftIndex, leftArr)) { // Get lifted value from the left array
                mergedArray[i] = leftArr[leftIndex++];
            } else if (isArrayStillHaveValue(rightIndex, rightArr)) { //Get lifted value from the right array
                mergedArray[i] = rightArr[rightIndex++];
            }
        }
        return mergedArray;
    }

    private static boolean isBothArraysStillHaveValues(int leftIndex, int rightIndex, int[] leftArr, int[] rightArr) {
        return (leftIndex < leftArr.length) && (rightIndex < rightArr.length);
    }

    private static boolean isArrayStillHaveValue(int index, int[] arr) {
        return index < arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2};
        System.out.println(Arrays.toString(sort(arr)));
        sortAndPrintOperationsNum(arr);
    }
}
