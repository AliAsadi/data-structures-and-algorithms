package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.BinaryTreePrinter;
import data_structure.trees.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a special binary tree having random pointers along with the usual left and right pointers. Clone the given tree.
 * <p>
 * https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1
 */
public class CloneBinaryTree {

    static TreeNode cloneTree(TreeNode node) {
        return cloneDfs(node);
    }

    static TreeNode cloneBfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        int root = node.value;
        map.put(root, new TreeNode(node.value));

        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode newNode = map.get(current.value);

            if (current.left != null) {
                newNode.left = map.get(current.left.value) != null ? map.get(current.left.value) : new TreeNode(current.left.value);
                queue.add(current.left);
                map.put(newNode.left.value, newNode.left);
            }

            if (current.right != null) {
                newNode.right = map.get(current.right.value) != null ? map.get(current.right.value) : new TreeNode(current.right.value);
                queue.add(current.right);
                map.put(newNode.right.value, newNode.right);
            }
        }

        return map.get(root);
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
