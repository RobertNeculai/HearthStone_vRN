package org.fasttrackit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("HearthStone");
        System.out.println("cracked edition");
        Player playerReference = new Player();
        playerReference.name = "Robert";
        playerReference.region = "Europe";
        playerReference.level = 60;
        Player player1 = new Player();
        player1.name = "John";
        player1.region = "North America";
        player1.level = 47;
        Hero heroReference = new Hero();
        heroReference.name="Garrosh";
        heroReference.heroclass="Warrior";
        Hero hero1 = new Hero();
        hero1.name="Thrall";
        hero1.heroclass="Shaman";
        Card cardReference= new Card();
        cardReference.name="Deathwing Dragonlord";
        cardReference.attack=12;
        cardReference.defense=12;
        cardReference.cost=10;
        cardReference.rarity="Legendary";
        cardReference.efect="DeathRattle: After minion dies summon all Dragon type Cards in your Hand";
        cardReference.expansion="Old Gods";
        Card card2= new Card();
        card2.name="Big Game Hunter";
        card2.attack=4;
        card2.defense=2;
        card2.cost=7;
        card2.rarity="Epic";
        card2.efect="BattleCry; Destroy a minion with 7 or more attack";
        card2.expansion="Classic";
        Passive passive1= new Passive();
        passive1.attack=0;
        passive1.defense=2;
        passive1.name="Armor up!";
        passive1.heal=0;
        passive1.selfdamage=0;
        passive1.efect="Gain 2 Armor";
        Passive passive2= new Passive();
        passive2.attack=0;
        passive2.defense=0;
        passive2.name="Force of the Elements";
        passive2.selfdamage=0;
        passive2.heal=0;
        passive2.efect="Summon a basic totem";








    }
}
