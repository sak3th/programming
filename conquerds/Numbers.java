
public class Numbers {
    private static final int PLAYER_ONE = 1;
    private static final int PLAYER_TWO = 2;

    public boolean canPlayerWin(int maxN, int p, int S) {
        final int[][] cache = new int[2][maxN + S];
        boolean res = canPlayerWin(maxN, new Move(0, PLAYER_TWO, null), S, cache, PLAYER_ONE) == p;
        for (int j = 0; j < maxN + S; System.out.print(j++ + "\t")); System.out.println();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < maxN + S; j++) {
                System.out.print(cache[i][j] + "\t");
            }
            System.out.println();
        }
        return res;
    }

    private int canPlayerWin(int maxN, Move m, int S, int[][] cache, int P) {
        if (m.s >= S) {
            cache[m.p - 1][m.s] = m.p;
            return cache[m.p - 1][m.s];
        }
        int O = opponent(m.p);
        if (m.p == P) {
            // all of the opponents moves must lead to sum greater than or equal to S
            boolean all = true;
            for (int i = maxN; i > 0; i--) {
                int result = cache[O - 1][m.s + i];
                if (result == 0) {
                    result = canPlayerWin(maxN, new Move(m.s + i, O, m), S, cache, P);
                    cache[O - 1][m.s + i] = result;
                }
                if (result != P) {
                    all = false;
                    break;
                }
            }
            return all ? P : O;
        } else {
            // any one of the opponents moves must lead to sum greater than or equal to S
            for (int i = maxN; i > 0; i--) {
                int result = cache[O - 1][m.s + i];
                if (result == 0) {
                    result = canPlayerWin(maxN, new Move(m.s + i, O, m), S, cache, P);
                    cache[O - 1][m.s + i] = result;
                }
                if (result == P) {
                    Move tmp = m; int s = m.s + i;
                    /*System.out.print( i + " ");
                    while (tmp != null && tmp.prev != null) {
                        System.out.print((tmp.s - tmp.prev.s)+ " ");
                        tmp = tmp.prev;
                    }
                    System.out.println();*/
                    return P;
                }
            }
            return O;
        }
    }

    private static int opponent(int p) {
        return (p == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
    }

    private class Move {
        int s; int p; Move prev;

        private Move(int s, int p, Move prev) {
            this.s = s;
            this.p = p;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        final int maxN = 11; final int SUM = 20;

        System.out.println(numbers.canPlayerWin(maxN, PLAYER_ONE, SUM));
    }
}
