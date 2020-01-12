package org.fasttrackit;

import java.lang.reflect.Array;
import java.util.*;

public class Deck {
    private int MaxSize = 30;
    private String name;
    String x;



    private  ArrayList<Card> decklist = new ArrayList<>();
    private int index=0,in=0;

    public Deck(String name) {
        this.name = name;
    }

    public ArrayList<Card> deckCreator() {
        cardSelector();
        System.out.println("This deck contains: ");
        for (Card card : decklist)
            System.out.println(card.getName());
        return decklist;
    }
   private void cardSelector() {
        while (decklist.size() < 4) {
            display();
            System.out.println("Select card: ");
            Scanner scanner = new Scanner(System.in);
            int j = scanner.nextInt();
            if(Collections.frequency(decklist,Card.getAllCards().get(j - 1))>1) {

                System.out.println("You can only have 2 copies of this card in your deck");
                cardSelector();
            }
            else
            decklist.add(in, Card.getAllCards().get(j-1));
            in++;
        }
    }

    public void display() {
        System.out.println("Cards: ");
        for (Card card : Card.getAllCards()) {
            System.out.println((index+1) + " " + card.getName() + " ,Attack: " + card.getCardEffect().getAttack() + " ,Heath: " + card.getCardEffect().getDefense() +
                    " ,Cost: " + card.getCardEffect().getCost() + " ,Effect: " + card.getCardEffect().getEfect());
            index++;
            if(index>=Card.getAllCards().size())
                index=0;

        }
    }
    public ArrayList<Card> getDecklist() {
        return decklist;
    }

    public void setDecklist(ArrayList<Card> decklist) {
        this.decklist = decklist;
    }
}