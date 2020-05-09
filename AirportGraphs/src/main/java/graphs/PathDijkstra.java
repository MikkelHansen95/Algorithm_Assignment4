package graphs;

import java.util.*;
/*
public class PathDijkstra {

    public WeightedGraph wg;

    public PathDijkstra(WeightedGraph graph) {
        this.wg = graph;
    }


    public void calculateShortestPath(Path from, Path to) {
        Comparator<PathEdge> comparator = new PrioQueueComparator();
        PriorityQueue<PathEdge> pq = new PriorityQueue(100000, comparator);
        int i = 0;
        List<PathEdge> next = wg.adjacents(from);
        if(next == null) { //
            throw new Error("Path does not exist!");
        }
        while(i < next.size()) {
            PathEdge pathEdge = next.get(i);
            if(i + 1 == next.size()) {

                // Peek on the next one
                PathEdge currentEdge = pq.poll();
                List<PathEdge> path = wg.adjacents(currentEdge.to);
                next = path;
                i = 0;
            } else {
                pq.add(pathEdge);
                i++;
            }
        }
        pq.forEach((e -> {
            System.out.println(e.getTo().label);
        }));
    }
    /*
    public static Graph calculateShortestPathFromSource(WeightedGraph graph, Node source, Node target) {
        //source.setWeight(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void CalculateMinimumDistance(Edge evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
     
}
*/