package data_structure.graphs.questions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
 * <p>
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
 * <p>
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * <p>
 * Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * Output: 1
 * Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
 * The tree structure of the employees in the company is shown.
 * <p>
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
public class TimeNeededToInformAllEmployees {

    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    /**
     * Time: O(n)
     * Space: O(n)
     * **/
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for (int employee = 0; employee < manager.length; employee++) {
            int employeeManager = manager[employee];
            if (!graph.containsKey(employeeManager)) graph.put(employeeManager, new ArrayList<>());
            graph.get(employeeManager).add(employee);
        }
        System.out.println(graph);

        return dfs(graph, informTime, headID);
    }

    private static int dfs(HashMap<Integer, ArrayList<Integer>> graph, int[] informTime, int cur) {
        int max = 0;

        boolean hasChildren = graph.containsKey(cur);
        if (!hasChildren) return max;

        for (int i = 0; i < graph.get(cur).size(); i++){
            int maxValue = dfs(graph, informTime, graph.get(cur).get(i));
            max = Math.max(max, maxValue);
        }

        return max + informTime[cur];
    }
    public static void main(String[] args) {
//        int[] manager = {2, 2, -1, 2, 2, 2};
//        int[] informTime = {0, 0, 1, 0, 0, 0};

        int[] manager = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informTime = {0, 0, 4, 0, 7, 3, 6, 0};

        System.out.println("R:" + numOfMinutes(manager.length, 4, manager, informTime));

    }
}
