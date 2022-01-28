package data_structure.arrays.questions.matrices.backtracking;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 * <p>
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        backtrackSolve(board);
    }

    public static boolean backtrackSolve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {// Try 1 through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (backtrackSolve(board)) {
                                return true; //If it's the solution return true
                            } else {
                                board[i][j] = '.'; //Otherwise go back
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false; //check row
            if (board[row][i] != '.' && board[row][i] == c) return false; //check column
            int blockRow = 3 * (row / 3) + i / 3;
            int blockColumn = 3 * (col / 3) + i % 3;
            if (board[blockRow][blockColumn] != '.' && board[blockRow][blockColumn] == c) return false; //check 3*3 block
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(Arrays.deepToString(board));

        solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }
}
