import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("test/resources/solution.dat"));
        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] elements = new int[N];
        for(int n = 0; n<N; n++) {
            elements[n] = sc.nextInt();
        }

        for(int q = 0; q<Q; q++) {
            int type = sc.nextInt();
            int i = sc.nextInt();
            int j = sc.nextInt();
            int[] lhs = Arrays.copyOfRange(elements, 0, i-1);
            int[] range = Arrays.copyOfRange(elements, i-1, j);
            int[] rhs = Arrays.copyOfRange(elements, j, N);

            if(type==1){ //move range [i, j] to the front
                /*
                 * 1. Push LHS up by range.length.
                 * 2. Insert range into gap.
                 */
                elements = join(range, lhs, rhs);
            } else if (type==2) { //move range [i, j] to the back
                /*
                 * 1. Push RHS down by range.length.
                 * 2. Insert range into gap.
                 */
                elements = join(lhs, rhs, range);
            }
            printArray(elements);
        }
        System.out.println(Math.abs(elements[0]-elements[N-1]));
        printArray(elements);
    }

    public static int[] join(int[] ... parms) {
        // calculate size of target array
        int size = 0;
        for (int[] array : parms) {
            size += array.length;
        }

        int[] result = new int[size];

        int j = 0;
        for (int[] array : parms) {
            for (int s : array) {
                result[j++] = s;
            }
        }
        return result;
    }

    private static void printArray(int[] arr) {
        for(int a : arr) System.out.print(a + " ");
        System.out.println();
    }
}