package org.fasttrackit;

public class Game {
    Turn turnA;
    Card activeCard1;
    Card activeCard2;
    Card activeCard3;
    Card activeCard4;
    Card activeCard5;
    Card activeCard6;
    Card activeCard7;
    Turn turnB;
    Hero hero1;
    Deck deck1;
    Card a;
    Card b;
    int boardLimit=7;
    public void activeCard(Card card) {
        if(card.active)
            System.out.println("Can be used");
        else
            System.out.println("Give this card a turn to activate");
    }

    public void cardDestoyed(Card a) {
        if (a.cardEffect.defense <= 0) {
            System.out.println(a.name + " has been destoyed");
            a.active = false;
        }
    }
    public void Attack(Card a,Card b) {
        if (a.cardEffect.attack > 0) {
            a.cardEffect.defense = a.cardEffect.defense  - b.cardEffect.attack;
            b.cardEffect.defense = b.cardEffect.defense  - a.cardEffect.attack;
            System.out.println(a.name+" has attacked "+b.name);
            System.out.println(b.name+" has "+b.cardEffect.defense+" health left");
            System.out.println(a.name+" has "+a.cardEffect.defense+" health left");
            cardDestoyed(a);
            cardDestoyed(b);
        } else
            System.out.println(a.name + " can't attack");
    }
}


