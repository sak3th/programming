package dp;

/**
 * Longest Common Subsequence
 */
public class LCS {

    public static void main(String[] args) {
        rsolve("COMBINATION".toCharArray(), "PERMUTATION".toCharArray());
        rsolve("COMBINATION".toCharArray(), "COMBUSTION".toCharArray());
        rsolve("MICHAELANGELO".toCharArray(), "HEIROGLYPHOLOGY".toCharArray());
        rsolve("ABCDEFG".toCharArray(), "HKLMNABCIJ".toCharArray());
        rsolve("forgeeksskeegfor".toCharArray(), "rofgeeksskeegrof".toCharArray());
    }

    static void rsolve(char[] m, char[] n) {
        System.out.println("recursive lcs " + rdp(m, n, 0, 0));
    }

    static int rdp(char[] m, char[] n, int i, int j) {
        if (i >= m.length || j >= n.length) return 0;
        int max = 0;
        if (m[i] == n[j]) {
            max = 1 + rdp(m, n, i + 1, j + 1);
        } else {
            max = Math.max(max, rdp(m, n, i, j + 1));
            max = Math.max(max, rdp(m, n, i + 1, j));
        }
        return max;
    }

}
