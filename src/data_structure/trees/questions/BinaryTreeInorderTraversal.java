package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderDFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Traversals.inorder(root, list);
        return list;
    }

    /**
     * Iterative solution
     **/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.add(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.value);
            temp = temp.right;
        }
        return list;
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(100);
        tree.add(120);
        tree.add(90);
        tree.add(95);
        tree.add(80);

        tree.printVertical();

        System.out.println(inorderTraversal(tree.getHead()));
        System.out.println(inorderDFS(tree.getHead()));
    }
}
