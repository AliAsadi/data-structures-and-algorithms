package data_structure.linked_lists.questions;

import data_structure.linked_lists.questions.utils.ListNode;
import data_structure.linked_lists.questions.utils.Utils;

import java.util.Stack;

import static data_structure.linked_lists.questions.utils.Utils.print;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    /**
     * Utilize the original list
     *
     * Time: O(n)
     * Space O(1)
     **/
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }

        return prev;
    }

    /**
     * Using Stack
     *
     * Time: O(n)
     * Space O(n)
     **/
    public static ListNode reverseListStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        ListNode list = new ListNode();
        ListNode temp = list;
        while (!stack.isEmpty()) {
            temp.val = stack.pop();
            if (!stack.isEmpty()) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return list;
    }


    /**
     * Recursive
     *
     * Time: O(n)
     * Space O(n)
     **/
    public static ListNode reverseListRecursive(ListNode head) {
        if (head.next == null) return head;

        /**
         *  The value returned is the last item;
         *  For example, if there are 5 items and we are on item 4, the method will return the last item, which is 5;
         *  IMPORTANT: the head indicates in 4 but the result is 5;
         *  array = [1,2,3,4,5]
         *  newHead = 5 -> result
         *  head = 4 -> currently
         * **/
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = reverseList(Utils.sortedLinkedList(20));
        print(head);
    }
}
