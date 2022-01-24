package data_structure.arrays.questions.matrices;

import java.util.Arrays;

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
 * <p>
 * space = 999
 * gate = 0
 * wall = -1
 * <p>
 * https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {

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
        System.out.println(Arrays.deepToString(maze));
    }
}
