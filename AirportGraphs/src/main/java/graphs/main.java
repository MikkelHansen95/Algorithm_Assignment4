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

        Path path1 = new Path("A", "din mor");
        Path path2 = new Path("B", "din mor");
        Path path3 = new Path("C", "din mor");
        Path path4 = new Path("D", "din mor");
        Path path5 = new Path("E", "din mor");
        Path path6 = new Path("F", "din mor");
        Map<Path, List<PathEdge>> map = new HashMap<>();
        WeightedGraph g = new WeightedGraph(map);

        PathEdge pe1 = new PathEdge(path1, path4, 3);
        PathEdge pe3 = new PathEdge(path1, path3, 4);
        PathEdge pe5 = new PathEdge(path1, path2, 6);
        PathEdge pe7 = new PathEdge(path4, path6, 9);
        PathEdge pe9 = new PathEdge(path3, path5, 12);
        PathEdge pe11 = new PathEdge(path2, path5, 5);

        g.addPath(path1, pe1);
        g.addPath(path1, pe3);
        g.addPath(path1, pe5);
        g.addPath(path4, pe7);
        g.addPath(path3, pe9);
        g.addPath(path2, pe11);

        PathDijkstra pd = new PathDijkstra(g);

        pd.calculateShortestPath(path1, path5);
        /*
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
*/
    }
}
