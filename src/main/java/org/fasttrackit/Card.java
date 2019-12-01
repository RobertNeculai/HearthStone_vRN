package org.fasttrackit;

public class Card {
    String name;
    String rarity;
    Type type;
    boolean active;
    Expansion expansion;
    CardEffect cardEffect;

    public Card(String name, String rarity,Type type, Expansion expansion, CardEffect cardEffect) {
        this.name = name;
        this.rarity = rarity;
        this.type=type;
        this.expansion = expansion;
        this.cardEffect = cardEffect;
    }
}