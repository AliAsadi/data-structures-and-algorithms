package data_structure.arrays.questions.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * "Google Question"
 * Return the first recurring character.
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
public class FirstRecurringCharacter {

    // Time = O(n)
    // Space = O(n)
    public static Integer findFirstRecurringCharacter(int[] arr) {
        if (arr != null) {
            Set<Integer> map = new HashSet<>();
            for (int value : arr) {
                if (map.contains(value)) {
                    return value;
                } else {
                    map.add(value);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 2, 3, 5, 1, 2, 4};
//        int[] arr = {2,1,1,2,3,5,1,2,4};
//        int[] arr = {2, 3, 4, 5};
        System.out.println(findFirstRecurringCharacter(arr));
    }

}
