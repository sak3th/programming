package dp;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the
 * given set with sum equal to given sum.
 *
 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {

    public static void main(String[] args) {
        rsolve(new int[]{3, 34, 4, 12, 5, 2}, 9);
        rsolve(new int[]{3, 34, 4, 12, 5, 2}, 101);
        dp(new int[]{3, 34, 4, 12, 5, 2}, 9);
        dp(new int[]{3, 34, 4, 12, 5, 2}, 101);
    }

    static void dp(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j - arr[i - 1] < 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = dp[i-1][j - arr[i - 1]] || dp[i-1][j];
            }
        }
        System.out.println("iterative set exists : " + dp[arr.length][sum]);
    }

    static void rsolve(int[] arr, int sum) {
        System.out.println("recursive set exists : " + rdp(arr, arr.length - 1, sum));
    }

    static boolean rdp(int[] arr, int i, int sum) {
        if (sum == 0) return true;
        if (sum < 0) return false;
        if (i < 0) return false;

        //if (arr[i] > sum) return rdp(arr, i - 1, sum);
        return rdp(arr, i - 1, sum - arr[i]) || rdp(arr, i - 1, sum);
    }
}
