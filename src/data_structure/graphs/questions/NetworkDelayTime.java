package data_structure.graphs.questions;

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times,
 * a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 * <p>
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {

    /**
     * Solution: DIJKSTRA
     **/
    public static int networkDelayTime(int[][] times, int n, int k) {

        // Build the adjacency list
        Map<Integer, List<NodeInfo>> adjacencyList = buildAdjacencyList(times);

        int[] distances = dijkstra(adjacencyList, n, k);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) answer = Math.max(answer, distances[i]);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static Map<Integer, List<NodeInfo>> buildAdjacencyList(int[][] times) {
        Map<Integer, List<NodeInfo>> adjacencyList = new HashMap<>();

        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adjacencyList.putIfAbsent(source, new ArrayList<>());
            adjacencyList.get(source).add(new NodeInfo(travelTime, dest));
        }

        return adjacencyList;
    }

    private static int[] dijkstra(Map<Integer, List<NodeInfo>> adjacencyList, int totalNumberOfNodes, int entryNode) {
        int[] distances = createDistancesArray(totalNumberOfNodes);

        Queue<NodeInfo> queue = new PriorityQueue<>(Comparator.comparing(NodeInfo::getTime));

        queue.add(new NodeInfo(0, entryNode));

        // Time for starting node is 0
        distances[entryNode] = 0;

        while (!queue.isEmpty()) {
            NodeInfo node = queue.remove();

            int currNode = node.getNode();
            int currNodeTime = node.getTime();

            boolean noDirectionFromThisNode = !adjacencyList.containsKey(currNode);
            if (noDirectionFromThisNode) continue;

            for (NodeInfo edge : adjacencyList.get(currNode)) {
                int time = edge.getTime();
                int neighborNode = edge.getNode();

                if (distances[neighborNode] > currNodeTime + time) {
                    distances[neighborNode] = currNodeTime + time;
                    queue.add(new NodeInfo(distances[neighborNode], neighborNode));
                }
            }
        }

        return distances;
    }

    private static int[] createDistancesArray(int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        return distances;
    }

    static class NodeInfo {
        int time;
        int node;

        public NodeInfo(int time, int node) {
            this.time = time;
            this.node = node;
        }

        public int getTime() {
            return time;
        }

        public int getNode() {
            return node;
        }
    }


    public static void main(String[] args) {
//        int value = networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
//        int value = networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1);
        int value = networkDelayTime(new int[][]{{1, 2, 9}, {1, 4, 2}, {2, 5, 1}, {4, 2, 4}, {4, 5, 6}, {5, 3, 7}, {3, 2, 3}, {3, 1, 5}}, 5, 1);

        System.out.println(value);
    }
}
