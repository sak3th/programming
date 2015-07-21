import java.util.Random;

public class TowerOfHanoi {

    public static void main(String[] args) {
        //System.out.println(solve(3, 3, 'a', 'b', 'c'));
        //System.out.println(solve(new int[]{1, 2, 3}, 3, 3, 'a', 'b', 'c'));
        System.out.println(solve(new int[]{2, 1}, 2, 2));
        Random rand = new Random();
        for (int n = 1; n < 10; n++) {
            int[] discs = new int[n];
            for (int i = 0; i < discs.length; i++) {
                discs[i] = rand.nextInt(9) +  1;
            }
            System.out.println(solve(discs, discs.length, discs.length));
        }
        //System.out.println(solve(discs, discs.length, discs.length) % 10000000007.0d);
    }

    static int solve(int N, int move, char begin, char aux, char end) {
        if (N == 1) {
            System.out.println(move + " : " + begin + " -> " + end);
            return 1;
        } else {
            int s = solve(N - 1, N - 1, begin, end, aux);
            int p = solve(1, N, begin, aux, end);
            int r = solve(N - 1, N - 1, aux, begin, end);
            return s + p + r;
        }
    }

    static int solve(int[] discs, int N, int move, char begin, char aux, char end) {
        if (N == 1) {
            System.out.println(move + " : " + begin + " -> " + end + " " + discs[move-1] + " time/s");
            return discs[move - 1];
        } else {
            int s = solve(discs, N - 1, N - 1, begin, end, aux);
            int p = solve(discs, 1, N, begin, aux, end);
            int r = solve(discs, N - 1, N - 1, aux, begin, end);
            return s + p + r;
        }
    }

    static double solve(int[] discs, int N, int move) {
        if (N > 1) {
            double s = solve(discs, N - 1, N - 1);
            return (s * 2) + discs[move - 1];
        }
        return discs[move - 1];
    }
}
