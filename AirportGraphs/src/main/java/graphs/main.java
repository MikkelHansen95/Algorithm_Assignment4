/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import graphs.Edge;
import graphs.Graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import graphs.Node;
import graphs.WeightedGraph;
import java.io.FileNotFoundException;

/**
 *
 * @author Mikkel
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException {

        Map<Node, List<Node>> graphMap = new HashMap();
        Graph g = new Graph(graphMap);
        
        Map<Node, List<Edge>> weightedMap = new HashMap();
        WeightedGraph wg = new WeightedGraph(weightedMap);
        
        Set<String> sourceAirportCodes = new HashSet<>();
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

                Node node = new Node(source,airline);
                Node nodeDest = new Node(destination, airline);
                g.addNode(node);
                g.addNode(nodeDest);
                g.addEdge(node, nodeDest);
                
                // CRAFTING WeightedGraph for Dijkstra
                
                Double distance = Double.parseDouble(arr[3]);
                Float time = Float.parseFloat(arr[4]);
                

                wg.addNode(node);
                wg.addNode(nodeDest);

                wg.addUndirectedEdge(node, nodeDest, distance);
                
                line = reader.readLine();
            }
             

            //System.out.println(g.getAdjVertices().size());
            Node node1 = new Node("GYD","2B");
            Node node2 = new Node("DME","2B");
            System.out.println("BREADTH");
            System.out.println(g.breadthFirstSearch(node1,node2));
            
            System.out.println("DEPTH");
            Set<Node> res = g.depthFirstTraversal(node1,node2);
            //System.out.println(res.size());
            
            System.out.println(wg.getV());

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
