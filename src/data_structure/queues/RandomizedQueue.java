package data_structure.queues;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int N = 10;
    private int index = 0;
    private Object[] items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = new Object[N];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return index == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return index;
    }

    // add the item
    public void enqueue(Item item) {
        validate(item);
        resize();
        items[index++] = item;
    }

    // remove and return a random item
    @SuppressWarnings("unchecked")
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            int randomIndex = randomIndex();
            Item item = (Item) items[randomIndex];
            items[randomIndex] = items[--index];
            items[index] = null;
            shrink();
            return item;
        }
    }

    private int randomIndex() {
        return (int) (Math.random() * index);
    }

    // return a random item (but do not remove it)
    @SuppressWarnings("unchecked")
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return (Item) items[randomIndex()];
        }
    }

    private void validate(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    private void resize() {
        if (items.length == index) {
            N = N * 2;
            items = Arrays.copyOf(items, N);
        }
    }

    private void shrink() {
        if (index == items.length * (20.0 / 100)) {
            N = N / 2;
            items = Arrays.copyOf(items, N);
        }
    }

    // return an independent iterator over items in random order
    @NotNull
    @SuppressWarnings("unchecked")
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            int tempIndex = 0;

            @Override
            public boolean hasNext() {
                return tempIndex < index;
            }

            @Override
            public Item next() {
                if (hasNext()) {
                    return (Item) items[tempIndex++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public String toString() {
        return "RandomizedQueue{" +
                "N=" + N +
                ", index=" + index +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    public static void main(String[] args) {
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
}