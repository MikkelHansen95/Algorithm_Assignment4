package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {

    private int V;
    private int E = 0;
    private Map<String, Edge> vertices;

    public WeightedGraph() {
        this.V = V;
        vertices = new HashMap<>();
    }

    public int getV() {
        return vertices.size();
    }
    
    public int getE() {
        return E;
    }

    public Map<String, Edge> getVertices() {
        return vertices;
    }

    public void addEdge(Edge source, Edge destination) {
        Edge node = new Edge(destination.destination, source.source, destination.airline, destination.distance, destination.time, vertices.get(source.source));
        vertices.put(source.source, node);
        E++;
    }

    public Iterable<Edge> adjacents(Edge v) {
        List<Edge> adjacents = new ArrayList<>();
        Edge node = vertices.get(v.source);
        while (node != null) {
            adjacents.add(node);
            node = node.next;
        }
        return adjacents;
    }

    @Override
    public String toString() {
        String text = "";
        for (Map.Entry<String, Edge> entry : vertices.entrySet()) {
            if (text.length() == 0) {
                text += "Airline : " + entry.getValue().airline + " - ";
            }
            text += "" + entry.getKey() + ": " + adjacents(new Edge("", entry.getKey(), "", Double.NaN, Double.NaN, null)) + "\n";
        }
        return text;
    }
    
}
