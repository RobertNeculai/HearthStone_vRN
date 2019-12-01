package org.fasttrackit;

public class Synergy {
    String type;


    public Synergy(String type) {
        this.type = type;
    }

    public boolean synergyActive(Card a,Card b) {
        if (a.getType() == b.getType()) {
            System.out.println("Synergy Active");
            return true;
        } else
            return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}