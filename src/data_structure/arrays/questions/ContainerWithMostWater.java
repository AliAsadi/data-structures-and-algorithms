package data_structure.arrays.questions;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * <p>
 * <p>
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * <p>
 * Example:
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * <p>
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * https://leetcode.com/problems/container-with-most-water/
 **/
public class ContainerWithMostWater {

    //BruteForce O(n^2)
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                int width = j - i;
                int container = minHeight * width;
                if (container > max) max = container;
            }
        }
        return max;
    }

    //O(n)
    public static int maxAreaOptimized(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        while (leftIndex < rightIndex) {
            int minHeight = Math.min(height[leftIndex], height[rightIndex]);
            int width = rightIndex - leftIndex;
            int container = minHeight * width;
            max = Math.max(container, max);

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxAreaOptimized(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxAreaOptimized(new int[]{4, 3, 2, 1, 4}));
    }
}
