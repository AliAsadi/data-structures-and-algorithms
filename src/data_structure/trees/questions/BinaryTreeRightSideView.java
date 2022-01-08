package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on
 * the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }


    /**
     * Time: O(n)
     * Space: O(n)
     * **/
    public static List<Integer> bfs(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int lastItem = queue.size() - 1;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == lastItem) result.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return result;
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
        tree.printHorizontal();

        System.out.println(rightSideView(tree.getHead()));
    }
}
