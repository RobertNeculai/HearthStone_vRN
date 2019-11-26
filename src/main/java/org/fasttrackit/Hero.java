package org.fasttrackit;

public class Hero {
    String name;
    String heroClass;
    Passive passive;

    public Hero(String name, String heroClass, Passive passive) {
        this.name = name;
        this.heroClass = heroClass;
        this.passive = passive;
    }
}
