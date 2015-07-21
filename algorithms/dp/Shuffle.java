package dp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shuffle {

    public static void main(String[] args) throws FileNotFoundException {
        String ioFile = "algorithms/" + Shuffle.class.getCanonicalName().replace(".", "/");
        Scanner sc = new Scanner(new File(ioFile + ".in"));
        int cases = sc.nextInt();
        for(int c = 0; c < cases; c++) {
            char[] X = sc.next().toCharArray();
            char[] Y = sc.next().toCharArray();
            char[] Z = sc.next().toCharArray();
            long now = System.currentTimeMillis();
            System.out.println(isShuffleR(X, Y, Z, X.length, Y.length) + " " + (System.currentTimeMillis() - now));
            now = System.currentTimeMillis();
            System.out.println(isShuffle(X, Y, Z) + " " + (System.currentTimeMillis() - now));
        }
        sc.close();

    }

    private static boolean isShuffle(char[] x, char[] y, char[] z) {
        boolean[][] shuffle = new boolean[x.length + 1][y.length + 1];

        shuffle[0][0] = true;
        for (int i = 1; i <= x.length; i++) shuffle[i][0] = ((x[i - 1] == z[i - 1]) && shuffle[i - 1][0]);
        for (int j = 1; j <= y.length; j++) shuffle[0][j] = ((y[j - 1] == z[j - 1]) && shuffle[0][j - 1]);

        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                shuffle[i][j] = ((z[i + j - 1] == x[i - 1] && shuffle[i - 1][j]) ||
                        (z[i + j - 1] == y[j - 1] && shuffle[i][j - 1]));
            }
        }
        return shuffle[x.length][y.length];
    }

    private static boolean isShuffleR(char[] x, char[] y, char[] z, int n, int m) {
        n--; m--;
        if (n < 0 && m < 0) {
            return true;
        } else if (n < 0) {
            return (z[m] == y[m]) && isShuffleR(x, y, z, n, m - 1);
        } else if (m < 0) {
            return (z[n] == x[n]) && isShuffleR(x, y, z, n - 1, m);
        }
        return ((z[n + m + 1] == x[n]) && isShuffleR(x, y, z, n, m + 1)) ||
                ((z[n + m + 1] == y[m]) && isShuffleR(x, y, z, n + 1, m));
    }


}
