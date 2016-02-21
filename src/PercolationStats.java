import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] tests;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) throw new IllegalArgumentException("[N: " + N + ", T: " + T + "]; Required: N,T > 0");
        tests = new double[T];
        for (int t = 0; t < T; t++) {
            double opened = 0;
            Percolation perc = new Percolation(N);
            while (!perc.percolates()) {
                int i = StdRandom.uniform(1, N + 1);
                int j = StdRandom.uniform(1, N + 1);
                if (!perc.isOpen(i, j)) {
                    perc.open(i, j);
                    opened++;
                }
            }
            tests[t] = opened / (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(tests);
    }

    public double stddev() {
        return StdStats.stddev(tests);
    }

    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(tests.length);
    }

    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(tests.length);
    }

    public static void main(String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("Insert 2 arguments: java PercolationStats N T");

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percStats = new PercolationStats(N, T);
        System.out.println("mean                    = " + percStats.mean());
        System.out.println("stddev                  = " + percStats.stddev());
        System.out.println("95% confidence interval = " + percStats.confidenceLo() + ", " + percStats.confidenceHi());
    }
}
