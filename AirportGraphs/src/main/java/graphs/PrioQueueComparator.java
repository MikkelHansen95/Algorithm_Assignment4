package graphs;

import java.util.Comparator;

public class PrioQueueComparator implements Comparator<PathEdge> {
    @Override
    public int compare(PathEdge current, PathEdge pathEdge) {
        if(current.weight > pathEdge.weight) {
            return 1;
        } else if(current.weight < pathEdge.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}