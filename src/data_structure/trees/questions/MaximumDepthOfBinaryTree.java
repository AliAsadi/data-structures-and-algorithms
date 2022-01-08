package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        return dfs(root);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * **/
    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = dfs(root.left);
        int maxRight = dfs(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }

    public static int bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            level++;

            Queue<TreeNode> tempQueue = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) tempQueue.add(node.left);
                if (node.right != null) tempQueue.add(node.right);
            }

            queue = tempQueue;
        }

        return level;
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(6);
        tree.add(20);
        tree.add(28);
        tree.add(123);
        tree.add(1231);
        tree.add(12312);
        tree.add(122234);
        tree.add(1231223);
        tree.add(12312231);
        tree.add(30);
        tree.add(22);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(5);
        tree.printHorizontal();

        System.out.println("Max Depth = " + maxDepth(tree.getHead()));
    }
}
