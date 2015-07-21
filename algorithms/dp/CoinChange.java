package dp;

import java.util.Arrays;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins
 * doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2},
 * {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {

    public static void main(String[] args) {
        rdp(5, new int[]{1, 2, 3});
        rdp(10, new int[]{2, 5, 3, 6});
        rdp(50, new int[]{1, 2});
        dp(5, new int[]{1, 2, 3});
        dp(10, new int[]{2, 5, 3, 6});
        dp(50, new int[]{1, 2});
    }

    static void dp(int N, int[] s) {
        int[][] dp = new int[N + 1][s.length + 1];
        for (int j = 0; j <= s.length; dp[0][j] = 1, j++);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= s.length; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i - s[j - 1] >= 0) {
                    dp[i][j] += dp[i - s[j - 1]][j];
                }
            }
        }
        System.out.println(dp[N][s.length] + " no of ways in i");
    }

    static void rdp(int N, int[] s) {
        Arrays.sort(s);
        System.out.println(rcc(N, s, 0) + " no of ways in r");
    }

    static int rcc(int N, int[] s, int index) {
        if (N == 0) return 1;
        int num = 0;
        for (int i = index; i < s.length; i++) {
            if (s[i] <= N) {
                num += rcc(N - s[i], s, i);
            }
        }
        return num;
    }
}
