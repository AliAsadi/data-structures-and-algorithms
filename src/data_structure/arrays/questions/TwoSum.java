package data_structure.arrays.questions;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Ali Asadi on 19/11/2021
 */

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 **/
public class TwoSum {

    //BruteForce O(n2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }

    //O(n)
    public static int[] twoSumOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMap.get(diff) != null) {
                return new int[]{hashMap.get(diff), i};
            }

            hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumOptimized(new int[]{2, 7, 11, 15}, 9)));
    }
}
