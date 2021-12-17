package data_structure.queues.questions;

import data_structure.queues.RandomizedQueue;

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
