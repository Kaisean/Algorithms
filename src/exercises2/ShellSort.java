package exercises2;

public class ShellSort {
    public static void main(String[] args) {
        int[] a = {26, 63, 66, 38, 15, 20, 10, 77, 19, 58};
        sort(a);
        //printArray(a);
    }

    public static void sort(int[] a) {
        int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    exchange(a, j, j - h);
                }
            }

            System.out.print("h: " + h + " | ");
            printArray(a);

            h /= 3;
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printArray(int[] a) {
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }
}
