package dp;

/**
 * Given an array of integers where each element represents the max number of steps that can be made
 * forward from that element. Write a function to return the minimum number of jumps to reach the
 * end of the array (starting from the first element). If an element is 0, then cannot move through
 * that element.
 *
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 */
public class MinimumJumps {

    public static void main(String[] args) {
        rsolve(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
        rsolve(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
    }

    static void rsolve(int[] arr) {
        System.out.println("Min jumps: " + rdp(arr, 0));
    }

    // hardcoded to always start at 0 and end at full length
    static int rdp(int[] arr, int i) {
        if (i >= arr.length - 1) return 0;
        int j = Integer.MAX_VALUE;
        for (int k = 1; k <= arr[i]; k++) {
            j = Math.min(j, 1 + rdp(arr, i+k));
        }
        return j;
    }
}
