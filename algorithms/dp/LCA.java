package dp;

/**
 * Longest Commong Array(Substring)
 */
public class LCA {

    public static void main(String[] args) {
        rsolve("COMBINATION".toCharArray(), "PERMUTATION".toCharArray());
        rsolve("COMBINATION".toCharArray(), "COMBUSTION".toCharArray());
        rsolve("MICHAELANGELO".toCharArray(), "HEIROGLYPHOLOGY".toCharArray());
        rsolve("ABCDEFG".toCharArray(), "HKLMNABCIJ".toCharArray());
        rsolve("forgeeksskeegfor".toCharArray(), "rofgeeksskeegrof".toCharArray());
    }

    static int max;
    static void rsolve(char[] m, char[] n) {
        max = 0;
        rdp(m, n, m.length - 1, n.length - 1);
        System.out.println("recursive lcs " + max);
    }

    static int rdp(char[] m, char[] n, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (m[i] == n[j]) {
            int tmp = 1 + rdp(m, n, i - 1, j - 1);
            max = Math.max(tmp, max);
            return tmp;
        } else {
            int tmp = Math.max(rdp(m, n, i - 1, j), rdp(m, n, i, j - 1));
            max = Math.max(tmp, max);
            return 0;
        }
    }
}
