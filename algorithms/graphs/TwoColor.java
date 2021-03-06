package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TwoColor {

    public static void main(String[] args) {
        Graph g = new Graph(9, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 4, false);
        g.addEdge(1, 5, false);
        g.addEdge(2, 3, false);
        g.addEdge(2, 7, false);
        g.addEdge(4, 7, false);
        g.addEdge(5, 8, false);
        g.addEdge(8, 9, false);

        TwoColor t = new TwoColor();
        if(t.bipartite(g)) {
            out("Bipartite " + "\n");
        } else {
            out("Not Bipartite" + "\n");
        }
    }

    static void out(String str) { System.out.print(str); }

    public boolean bipartite(Graph g) {
        initBfs(g);
        for (int i = 1; i <= g.numV; i++) {
            if (!mDiscovered[i]) {
                mColor[i] = 1;
                bfs(i, g);
                if (!mBipartite) return false;
            }
        }

        return true;
    }

    private boolean[] mDiscovered;
    private boolean[] mProcessed;
    private int[] mParent;
    private int[] mColor;
    private boolean mBipartite = true;

    private void initBfs(Graph g) {
        mDiscovered = new boolean[g.numV + 1];
        mProcessed = new boolean[g.numV + 1];
        mParent = new int[g.numV + 1];
        mColor = new int[g.numV + 1];
        for (int i = 1; i <= g.numV; i++) {
            mDiscovered[i] = mProcessed[i] = false;
            mParent[i] = -1;
        }
    }

    /* call initBfs() before this function */
    private void bfs(int start, Graph g) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(new Integer(start));
        mDiscovered[start] = true;

        while (!q.isEmpty()) {
            int vertex = q.remove();
            processVertexEarly(vertex);
            mProcessed[vertex] = true;

            Graph.Adjacent adj = g.adjacents[vertex];
            while(adj != null) {
                int end = adj.end;
                if (!mProcessed[end] ||g.directed) processEdge(vertex, end);
                if (!mDiscovered[end]) {
                    q.add(new Integer(end));
                    mDiscovered[end] = true;
                    mParent[end] = vertex;
                }
                adj = adj.next;
            }
            processVertexLate(vertex);
        }
    }

    private void processVertexEarly(int vertex) { }

    private void processEdge(int begin, int end) {
        if (mColor[begin] == mColor[end]) {
            mBipartite = false;
        }
        mColor[end] = mColor[begin] * -1;
    }

    private void processVertexLate(int vertex) { }
}

