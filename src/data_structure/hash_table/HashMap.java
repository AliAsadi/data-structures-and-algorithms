package data_structure.hash_table;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Ali Asadi on 15/09/2021
 */
public class HashMap<K, V> {

    private int N = 10;

    private int size = 0;
    private Node<K, V>[] table;

    public HashMap() {
        table = new Node[N];
    }

    public HashMap(int capacity) {
        N = capacity;
        table = new Node[N];
    }

    public V put(K key, V value) {
        resize();

        int index = hash(key);
        Node<K, V> node = table[index];

        if (node == null) {
            size++;
            table[index] = new Node<>(key, value);
            return value;
        } else {

            //check first node
            if (node.key == key) {
                node.value = value;
                return value;
            }

            while (node.next != null) {
                //check if key exist
                if (node.key == key) {
                    node.value = value;
                    return value;
                }
                node = node.next;
            }

            size++;
            node.next = new Node<>(key, value);
        }

        return value;
    }

    @Nullable
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return (node != null) ? node.value : null;
    }

    @Nullable
    private Node<K, V> getNode(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    /**
     * Time Complexity
     * Best: O(1)
     * Worst: O(n)
     * **/
    @Nullable
    public V remove(K key) {
        int index = hash(key);
        Node<K, V> node = table[index];

        if (node != null) {
            //check first node
            if (node.key.equals(key)) {
                table[index] = node.next;
                size--;
                return node.value;
            }

            Node<K, V> prev = node;  //first node
            node = node.next; //second node

            while (node != null) {
                if (node.key.equals(key)) {
                    prev.next = node.next;
                    size--;
                    return node.value;
                }
                prev = node;
                node = node.next;
            }
        }

        return null;
    }

    private void resize() {
        if (table.length == size) {
            Node<K, V>[] temp = table;

            N = N * 2;
            table = new Node[N];
            size = 0;

            //re-hashing
            for (Node<K, V> node : temp) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public int hash(K key) {
        return Objects.hash(key) % N;
    }

    @Override
    public String toString() {
        return "HashMap{" +
                "N=" + N +
                ", size=" + size +
                ", table=" + Arrays.toString(table) +
                '}';
    }

    public void printMapCollision() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            if (node != null) {
                s.append("index:").append(i).append(" -> ");

                while (node != null) {

                    s.append("(").append(node.key).append(")");

                    node = node.next;
                    if (node != null) {
                        s.append(" -> ");
                    }
                }
                s.append(System.lineSeparator());
            }
        }

        System.out.println(s.toString());
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next= " + ((next != null) ? next.key : null) +
                    '}';
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ali", "aa");
        map.put("ali2", "aa"); //Collision "ali" & "ali2" have the same hash value (before the for loop and the resizing)
        map.put("ali3", "aa");
        map.put("ali3", "test");

        for (int i = 0; i < 200000; i++) {
            map.put("" + i, "" + i);
        }

        map.remove("ali3");

        map.printMapCollision();
//        System.out.println(map);
        System.out.println(map.get("ali3"));
        System.out.println(map.hash("ali"));
    }
}

