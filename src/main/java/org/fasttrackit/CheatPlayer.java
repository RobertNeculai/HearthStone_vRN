package org.fasttrackit;

public class CheatPlayer extends Player {
    public CheatPlayer(String name, String region, int level, int rank) {
        super(name, region, level, rank);
    }

    @Override
    public void cardPlay(Card card, Turn turn) {
            System.out.println("Name : " + card.getName() + " Attack: " + card.getCardEffect().getAttack() + " Health: " + card.getCardEffect().getDefense());
            System.out.println(this.getName() + " just played " + card.getName() + " in turn " + turn.getTnumber());
            System.out.println("mana remaining " + turn.getMana());
            System.out.println("Beware This is a GM card");
            turn.setTime(100);
            System.out.println("Remaining time for this round: "+turn.getTime());
    }
}
