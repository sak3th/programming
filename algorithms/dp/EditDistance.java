package dp;


public class EditDistance {

    private static final int MATCH = 0;
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int TRANSPOSE = 3;

    public static void main(String[] args) {
        char[] x = "thou shall not".toCharArray();
        char[] y = "you should not".toCharArray();
        //char[] x = "saketh".toCharArray();
        //char[] y = "sakeht".toCharArray();
        long now = System.currentTimeMillis();
        System.out.println(editDistance(x, y) + " " + (System.currentTimeMillis() - now));
    }

    private static int editDistance(char[] x, char[] y) {
        int[][] dist = new int[x.length + 1][y.length + 1];
        int[] costs = new int[TRANSPOSE + 1];

        // row init
        for (int i = 0; i <= x.length; i++) {
            dist[i][0] = i;
        }
        // column init
        for (int j = 0; j <= y.length; j++) {
            dist[0][j] = j;
        }

        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                costs[MATCH] = dist[i - 1][j - 1] + ((x[i - 1] == y[j - 1]) ? 0 : 1);
                costs[INSERT] = dist[i][j - 1] + 1;
                costs[DELETE] = dist[i - 1][j] + 1;
                costs[TRANSPOSE] = (i > 1 && j > 1 && x[i - 1] == y[j - 2] && x[i - 2] == y[j - 1])
                        ? dist[i - 2][j - 2] + 1 : Integer.MAX_VALUE;
                dist[i][j] = costs[MATCH];
                for (int e = INSERT; e <= TRANSPOSE; e++) {
                    dist[i][j] = Math.min(dist[i][j], costs[e]);
                }
            }
        }

        return dist[x.length][y.length];
    }
}
