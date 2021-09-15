package data_structure.hash_table.questions;


import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    /**
     * // Google Question
     *
     * Given an array = [2,5,1,2,3,5,1,2,4]:
     * It should return 2
     *
     * Given an array = [2,1,1,2,3,5,1,2,4]:
     * It should return 1
     *
     * Given an array = [2,3,4,5]:
     * It should return undefined
     */
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 2, 3, 5, 1, 2, 4};
//        int[] arr = {2,1,1,2,3,5,1,2,4};
//        int[] arr = {2, 3, 4, 5};
        int value = findFirstRecurringCharacter(arr);
        System.out.println(value);
    }

    //  Questions:
    //  -----------
    //  NONE
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
    public static Integer findFirstRecurringCharacter(int[] arr) {
        if (arr != null) {
            Map<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.get(arr[i]) != null) {
                    return arr[i];
                } else {
                    map.put(arr[i], true);
                }
            }
        }
        return null;
    }

}
