package stack_queue;

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


        int N = 3;

        for (int i = 0; i < N; i++) {
            System.out.println(randomizedQueue.dequeue());
        }

    }
}
