/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.IOException;


public class main {

    public static void main(String[] args) throws FileNotFoundException {

        Map<Node, List<Node>> graphMap = new HashMap();
        Graph g = new Graph(graphMap);

        WeightedGraph wg = new WeightedGraph();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./src/main/java/data/routes.txt"));
            String headers = reader.readLine();

            String line = reader.readLine();
            while (line != null) {
                String[] arr = line.split(";");
                // CRAFTING graph for BFS and DFS
                String airline = arr[0];
                String source = arr[1];
                String destination = arr[2];
                Double distance = Double.parseDouble(arr[3]);
                Double time = Double.parseDouble(arr[4]);

                Node node = new Node(source, airline);
                Node nodeDest = new Node(destination, airline);

                g.addNode(node);
                g.addNode(nodeDest);
                g.addEdge(node, nodeDest);

                wg.addEdge(new Edge("", source, "", 0.0, 0.0, null), new Edge(destination, source, airline, distance, time, null));

                line = reader.readLine();
            }

            Node node1 = new Node("GYD", "2B");
            Node node2 = new Node("DME", "2B");
            System.out.println("BREADTH FIRST SEARCH: " + node1.label + " -> " + node2.label);
            Set<Node> resu = g.breadthFirstSearch(node1, node2);
            resu.forEach((t) -> {
                System.out.print(t.label + "(" + t.company + ") --> ");
            });
            System.out.println("");

            System.out.println("--------------------");

            System.out.println("DEPTH FIRST SEARCH: " + node1.label + " -> " + node2.label);
            Set<Node> res = g.depthFirstTraversal(node1, node2);
            res.forEach((t) -> {
                System.out.print(t.label + "(" + t.company + ") --> ");

            });
            System.out.println("");

            System.out.println("--------------------");

            System.out.println("Dijkstra's Algorithm: AER -> DWC");
            Dijkstra dk = new Dijkstra(wg, "AER", "distance");
            System.out.println(dk.showPathTo("DWC", "Distance"));

            Dijkstra dk1 = new Dijkstra(wg, "AER", "time");
            System.out.println(dk1.showPathTo("DWC", "Time"));

            System.out.println("--------------------");

            System.out.println("Minimum Spanning Tree:");
            
            MinimumSpanningTree minimumSTree = new MinimumSpanningTree(wg);

            for (Map.Entry<String, Edge> entry : wg.getVertices().entrySet()) {
                Edge node = entry.getValue();
                minimumSTree.addEgde(node.source, node.destination, node.distance);
            }
            minimumSTree.minimumSpanningTreeKruskal();

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

    }
}
