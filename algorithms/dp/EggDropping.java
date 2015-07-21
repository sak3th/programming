package dp;

/**
 * Given an N story building and a supply of k eggs, ﬁnd the strategy which minimizes (in the worst
 * case) the number of experimental drops required to determine the break ﬂoor.
 */
public class EggDropping {

    public static void main(String[] args) {
        System.out.println(solve(8, 4));
        System.out.println(solve(256, 15));
        System.out.println(solve(1024, 15));
        System.out.println(solve(100, 2));
        System.out.println(solve(100, 3));
    }

    private static int solve(int n, int k) {
        int[][] cost = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) cost[i][1] = i;
        for (int j = 1; j <= k; j++) cost[1][j] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                cost[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++) {
                    int c = 1 + Math.max((cost[x - 1][j - 1]), cost[i - x][j]);
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }
        return cost[n][k];
    }


    static int  rsolve(int e, int f) {
        return rdp(e, f, f);
    }

    // FIXME stackoverflow error because of recursive calls
    static int rdp(int e, int f, int k) {
        if (f <= 1) return 1;
        if (e == 1) return f;
        if (e <= 0) return Integer.MAX_VALUE;

        return 1 + Math.min(rdp(e - 1, f - 1, k), rdp (e, k - f, k));

    }
}
