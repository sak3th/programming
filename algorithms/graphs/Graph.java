package graphs;

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

