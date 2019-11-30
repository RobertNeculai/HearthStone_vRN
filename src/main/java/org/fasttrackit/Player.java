package org.fasttrackit;

import java.util.Scanner;

public class Player {
    String name;
    String region;
    int level;
    int rank;

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
        if(turn.mana>=card.cardEffect.cost) {
            System.out.println(name + " just played " + card.name + " in turn " + turn.tnumber);
            turn.mana -=card.cardEffect.cost;
            System.out.println("mana remaining " + turn.mana);
        }
        else
            System.out.println("Not enough mana to play that card ");

    }
    public void passivepowerPlay(Hero hero, Turn turn)
    {
        if(turn.mana>=hero.passive.cost) {
            System.out.println(name + " playing as " + hero.name + " used " + hero.passive.name);
            turn.mana -= hero.passive.cost;
            System.out.println("mana remaining " + turn.mana);
        }
        else
            System.out.println("Not enough mana to use that ");
        }
    }
