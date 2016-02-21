package exercises1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/exercises1/q2.dat"));
        int N = Integer.parseInt(sc.nextLine());
        int S = Integer.parseInt(sc.nextLine());
        WeightedQuickUnionUF qu = new WeightedQuickUnionUF(N);

        System.out.print("     ");
        for (int n = 0; n < N; n++) {
            System.out.print(qu.find(n) + " ");
        }
        System.out.println();

        String line = sc.nextLine();
        String[] inputs = line.split(" ");
        for (String input : inputs) {
            String[] pq = input.split("\\p{Pd}");
            int p = Integer.parseInt(pq[0]);
            int q = Integer.parseInt(pq[1]);
            qu.union(p, q);

            System.out.print(p + "-" + q + ": ");
            for (int n = 0; n < N; n++) {
                System.out.print(qu.parent[n] + " ");
            }
            System.out.println();
        }
    }
}
