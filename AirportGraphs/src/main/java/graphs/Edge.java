package graphs;

/**
 * @author Mikkel
 */
public class Edge {

    public String destination;
    public String source;
    public String airline;
    public Double distance;
    public Double time;
    public Edge next;

    public Edge(String destination, String source, String airline, Double distance, Double time, Edge next) {
        this.destination = destination;
        this.source = source;
        this.airline = airline;
        this.distance = distance;
        this.time = time;
        this.next = next;
    }

    public Edge(String destination, String source, Double distance) {
        this.destination = destination;
        this.source = source;
        this.distance = distance;
    }
    

    @Override
    public String toString() {
        return this.destination + "; " + this.airline + "; " + this.next;
    }
}
