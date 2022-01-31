package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.BinaryTreePrinter;
import data_structure.trees.utils.TreeNode;

/**
 * Given a special binary tree having random pointers along with the usual left and right pointers. Clone the given tree.
 *
 * https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1
 */
public class CloneBinaryTree {

    static TreeNode cloneTree(TreeNode node) {
        return cloneDfs(node);
    }

    static TreeNode cloneDfs(TreeNode node) {
        if (node == null) return null;

        TreeNode newNode = new TreeNode(node.value);
        newNode.left = cloneTree(node.left);
        newNode.right = cloneTree(node.right);

        return newNode;
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(100);
        tree.add(120);
        tree.add(90);
        tree.add(95);
        tree.add(80);


        tree.printVertical();
        BinaryTreePrinter.printVertical(cloneTree(tree.getHead()));
    }
}
