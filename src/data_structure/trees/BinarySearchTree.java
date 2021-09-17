package data_structure.trees;

import data_structure.trees.utils.BinaryTreePrinter;
import data_structure.trees.utils.TreeNode;

/**
 * Created by Ali Asadi on 17/09/2021
 */
public class BinarySearchTree {

    TreeNode head;
    int size = 0;

    public boolean add(int value) {
        boolean added = addNumber(value);
        if (added) size++;
        return added;
    }

    private boolean addNumber(int value) {
        if (head == null) {
            head = new TreeNode(value);
            return true;
        }

        TreeNode temp = head;

        while (temp != null) {
            if (value == temp.value) return false; //duplicate

            if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = new TreeNode(value);
                    return true;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = new TreeNode(value);
                    return true;
                }
                temp = temp.left;
            }
        }

        return false;
    }

    public boolean remove(int value) {
        return false;
    }

    public boolean contains(int value) {
        if (head == null) return false;

        TreeNode temp = head;

        while (temp != null) {
            if (value == temp.value) return true; // found

            if (value > temp.value) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        BinaryTreePrinter.printVertical(head);
        BinaryTreePrinter.printHorizontal(head);
        return "BinarySearchTree{ size=" + size + " }";
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(6);
        tree.add(9);
        tree.add(3);
        tree.add(1);
        tree.add(5);
        tree.add(7);
        tree.add(11);

//        for (int i = 0; i < 10; i++) {
//            tree.add((int) (Math.random() * 30));
//        }

        System.out.println(tree);
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(199));

    }


}


