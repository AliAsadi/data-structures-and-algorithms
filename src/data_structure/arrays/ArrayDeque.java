package data_structure.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Deque = Double Ended Queue
public class ArrayDeque<Item> implements Iterable<Item> {

    private Object[] items;

    private int N = 10;

    private final int head = 0;
    private int tail = 0;

    // construct an empty deque
    public ArrayDeque() {
        items = new Object[N];
    }

    // is the deque empty?
    public boolean isEmpty() {
        return tail == 0;
    }

    // return the number of items on the deque
    public int size() {
        return tail;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validate(item);
        items = shiftRight(items);
        items[head] = item;
        tail++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validate(item);
        items[tail++] = item;
    }

    private void validate(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        resize();
    }

    private void resize() {
        if (items.length == tail) {
            N = N * 2;
            items = Arrays.copyOf(items, N);
        }
    }

    private void resizeSmaller() {
        if (tail == items.length * (20.0 / 100)) {
            N = N / 2;
            items = Arrays.copyOf(items, N);
        }
    }

    // remove and return the item from the front
    @SuppressWarnings("unchecked")
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Item item = (Item) items[head];
            items[head] = null;
            items = shiftLeft(items);
            tail--;
            resizeSmaller();
            return item;
        }
    }

    // remove and return the item from the back
    @SuppressWarnings("unchecked")
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Item item = (Item) items[--tail];
            items[tail] = null;
            resizeSmaller();
            return item;
        }
    }

    @NotNull
    private Object[] shiftRight(Object[] items) {
        Object[] temp = new Object[items.length];
        if (items.length - 1 >= 0) System.arraycopy(items, 0, temp, 1, items.length - 1);
        return temp;
    }

    @NotNull
    private Object[] shiftLeft(Object[] items) {
        Object[] temp = new Object[items.length];
        if (items.length - 1 >= 0) System.arraycopy(items, 1, temp, 0, items.length - 1);
        return temp;
    }

    // return an iterator over items in order from front to back
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int iteratorHead = head;
            final int iteratorTail = tail;

            @Override
            public boolean hasNext() {
                return iteratorHead < iteratorTail;
            }

            @Override
            @SuppressWarnings("unchecked")
            public Item next() {
                if (hasNext()) {
                    return (Item) items[iteratorHead++];
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        return "Deque{" +
                "items=" + Arrays.toString(items) +
                ", N=" + N +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
