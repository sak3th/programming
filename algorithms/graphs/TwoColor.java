package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TwoColor extends Graph {

    public static void main(String[] args) {
        TwoColor t = new TwoColor(9);
        t.addEdge(1, 2, true);
        t.addEdge(1, 4, true);
        t.addEdge(1, 5, true);
        t.addEdge(2, 3, true);
        t.addEdge(2, 7, true);
        t.addEdge(4, 7, true);
        t.addEdge(5, 8, true);
        t.addEdge(8, 9, true);

        if(t.bipartite()) {
            out("Bipartite " + "\n");
        } else {
            out("Not Bipartite" + "\n");
        }
    }

    static void out(String str) { System.out.print(str); }

    boolean[] discovered = new boolean[MAXV + 1];
    boolean[] processed = new boolean[MAXV + 1];
    int[] color = new int[MAXV + 1];
    boolean bipartite = true;

    public TwoColor(int vertices) {
        super(vertices);
    }

    public boolean bipartite() {
        initBfs();
        for (int i = 1; i <= vertices; i++) {
            if (!discovered[i]) {
                color[i] = 1;
                bfs(i);
                if (!bipartite) return false;
            }
        }

        return true;
    }

    private void initBfs() {
        for (int i = 0; i <= MAXV; i++) {
            discovered[i] = processed[i] = false;
            parent[i] = -1;
        }
    }

    /* call initBfs() before this function */
    private void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(new Integer(start));
        discovered[start] = true;

        while (!q.isEmpty()) {
            int vertex = (Integer)q.remove();
            processVertexEarly(vertex);
            processed[vertex] = true;
            Adjacent adj = adjacents[vertex];

            while (adj != null) {
                int end = adj.end;
                if (!processed[end] || directed) processEdge(vertex, end);
                if (!discovered[end]) {
                    q.add(new Integer(end));
                    discovered[end] = true;
                    parent[end] = vertex;
                }
                adj = adj.next;
            }
            processVertexLate(vertex);
        }
    }

    private void processVertexEarly(int vertex) { }

    private void processEdge(int begin, int end) {
        if (color[begin] == color[end]) {
            bipartite = false;
        }
        color[end] = color[begin] * -1;
    }

    private void processVertexLate(int vertex) { }
}

