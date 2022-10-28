package data_structure.union_find;

public class Percolation {

    private final int[][] arr;

    private final int top;
    private final int bottom;

    private final WeightedQuickUnionUF quickUnionUF;

    private final int n;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        quickUnionUF = new WeightedQuickUnionUF(n * n + 2);

        top = n * n;
        bottom = n * n + 1;

        arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) return;

        //open site
        arr[row][col] = 1;

        int index = getIndex(row, col);

        if (isTop(row)) {
            quickUnionUF.union(index, top);
        }

        if (isBottom(row)) {
            quickUnionUF.union(index, bottom);
        }

        connectTo(row - 1, col, index);
        connectTo(row + 1, col, index);
        connectTo(row, col - 1, index);
        connectTo(row, col + 1, index);
    }

    private void connectTo(int row, int col, int index) {
        if (isValid(row, col) && isOpen(row, col)) {
            quickUnionUF.union(getIndex(row, col), index);
        }
    }

    boolean isValid(int row, int col) {
        return row > -1 && row < n
                && col > -1 && col < n;
    }

    private boolean isTop(int row) {
        return row == 0;
    }

    private boolean isBottom(int row) {
        return row == n - 1;
    }

    private int getIndex(int row, int col) {
        return row * n + col;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return arr[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return quickUnionUF.connected(getIndex(row, col), top);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int openSites = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (isOpen(i, j)) {
                    openSites++;
                }
            }
        }
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return quickUnionUF.connected(top, bottom);
    }
}
