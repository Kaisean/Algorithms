package exercises1;

import edu.princeton.cs.algs4.QuickFindUF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/exercises1/q1.dat"));
        int N = Integer.parseInt(sc.nextLine());
        QuickFindUF qf = new QuickFindUF(N);
        int S = Integer.parseInt(sc.nextLine());

        String line = sc.nextLine();
        String[] inputs = line.split(" ");
        for (String input : inputs) {
            String[] pq = input.split("\\p{Pd}");
            int p = Integer.parseInt(pq[0]);
            int q = Integer.parseInt(pq[1]);
            qf.union(p, q);
        }


        for (int n = 0; n < N; n++) {
            System.out.print(qf.find(n) + " ");
        }
    }
}
