package data_structure.linked_lists.questions;

/**
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer,
 * and an additional child pointer. This child pointer may or may not point to a separate doubly linked list,
 * also containing these special nodes. These childlists may have one or more children of their own, and so on,
 * to produce a multilevel data structure as shown in the example below.
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 *
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
