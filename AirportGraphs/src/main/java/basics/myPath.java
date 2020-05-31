package basics;

import javax.validation.constraints.NotNull;

public class myPath implements Comparable<myPath> {

    public String v;
    public double weight;

    public myPath(String v, double weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(@NotNull myPath other) {
        if (this.weight < other.weight) {
            return -1;
        }
        if (this.weight > other.weight) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "" + v + ": " + weight;
    }

}
