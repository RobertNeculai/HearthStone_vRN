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
        Player playerReference = new Player("Robert","Europe",60);
        Player player1 = new Player("John","North America",47);
        Passive passive1= new Passive("Armor up!","Gain 2 Armor",0,2,0,0);
        Passive passive2= new Passive("Force of the Elements","Summon a basic totem",0,0,0,0);
        Hero heroReference = new Hero("Garrosh","Warrior",passive1);
        Hero hero1 = new Hero("Thrall","Shaman",passive2);
        Expansion expansion= new Expansion("Classic");
        Expansion expansion1=new Expansion("Old Gods");
        CardEffect cardEffect1=new CardEffect("Deathrattle: After this minion dies summon all Dragon type cards in your Hand",10,12,12,0);
        CardEffect cardEffect2=new CardEffect("BattleCry; Destroy a minion with 7 or more attack",7,4,2,0);
        Card cardReference= new Card("Deathwing Dragonlord","Epic",expansion1,cardEffect1);
        Card card2= new Card("Big Game Hunter","Epic",expansion,cardEffect2);
        MatchType match1=new MatchType("Ranked",true,2);
        offline offline1=new offline("Offline",false,1,"Story","Hard");
        MatchType match2=new MatchType("Battleground",true,8);
        onlineRanked rank1= new onlineRanked("Ranked",true,1,true,"Lepper Gnome",24);


    }
}