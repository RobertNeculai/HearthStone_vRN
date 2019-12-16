package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private  List<Card> list = new ArrayList<>();
   // private Deck[] Decks=new Deck[30];
   private int boardLimit=7;

    private void initCards()
    {

        }
    public void activeCard(Card card) {
        if(card.isActive())
            System.out.println("Can be used");
        else
            System.out.println("Give this card a turn to activate");
    }

    public void cardDestoyed(Card a) {
        if (a.getCardEffect().getDefense() <= 0) {
            System.out.println(a.getName() + " has been destoyed");
            a.setActive(false);
        }
    }
    public void Attack(Card a,Card b) {
        if (a.getCardEffect().getAttack()> 0) {
            a.getCardEffect().setDefense(a.getCardEffect().getDefense()  - b.getCardEffect().getAttack());
            b.getCardEffect().setDefense( b.getCardEffect().getDefense() - a.getCardEffect().getAttack());
            System.out.println(a.getName()+" has attacked "+b.getName());
            System.out.println(b.getName()+" has "+b.getCardEffect().getDefense()+" health left");
            System.out.println(a.getName()+" has "+a.getCardEffect().getDefense()+" health left");
            cardDestoyed(a);
            cardDestoyed(b);
        } else
            System.out.println(a.getName() + " can't attack");
    }
}


