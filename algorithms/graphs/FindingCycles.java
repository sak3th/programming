package graphs;

import java.util.HashMap;
import java.util.Stack;

public class FindingCycles {

    public static void main(String[] args) {
        HashMap<String, Integer> map;
        Graph g = new Graph(10, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(4, 5, false);
        g.addEdge(5, 6, false);
        g.addEdge(6, 7, false);
        g.addEdge(7, 8, false);
        g.addEdge(7, 9, false);
        g.addEdge(1, 10, false);
        g.addEdge(8, 9, false);
        FindingCycles fc = new FindingCycles();
        fc.findCycle(g);
    }

    static void out (String str) {
        System.out.print(str);
    }

    public void findCycle(Graph g) {
        initDfs(g);
        for (int i = 1; i <= g.numV; i++) {
            if (!mDiscovered[i]) {
                idfs(i, g);
            }
        }
        if (!mFinished) out("No cycle found" + "\n");
    }

    private int[] mParent;
    private boolean[] mDiscovered;
    private boolean[] mProcessed;
    private int[] mEntryTime;
    private int[] mExitTime;
    private int mTime;
    private boolean mFinished;

    private void initDfs(Graph g) {
        mDiscovered = new boolean[g.numV + 1];
        mProcessed = new boolean[g.numV + 1];
        mEntryTime = new int[g.numV + 1];
        mExitTime = new int[g.numV + 1];
        mParent =  new int[g.numV + 1];
        mFinished = false;
        for (int i = 0; i <= g.numV; i++) {
            mDiscovered[i] = mProcessed[i] = false;
            mParent[i] = -1;
        }
    }

    /* call initDfs() before this function */
    private void idfs(int start, Graph g) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(start, g.adjacents[start]));
        mDiscovered[start] = true;
        mEntryTime[start] = ++mTime;
        processVertexEarly(start);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.peek();
            if (vertex.adj != null) {
                int end = vertex.adj.end;
                if (!mDiscovered[end]) {
                    mParent[end] = vertex.v;
                    System.out.println("!d " + vertex.v + " -> " + end);
                    processEdge(vertex.v, end, g);

                    stack.push(new Vertex(end, g.adjacents[end]));
                    mDiscovered[end] = true;
                    mEntryTime[end] = ++mTime;
                    processVertexEarly(end);
                } else if ((!mProcessed[end] && mParent[vertex.v] != end) || g.directed) {
                    System.out.println("!p " + vertex.v + " -> " + end);
                    processEdge(vertex.v, end, g);
                }
                vertex.adj = vertex.adj.next;
            } else {
                stack.pop();
                processVertexLate(vertex.v);
                mExitTime[vertex.v] = ++mTime;
                mProcessed[vertex.v] = true;
            }
            if (mFinished) return;
        }
    }

    /* call initDfs() before this function */
    private void dfs(int vertex, Graph g) {
        if (mFinished) return;

        mDiscovered[vertex] = true;
        mEntryTime[vertex] = ++mTime;
        processVertexEarly(vertex);

        Graph.Adjacent adj = g.adjacents[vertex];
        while (adj != null) {
            int end = adj.end;
            if (!mDiscovered[end]) {
                mParent[end] = vertex;
                processEdge(vertex, end, g);
                dfs(end, g);
            } else if ((!mProcessed[end] && mParent[vertex] != end) || g.directed) {
                processEdge(vertex, end, g);
            }
            if (mFinished) return;
            adj = adj.next;
        }
        processVertexLate(vertex);
        mExitTime[vertex] = ++mTime;
        mProcessed[vertex] = true;
    }

    private void processVertexEarly(int vertex) {}

    private void processVertexLate(int vertex) {}

    private void processEdge(int vertex, int end, Graph g) {
        if (mDiscovered[end] && mParent[vertex] != end) {
            out("Cycle from " + vertex + " to " + end + "\n");
            out("Path: ");
            int p = vertex;
            do {
                out(p + "<-" + mParent[p]);
                p = mParent[p];
            } while (mParent[p] != end);
            out("<-" + end);
            mFinished = true;
        }
    }

    private class Vertex {
        int v;
        Graph.Adjacent adj;
        public Vertex(int v, Graph.Adjacent adj) {
            this.v = v;
            this.adj = adj;
        }
    }
}
