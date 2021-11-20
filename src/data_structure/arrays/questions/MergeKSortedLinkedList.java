package data_structure.arrays.questions;

import java.util.*;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * input {{1,2,3},{4,5,6},{7,8,9}}
 * Output: {1,2,3,4,5,6,7,8,9}
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/
 **/
public class MergeKSortedLinkedList {

    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        ListNode head = null;
        ListNode temp = null;
        while (!queue.isEmpty()) {
            if (head == null) {
                head = queue.poll();
                temp = head;
            }

            temp.next = queue.poll();
            temp = temp.next;
        }

        if (temp != null) temp.next = null;

        return head;

    }

    public static void main(String[] args) {
        ListNode[] nodeArray = new ListNode[]{generateLinkedList(10, 20), generateLinkedList(0, 5), generateLinkedList(30, 34)};

        ListNode head = mergeKLists(nodeArray);

        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    private static ListNode generateLinkedList(int from, int to) {
        ListNode head = null;
        ListNode arr = null;
        for (int i = from; i < to; i++) {
            if (head == null) {
                head = new ListNode();
                arr = head;

                head.val = i;
            } else {
                arr.next = new ListNode(i);
                arr = arr.next;
            }

        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
