package data_structure.graphs;


import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 *
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    public static Node cloneGraph(Node node) {
        return bfs(node);
    }

    private static Node bfs(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        int root = node.val;
        map.put(root, new Node(node.val, new ArrayList<>()));

        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            Node newNode = map.get(currentNode.val);

            for (Node neighbor : currentNode.neighbors) {
                Node newNeighbor = new Node(neighbor.val, new ArrayList<>());
                if (!map.containsKey(neighbor.val)) {
                    map.put(newNeighbor.val, newNeighbor);
                    queue.add(neighbor);
                }

                newNode.neighbors.add(map.get(neighbor.val));
            }

        }
        return map.get(root);
    }


    static void bfsPrintUndirectedGraph(Node node) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            map.put(currentNode.val, new ArrayList<>());

            for (Node neighbor : currentNode.neighbors) {
                map.get(currentNode.val).add(neighbor.val);
                if (!map.containsKey(neighbor.val)) queue.add(neighbor);
            }
        }

        System.out.println(map);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(List.of(new Node[]{node2, node4}));
        node2.neighbors.addAll(List.of(new Node[]{node1, node3}));
        node3.neighbors.addAll(List.of(new Node[]{node2, node4}));
        node4.neighbors.addAll(List.of(new Node[]{node1, node3}));

        bfsPrintUndirectedGraph(node1);
        Node newNode = cloneGraph(node1);
        bfsPrintUndirectedGraph(newNode);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}


