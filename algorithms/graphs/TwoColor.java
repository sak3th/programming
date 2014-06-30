package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TwoColor {

    public static void main(String[] args) {
        TwoColor t = new TwoColor();
        BipartiteGraph bg = t.new BipartiteGraph(9);

        bg.addEdge(1, 2, true);
        bg.addEdge(1, 4, true);
        bg.addEdge(1, 5, true);
        bg.addEdge(2, 3, true);
        bg.addEdge(2, 7, true);
        bg.addEdge(4, 7, true);
        bg.addEdge(5, 8, true);
        bg.addEdge(8, 9, true);

        if(bg.bipartite()) {
            out("Bipartite " + "\n");
        } else {
            out("Not Bipartite" + "\n");
        }
    }

    static void out(String str) { System.out.print(str); }

    public class BipartiteGraph extends Graph {
        boolean[] discovered = new boolean[MAXV + 1];
        boolean[] processed = new boolean[MAXV + 1];
        int[] color = new int[MAXV + 1];
        boolean bipartite = true;

        public BipartiteGraph(int vertices) {
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

        public void processVertexEarly(int vertex) { }

        public void processEdge(int begin, int end) {
            if (color[begin] == color[end]) {
                bipartite = false;
            }
            color[end] = color[begin] * -1;
        }

        public void processVertexLate(int vertex) { }
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
                addEdge(begin, end, true);
                this.directed = false;
            } else  {
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
