package org.fasttrackit;

public class Game {
   private Turn turnA;
   private Card activeCard1;
   private Card activeCard2;
   private Card activeCard3;
   private Card activeCard4;
   private Card activeCard5;
   private Card activeCard6;
   private Card activeCard7;
   private Turn turnB;
   private Hero hero1;
   private Deck deck1;
   private Card a;
   private Card b;
   private int boardLimit=7;
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


