package data_structure.linked_lists.questions;

import data_structure.linked_lists.questions.utils.ListNode;
import data_structure.linked_lists.questions.utils.Utils;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseSubLinkedList {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode leftToLeft = head;

        int pos = 1;
        while (current != null) {

            if (pos + 1 == left) leftToLeft = current;

            if (pos == right) {
                ListNode rightToRight = current.next;
                if (left == 1) return reverseList(leftToLeft, rightToRight);
                leftToLeft.next = reverseList(leftToLeft.next, rightToRight);
                return head;
            }
            pos++;
            current = current.next;
        }

        return head;
    }

    /**
     * Utilize the original list
     * <p>
     * Time: O(n)
     * Space O(1)
     **/
    public static ListNode reverseList(ListNode head, ListNode prev) {
        ListNode rightToRight = prev;
        while (head != rightToRight) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }

        return prev;
    }

    public static void main(String[] args) {
        Utils.print(reverseBetween(Utils.sortedLinkedList(1, 5), 2, 4));

//        Utils.print(reverseBetween(new ListNode(5), 1, 1));
    }
}
