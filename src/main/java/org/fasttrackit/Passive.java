package org.fasttrackit;

public class Passive {
    String name;
    String efect;
    int attack;
    int defense;
    int heal;
    int SelfDamage;

    public Passive(String name, String efect, int attack, int defense, int heal, int selfDamage) {
        this.name = name;
        this.efect = efect;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
        SelfDamage = selfDamage;
    }
}
