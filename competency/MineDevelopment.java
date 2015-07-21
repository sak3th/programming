import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MineDevelopment {

    private static final int P = 0;
    private static final int I = 1;
    private static final int C = 2;
    private static final int V = 3;
    private static final int PV = 4;

    public static void main(String[] args) throws FileNotFoundException {
        String file = "competency/MineDevelopment.in";
        Scanner sc = new Scanner(new FileReader(file));

        int cases = sc.nextInt();
        for (int c = 1; c <= cases; c++) {
            int N = sc.nextInt();
            int B = sc.nextInt();
            int[][] mines = new int[N][4];
            for (int n = 0; n < N; n++) {
                for (int j = P; j <= PV; j++) {
                    mines[n][j] = sc.nextInt();
                }
            }
            System.out.println("Case #" + c);
            solve(mines, B);
        }
    }

    private static void solve(int[][] mines, int B) {
        int[][] profit = new int[mines.length + 1][B + 1];
        int[][] pMines = new int[mines.length + 1][B + 1];

        int v, p, m, mp;
        for (int i = 1; i <= mines.length; i++) {
            for (int j = 1; j <= B; j++) {
                profit[i][j] = profit[i - 1][j];
                pMines[i][j] = pMines[i - 1][j];
                if (mines[i - 1][C] <= j) {
                    p = mines[i - 1][P];
                    m = pMines[i - 1][j - mines[i - 1][C]];
                    mp = (m == 0)? -1 : pMines[m - 1][j - mines[m - 1][C]];
                    if (p == 0 || p == m || p == mp) {
                        v = mines[i - 1][V] + profit[i - 1][j - mines[i - 1][C]];
                        if (v > profit[i - 1][j]) {
                            profit[i][j] = v;
                            pMines[i][j] = mines[i - 1][I];
                        }
                    }
                }
            }
        }

        System.out.println(profit[mines.length][B]);
    }

    private static void printMines(int[][] mines, int[][] profit, int[][] pMines, int B) {
        int m = pMines[mines.length][B];
        printMines(mines, profit, pMines, (B - mines[m - 1][C]));
        System.out.print(m + " ");
    }
}
