package graphs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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

    public void removeNode(String label) {
        Node v = new Node(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Node(label));
    }

    public void addEdge(Node node1, Node node2) {
        adjVertices.get(node1).add(node2);
        adjVertices.get(node2).add(node1);
    }

    public void removeEdge(String label1, String label2) {
        Node v1 = new Node(label1);
        Node v2 = new Node(label2);
        List<Node> eV1 = adjVertices.get(v1);
        List<Node> eV2 = adjVertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    public List<Node> getAdjVertices(Node node) {
        return adjVertices.get(node);
    }

    public boolean breadthFirstSearch(Node rootNode, Node nodeDest) {
        Set<Node> visited = new LinkedHashSet<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(rootNode);
        visited.add(rootNode);
        while (!queue.isEmpty()) {
            Node vertex = queue.poll();
            for (Node v : getAdjVertices(vertex)) {
                if (!visited.contains(v)) {
                    if (v.company.equals(rootNode.company)) {
                        visited.add(v);
                    }

                    if (v.label.equals(nodeDest.label)) {
                        visited.add(nodeDest);
                        for (Node node : visited) {
                            System.out.print(" -->" + node.label + "(" + node.company + ")");
                        }
                        System.out.println("");
                        return true;
                    }
                    queue.add(v);
                }
            }
        }
        return false;
    }

    public Set<Node> depthFirstTraversal(Node rootNode, Node nodeDest) {
        Set<Node> visited = new LinkedHashSet<Node>();
        Stack<Node> stack = new Stack<Node>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            Node vertex = stack.pop();
            if (!visited.contains(vertex)) {
                if(vertex.company.equals(rootNode.company)){
                    visited.add(vertex);
                    if(vertex.label.equals(nodeDest.label)){
                        return visited;
                    }
                }

                for (Node v : getAdjVertices(vertex)) {
                    if(v.company.equals(rootNode.company)){
                       stack.push(v); 
                    }
                    
                }
            }
        }
        return visited;
    }
}