package graphs;

public class FindingCycles {

    public class FindingCyclesGraph extends Graph {
        boolean[] discovered = new boolean[MAXV + 1];
        boolean[] processed = new boolean[MAXV + 1];
        int[] entryTime = new int[MAXV + 1];
        int[] exitTime = new int[MAXV + 1];
        int time = 0;
        boolean finished = false;

        public FindingCyclesGraph(int vertices) {
            super(vertices);
        }

        public void initDfs() {
            for (int i = 0; i <= MAXV; i++) {
                discovered[i] = processed[i] = false;
                parent[i] = -1;
            }
        }

        /* call initDfs() before this function */
        public void dfs(int vertex) {
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
                } else if ((!processed[end] && parent[end] != vertex) || directed) {
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
        }
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
