package data_structure.arrays.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {
    /**
     * Create a function that merge sorted arrays
     * input [0,3,4,31], [4,6,30]
     * output [0, 3, 4, 4, 6, 30, 31]
     **/
    public static void main(String[] args) {
        List<Integer> array = mergeSortedArrays(Arrays.asList(0, 3, 4, 31), Arrays.asList(4, 6, 30));
//        List<Integer> array = mergeSortedArrays(Arrays.asList(0, 3, 4, 31, 177), Arrays.asList(4, 6, 30, 55, 67, 70, 111, 200, 300));
//        List<Integer> array = mergeSortedArrays(Arrays.asList(0, 3, 4, 31, 177), new ArrayList<>());
//        List<Integer> array = mergeSortedArrays( new ArrayList<>(), Arrays.asList(4, 6, 30));
//        List<Integer> array = mergeSortedArrays(null, Arrays.asList(4, 6, 30, 55, 67, 70, 111, 200, 300));
//        List<Integer> array = mergeSortedArrays(null, null);
        System.out.println(array);
    }

    //  Questions:
    //  -----------
    //  1. The input could be null? or empty?
    //  2. Are they only integer or could be float? negate values?
    //  3. In case one of both null what we should return? or if one is null to return the second?
    //
    //  Rules:
    // ------------
    // 1. Check inputs
    // 2. Check outputs
    //
    //  BigO:
    // -------------
    // Time = O(n)
    // Space = O(n)
    public static List<Integer> mergeSortedArrays(List<Integer> array1, List<Integer> array2) {
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();

        if (array1 != null && array2 != null) {
            int index1 = 0;
            int index2 = 0;

            while (index1 < array1.size()) {
                int num1 = array1.get(index1);

                if (index2 < array2.size()) {
                    int num2 = array2.get(index2);

                    if (num1 < num2) {
                        mergedSortedArray.add(num1);
                        index1++;
                    } else {
                        mergedSortedArray.add(num2);
                        index2++;
                    }
                } else {
                    //If the second array is empty, add all of the first array's left items to the list.
                    mergedSortedArray.add(num1);
                    index1++;
                }
            }

            //If the second array is larger than the first and there are items left in it, add them to the list.
            if (index2 < array2.size()) {
                for (int i = index2; i < array2.size(); i++) {
                    mergedSortedArray.add(array2.get(i));
                }
            }
        } else {
            if (array1 == null && array2 == null) {
                return mergedSortedArray;
            } else {
                if (array1 == null) {
                    return array2;
                } else {
                    return array1;
                }
            }
        }

        return mergedSortedArray;
    }
}
