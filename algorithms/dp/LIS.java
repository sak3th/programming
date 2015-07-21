package dp;

import java.util.Arrays;

/**
 * Longest Increasing Sequence(subsequence). Also referred to as Maximum Monotone Subsequence.
 *
 * A numerical sequence is monotonically increasing if the ith element is at least as big as the (i - 1)st element.
 *
 * Example
 * Input {2, 4, 3, 5, 1, 7, 6, 9, 8}
 * Output 5  - Any of {2, 4, 5, 7, 9}, {2, 4, 5, 7, 8}, {2, 3, 5, 6, 8}, ...
 */
public class LIS {

    public static void main(String[] args) {
        lis(new int[]{ 10, 22, 9, 33, 19, 20, 21, 50, 41, 60, 80 });
        //rLis(new int[]{2, 4, 3, 5, 1, 7, 6, 9, 8});
        rLis(new int[]{ 10, 22, 9, 33, 19, 20, 21, 50, 41, 60, 80 });

    }

    static void lis(int[] array) {
        int[] lis = new int[array.length];
        int[] pre = new int[array.length];
        Arrays.fill(lis, 1);
        Arrays.fill(pre, -1);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int maxLisAt = 0;
        for (int max = 0, i = 0; i < lis.length; i++) {
            if (max < lis[i]) {
                max = lis[i];
                maxLisAt = i;
            }
        }
        for (int e : array) System.out.print(e + " "); System.out.println();
        for (int e : lis) System.out.print(e + " "); System.out.println();
        for (int e : pre) System.out.print(e + " "); System.out.println();
        System.out.println(lis[maxLisAt]);
        int predecessor = maxLisAt;
        while (predecessor != -1) {
            System.out.print(array[predecessor] + " ");
            predecessor = pre[predecessor];
        }
    }

    static void rLis(int[] arr) {
        for (int e : arr) System.out.print(e + " "); System.out.println();
        System.out.println(rdp(arr, 0, Integer.MIN_VALUE));
    }

    static int rdp(int[] arr, int index, int max) {
        //System.out.println("(" +index + ", " + max + ")");
        int u = 0;
        if (index == arr.length - 1) {
            if (arr[index] > max) {
                return 1;
            }
            return 0;
        }

        if (arr[index] > max) {
            u = 1 + rdp(arr, index + 1, arr[index]);
        }
        return Math.max(u, rdp(arr, index + 1, max));
    }
}
