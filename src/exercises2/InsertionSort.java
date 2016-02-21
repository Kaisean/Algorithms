package exercises2;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {27, 32, 59, 82, 96, 71, 67, 38, 33, 47};
        sort(a);
    }

    public static void sort(int[] a) {
        for(int i = 0; i<a.length; i++) {
            for(int j = i; j>0 && a[j] < a[j-1] ; j--) {
                exchange(a, j, j-1);
                printArray(a);
            }
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void printArray(int[] a) {
        for(int i : a) System.out.print(i + " ");
        System.out.println();
    }
}
