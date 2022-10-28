package data_structure.queues.questions;

import data_structure.queues.RandomizedQueue;

/**
 *
 * Write a generic data type for a deque and a randomized queue. The goal of this assignment is to implement elementary
 * data structures using arrays and linked lists, and to introduce you to generics and iterators.
 *
 * https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php
 * **/
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        String string = "ABCDEFGHI";
        for (char ch : string.toCharArray()) {
            randomizedQueue.enqueue(ch + "");
        }

        for (int i = 0; i < 3; i++) System.out.println(randomizedQueue.dequeue());

    }
}
