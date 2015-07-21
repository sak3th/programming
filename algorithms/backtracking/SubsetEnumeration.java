package backtracking;

public class SubsetEnumeration {

    public static void main(String[] args) {
        boolean[] a = new boolean[100];
        backtrack(a, 0, 3);
    }

    private static boolean finished = false;

    private static void backtrack(boolean[] a, int k, int input) {
        if (reachedSolution(a, k, input)) {
            processSolution(a, k, input);
        } else {
            k = k + 1;
            boolean[] candidates = constructCandidates(a, k, input);
            for (boolean c : candidates) {
                a[k] = c;
                // make move
                backtrack(a, k, input);
                if (finished) return;
                // unmake move
            }
        }
    }

    private static boolean reachedSolution(boolean[] a, int k, int input) {
        return (k == input);
    }

    private static void processSolution(boolean[] a, int k, int input) {
        System.out.print("{");
        for (int i = 1; i <= k; i++) {
            if (a[i]) {
                System.out.print(" " + i);
            }
        }
        System.out.println(" }");
    }

    private static boolean[] constructCandidates(boolean[] a, int k, int input) {
        return new boolean[] { false, true };
    }
}
