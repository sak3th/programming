package graphs;

public class FindingCycles extends Graph {

    public static void main(String[] args) {
        FindingCycles fc = new FindingCycles(9);
        /*fc.addEdge(1, 2, false);
        fc.addEdge(2, 3, false);
        fc.addEdge(3, 4, false);
        fc.addEdge(4, 5, false);
        fc.addEdge(5, 6, false);*/
        fc.addEdge(6, 7, false);
        fc.addEdge(7, 8, false);
        fc.addEdge(7, 9, false);
        fc.addEdge(8, 9, false);
        fc.findCycle();

    }

    static void out (String str) {
        System.out.print(str);
    }

    boolean[] discovered = new boolean[MAXV + 1];
    boolean[] processed = new boolean[MAXV + 1];
    int[] entryTime = new int[MAXV + 1];
    int[] exitTime = new int[MAXV + 1];
    int time;
    boolean finished = false;

    public FindingCycles(int vertices) {
        super(vertices);
    }

    public void findCycle() {
        initDfs();
        for (int i = 1; i <= vertices; i++) {
            if (!discovered[i]) {
                dfs(i);
            }
        }
        if (!finished) out("No cycle found" + "\n");
    }

    private void initDfs() {
        for (int i = 0; i <= MAXV; i++) {
            discovered[i] = processed[i] = false;
            parent[i] = -1;
        }
    }

    /* call initDfs() before this function */
    private void dfs(int vertex) {
        if (finished) return;

        discovered[vertex] = true;
        entryTime[vertex] = ++time;
        processVertexEarly(vertex);

        Adjacent adj = adjacents[vertex];
        while (adj != null) {
            int end = adj.end;
            if (!discovered[end]) {
                parent[end] = vertex;
                processEdge(vertex, end);
                dfs(end);
            } else if ((!processed[end] && parent[vertex] != end) || directed) {
                processEdge(vertex, end);
            }
            if (finished) return;
            adj = adj.next;
        }
        processVertexLate(vertex);
        exitTime[vertex] = ++time;
        processed[vertex] = true;
    }

    private void processVertexEarly(int vertex) {
    }

    private void processVertexLate(int vertex) {
    }

    private void processEdge(int vertex, int end) {
        //out(vertex + "->" + end + "\n");
        if (discovered[end] && parent[vertex] != end) {
            out("Cycle from " + vertex + " to " + end + "\n");
            out("Path: ");
            int p = vertex;
            do {
                out(p + "<-" + parent[p]);
                p = parent[p];
            } while (parent[p] != end);
            out("<-" + end);
            finished = true;
        }
    }
}
