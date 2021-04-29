package stack_queue;


import java.util.function.Consumer;

public class App {

    interface AA {
        void aa();
    }

    public static void main(String[] args) {




        test();
        test();
        test();
        test();
        test();
        test();
        test();
        queueWithTwoStacks();

        while (true) {

        }
    }

    private static void test() {
        Consumer<Integer> aa = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("LOL" + integer);
            }

        };

        aa.accept(5);
        aa.accept(6);
        aa.accept(7);
    }

    private static void queueWithTwoStacks() {
        QueueWithTwoStacks<Integer> queueWithTwoStacks = new QueueWithTwoStacks<>();
        queueWithTwoStacks.add(5);
        queueWithTwoStacks.add(3);
        queueWithTwoStacks.add(1);

        System.out.println(queueWithTwoStacks.toString());

        System.out.println(queueWithTwoStacks.remove());
        System.out.println(queueWithTwoStacks.remove());
        System.out.println(queueWithTwoStacks.remove());


    }

    private static void stack() {
        Stack<Integer> ss = new Stack<>();
        ss.push(5);
        ss.push(5);
        ss.push(5);

        System.out.println(ss.toString());
        ss.peek();
        ss.peek();
        ss.peek();
        ss.peek();

        ss.pop();
        ss.pop();


        System.out.println(ss.toString());
    }

    private static void randomQueue() {
        RandomizedQueue<Integer> integers = new RandomizedQueue<>();
        integers.enqueue(1);
        integers.enqueue(2);
        integers.enqueue(3);
        integers.enqueue(4);
        integers.enqueue(5);
        integers.enqueue(6);

        integers.dequeue();
        integers.dequeue();
        integers.dequeue();
        integers.dequeue();

        StringBuilder builder = new StringBuilder();

        integers.iterator().forEachRemaining(integer -> {
            builder.append(integer).append(", ");
        });

        System.out.println(builder.toString());
        System.out.println("size = " + integers.size());
        System.out.println(integers.toString());
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
        integers.addLast( 5);
//        integers.addLast( 5);

        integers.removeLast();
        integers.removeFirst();
        integers.removeFirst();
        integers.removeFirst();
        integers.removeLast();
        integers.removeLast();
        integers.addFirst(2);
        integers.addLast( 5);

        StringBuilder builder = new StringBuilder();

        integers.iterator().forEachRemaining(integer -> {
            builder.append(integer).append(", ");
        });

//        iterator.remove();

        System.out.println(builder.toString());
        System.out.println("size = " + integers.size());
        System.out.println(integers.toString());
    }
}
