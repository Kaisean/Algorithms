package exercises4;

import java.util.Scanner;

public class BinaryHeap {
    public int[] pq;
    private int N;

    public BinaryHeap(int capacity) {
        pq = new int[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void swim(int k) {
        while (k > 1 && pq[k / 2] < pq[k]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void insert(int key) {
        pq[++N] = key;
        swim(N);
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && pq[j] < pq[j + 1]) j++;
            if (!(pq[k] < pq[j])) break;
            exch(k, j);
            k = j;
        }
    }

    public int delMax() {
        int max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = 0;
        return max;
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap(13);
        Scanner sc = new Scanner("96 81 61 68 70 25 51 43 65 63");
        while (sc.hasNextInt()) bh.insert(sc.nextInt());
        System.out.print("Initial: ");
        printArray(bh.pq);
        int[] input = new int[]{88, 62, 19};
        for (int i : input) {
            bh.insert(i);
            System.out.print("Insert " + i + ": ");
            printArray(bh.pq);
        }

        System.out.println();

        bh = new BinaryHeap(10);
        sc = new Scanner("93 77 91 75 64 25 42 17 30 52");
        while (sc.hasNextInt()) bh.insert(sc.nextInt());
        System.out.print("Initial: ");
        printArray(bh.pq);
        for (int i = 0; i < 3; i++) {
            System.out.print("delMax() returns " + bh.delMax() + ": ");
            printArray(bh.pq);
        }

        System.out.println();

        bh = new BinaryHeap(10);
        sc = new Scanner("3 2 1");
        while (sc.hasNextInt()) bh.insert(sc.nextInt());
        System.out.print("Initial: ");
        printArray(bh.pq);
        int pop = bh.delMax();
        System.out.print("delMax() and re-insert " + pop + ": ");
        bh.insert(pop);
        printArray(bh.pq);
    }

    private static void printArray(int[] a) {
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }
}
