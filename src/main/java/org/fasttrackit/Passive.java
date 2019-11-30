package org.fasttrackit;

public class Passive {
    String name;
    String efect;
    int attack;
    int defense;
    int heal;
    int SelfDamage;
    int cost;

    public Passive(String name, String efect, int attack, int defense, int heal, int selfDamage,int cost) {
        this.name = name;
        this.efect = efect;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
        SelfDamage = selfDamage;
        this.cost=cost;
    }
}
