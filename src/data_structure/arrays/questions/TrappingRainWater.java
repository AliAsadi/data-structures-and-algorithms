package data_structure.arrays.questions;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    /**
     * Time: O(n^2)
     * Space: O(1)
     *
     * The solution is to collect the current index's *maxLeft* and *maxRight* values, and get the min between them;
     * Then subtract the *result* from the current index to find out how much water you hold.
     */
    public static int trap(int[] height) {
        int totalWater = 0;

        for (int currentIndex = 0; currentIndex < height.length; currentIndex++) {
            int leftIndex = currentIndex;
            int rightIndex = currentIndex;

            int maxLeft = 0;
            int maxRight = 0;

            //Go to the index's left side <<< and check the maxLeft
            while (leftIndex >= 0) {
                maxLeft = Math.max(maxLeft, height[leftIndex]);
                leftIndex--;
            }

            //Go to the index's right side >>> and get the maxRight
            while (rightIndex < height.length) {
                maxRight = Math.max(maxRight, height[rightIndex]);
                rightIndex++;
            }

            //Look at the current index and see how much water he can hold.
            totalWater += Math.min(maxLeft, maxRight) - height[currentIndex];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }

}
