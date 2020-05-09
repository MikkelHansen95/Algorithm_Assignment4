/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Mikkel
 */
public class Node {

    public String label;
    public String company;
    double weight = 0.0;
    LinkedList<Node> shortestPath = new LinkedList();

    public Node(String label, String company) {
        this.label = label;
        this.company = company;
        this.weight = Double.MAX_VALUE;
    }

    // equals and hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.label);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        return true;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LinkedList<Node> getShortestPath() {
        return this.shortestPath;
    }

    public void setShortestPath(LinkedList<Node> sp) {
        this.shortestPath = sp;
    }

    @Override
    public String toString() {
        return "Node{" + "label=" + label + ", company=" + company + ", weight=" + weight + ", shortestPath=" + shortestPath + '}';
    }

    public String toStringLabel() {
        return "" + label + ", ";
    }

    public String toStringForShortestPath() {
        String str = "";
        for (Node node : shortestPath) {
            str += toStringLabel();
        }
        return str + " size : " + shortestPath.size() + " ";
    }

}
