package graphs;

public class PathEdge {
    public Path from;
    public Path to;
    double weight = 0;

    public PathEdge(Path from, Path to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Path getFrom() {
        return from;
    }

    public void setFrom(Path from) {
        this.from = from;
    }

    public Path getTo() {
        return to;
    }

    public void setTo(Path to) {
        this.to = to;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
