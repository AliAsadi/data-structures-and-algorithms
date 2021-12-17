package data_structure.queues.questions;

import data_structure.queues.RandomizedQueue;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("A");
        randomizedQueue.enqueue("B");
        randomizedQueue.enqueue("C");
        randomizedQueue.enqueue("D");
        randomizedQueue.enqueue("E");
        randomizedQueue.enqueue("F");
        randomizedQueue.enqueue("G");
        randomizedQueue.enqueue("H");
        randomizedQueue.enqueue("I");

        for (int i = 0; i < 3; i++) System.out.println(randomizedQueue.dequeue());

    }
}
