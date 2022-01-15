package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {


    /**
     * Solution based on inorder traversal
     *
     * Time: O(n)
     * **/
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode prev = null;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (prev != null && prev.value >= temp.value) return false;
            prev = temp;
            temp = temp.right;
        }
        return true;
    }

    /**
     * Dfs solution
     * **/
    static boolean dfsIsValidBST(TreeNode root) {
        return dfsIsValidBST(root, null);
    }

    static boolean dfsIsValidBST(TreeNode root, TreeNode prev) {
        if (root == null) return true;

        if (!dfsIsValidBST(root.left, prev)) return false;
        if (prev != null && prev.value > root.value) return false;
        prev = root;

        return dfsIsValidBST(root.right, prev);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(100);
        tree.add(120);
        tree.add(90);
        tree.add(95);
        tree.add(80);
//        tree.add(110);

        tree.printVertical();

//        System.out.println(getTreeHeight(tree.getHead()));
        System.out.println(isValidBST(tree.getHead()));
        System.out.println(dfsIsValidBST(tree.getHead()));
    }
}
