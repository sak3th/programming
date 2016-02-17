package graphs;

import java.util.Stack;

public class StronglyConnectedComponents {

    public static void main(String[] args) {
        Graph g = new Graph(8, true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true); g.addEdge(2, 4, true); g.addEdge(2, 5, true);
        g.addEdge(3, 1, true);
        g.addEdge(4, 1, true); g.addEdge(4, 6, true); g.addEdge(4, 8, true);
        g.addEdge(5, 6, true);
        g.addEdge(6, 7, true);
        g.addEdge(7, 5, true);
        g.addEdge(8, 6, true);

        StronglyConnectedComponents strongly = new StronglyConnectedComponents();
        strongly.strongComponents(g);
    }

    private void strongComponents(Graph g) {
        init(g);
        for (int i = 1; i <= g.numV; i++) {
            if (!discovered[i]) {
                idfs(g, i);
            }
        }
        System.out.println(components + " strongly connected componets");
        /*for (int c = 1; c <= components; c++) {
            System.out.print("Component " + c + ": ");
            for (int i = 1; i <= g.numV; i++) {
                if (scc[i] == c) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }*/
    }

    private void processVertexEarly(int v) {
        low[v] = v; compStack.push(v);
    }

    private void processEdge(int  start, int end) {
        Edge classification = classifyEdge(start, end);
        if (classification == Edge.BACK) {
            if (entryTime[end] < entryTime[low[start]]) {
                low[start] = end;
            }
        }
        if (classification == Edge.CROSS) {
            if (scc[end] == -1 && entryTime[end] < entryTime[low[start]]) {
                low[start] = end;
            }
        }
    }

    private void processVertexLate(int vertex) {
        if (low[vertex] == vertex) {
            ++components;
            System.out.print("Component " + components + ": ");
            scc[vertex] = components;
            int t;
            System.out.print(vertex + " ");
            while (!compStack.isEmpty() && (t = compStack.pop()) != vertex) {
                System.out.print(t + " ");
                scc[t] = components;
            }
            System.out.println();
        }

        if (parent[vertex] > 0 && entryTime[low[vertex]] < entryTime[low[parent[vertex]]]) {
            low[parent[vertex]] = low[vertex];
        }
    }

    private void init(Graph g) {
        parent = new int[g.numV + 1];
        discovered = new boolean[g.numV + 1];
        processed = new boolean[g.numV + 1];
        entryTime = new int[g.numV + 1];
        exitTime = new int[g.numV + 1];
        low = new int[g.numV + 1];
        scc = new int[g.numV + 1];
        time = 0;
        finished = false;
        for (int i = 0; i <= g.numV; i++) {
            discovered[i] = processed[i] = false;
            parent[i] = -1;
            ///low[i] = i;
            scc[i] = -1;
        }
        compStack = new Stack();
        components = 0;
    }

    private void idfs(Graph g, int start) {
        Stack<Vertex> stack = new Stack();
        stack.push(new Vertex(start, g.adjacents[start]));
        discovered[start] = true;
        entryTime[start] = ++time;
        processVertexEarly(start);

        while (!stack.isEmpty()) {
            Vertex peek = stack.peek();
            if (peek.adj != null) {
                int end = peek.adj.end;
                if (!discovered[end]) {
                    parent[end] = peek.v;
                    processEdge(peek.v, end);
                    stack.push(new Vertex(end, g.adjacents[end]));
                    discovered[end] = true;
                    entryTime[end] = ++time;
                    processVertexEarly(end);
                } else if ((!processed[end] && parent[peek.v] != end) || g.directed) {
                    processEdge(peek.v, end);
                }
                peek.adj = peek.adj.next;
            } else {
                stack.pop();
                processVertexLate(peek.v);
                exitTime[peek.v] = ++time;
                processed[peek.v] = true;
            }
            if (finished) return;
        }
    }

    private Edge classifyEdge(int start, int end) {
        if (parent[end] == start) return Edge.TREE;
        if (discovered[end] && !processed[end]) return Edge.BACK;
        if (processed[end] && (entryTime[end] > entryTime[start])) return Edge.FORWARD;
        if (processed[end] && (entryTime[end] < entryTime[start])) return Edge.CROSS;
        System.out.println("Error! Edge classifcation " + start + " -> " + end);
        return Edge.NONE;
    }

    private enum Edge {TREE, BACK, FORWARD, CROSS, NONE}

    private class Vertex {
        int v;
        Graph.Adjacent adj;
        public Vertex(int v, Graph.Adjacent adj) {
            this.v = v;
            this.adj = adj;
        }
    }

    int[] parent, entryTime, exitTime;
    boolean[] discovered, processed;
    int time;
    boolean finished;

    int[] low, scc;
    Stack<Integer> compStack;
    int components;
}
