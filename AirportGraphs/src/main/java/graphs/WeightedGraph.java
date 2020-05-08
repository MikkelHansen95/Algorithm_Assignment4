package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    private Map<Node, List<Edge>> vertices;

    public WeightedGraph(Map<Node, List<Edge>> adjVertices) {
        this.vertices = adjVertices;
    }

    public void addNode(Node node1) {
        vertices.putIfAbsent(node1, new ArrayList<>());
    }

    public void addEdge(Node v, Node w, double weight) {
        Edge edge = new Edge(v, w, weight);
        vertices.get(v).add(edge);
    }

    public void addUndirectedEdge(Node v, Node w, double weight) {
        addEdge(v, w, weight);
        addEdge(w, v, weight);
    }

    public int getV() {
        return vertices.size();
    }

    public Iterable<Edge> adjacents(int v) {
        return vertices.get(v);
    }

}
