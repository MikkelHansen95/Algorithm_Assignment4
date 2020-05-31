package graphs;

import basics.myQueue;
import basics.myStack;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph {

    private Map<Node, List<Node>> adjVertices;

    public Graph(Map<Node, List<Node>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public Map<Node, List<Node>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Node, List<Node>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public void addNode(Node node1) {
        adjVertices.putIfAbsent(node1, new ArrayList<>());
    }

    public void addEdge(Node node1, Node node2) {
        adjVertices.get(node1).add(node2);
        adjVertices.get(node2).add(node1);
    }

    public List<Node> getAdjVertices(Node node) {
        return adjVertices.get(node);
    }

    public Set<Node> breadthFirstSearch(Node rootNode, Node nodeDest) {
        // Set of visited Nodes/vertex
        Set<Node> visited = new LinkedHashSet<Node>();
        // Creating queue
        Node[] queuearr = new Node[10000];
        myQueue<Node> queue = new myQueue(queuearr);
        // Add root node to queue and visited
        queue.enqueue(rootNode);
        visited.add(rootNode);
        while (!queue.isEmpty()) {
            //pull node out of queue
            Node vertex = queue.dequeue();
            // Get all vertices of current vertex
            for (Node v : getAdjVertices(vertex)) {
                if (!visited.contains(v)) {
                    // Find BFS with same airline(company)
                    if (v.company.equals(rootNode.company)) {
                        visited.add(v);
                    }
                    // If you found your destination return the visited nodes to be able to see your search history
                    // Function could return boolean
                    if (v.label.equals(nodeDest.label)) {
                        visited.add(nodeDest);
                        return visited;
                    }
                    queue.enqueue(v);
                }
            }
        }
        return null;
    }

    public Set<Node> depthFirstSearch(Node rootNode, Node nodeDest) {
        // Set of visited Nodes/vertex
        Set<Node> visited = new LinkedHashSet<>();
        // Creating stack
        Node[] stackarr = new Node[10000];
        myStack<Node> stack = new myStack(stackarr);
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            Node vertex = stack.pop();
            //Checks if you already have visited the vertex/node
            if (!visited.contains(vertex)) {
                // Checks airline company
                if (vertex.company.equals(rootNode.company)) {
                    visited.add(vertex);
                    // Checks if we found destination
                    if (vertex.label.equals(nodeDest.label)) {
                        return visited;
                    }
                    // If right airline loop trough vertices and push all vertices if company is the same
                    for (Node v : getAdjVertices(vertex)) {
                        if (!visited.contains(v)) {
                            stack.push(v);
                        }
                    }
                }
            }
        }
        return null;
    }

}
