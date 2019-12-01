package org.fasttrackit;

public class Passive {
   private String name;
   private String efect;
   private int attack;
   private int defense;
   private int heal;
   private int SelfDamage;
   private int cost;

    public Passive(String name, String efect, int attack, int defense, int heal, int selfDamage,int cost) {
        this.name = name;
        this.efect = efect;
        this.attack = attack;
        this.defense = defense;
        this.heal = heal;
        SelfDamage = selfDamage;
        this.cost=cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEfect() {
        return efect;
    }

    public void setEfect(String efect) {
        this.efect = efect;
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

    public int getSelfDamage() {
        return SelfDamage;
    }

    public void setSelfDamage(int selfDamage) {
        SelfDamage = selfDamage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
