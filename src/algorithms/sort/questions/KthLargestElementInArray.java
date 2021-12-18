package algorithms.sort.questions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {


    /**
     * Time: O(n log(n))
     * Space: O(n log(n))
     * **/
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * Priority Queue Using Heap; (Min Heap)
     * **/
    public static int findKthLargestPriorityQueue(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr,2));
    }
}
