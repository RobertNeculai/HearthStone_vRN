package org.fasttrackit;

public class Synergy {
    String type;


    public Synergy(String type) {
        this.type = type;
    }

    public boolean synergyActive(Card a,Card b) {
        if (a.type == b.type) {
            System.out.println("Synergy Active");
            return true;
        } else
            return false;
    }
}