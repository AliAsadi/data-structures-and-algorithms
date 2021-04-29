package stack_queue;

import java.util.*;
import java.util.ArrayDeque;

public class QueueWithTwoStacks<T> {
    private final Stack<T> in = new Stack<>();
    private final Stack<T> out = new Stack<>();

    void add(T item) {
        in.push(item);
    }

    T remove() {
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
}
