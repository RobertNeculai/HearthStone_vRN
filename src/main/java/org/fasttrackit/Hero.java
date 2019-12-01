package org.fasttrackit;

public class Hero {
   private String name;
   private String heroClass;
   private Passive passive;

    public Hero(String name, String heroClass, Passive passive) {
        this.name = name;
        this.heroClass = heroClass;
        this.passive = passive;
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
