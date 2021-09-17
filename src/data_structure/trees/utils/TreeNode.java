package data_structure.trees.utils;

/**
 * Created by Ali Asadi on 17/09/2021
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public StringBuilder printTree(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if(left!=null) {
            left.printTree(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(value).append("\n");
        if(right!=null) {
            right.printTree(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return printTree(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
