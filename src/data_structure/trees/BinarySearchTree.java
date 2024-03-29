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
        boolean added = addNode(value);
        if (added) size++;
        return added;
    }

    private boolean addNode(int value) {

        TreeNode newNode = new TreeNode(value);

        if (head == null) {
            head = newNode;
            return true;
        }

        TreeNode temp = head;

        while (true) {
            if (value == temp.value) return false; //duplicate

            if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
    }

    /**
     * 1. Check if the value exist.
     * 2. Check if the node there is a (2 child's) or (1 child) or (Zero).
     * 3. If there is 2 child's we loop to find the minimum node in the right subtree of the node the need we want to remove.
     * **/
    public boolean remove(int value) {
        TreeNode nodeToRemove = head;
        TreeNode parent = head;

        while (nodeToRemove != null) {
            if (value == nodeToRemove.value) { // FOUND
                if (nodeToRemove.right != null && nodeToRemove.left != null) {
                    removeNodeWithTwoChild(nodeToRemove, parent, value); //TWO CHILD
                } else {
                    removeNodeWithZeroOrOneChild(nodeToRemove, parent, value); // ONE CHILD || ZERO
                }
                size--;
                return true;
            }

            //keep looking
            if (value > nodeToRemove.value) {
                parent = nodeToRemove;
                nodeToRemove = nodeToRemove.right;
            } else {
                parent = nodeToRemove;
                nodeToRemove = nodeToRemove.left;
            }
        }
        return false;
    }

    private void removeNodeWithTwoChild(TreeNode nodeToRemove, TreeNode parent, int value) {
        TreeNode minimumNode = nodeToRemove.right;// Find minimum node of right subtree of the node that needed to be removed.
        TreeNode minimumNodeParent = nodeToRemove;

        while (minimumNode.left != null) {
            minimumNodeParent = minimumNode;
            minimumNode = minimumNode.left;
        }

        //1. disconnect the minimum node from the minimum parent node
        disconnectMinimumNodeFromParent(minimumNode, minimumNodeParent);

        //2. connect the minimum node to the node to be removed connection (right and left)
        connectMinimumNodeToRemovedNodeConnections(minimumNode, nodeToRemove);

        //3. connect the minimum node to parent of the removed node
        connectMinimumNodeToParent(parent, minimumNode, value);
    }

    private void connectMinimumNodeToParent(TreeNode parent, TreeNode minimumNode, int value) {
        if (value == head.value) {
            head = minimumNode;
        } else if (value > parent.value) {

            parent.right = minimumNode;
        } else {
            parent.left = minimumNode;
        }
    }

    private void connectMinimumNodeToRemovedNodeConnections(TreeNode minimumNode, TreeNode nodeToRemove) {

        if (minimumNode.right == null) { //If there is no connection to the minimumNode on the right side
            minimumNode.right = nodeToRemove.right; //Connect node to right side
        }

        if (minimumNode.left == null) {  //If there is no connection to the minimumNode on the left side
            minimumNode.left = nodeToRemove.left;   //Connect node to left side
        }
    }

    private void disconnectMinimumNodeFromParent(TreeNode minimumNode, TreeNode minimumNodeParent) {
        if (minimumNodeParent.left == minimumNode) {
            minimumNodeParent.left = null;
        } else {
            minimumNodeParent.right = null;
        }
    }

    private void removeNodeWithZeroOrOneChild(TreeNode nodeToRemove, TreeNode parent, int value) {
        if (nodeToRemove.right != null) { // RIGHT CHILD
            if (value > parent.value) {
                parent.right = nodeToRemove.right;
            } else {
                parent.left = nodeToRemove.right;
            }
        } else { // LEFT CHILD || OR ZERO
            if (value > parent.value) {
                parent.right = nodeToRemove.left;
            } else {
                parent.left = nodeToRemove.left;
            }
        }
    }

    public boolean contains(int value) {
        return getNodeByValue(value) != null;
    }

    private TreeNode getNodeByValue(int value) {
        TreeNode temp = head;

        while (temp != null) {
            if (value == temp.value) return temp; // found

            if (value > temp.value) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return null;
    }

    public TreeNode getHead() {
        return head;
    }

    @Override
    public String toString() {
//        BinaryTreePrinter.printVertical(head);
        BinaryTreePrinter.printHorizontal(head);
        return "BinarySearchTree{ size=" + size + " }";
    }

    public void printHorizontal() {
        BinaryTreePrinter.printHorizontal(head);
    }

    public void printVertical() {
        BinaryTreePrinter.printVertical(head);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(6);
        tree.add(20);
        tree.add(28);
        tree.add(30);
        tree.add(22);
//        tree.add(21);
        tree.add(8);
        tree.add(3);
        tree.add(1);
        tree.add(5);

//        tree.remove(6);
//        tree.remove(3);

//        for (int i = 0; i < 15; i++) {
//            tree.add((int) (Math.random() * 30));
//            tree.add(i);
//        }

//        tree.remove(9);
//        tree.remove(11);
//        tree.remove(28);
//        tree.remove(20);
        tree.remove(6);
//        tree.add(19);
        tree.remove(8);
        tree.remove(28);
        tree.remove(20);

        System.out.println(tree);
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(199));

    }


}


