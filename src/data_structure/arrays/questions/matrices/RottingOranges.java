package data_structure.arrays.questions.matrices;

import kotlin.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * <p>
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * <p>
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int[][] directions = {
                {-1, 0},//up
                {1, 0},//down
                {0, 1},//right
                {0, -1}//left
        };

        int minutes = 0;
        int fresh = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) fresh++;
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        if (fresh == 0) return 0;

        while (!queue.isEmpty()) {
            int rottenNum = queue.size();

            while (rottenNum > 0) {
                rottenNum--;

                int[] orangeIdx = queue.poll();

                for (int[] direction : directions) {
                    int i = direction[0] + orangeIdx[0];//x
                    int j = direction[1] + orangeIdx[1];//y

                    if ((i >= 0) && (i < grid.length) && (j >= 0) && (j < grid[i].length) && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        fresh--;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            minutes++;
        }

        return (fresh == 0) ? minutes - 1 : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};

        System.out.println(orangesRotting(grid));
        System.out.println(orangesRotting(grid2));

    }
}
