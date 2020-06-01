package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    public WeightedGraph wg;
    public String[] vertices;
    public ArrayList<Edge> allEdges = new ArrayList<>();

    public MinimumSpanningTree(WeightedGraph graph) {
        this.wg = graph;
        ArrayList<String> keys = new ArrayList<>(graph.getVertices().keySet());
        vertices = new String[keys.size()];
        for(int i = 0; i < vertices.length; i++) {
            vertices[i] = keys.get(i);
        }
        
        for (Map.Entry<String, Edge> entry : wg.getVertices().entrySet()) {
            Edge node = entry.getValue();
            addEgde(node.source, node.destination, node.distance);
        }
    }

    public void addEgde(String source, String destination, Double weight) {
        Edge edge = new Edge(destination, source, weight);
        allEdges.add(edge);
    }

    public void minimumSpanningTreeKruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingDouble(o -> o.distance));

        for (int i = 0; i < allEdges.size(); i++) {
            pq.add(allEdges.get(i));
        }

        Map<String, String> parent = new HashMap<>();
        makeSet(parent);
        ArrayList<Edge> mst = new ArrayList<>();

        int index = 0;
        while (!pq.isEmpty() && index < vertices.length - 1) {
            Edge edge = pq.poll();

            String x_set = find(parent, edge.source);
            String y_set = find(parent, edge.destination);
            
            if (x_set.equals(y_set)) {
            } else {
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }
        
        print(mst);
    }
    
    public void makeSet(Map<String, String> parent) {
        for (int i = 0; i < vertices.length; i++) {
            parent.put(vertices[i], vertices[i]);
        }
    }
    
    public String find(Map<String, String> parent, String vertex) {

        if (parent.get(vertex) != null && !parent.get(vertex).equals(vertex)) {
            return find(parent, parent.get(vertex));
        };
        return vertex;
    }
    
    public void union(Map<String, String> parent, String x, String y) {
        String x_set_parent = find(parent, x);
        String y_set_parent = find(parent, y);
        parent.put(y_set_parent, x_set_parent);
    }
    
    public void print(ArrayList<Edge> edgeList) {
        Double weight = 0.0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            weight += edge.distance;
            //System.out.println("Edge number: " + i + " | source: " + edge.source + " target: " + edge.destination + " weight: " + edge.distance);
        }
        System.out.println(edgeList.size() + " | " + weight);
    }
}