/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Objects;

/**
 *
 * @author Mikkel
 */
public class Vertex {

    public String label;
    public String company;
    public double weight;


    public Vertex(String label, String company, double weigth) {
        this.label = label;
        this.company = company;
        this.weight = weight;
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


}
