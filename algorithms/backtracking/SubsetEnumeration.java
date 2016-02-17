package backtracking;

public class SubsetEnumeration {

    public static void main(String[] args) {
        new SubsetEnumeration().solve();
    }

    public void solve() {
        int elements = 3;
        boolean[] a = new boolean[2<<elements]; // 2^n subsets in a set
        backtrack(a, 0, elements);
    }

    private void backtrack(boolean[] a, int k, int input) {
        if (isSolution(a, k, input)) {
            processSolution(a, k, input);
        } else {
            k = k + 1;
            boolean[] candidates = constructCandidates(a, k, input);
            for (boolean c : candidates) {
                a[k] = c;
                // make move
                backtrack(a, k, input);
                // unmake move
            }
        }
    }

    private boolean isSolution(boolean[] a, int k, int input) {
        return (k == input);
    }

    private void processSolution(boolean[] a, int k, int input) {
        System.out.print("{");
        for (int i = 1; i <= k; i++) {
            if (a[i]) {
                System.out.print(" " + i);
            }
        }
        System.out.println(" }");
    }

    private boolean[] constructCandidates(boolean[] a, int k, int input) {
        return new boolean[] { false, true };
    }
}
