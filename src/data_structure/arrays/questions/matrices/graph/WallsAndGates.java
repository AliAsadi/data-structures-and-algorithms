package data_structure.arrays.questions.matrices.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a maze with cells being: gates, walls or empty spaces.
 * Fill the empty spaces with the number of steps to the closest gate. Allowed steps: UP, RIGHT, LEFT & DOWN
 * <p>
 * Input:
 * _ W G _
 * _ _ _ W
 * _ W _ W
 * G W _ _
 * <p>
 * Output:
 * 3 W G 1
 * 2 2 1 W
 * 1 W 2 W
 * G W 3 4
 * <p>
 * space = 999
 * gate = 0
 * wall = -1
 * <p>
 * https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {

    /**
     * Time: O(n)
     * Space: O(n)
     **/
    public static void solution(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) { //gate
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    public static void solutionBfs(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) { //gate
                    queue.add(new int[]{i, j});
                    bfs(queue, grid, 0);
                }
            }
        }
    }


    static void bfs(Queue<int[]> queue, int[][] grid, int steps) {

        int[][] directions = {
                {-1, 0},//up
                {1, 0},//down
                {0, 1},//right
                {0, -1}//left
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            while (size > 0) {
                int[] idx = queue.poll();
                size--;
                for (int[] direction : directions) {
                    int i = direction[0] + idx[0];//x
                    int j = direction[1] + idx[1];//y

                    if ((i >= 0) && (i < grid.length) && (j >= 0) && (j < grid[i].length) && grid[i][j] >= steps) {
                        grid[i][j] = steps;
                        queue.add(new int[]{i, j});
                    }
                }
            }

        }

    }

    static void dfs(int[][] grid, int i, int j, int steps) {
        if ((i >= 0) && (i < grid.length) && (j >= 0) && (j < grid[i].length) && grid[i][j] >= steps) {
            grid[i][j] = steps;

            dfs(grid, i - 1, j, steps + 1);//up
            dfs(grid, i + 1, j, steps + 1);//down
            dfs(grid, i, j + 1, steps + 1);//right
            dfs(grid, i, j - 1, steps + 1);//left
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {999, -1, 0, 999},
                {999, 999, 999, -1},
                {999, -1, 999, -1},
                {0, -1, 999, 999}
        };

        solution(maze);
//        solutionBfs(maze);
        System.out.println(Arrays.deepToString(maze));
    }
}
