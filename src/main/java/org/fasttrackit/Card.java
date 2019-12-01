package org.fasttrackit;

public class Card {
   private String name;
   private String rarity;
   private Type type;
   private boolean active;
   private Expansion expansion;
   private CardEffect cardEffect;

    public Card(String name, String rarity,Type type, Expansion expansion, CardEffect cardEffect) {
        this.name = name;
        this.rarity = rarity;
        this.type=type;
        this.expansion = expansion;
        this.cardEffect = cardEffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public CardEffect getCardEffect() {
        return cardEffect;
    }

    public void setCardEffect(CardEffect cardEffect) {
        this.cardEffect = cardEffect;
    }
}