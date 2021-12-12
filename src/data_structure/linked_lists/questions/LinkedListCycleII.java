package data_structure.linked_lists.questions;

import data_structure.linked_lists.questions.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * <p>
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    /**
     * Time: O(n)
     * Space: O(1)
     **/
    public static ListNode detectCycleFloydAlgorithm(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != null) {
                    if (head == slow) return head;
                    head = head.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }


    /**
     * Time: O(n)
     * Space: O(n)
     **/
    public static ListNode detectCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> visited = new HashSet<>();
        while (current != null) {
            if (visited.contains(current)) return current;
            visited.add(current);
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;

        System.out.println(detectCycle(a).val);
        System.out.println(detectCycleFloydAlgorithm(a).val);

    }
}
