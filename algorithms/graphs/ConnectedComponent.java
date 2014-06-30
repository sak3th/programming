package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponent extends Graph {

    public static void main(String[] args) {
        ConnectedComponent ccomp = new ConnectedComponent(9);
        ccomp.addEdge(1, 2, false);
        ccomp.addEdge(1, 4, false);
        ccomp.addEdge(1, 5, false);
        ccomp.addEdge(2, 7, false);
        ccomp.addEdge(4, 7, false);
        ccomp.addEdge(5, 8, false);
        ccomp.addEdge(8, 9, false);
        ccomp.addEdge(3, 6, false);

        ccomp.findComponents();
    }

    static void out(String str) { System.out.print(str); }

    boolean[] discovered = new boolean[MAXV + 1];
    boolean[] processed = new boolean[MAXV + 1];

    public ConnectedComponent(int vertices) {
        super(vertices);
    }

    public void findComponents() {
        out("Edges: " + edges + "\n");
        initBfs();
        int c = 0;
        for (int i = 1; i <= vertices; i++) {
            if (!discovered[i]) {
                c++;
                out("Component " + c + " [");
                bfs(i);
                out(" ]\n");
            }
        }
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
            int vertex = ((Integer)q.remove());
            processVertexEarly(vertex);
            processed[vertex] = true;
            Adjacent adj = adjacents[vertex];

            while(adj != null) {
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

    private void processVertexEarly(int vertex) {
        out(" " + vertex);
    }

    private void processEdge(int begin, int end) { }

    private void processVertexLate(int vertex) {}

}
