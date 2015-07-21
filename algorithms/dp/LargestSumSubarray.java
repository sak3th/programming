package dp;

/**
 *
 */
public class LargestSumSubarray {

    public static void main(String[] args) {
        rsolve(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        dp(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
    }

    static void dp(int[] arr) {
        int max = arr[0];
        int pmax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            pmax = Math.max(arr[i], arr[i] + pmax);
            max = Math.max(max, pmax);
        }
        System.out.println("dp table max sum : " + max);
    }

    static void rsolve(int[] arr) {
        System.out.println("r max sum : " + rdp(arr, 1, arr[0], arr[0]));
    }

    static int rdp(int[] arr, int i, int tmax, int pmax) {
        if (i == arr.length - 1) {
            return Math.max(tmax, pmax + arr[1]);
        }
        pmax = Math.max(arr[i], arr[i] + pmax);
        tmax = Math.max(tmax, pmax);
        return rdp(arr, i + 1, tmax, pmax);
    }
}
