package org.fasttrackit;

public class CardEffect {
    String efect;
    int cost;
    int attack;
    int defense;
    int heal;
    boolean taunt;

    public CardEffect(String efect, int cost, int attack, int defense, int heal,boolean taunt) {
        this.efect = efect;
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
        this.taunt=taunt;
    }
}
