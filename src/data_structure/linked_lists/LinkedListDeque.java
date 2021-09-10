package data_structure.linked_lists;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Deque = Double Ended Queue
public class LinkedListDeque<Item> implements Iterable<Item> {

    static class Node {
        Object value;
        Node next;
        Node prev;

        public Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    // construct an empty deque
    public LinkedListDeque() {}

    // is the deque empty?
    public boolean isEmpty() {
        return head == null;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validate(item);

        Node node = new Node(item);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;

            head = node;
        }

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validate(item);
        Node node = new Node(item);
        tail.next = node;
        node.prev = tail;

        tail = node;
        size++;
    }

    // remove and return the item from the front
    @SuppressWarnings("unchecked")
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node temp = head;
            head = head.next;

            temp.next = null;
            temp.prev = null;
            size--;
            return (Item) temp.value;
        }
    }

    // remove and return the item from the back
    @SuppressWarnings("unchecked")
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            Node temp = tail;
            tail = tail.prev;

            temp.next = null;
            temp.prev = null;
            size--;
            return (Item) temp.value;
        }
    }

    // return an iterator over items in order from front to back
    @NotNull
    @Override
    public Iterator<Item> iterator() {

        return new Iterator<>() {
            Node iteratorHead = head;
            int index;
            final int size = size();

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public Item next() {
                if (hasNext()) {
                    Node current = iteratorHead;
                    iteratorHead = iteratorHead.next;
                    index++;
                    return (Item) current.value;
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
        return "LinkedListDeque{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    private void validate(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }
}
