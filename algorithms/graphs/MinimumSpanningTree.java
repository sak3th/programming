package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    /** #DP #GREEDY */
    private int[] prim(Graph g, int start) {
        boolean[] intree = new boolean[g.numV + 1];
        int[] distance = new int[g.numV + 1]; // distances of vertices to TREE
        int[] parent = new int[g.numV + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        distance[start] = 0;
        while (!intree[start]) {
            intree[start] = true;
            Graph.Adjacent adj = g.adjacents[start];
            // fill only lesser weights of adjacents of v into distance[]
            while (adj != null) {
                int end = adj.end;
                int weight = adj.weight;
                if (!intree[end] && (distance[end] > weight)) {
                    distance[end] = weight;
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
            System.out.println(parent[start] + " -> " + start);
        }
        return parent;
    }

    private void kruskals(Graph g) {
        int[] component = new int[g.numV + 1];
        List<Edge> kruskals = new ArrayList<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(g.numE, new Comparator<Edge>() {
            @Override
            public int compare(Edge l, Edge r) {
                if (l.weight < r.weight) return -1;
                if (l.weight == r.weight) return 0;
                return 1;
            }
        });

        // ElogE operation
        for (int i = 1; i <= g.numV; i++) {
            Graph.Adjacent adj = g.adjacents[i];
            component[i] = i;
            while (adj != null) {
                edgeQueue.add(new Edge(i, adj.end, adj.weight));
                adj = adj.next;
            }
        }

        int count = 0;
        SetUnion set = new SetUnion(g.numV);
        while (count < g.numV - 1) {
            Edge edge = edgeQueue.peek(); // log e operation
            //System.out.println("set " + set);
            //System.out.println("edge " + edge);
            //if (!set.sameComponent(edge.begin, edge.end)) {
            if (component[edge.begin] != component[edge.end]) {
                kruskals.add(edge);
                count++;
                for (int i = 1; i <= g.numV; i++) {
                    if (component[i] == component[edge.end]) {
                        component[i] = component[edge.begin];
                    }
                }
                //set.merge(edge.begin, edge.end);
            }
            edgeQueue.remove(edge);
        }

        for (Edge edge : kruskals) {
            System.out.println(edge.begin + " -> " + edge.end);
        }
    }

    private class Edge {
        int begin, end, weight;
        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        MinimumSpanningTree mst = new MinimumSpanningTree();
        Graph g = new Graph(6, false);
        g.addEdge(1, 2, 1, false);
        g.addEdge(2, 3, 2, false);
        g.addEdge(2, 4, 3, false);
        g.addEdge(1, 4, 4, false);
        g.addEdge(1, 5, 5, false);
        g.addEdge(1, 6, 6, false);
        g.addEdge(2, 5, 7, false);
        g.addEdge(2, 6, 8, false);
        //System.out.println("Prim");
        //int[] parent = mst.prim(g, 1);
        System.out.println("Kruskals");
        mst.kruskals(g);
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

class SetUnion {
    int[] parent, size;
    int n;

    public SetUnion(int n) {
        this.n = n;
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i<= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    void merge(int s1, int s2) {
        int r1 = find(s1), r2 = find(s2);
        if (r1 == r2) return; // already in the same component
        if (size[r1] >= size[r2]) {
            size[r1] += size[r2];
            parent[r2] = r1;
        } else {
            size[r2] += size[r1];
            parent[r1] = r2;
        }
    }

    boolean sameComponent(int s1, int s2) {
        return find(s1) == find(s2);
    }
}