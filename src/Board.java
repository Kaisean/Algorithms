public class Board {
    private int[][] tiles;
    private int N;
    private int hamming = 0;
    private int manhattan = 0;

    public Board(int[][] blocks) {
        N = blocks.length;
        tiles = blocks;

        // Calculate Hamming function
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = N * i + j + 1;
                int tile = tiles[i][j];
                hamming += (tile == n) || (tile == 0) ? 0 : 1;
            }
        }

        // Calculate Manhattan function
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int n = N * i + j + 1;  // location of tile
                int tile = tiles[i][j]; // tile number
                manhattan += (tile == n) || (tile == 0) ? 0 : Math.abs(tile - n) / N + Math.abs(tile - n) % N;
            }
        }
    }

    public int dimension() {                 // board dimension N
        return N;
    }

    public int hamming() {                  // number of tiles out of place
        return hamming;
    }

    public int manhattan() {
        return manhattan;
    }

    public boolean isGoal() {
        return hamming == 0;
    }

    public Board twin() {
        int[][] copy = tiles;
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(copy[i][j]!=0)
            }
        }*/
        return new Board(copy);
    }

    public boolean equals(Object y) {
        return false;
    }        // does this board equal y?

    public Iterable<Board> neighbors() {
        return null;
    }     // all neighboring boards

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tiles[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        int[][] blocks = {{8, 1, 3}, {4, 0, 2}, {7, 6, 5}};
        //int[][] blocks = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board board = new Board(blocks);
        System.out.println(board.toString());
        System.out.println("Hamming: " + board.hamming());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("isGoal: " + board.isGoal());

    }

}
