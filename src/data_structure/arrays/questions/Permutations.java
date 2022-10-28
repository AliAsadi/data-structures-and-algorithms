package data_structure.arrays.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) { // goal reached
            result.add(new ArrayList<>(permutation)); // add solution to res
        } else {
            for (int i = 0; i < nums.length; i++) {
                boolean elementExist = permutation.contains(nums[i]);
                if (!elementExist) { // element already exists, skip
                    permutation.add(nums[i]); // make choice
                    backtrack(result, permutation, nums);
                    permutation.remove(permutation.size() - 1); // undo choice
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
