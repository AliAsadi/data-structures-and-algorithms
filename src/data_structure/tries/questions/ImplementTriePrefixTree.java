package data_structure.tries.questions;

import java.util.HashMap;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * <p>
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * <p>
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTriePrefixTree {

    static class TrieNode {
        boolean end = false;
        HashMap<Character, TrieNode> children = new HashMap<>();
    }

    static class Trie {

        TrieNode root = new TrieNode();

        public Trie() {

        }

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                boolean charNotExist = !current.children.containsKey(c);
                if (charNotExist) current.children.put(c, new TrieNode());
                current = current.children.get(c);
            }
            current.end = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                boolean charNotExist = !current.children.containsKey(c);
                if (charNotExist) return false;
                current = current.children.get(c);
            }

            return current.end;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                boolean charNotExist = !current.children.containsKey(c);
                if (charNotExist) return false;
                current = current.children.get(c);
            }

            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("dog"));//false
        trie.insert("dog");
        System.out.println(trie.search("dog"));//true
        System.out.println(trie.startsWith("app"));//true
        System.out.println(trie.search("app"));//false
        trie.insert("app");
        System.out.println(trie.search("app"));//true

    }
}
