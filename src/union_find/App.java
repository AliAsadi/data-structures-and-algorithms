package union_find;

public class App {
    public static void main(String[] args) {
        Percolation percolation = new Percolation(5);

        percolation.open(3, 0);
        percolation.open(2, 0);

        percolation.open(1, 0);
        percolation.open(1, 0);

        percolation.open(0, 0);
        percolation.open(0, 3);
        percolation.open(0, 2);
        percolation.open(2, 0);
        percolation.open(2, 1);
        percolation.open(2, 3);
        percolation.open(2, 4);
        percolation.open(2, 2);
        percolation.open(2, 0);
        percolation.open(2, 3);
        percolation.open(3, 4);
        percolation.open(2, 3);
        percolation.open(2, 3);
        percolation.open(2, 4);
        percolation.open(0, 4);
        percolation.open(1, 4);

//        percolation.open(4, 4);


        System.out.println("isFull: " + percolation.isFull(2,4));
        System.out.println("numberOfOpenSites: " + percolation.numberOfOpenSites());
        System.out.println("percolates: " + percolation.percolates());

    }

    static void findLargestNumberInComponent2() {
        QuickUnionUF qUnion = new QuickUnionUF(10);

        qUnion.unionLargest(6, 1);
        qUnion.unionLargest(6, 9);
        qUnion.unionLargest(9, 1);
        qUnion.unionLargest(9, 2);

        qUnion.unionLargest(7, 5);

        System.out.println("parent: " + qUnion.findLargestNumberInComponent(6));
        System.out.println("components: " + qUnion.count());
        System.out.println(qUnion.toString());
    }

    static void findLargestNumberInComponent() {
        QuickUnionUF qUnion = new QuickUnionUF(10);
        qUnion.union(0, 2);
        qUnion.union(1, 2);
        qUnion.union(4, 3);
        qUnion.union(5, 3);
        qUnion.union(6, 3);
        qUnion.union(7, 2);
        qUnion.union(2, 8);
        qUnion.union(9, 2);

        System.out.println("parent: " + qUnion.findLargestNumberInComponent(3));
        System.out.println("components: " + qUnion.count());
        System.out.println(qUnion.toString());
    }

    static void quickUnion() {
        QuickUnionUF qUnion = new QuickUnionUF(10);
        qUnion.union(0, 2);
        qUnion.union(1, 2);
        qUnion.union(2, 2);
        qUnion.union(3, 2);
        qUnion.union(4, 2);
        qUnion.union(5, 2);
        qUnion.union(6, 2);
        qUnion.union(7, 2);
        qUnion.union(2, 8);
        qUnion.union(9, 2);

        System.out.println("parent: " + qUnion.find(0));
        System.out.println("components: " + qUnion.count());
        System.out.println(qUnion.toString());
    }

    static void quickFind() {
        QuickFindUF qFind = new QuickFindUF(10);
        qFind.union(0, 2);
        qFind.union(1, 2);
        qFind.union(2, 2);
        qFind.union(3, 2);
        qFind.union(4, 2);
        qFind.union(5, 2);
        qFind.union(6, 2);
        qFind.union(7, 2);
        qFind.union(2, 8);
        qFind.union(9, 2);
        System.out.println("parent: " + qFind.find(0));
        System.out.println("components: " + qFind.count());
        System.out.println(qFind.toString());

    }
}
