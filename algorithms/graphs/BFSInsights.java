package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSInsights {

    public static void main(String[] args) {
        Graph g = new Graph(4, false);
        g.addEdge(1, 2, false);
        g.addEdge(1, 3, false);
        g.addEdge(2, 4, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);

        BFSInsights bsfi = new BFSInsights();
        bsfi.findComponents(g);
    }

    public void findComponents(Graph g) {
        initBfs(g);
        int c = 0;
        for (int i = 1; i <= g.numV; i++) {
            if (!mDiscovered[i]) {
                c++;
                out("Component " + c + " { ");
                bfs(i, g);
                out(" }\n");
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
                if (!mDiscovered[end]) {
                    q.add(new Integer(end));
                    mDiscovered[end] = true;
                    mParent[end] = vertex;
                }
                if (!mProcessed[end] || g.directed) {
                    processEdge(vertex, end);
                }
                adj = adj.next;
            }
            processVertexLate(vertex);
        }
    }

    private void processVertexEarly(int vertex) { System.out.print(vertex + "("); }

    private void processEdge(int begin, int end) { System.out.print(" " + begin + "->" + end); }

    private void processVertexLate(int vertex) { System.out.print(" ) ");}

    private static void out(String str) { System.out.print(str); }
}
