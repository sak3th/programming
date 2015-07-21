package graphs;

import java.util.Arrays;

/**
 * #DP #GREEDY
 */
public class Dijkstras {

    static int[] shortestPath(Graph g, int start) {
        boolean[] intree = new boolean[g.numV + 1];
        int[] distance = new int[g.numV + 1];
        int[] parent = new int[g.numV + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[start] = 0;
         while(!intree[start]) {
            intree[start] = true;
            Graph.Adjacent adj = g.adjacents[start];
            while (adj != null) {
                int end = adj.end;
                int weight = adj.weight;
                if (distance[end] > (distance[start] + weight)) {
                    distance[end] = distance[start] + weight;
                    parent[end] = start;
                }
                adj = adj.next;
            }

            start = 1;
            int dist = Integer.MAX_VALUE;
            for (int i = 1; i <= g.numV; i++) {
                if ((intree[i] == false) && (dist > distance[i])) {
                    dist = distance[i];
                    start = i;
                }
            }
        }
        return parent;
    }

    public static void main(String[] args) {
        Graph g = new Graph(6, false);
        g.addEdge(1, 2, 1, false);
        g.addEdge(2, 3, 2, false);
        g.addEdge(3, 4, 3, false);
        g.addEdge(1, 4, 10, false);
        g.addEdge(4, 5, 2, false);
        g.addEdge(5, 6, 3, false);
        g.addEdge(1, 6, 10, false);
        int[] parent = shortestPath(g, 1);

        System.out.println("Dijkstras Shortest Path\n");

        printPath(1, 4, parent);
        printPath(1, 6, parent);
    }

    private static void printPath(int p, int s, int[] parent) {
        System.out.print("Path : " + s);
        while (parent[s] != -1 && parent[s] != p) {
            System.out.print("->" + parent[s]);
            s = parent[s];
        }
        System.out.println("->" + p);
    }
}
