package data_structure.linked_lists.questions.utils;

import java.util.Random;

/**
 * Created by Ali Asadi on 05/12/2021
 */
public class Utils {

    public static ListNode sortedLinkedList(int from, int to) {
        return generateLinkedList(from, to, true);
    }

    public static ListNode sortedLinkedList(int size) {
        return generateLinkedList(size, true);
    }

    public static ListNode randomLinkedList(int from, int to) {
        return generateLinkedList(from, to, false);
    }

    public static ListNode randomLinkedList(int size) {
        return generateLinkedList(size, false);
    }

    private static ListNode generateLinkedList(int size, boolean sorted) {
        ListNode head = null;
        ListNode arr = null;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (head == null) {
                head = new ListNode();
                arr = head;
                head.val = (sorted) ? i : random.nextInt(100);
            } else {
                arr.next = sorted ? new ListNode(i) : new ListNode(random.nextInt(100));
                arr = arr.next;
            }

        }
        return head;
    }

    private static ListNode generateLinkedList(int from, int to, boolean sorted) {
        ListNode head = null;
        ListNode arr = null;
        Random random = new Random();
        for (int i = from; i < to; i++) {
            if (head == null) {
                head = new ListNode();
                arr = head;
                head.val = (sorted) ? i : random.nextInt(to - from) + from; //(int) (System.currentTimeMillis() % to - from) + from;
            } else {
                arr.next = sorted ? new ListNode(i) : new ListNode(random.nextInt(to - from) + from);
                arr = arr.next;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        if (head == null) return;
        StringBuilder builder = new StringBuilder();
        while (head.next != null) {
            builder.append(head.val).append(", ");
            head = head.next;
        }
        builder.append(head.val);
        System.out.print(builder.toString());
    }
}
