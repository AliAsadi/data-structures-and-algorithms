package data_structure.trees.questions;

import data_structure.trees.BinarySearchTree;
import data_structure.trees.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Traversals {

    private static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.value);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

    public static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.value);
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(100);
        tree.add(120);
        tree.add(90);
        tree.add(95);
        tree.add(80);
        tree.printVertical();

        ArrayList<Integer> inorder = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        inorder(tree.getHead(), inorder);
        preorder(tree.getHead(), preorder);
        postorder(tree.getHead(), postorder);


        System.out.println("InOrder   [Left,Root,Right] -> " + inorder);
        System.out.println("PreOrder  [Root,Left,Right] -> " + preorder);
        System.out.println("PostOrder [Left,Right,Root] -> " + postorder);
    }
}
