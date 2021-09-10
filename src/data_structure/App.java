package data_structure;


import data_structure.linked_lists.LinkedListDeque;
import data_structure.queues.QueueWithTwoStacks;
import data_structure.queues.RandomizedQueue;
import data_structure.stacks.Stack;

import java.util.function.Consumer;

public class App {

    public static void main(String[] args) {
//        queueWithTwoStacks();
        randomizedQueue();
    }

    private static void queueWithTwoStacks() {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.add(5);
        queue.add(3);
        queue.add(1);

        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("queue: " + queue.toString());
    }

    private static void stack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println("peak: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("stack: " + stack.toString());
    }

    private static void randomizedQueue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        StringBuilder builder = new StringBuilder();

        queue.iterator().forEachRemaining(integer -> {
            builder.append(integer).append(", ");
        });

        System.out.println("queue: " + builder.toString());
        System.out.println("size = " + queue.size());
        System.out.println(queue.toString());
    }

    private static void arrayDeque() {
        LinkedListDeque<Integer> integers = new LinkedListDeque<>();
        integers.addFirst(1);
        integers.addFirst(2);
        integers.addFirst(3);
        integers.addLast(1);
        integers.addFirst(1);
        integers.addFirst(1);

        integers.addLast(2);
        integers.addFirst(2);
        integers.addLast(5);

        integers.removeLast();
        integers.removeFirst();
        integers.removeFirst();
        integers.removeFirst();
        integers.removeLast();
        integers.removeLast();
        integers.addFirst(2);
        integers.addLast(5);

        StringBuilder builder = new StringBuilder();

        integers.iterator().forEachRemaining(integer -> {
            builder.append(integer).append(", ");
        });


        System.out.println("deque: " + builder.toString());
        System.out.println("size = " + integers.size());
        System.out.println(integers.toString());
    }
}
