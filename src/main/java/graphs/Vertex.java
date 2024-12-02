package graphs;

import java.util.ArrayList;

public class Vertex {
    int v;
    ArrayList<Edge> edges;

    public Vertex(int v) {
        this.v = v;
        edges = new ArrayList<>();
    }

    void addEdge(Edge e) {
        edges.add(e);
    }

    void removeEdge(Edge e) {
        edges.remove(e);
    }

    void removeEdge(Vertex end) {
        this.edges.removeIf(edge -> edge.end == end);
    }

}
