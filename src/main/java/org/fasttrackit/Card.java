package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;

public class Card {
   private String name;
   private String rarity;
   private Type type;
   private boolean active;
   private Expansion expansion;
   private CardEffect cardEffect;
   public static ArrayList<Card> allCards = new ArrayList<Card>();


    public Card(String name, String rarity, Type type, Expansion expansion, CardEffect cardEffect) {
        this.name=name;
        this.rarity = rarity;
        this.type=type;
        this.expansion = expansion;
        this.cardEffect = cardEffect;
        allCards.add(this);

    }
    public boolean cardPlay(Card card,Turn turn)
    {
        if(turn.getMana()>=card.getCardEffect().getCost()) {
            System.out.println(name + " just played " + card.getName() + " in turn " + turn.getTnumber());
            turn.setMana(turn.getMana()-card.getCardEffect().getCost());
            System.out.println("mana remaining " + turn.getMana());
            return true;
        }
        else {
            System.out.println("Not enough mana to play that card ");
            return false;
        }
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
    public static ArrayList<Card> getAllCards() {
        return allCards;
    }
}
