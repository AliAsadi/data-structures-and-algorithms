package data_structure.arrays.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given K sorted arrays the task is to merge them into one sorted array.
 * input {{1,2,3},{4,5,6},{7,8,9}}
 * Output: {1,2,3,4,5,6,7,8,9}
 **/
public class MergeKSortedArrays {

    public static int[] mergeSortedArrays(int[][] arrays) { // List<List<Integer>> arrays
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                queue.add(arrays[i][j]);
            }
        }

        while (!queue.isEmpty()) {
            mergedSortedArray.add(queue.poll());
        }

        return mergedSortedArray.stream().mapToInt(Integer::intValue).toArray();
    }

    public static String[] mergeSortedArrays(String[][] arrays) { // List<List<Integer>> arrays
        ArrayList<String> mergedSortedArray = new ArrayList<>();

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                queue.add(arrays[i][j]);
            }
        }

        while (!queue.isEmpty()) {
            mergedSortedArray.add(queue.poll());
        }

        return mergedSortedArray.toArray(new String[0]);
    }

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

        if (temp!=null) temp.next = null;

        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] intArray = mergeSortedArrays(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        String[] stringArray = mergeSortedArrays(new String[][]{{"Ali", "Ahmad", "Yoni"}, {"Lolo", "Oleg", "Zach"}, {"Bob", "Kole", "Nimer"}});



        ListNode[] lists = new ListNode[]{new ListNode()};
        ListNode list = mergeKLists(lists);

        while (list != null) {
            System.out.print(list.val + ", ");
            list = list.next;
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(stringArray));
    }

    private static ListNode generateLinkedList() {
        ListNode head = null;
        ListNode arr = null;
        for (int i = 1; i < 5; i++) {
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

}
