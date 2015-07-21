package graphs;

public class Graph {

    public int numV;
    public int numE;
    public boolean directed;
    public int[] degree;
    public Adjacent[] adjacents;

    public Graph(int vertices, boolean directed) {
        this.numV = vertices;
        this.directed = directed;
        degree = new int[vertices + 1];
        adjacents = new Adjacent[vertices + 1];
    }

    public void addEdge(int begin, int end, boolean directed) {
        Adjacent adj = new Adjacent();
        adj.end = end;
        adj.next = adjacents[begin];
        adjacents[begin] = adj;
        degree[begin]++;

        if (!directed) {
            addEdge(end, begin, true);
        } else {
            numE++;
        }
    }

    public void addEdge(int begin, int end, int weight, boolean directed) {
        Adjacent adj = new Adjacent();
        adj.end = end;
        adj.weight = weight;
        adj.next = adjacents[begin];
        adjacents[begin] = adj;
        degree[begin]++;

        if (!directed) {
            addEdge(end, begin, weight, true);
        } else {
            numE++;
        }
    }

    public class Adjacent {
        public int end;
        public int weight;
        public Adjacent next;
    }
}

