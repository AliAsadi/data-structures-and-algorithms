package data_structure.queues.questions;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all
 * the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {

    private static class MyQueue {

        private final Stack<Integer> in = new Stack<>();
        private final Stack<Integer> out = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (out.empty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int peek() {
            if (out.empty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());

    }
}
