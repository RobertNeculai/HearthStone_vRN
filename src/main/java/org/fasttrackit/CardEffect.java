package org.fasttrackit;

public class CardEffect {
   private String efect;
   private int cost;
   private int attack;
   private int defense;
   private int heal;
   private boolean taunt;

    public CardEffect(String efect, int cost, int attack, int defense, int heal,boolean taunt) {
        this.efect = efect;
        this.cost = cost;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
        this.taunt=taunt;
    }

    public String getEfect() {
        return efect;
    }

    public void setEfect(String efect) {
        this.efect = efect;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public boolean isTaunt() {
        return taunt;
    }

    public void setTaunt(boolean taunt) {
        this.taunt = taunt;
    }
}
