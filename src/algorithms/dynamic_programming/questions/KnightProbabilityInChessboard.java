package algorithms.dynamic_programming.questions;

/**
 * On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
 * <p>
 * A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
 * <p>
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * <p>
 * The knight continues moving until it has made exactly k moves or has moved off the chessboard.
 * <p>
 * Return the probability that the knight remains on the board after it has stopped moving.
 * <p>
 * Example 1:
 * Input: n = 3, k = 2, row = 0, column = 0
 * Output: 0.06250
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * <p>
 * Example 2:
 * Input: n = 1, k = 0, row = 0, column = 0
 * Output: 1.00000
 * <p>
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 */
public class KnightProbabilityInChessboard {

    static int[][] directions = new int[][]{{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};


    /**
     * https://leetcode.com/problems/knight-probability-in-chessboard/discuss/162722/Simple-Java-DP-solution-with-explanation
     * **/
    public static double knightProbability(int n, int moves, int row, int column) {
        double [][][] ways = new double[moves+1][n][n];
        ways[0][row][column]=1;
        for(int m=1; m<=moves;++m){
            for(int i=0; i<n;++i){
                for(int j=0; j<n;++j){
                    for(int [] dir: directions){
                        int oldR = i-dir[0];
                        int oldC = j-dir[1];
                        if(oldR>=0 && oldC>=0 && oldR<n && oldC<n){
                            ways[m][i][j]+=(ways[m-1][oldR][oldC]/8.0);
                        }
                    }
                }
            }
        }
        double res = 0;
        for(int i=0; i<n;++i){
            for(int j=0; j<n;++j){
                res+=ways[moves][i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }
}
