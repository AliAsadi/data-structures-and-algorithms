package data_structure.queues;

import data_structure.stacks.Stack;

import java.util.*;

public class QueueWithTwoStacks<T> {
    private final data_structure.stacks.Stack<T> in = new data_structure.stacks.Stack<>();
    private final data_structure.stacks.Stack<T> out = new Stack<>();

    public void add(T item) {
        in.push(item);
    }

    public T remove() {
        if (in.isEmpty() && out.isEmpty()) {
            throw new NoSuchElementException();
        } else if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    @Override
    public String toString() {
        return "QueueWithTwoStacks{" +
                "in=" + in +
                ", out=" + out +
                '}';
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.add(5);
        queue.add(3);
        queue.add(1);

        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove());
        System.out.println("queue: " + queue.toString());
    }
}
