package org.fasttrackit;

import java.util.Scanner;

public class Player {
    private String name;
    private String region;
    private int level;
    private int rank;
    public Player(String name, String region, int level,int rank) {
        this.name = name;
        this.region = region;
        this.level = level;
        this.rank= rank;
    }
    private String getPlayerNameFromUser()
    {
        System.out.println("Please Enter Vehicle Name: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public void cardPlay(Card card,Turn turn)
    {
        if(turn.getMana()>=card.getCardEffect().getCost()) {
            System.out.println(name + " just played " + card.getName() + " in turn " + turn.getTnumber());
            turn.setMana(turn.getMana()-card.getCardEffect().getCost());
            System.out.println("mana remaining " + turn.getMana());
        }
        else
            System.out.println("Not enough mana to play that card ");
    }
    public void DeathRattlePlay(Card a,Card b,Synergy synergy)
    {
        if(a.getCardEffect().getDefense()<=0 && synergy.synergyActive(a,b)) {
            System.out.println(a.getName() + " triggered  " + a.getCardEffect().getEfect());
            System.out.println(b.getName() + " has been summoned");
            a.setActive(true);
        }
    }
    public void passivepowerPlay(Hero hero, Turn turn)
    {
        if(turn.getMana()>=hero.getPassive().getCost()) {
            System.out.println(name + " playing as " + hero.getName() + " used " + hero.getPassive().getName());
            turn.setMana(turn.getMana()-hero.getPassive().getCost());
            System.out.println("mana remaining " + turn.getMana());
        }
        else
            System.out.println("Not enough mana to use that ");
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
