package org.fasttrackit;

public class Card {
    String name;
    String rarity;
    Expansion expansion;
    CardEffect cardEffect;

    public Card(String name, String rarity, Expansion expansion, CardEffect cardEffect) {
        this.name = name;
        this.rarity = rarity;
        this.expansion = expansion;
        this.cardEffect = cardEffect;
    }
}