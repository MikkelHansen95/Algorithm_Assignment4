package graphs;

import basics.myPath;
import java.util.PriorityQueue;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Mikkel
 */
public class Dijkstra {

    public WeightedGraph wg;
    private String source;
    // Create map with AIRPORT SOURCE AND TARGET
    private Map<String, String> edgeTo;
    // Create map with AIRPORT TARGER AND WEIGHT
    private Map<String, Double> distTo;
    // PriorityQueue
    private PriorityQueue<myPath> pqMin = new PriorityQueue<>();

    public Dijkstra(WeightedGraph graph, String source, String type) {
        this.wg = graph;
        this.source = source;
        // Get all AIRPORTS
        ArrayList<String> keys = new ArrayList<>(wg.getVertices().keySet());
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        for (String v : keys) {
            // destination as KEY and source as VALUE
            edgeTo.put(v, "");
            // destination as KEY and WEIGHT as VALUE
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        edgeTo.put(source, source);
        distTo.put(source, 0.0);
        pqMin.add(new myPath(source, 0.0));
        build(type);
    }

    private void build(String weightType) {
        while (!pqMin.isEmpty()) {
            myPath path = pqMin.poll();
            relax(path, weightType);
        }
    }

    private void relax(myPath path, String type) {
        Iterable<Edge> adj = wg.adjacents(new Edge("", path.v, "", Double.NaN, Double.NaN, null));
        for (Edge edge : adj) {
            double weightValue = 0.0;
            if (type.equals("distance")) {
                weightValue = distTo.get(edge.source) + edge.distance;
            } else if (type.equals("time")) {
                weightValue = distTo.get(edge.source) + edge.time + 1.0;
            }
            if (distTo.get(edge.destination) != null) {

                if (distTo.get(edge.destination) > weightValue) {
                    // update distTo and edgeTo...
                    distTo.put(edge.destination, weightValue);
                    edgeTo.put(edge.destination, edge.source);
                    // update priority queue
                    pqMin.add(new myPath(edge.destination, weightValue));
                }
            }
        }
    }

    public String showPathTo(String destination, String type) {
        String path = "" + destination;
        Double weight = distTo.get(destination);
        while (edgeTo.get(destination) != null && !edgeTo.get(destination).equals("") && !edgeTo.get(destination).equals(destination)) {
            destination = edgeTo.get(destination);
            weight += distTo.get(destination);
            path = "" + destination + " -> " + path;
        }
        return path + " " + type+ ": " + weight;
    }

    public void print(PrintStream out, String type) {
        ArrayList<String> keys = new ArrayList<>(wg.getVertices().keySet());
        for (String k : keys) {
            out.println("" + k + ": " + showPathTo(k,type));
        }
    }

}
