import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Kevin Kim
 * 2016-01-24
 * Percolation class for creating a status that tracks node sets and node openness.
 * <p/>
 * Values for status:
 * 000 - Closed
 * 001 - Open
 * 011 - Open and connected to Bottom
 * 101 - Open and connected to Top
 * 111 - Open and connected to Top and Bottom
 */
public class Percolation {
    private boolean percolates;
    private int[] status;
    private int N;
    private final WeightedQuickUnionUF uf;

    /*
     * Create N-by-N grid, with all sites blocked
     */
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("N = " + N + ", N must be > 0.");
        uf = new WeightedQuickUnionUF(N * N);
        status = new int[N * N];
        this.N = N;
        percolates = false;
    }

    /*
     * Open site (row i, column j) if it is not open already
     */
    public void open(int i, int j) {
        if (isOpen(i, j)) return;
        int node = point(i, j);
        status[node] = 0b001;

        if (i == 1) status[node] = status[node] | 0b101;
        if (i == N) status[node] = status[node] | 0b011;

        if (i > 1 && isOpen(i - 1, j)) connect(node, point(i - 1, j));
        if (i < N && isOpen(i + 1, j)) connect(node, point(i + 1, j));
        if (j > 1 && isOpen(i, j - 1)) connect(node, point(i, j - 1));
        if (j < N && isOpen(i, j + 1)) connect(node, point(i, j + 1));

        if (status[uf.find(node)] == 0b111) percolates = true;
    }

    private void connect(int node, int neighbor) {
        int nodeStatus = status[uf.find(neighbor)] | status[uf.find(node)];
        uf.union(neighbor, node);
        status[uf.find(node)] = nodeStatus;
    }

    public boolean isOpen(int i, int j) {
        return (status[point(i, j)] & 0b001) == 0b1;
    }

    public boolean isFull(int i, int j) {
        return ((status[uf.find(point(i, j))] >> 2) & 0b001) == 0b1;
    }

    public boolean percolates() {
        return percolates;
    }

    private void validate(int i, int j) {
        if (i < 1 || i > N) throw new IndexOutOfBoundsException("Row index i out of bounds.");
        if (j < 1 || j > N) throw new IndexOutOfBoundsException("Row index j out of bounds.");
    }

    private int point(int i, int j) {
        validate(i, j);
        return (i - 1) * N + (j - 1);
    }
}
