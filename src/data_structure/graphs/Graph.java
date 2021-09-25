package data_structure.graphs;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

/**
 * Created by Ali Asadi on 25/09/2021
 */
public class Graph {

    private int numOfNodes = 0;
    private final HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();

    void addVertex(int value) {
        if (adjacencyList.get(value) == null) {
            adjacencyList.put(value, new ArrayList<>());
            numOfNodes++;
        }
    }

    void addEdge(int value1, int value2) {
        if (adjacencyList.get(value1) != null && adjacencyList.get(value2) != null) {
            adjacencyList.get(value1).add(value2);
            adjacencyList.get(value2).add(value1);
        }
    }

    public void showConnections() {
        Set<Integer> keys = adjacencyList.keySet();
        for (int node : keys) {
            List<Integer> nodeConnections = adjacencyList.get(node);
            StringBuilder connections = new StringBuilder();
            for (int edge : nodeConnections) {
                connections.append(edge).append(" ");
            }
            System.out.println(node + "-->" + connections);
        }
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(5);
        myGraph.addVertex(6);
        myGraph.addEdge(3, 1);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(4, 5);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(1, 0);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(6, 5);

        myGraph.showConnections();

//        Answer:
//        0-- > 1 2
//        1-- > 3 2 0
//        2-- > 4 1 0
//        3-- > 1 4
//        4-- > 3 2 5
//        5-- > 4 6
//        6-- > 5
    }
}
