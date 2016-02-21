public class Board {
    private char[] blocks;
    private int N;
    private int hamming;

    public Board(int[][] blocks) {           // construct a board from an N-by-N array of blocks
        N = blocks.length;
        this.blocks = new char[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.blocks[i + j] = Character.forDigit(blocks[i][j], 10);
            }
        }

        for (int n = 0; n < N; n++) {
            hamming += this.blocks[n] == Character.forDigit(n,10) ? 1 : 0;
        }


    }

    // (where blocks[i][j] = block in row i, column j)
    public int dimension() {                 // board dimension N
        return N;
    }

    public int hamming() {                  // number of blocks out of place
        return hamming;
    }

    public int manhattan(){return 0;}                 // sum of Manhattan distances between blocks and goal

    public boolean isGoal(){return false;}                // is this board the goal board?

    public Board twin(){return null;}                    // a board that is obtained by exchanging any pair of blocks

    public boolean equals(Object y){return false;}        // does this board equal y?

    public Iterable<Board> neighbors(){return null;}     // all neighboring boards

    public String toString(){return null;}               // string representation of this board (in the output format specified below)

    public static void main(String[] args){} // unit tests (not graded)

}
