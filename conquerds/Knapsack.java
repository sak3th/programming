
public class Knapsack {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[]) {
        int[][] k = new int[val.length + 1][W + 1];

        for (int i = 0; i <= val.length; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0 ) {
                    k[i][w] = 0; //redundant in java
                } else if (wt[i - 1] <= w) {
                    int withItem = val[i - 1] + k[i - 1][w - wt[i - 1]];
                    int withoutItem = k[i - 1][w];
                    k[i][w] = Math.max(withItem, withoutItem);
                } else {
                    k[i][w] =  k[i - 1][w];
                }
            }
        }

        return k[val.length][W];
    }

    public static void main(String[] args) {
        int val[] = {6, 10, 12};
        int wt[] = {1, 2, 3};
        int W = 5;
        System.out.println(knapSack(W, wt, val));
    }
}
