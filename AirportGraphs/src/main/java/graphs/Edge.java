/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author Mikkel
 */
public class Edge {

    public String destination;
    public String source;
    public String airline;
    public Double distance;
    public Double time;
    public Edge next;

    public Edge(String destination, String source, String airline, Double distance, Double time, Edge next) {
        this.destination = destination;
        this.source = source;
        this.airline = airline;
        this.distance = distance;
        this.time = time;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.destination + "; " + this.airline + "; " + this.next;
    }
}
