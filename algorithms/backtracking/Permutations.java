package backtracking;

import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        //char[] input = "1234567890".toCharArray();
        //char[] input = "DATE".toCharArray();
        char[] input = "banana".toCharArray();
        permute(input);
    }

    private static void permute(char[] input) {
        int[] a = new int[input.length];
        Arrays.sort(input);
        backtrack(a, -1, input);
    }

    private static void backtrack(int[] a, int k, char[] input) {
        if (isSolution(k, input)) {
            processSolution(a, input);
        } else {
            k = k + 1;
            int[] c = constructCandidates(a, k);
            for (int i = 0; i < c.length; i++) {
                if (i == 0 || input[c[i - 1]] != input[c[i]]) {
                    a[k] = c[i];
                    backtrack(a, k, input);
                }
            }
        }
    }

    private static boolean isSolution(int k, char[] input) {
        return k + 1 == input.length;
    }

    private static void processSolution(int[] a, char[] input) {
        System.out.print("{");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + input[a[i]]);
        }
        System.out.println(" } ");
    }

    private static int[] constructCandidates(int[] a, int k) {
        int[] c = new int[a.length - k];
        int[] o = new int[a.length];
        for (int i = 0; i < k; i++) {
            o[a[i]] = -1;
        }
        for (int i = 0, index = 0; i < o.length; i++) {
            if (o[i] != -1) {
                c[index++] = i;
            }
        }
        return c;
    }
}
