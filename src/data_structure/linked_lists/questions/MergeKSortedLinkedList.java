package data_structure.linked_lists.questions;


import data_structure.linked_lists.questions.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static data_structure.linked_lists.questions.utils.Utils.print;
import static data_structure.linked_lists.questions.utils.Utils.sortedLinkedList;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * input {{1,2,3},{4,5,6},{7,8,9}}
 * Output: {1,2,3,4,5,6,7,8,9}
 * <p>
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
        ListNode[] array = new ListNode[]{sortedLinkedList(10, 20), sortedLinkedList(0, 5), sortedLinkedList(30, 34)};
        ListNode head = mergeKLists(array);
        print(head);
    }
}
