package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last, is completely filled
 * in a complete binary tree, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * <p>
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {

    private static int getTreeHeight(TreeNode root) {
        if (root == null) return -1; // -1 to start from 0
        return getTreeHeight(root.left) + 1;
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int height = getTreeHeight(root);
        int nodeCountWithoutLastLevel = (int) Math.pow(2, height);

        int lastLevelPossibleNodeCount = nodeCountWithoutLastLevel - 1; // -1 for getting the right index if last level include 8 node the total is 7 since we start from 0;

        int left = 0;
        int right = lastLevelPossibleNodeCount;

        while (left < right) {
            int idx = (int) Math.ceil((left + right) / 2.0);
            if (nodeExist(root, height, lastLevelPossibleNodeCount, idx)) {
                left = idx;
            } else {
                right = idx - 1;
            }
        }
        return nodeCountWithoutLastLevel + left;
    }

    private static boolean nodeExist(TreeNode root, int height, int lastLevelPossibleNodeCount, int idx) {
        int left = 0;
        int right = lastLevelPossibleNodeCount;
        int level = 0;

        while (level < height) {
            int mid = (int) Math.ceil((left + right) / 2.0);
            if (idx >= mid) {
                root = root.right;
                left = mid;
            } else {
                root = root.left;
                right = mid - 1;
            }
            level++;
        }
        return root != null;
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
//        tree.add(100);
//        tree.add(120);
//        tree.add(125);
//        tree.add(119);
//        tree.add(118);
//        tree.add(90);
//        tree.add(95);
//        tree.add(97);
//        tree.add(91);
//        tree.add(80);
//        tree.add(85);
//        tree.add(75);

        tree.add(100);
        tree.add(120);
        tree.add(90);
        tree.add(95);
        tree.add(80);
//        tree.add(110);

        tree.printVertical();

//        System.out.println(getTreeHeight(tree.getHead()));
        System.out.println(countNodes(tree.getHead()));

    }
}
