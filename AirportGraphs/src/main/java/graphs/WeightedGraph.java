package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightedGraph {

    private Map<Path, List<PathEdge>> vertices;

    public WeightedGraph(Map<Path, List<PathEdge>> adjVertices) {
        this.vertices = adjVertices;
    }

    public void addPath(Path path, PathEdge pe) {
        if(!vertices.containsKey(path)) {
            List newList = new ArrayList();
            newList.add(pe);
            vertices.putIfAbsent(path, newList);
        } else {
            List currentList = vertices.get(path);
            currentList.add(pe);
        }
    }

    public Map<Path, List<PathEdge>> getVertices() {
        return vertices;
    }

    public void setVertices(Map<Path, List<PathEdge>> vertices) {
        this.vertices = vertices;
    }

    public int getV() {
        return vertices.size();
    }

    public List<PathEdge> adjacents(Path path) {
        return vertices.get(path);
    }

}
