package data_structure.arrays.questions.matrices.graph;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Input:
 * [["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]]
 * <p>
 * Output: 3
 * <p>
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    static void dfs(char[][] grid, int i, int j) {
        if ((i >= 0) && (i < grid.length) && (j >= 0) && (j < grid[i].length) && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);//up
            dfs(grid, i + 1, j);//down
            dfs(grid, i, j + 1);//right
            dfs(grid, i, j - 1);//left
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        char[][] grid2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
        System.out.println(numIslands(grid2));
    }
}
