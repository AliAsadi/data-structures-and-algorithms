package data_structure.queues;

import data_structure.stacks.Stack;

import java.util.*;

public class QueueWithTwoStacks<T> {
    private final Stack<T> in = new Stack<>();
    private final Stack<T> out = new Stack<>();

    public void add(T item) {
        in.push(item);
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public T peek() {
        if (!isEmpty() && out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
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
