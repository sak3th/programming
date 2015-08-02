package backtracking;


public class NQueens {

    public static void main(String[] args) {
        nqueens(8);
    }

    static int numSolutions = 0;
    private static void nqueens(int n) {
        int[][] a = new int[n][n];
        backtrack(a, -1);
        System.out.println("Total num of solutions: " + numSolutions);
    }

    private static void backtrack(int[][] a, int k) {
        if (isSolution(a, k)) {
            //processSolution(a);
            numSolutions++;
        } else {
            k = k + 1;
            int[] c = constructCandidates(a, k);
            if (c != null) {
                for (int i = 0; i < c.length; i++) {
                    makeMove(a, k, c[i]);
                    backtrack(a, k);
                    unmakeMove(a, k, c[i]);
                }
            }
        }
    }

    private static void makeMove(int[][] a, int k, int y) {
        for (int j = 0; j < a.length; j++) {
            a[k][j] += 1;
        }
        for (int i = 0; i < a.length; i++) {
            a[i][y] += 1;
        }
        if (k + y < a.length) {
            for (int i = 0, j = y + k; i < a.length && j > -1; i++, j--) {
                a[i][j] += 1;
            }
        } else {
            for (int j = a.length - 1, i = y + k - a.length + 1; i < a.length && j > -1; i++, j--) {
                a[i][j] += 1;
            }
        }
        if (k <= y) {
            for (int i = 0, j = y - k; i < a.length && j < a.length; i++, j++) {
                a[i][j] += 1;
            }
        } else {
            for (int j = 0, i = k - y; i < a.length && j < a.length; i++, j++) {
                a[i][j] += 1;
            }
        }
        a[k][y] = 0;
    }

    private static void unmakeMove(int[][] a, int k, int y) {
        for (int j = 0; j < a.length; j++) {
            a[k][j] -= 1;
        }
        for (int i = 0; i < a.length; i++) {
            a[i][y] -= 1;
        }
        if (k + y < a.length) {
            for (int i = 0, j = y + k; i < a.length && j > -1; i++, j--) {
                a[i][j] -= 1;
            }
        } else {
            for (int j = a.length - 1, i = y + k - a.length + 1; i < a.length && j > -1; i++, j--) {
                a[i][j] -= 1;
            }
        }
        if (k <= y) {
            for (int i = 0, j = y - k; i < a.length && j < a.length; i++, j++) {
                a[i][j] -= 1;
            }
        } else {
            for (int j = 0, i = k - y; i < a.length && j < a.length; i++, j++) {
                a[i][j] -= 1;
            }
        }
        a[k][y] = 0;
    }

    private static int[] constructCandidates(int[][] a, int k) {
        // TODO optimize to exclude symmetrical duplicates
        int unattacked = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[k][i] == 0) {
                unattacked++;
            }
        }
        int[] c = null;
        if (unattacked != 0) {
            c = new int[unattacked];
            for (int i = 0, fill = 0; i < a.length; i++) {
                if (a[k][i] == 0) {
                    c[fill++] = i;
                }
            }
        }
        return c;
    }

    private static void processSolution(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print((a[i][j] <= 0 ? " #" : " _" ));
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSolution(int[][] a, int k) {
        return k + 1 == a.length;
    }
}
