import java.io.FileInputStream;
import java.util.Scanner;

import graphs.Graph;

public class SupplyRoute {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("competency/SupplyRoute.in"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int dimen = sc.nextInt();
            int[][] cost = new int[dimen][dimen];
            for (int i = 0; i < dimen; i++) {
                String str = sc.next();
                for (int j = 0; j < dimen; j++) {
                    cost[i][j] = Character.getNumericValue(str.charAt(j));
                    //cost[i][j] = sc.nextInt();
                }
            }

            Graph g = new Graph(dimen * dimen, true);
            for (int i = 0; i < dimen; i++) {
                for (int j = 0; j < dimen; j++) {
                    if (i - 1 >= 0) {
                        int v1 = i * dimen + j + 1;
                        int v2 = (i - 1) * dimen + j + 1;
                        g.addEdge(v1, v2, cost[i - 1][j], true);
                    }
                    if (i + 1 < dimen) {
                        int v1 = i * dimen + j + 1;
                        int v2 = (i + 1) * dimen + j + 1;
                        g.addEdge(v1, v2, cost[i + 1][j], true);
                    }
                    if (j - 1 >= 0) {
                        int v1 = i * dimen + j + 1;
                        int v2 = i * dimen + j; //i * dimen + (j - 1) + 1
                        g.addEdge(v1, v2, cost[i][j - 1], true);
                    }
                    if (j + 1 < dimen) {
                        // i, j + 1
                        int v1 = i * dimen + j + 1;
                        int v2 = i * dimen + j + 2; //i * dimen + (j + 1) + 1
                        g.addEdge(v1, v2, cost[i][j + 1], true);
                    }
                }
            }


            // Print the answer to standard output(screen).
            System.out.println("#" + test_case + " " +  dijkstras(g, 1));
        }
    }

    private static int dijkstras(Graph g, int start) {
        boolean[] intree = new boolean[g.numV + 1];
        int[] parent = new int[g.numV + 1];
        int[] cost = new int[g.numV + 1];

        for (int c = 0; c <= g.numV; c++) cost[c] = Integer.MAX_VALUE;
        for (int p = 0; p <= g.numV; p++) parent[p] = -1;

        cost[start] = 0;

        while (!intree[start]) {
            intree[start] = true;
            Graph.Adjacent adj = g.adjacents[start];
            // fill only lesser weights of adjacents of v into distance[]
            while (adj != null) {
                int end = adj.end;
                int weight = adj.weight;
                if (cost[end] > (cost[start] + weight)) {
                    cost[end] = cost[start] + weight;
                    parent[end] = start;
                }
                adj = adj.next;
            }

            start = 1;
            int dist = Integer.MAX_VALUE;
            for (int i = 1; i <= g.numV; i++) {
                if ((intree[i] == false) && (dist > cost[i])) {
                    dist = cost[i];
                    start = i;
                }
            }
        }

        /*printPath(parent, g.numV);
        System.out.println();*/
        return cost[g.numV];
    }

    private static void printPath(int[] parent, int end) {
        if (parent[end] != -1) {
            printPath(parent, parent[end]);
            System.out.print(parent[end] + "->" + end + " ");
        }
    }
}
