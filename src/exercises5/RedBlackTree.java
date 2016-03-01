package exercises5;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class RedBlackTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner("40 14 89 10 34 70 97 69 87 72");
        RedBlackBST<Integer, Integer> rb = new RedBlackBST();
        while(sc.hasNextInt()) rb.put(sc.nextInt(), null);
        for (Integer s : rb.keys())
            StdOut.println(s + " " + rb.get(s));
    }
}
