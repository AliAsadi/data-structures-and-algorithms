package data_structure.linked_lists.questions;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        Node current = head;
        while (current != null) {
            if (current.child == null) {
                current = current.next;
            } else {
                Node childTail = current.child;
                while (childTail.next != null) childTail = childTail.next;

                childTail.next = current.next;
                if (current.next != null) current.next.prev = childTail;

                current.next = current.child;
                current.next.prev = current;
                current.child = null;
                current = current.next;
            }
        }
        return head;
    }

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
