package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }

    /**
     * Time: O(n)
     * Space: O(n)
     * **/
    public static List<List<Integer>> bfs(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> tree = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> tempQueue = new ArrayDeque<>();
            ArrayList<Integer> levelValues = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                levelValues.add(node.value);
                if (node.left != null) tempQueue.add(node.left);
                if (node.right != null) tempQueue.add(node.right);
            }
            tree.add(levelValues);
            queue = tempQueue;
        }

        return tree;
    }

    /**
     * remove the tempQueue (Improve space complexity?)
     * **/
    public static List<List<Integer>> bfs2(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> tree = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> levelValues = new ArrayList<>();
            int leveSize = queue.size();

            for (int i = 0; i < leveSize; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            tree.add(levelValues);
        }

        return tree;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(6);
        tree.add(20);
        tree.add(28);
        tree.add(123);
        tree.add(1231);
        tree.add(12312);
        tree.add(30);
        tree.add(22);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(5);

        System.out.println(levelOrder(tree.getHead()));
        System.out.println(bfs2(tree.getHead()));
    }
}
