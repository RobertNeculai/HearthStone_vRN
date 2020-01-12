package org.fasttrackit;

import java.util.ArrayList;

public class Hero {
   private String name;
   private String heroClass;
   private Passive passive;
    public static ArrayList<Hero> allHeroes = new ArrayList<Hero>();
    private int healthRemaining=30;
    public Hero(String name, String heroClass, Passive passive) {
        this.name = name;
        this.heroClass = heroClass;
        this.passive = passive;
        allHeroes.add(this);
    }

    public boolean cardPlay(Card card, Turn turn)
    {
        if(card.getName()=="The coin")
            turn.setMana(turn.getMana()+1);
        if(turn.getMana()>=card.getCardEffect().getCost()) {
            System.out.println(name + " just played " + card.getName() + " in turn " + turn.getTnumber());
            turn.setMana(turn.getMana()-card.getCardEffect().getCost());
            System.out.println("mana remaining " + turn.getMana());
            return true;
        }
        else
            System.out.println("Not enough mana to play that card ");
        return false;
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
    public int getHealthRemaining() {
        return healthRemaining;
    }

    public void setHealthRemaining(int healthRemaining) {
        this.healthRemaining = healthRemaining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public Passive getPassive() {
        return passive;
    }

    public void setPassive(Passive passive) {
        this.passive = passive;
    }
}
