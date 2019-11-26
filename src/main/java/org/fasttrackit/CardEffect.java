package org.fasttrackit;

public class CardEffect {
    String efect;
    int cost;
    int attack;
    int defense;
    int heal;

    public CardEffect(String efect, int cost, int attack, int defense, int heal) {
        this.efect = efect;
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
    }
}
