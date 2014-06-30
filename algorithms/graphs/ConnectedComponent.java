package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponent {

    public static void main(String[] args) {
        ConnectedComponent ccomp = new ConnectedComponent();
        ConnectedComponentGraph ccg = ccomp.new ConnectedComponentGraph(9);

        ccg.addEdge(1, 2, false);
        ccg.addEdge(1, 4, false);
        ccg.addEdge(1, 5, false);
        ccg.addEdge(2, 7, false);
        ccg.addEdge(4, 7, false);
        ccg.addEdge(5, 8, false);
        ccg.addEdge(8, 9, false);
        ccg.addEdge(3, 6, false);

        ccg.findComponents();
    }

    static void out(String str) { System.out.print(str); }

    public class ConnectedComponentGraph extends Graph {
        boolean[] discovered = new boolean[MAXV + 1];
        boolean[] processed = new boolean[MAXV + 1];

        public ConnectedComponentGraph(int vertices) {
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

        public void initBfs() {
            for (int i = 0; i <= MAXV; i++) {
                discovered[i] = processed[i] = false;
                parent[i] = -1;
            }
        }

        /* call initBfs() before this function */
        public void bfs(int start) {
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

        public void processVertexEarly(int vertex) {
            out(" " + vertex);
        }

        public void processEdge(int begin, int end) { }

        public void processVertexLate(int vertex) {}
    }

    public class Graph {
        static final int MAXV = 1000;

        int vertices;
        int edges;
        boolean directed;
        int[] degree = new int[MAXV + 1];
        int[] parent = new int[MAXV + 1];
        Adjacent[] adjacents = new Adjacent[MAXV + 1];

        public Graph(int vertices) {
            this.vertices = vertices;
            directed = true;
        }

        public void addEdge(int begin, int end, boolean directed) {
            Adjacent adj = new Adjacent();
            adj.end = end;
            adj.next = adjacents[begin];
            adjacents[begin] = adj;
            degree[begin]++;

            if (!directed) {
                addEdge(end, begin, true);
                this.directed = false;
            } else {
                edges ++;
            }
        }

        public class Adjacent {
            int end;
            int weight;
            Adjacent next;
        }
    }
}
