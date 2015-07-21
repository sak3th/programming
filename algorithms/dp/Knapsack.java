package dp;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the
 * maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and
 * wt[0..n-1] which represent values and weights associated with n items respectively. Also given
 * an integer W which represents knapsack capacity, find out the maximum value subset of val[]
 * such that sum of the weights of this subset is smaller than or equal to W. You cannot break an
 * item, either pick the complete item, or don’t pick it (0-1 property)
 */
public class Knapsack {

    public static void main(String[] args) {
        rknapsack(5, new int[]{60, 100, 120}, new int[]{1, 2, 3});
        rknapsack(10, new int[]{60, 100, 120, 130, 140}, new int[]{1, 2, 3, 4, 5});
        rknapsack(10, new int[]{0, 60, 100, 120, 130, 140}, new int[]{0, 1, 2, 3, 4, 5});
        dp(5, new int[]{60, 100, 120}, new int[]{1, 2, 3});
        dp(10, new int[]{60, 100, 120, 130, 140}, new int[]{1, 2, 3, 4, 5});
        dp(10, new int[]{0, 60, 100, 120, 130, 140}, new int[]{0, 1, 2, 3, 4, 5});
    }

    static void dp(int W, int[] values, int[] weights) {
        int dp[][] = new int[values.length + 1][W + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        System.out.println("DP knapsack max : " + dp[values.length][W]);
    }

    static void rknapsack(int W, int[] values, int[] weights) {
        System.out.println("Recursive knapsack max : " + rdp(W, values, weights, values.length -1));
    }

    static int rdp(int W, int[] values, int[] weights, int i) {
        if (i < 0) return 0;
        int value = rdp(W, values, weights, i - 1);
        if (weights[i] <= W) {
            value = Math.max(value, values[i] + rdp(W - weights[i], values, weights, i - 1));
        }
        return value;
    }
}
