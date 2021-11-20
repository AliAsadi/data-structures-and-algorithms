package data_structure.arrays.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given K sorted arrays the task is to merge them into one sorted array.
 * input {{1,2,3},{4,5,6},{7,8,9}}
 * Output: {1,2,3,4,5,6,7,8,9}
 **/
public class MergeKSortedArrays {

    public static int[] mergeSortedArrays(int[][] arrays) { // List<List<Integer>> arrays
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                queue.add(arrays[i][j]);
            }
        }

        while (!queue.isEmpty()) {
            mergedSortedArray.add(queue.poll());
        }

        return mergedSortedArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public static String[] mergeSortedArrays(String[][] arrays) { // List<List<Integer>> arrays
        ArrayList<String> mergedSortedArray = new ArrayList<>();

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                queue.add(arrays[i][j]);
            }
        }

        while (!queue.isEmpty()) {
            mergedSortedArray.add(queue.poll());
        }

        return mergedSortedArray.toArray(new String[0]);
    }

    public static void main(String[] args) {
        int[] intArray = mergeSortedArrays(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        String[] stringArray = mergeSortedArrays(new String[][]{{"Ali", "Ahmad", "Yoni"}, {"Lolo", "Oleg", "Zach"}, {"Bob", "Kole", "Nimer"}});

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
    }


}
