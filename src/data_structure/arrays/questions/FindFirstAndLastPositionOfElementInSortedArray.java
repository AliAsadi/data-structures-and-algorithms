package data_structure.arrays.questions;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Binary Search
     * Time: O(log n)
     * **/
    public static int[] searchRange(int[] nums, int target) {
        int[] notFound = new int[]{-1, -1};
        if (nums.length == 0) return notFound;

        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.length == mid) return notFound;
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;
                while (start >= 0 && nums[start] == target) start--; start++;
                while (end < nums.length && nums[end] == target) end++; end--;
                return new int[]{start, end};
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return notFound;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
//        int[] arr = new int[]{1};
        int[] arr = new int[]{2,2};
//        int[] arr = new int[]{1,3};
        System.out.println(Arrays.toString(searchRange(arr, 6)));
    }
}
