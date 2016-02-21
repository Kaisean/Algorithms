import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Subset {
    public static void main(String[] args) {
        int K = Integer.parseInt(args[0]);
        RandomizedQueue<String> rQ = new RandomizedQueue<>();
        String[] input = StdIn.readAllStrings();
        StdRandom.shuffle(input);
        for (int k = 0; k < K; k++) rQ.enqueue(input[k]);
        for (String token : rQ) System.out.println(token);
    }
}