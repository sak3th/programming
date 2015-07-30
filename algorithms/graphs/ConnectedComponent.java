package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Defined only for undirected graphs
 */
public class ConnectedComponent {

    public static void main(String[] args) {
        Graph g = new Graph(9, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 4, false);
        g.addEdge(1, 5, false);
        g.addEdge(2, 7, false);
        g.addEdge(4, 7, false);
        g.addEdge(5, 8, false);
        g.addEdge(8, 9, false);
        g.addEdge(3, 6, false);

        ConnectedComponent ccomp = new ConnectedComponent();
        ccomp.findComponents(g);
    }

    public void findComponents(Graph g) {
        out("Edges: " + g.numE + "\n");
        initBfs(g);
        int c = 0;
        for (int i = 1; i <= g.numV; i++) {
            if (!mDiscovered[i]) {
                c++;
                out("Component " + c + " [");
                bfs(i, g);
                out(" ]\n");
            }
        }
    }

    private int[] mParent;
    private boolean[] mDiscovered;
    private boolean[] mProcessed;

    private void initBfs(Graph g) {
        mDiscovered = new boolean[g.numV + 1];
        mProcessed = new boolean[g.numV + 1];
        mParent = new int[g.numV + 1];
        for (int i = 0; i <= g.numV; i++) {
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
                if (!mProcessed[end] || g.directed) processEdge(vertex, end);
                if (!mDiscovered[end]) {
                    mParent[end] = vertex;
                    q.add(new Integer(end));
                    mDiscovered[end] = true;
                }
                adj = adj.next;
            }
            processVertexLate(vertex);
        }
    }

    private void processVertexEarly(int vertex) {
        out(" " + vertex);
    }

    private void processEdge(int begin, int end) { }

    private void processVertexLate(int vertex) {}

    private static void out(String str) { System.out.print(str); }
}
