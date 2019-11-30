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
        Player playerReference = new Player("Robert","Europe",60,24);
        Player player1 = new Player("John","North America",47,8);
        Passive passive1= new Passive("Armor up!","Gain 2 Armor",0,2,0,0,2);
        Passive passive2= new Passive("Force of the Elements","Summon a basic totem",0,0,0,0,2);
        Hero heroReference = new Hero("Garrosh","Warrior",passive1);
        Hero hero1 = new Hero("Thrall","Shaman",passive2);
        Expansion expansion= new Expansion("Classic");
        Expansion expansion1=new Expansion("Old Gods");
        Expansion expansion2=new Expansion("Frozen Knights");
        CardEffect cardEffect1=new CardEffect("Deathrattle: After this minion dies summon all Dragon type cards in your Hand",10,12,12,0,false);
        CardEffect cardEffect2=new CardEffect("Battlecry; Destroy a minion with 7 or more attack",7,4,2,0,false);
        CardEffect cardEffect3=new CardEffect("End of turn effect: At the end of your turn gain 1 Death Knight Card",8,8,8,0,true);
        Card cardReference= new Card("Deathwing Dragonlord","Epic",expansion1,cardEffect1);
        Card card2= new Card("Big Game Hunter","Epic",expansion,cardEffect2);
        Card card3=new Card("The Lich King","Legendary",expansion2,cardEffect3);
        MatchType match1=new MatchType("Ranked",true,2);
        Offline offline1=new Offline("Offline",false,1,"Story","Hard");
        MatchType match2=new MatchType("Battleground",true,8);
        OnlineRanked rank1= new OnlineRanked("Ranked",true,1,true,"Lepper Gnome",24);
        Turn turnA = new Turn(9,9,30);
        Turn turnB=new Turn(9,9,30);
        player1.cardPlay(card2,turnA);
        playerReference.cardPlay(cardReference,turnB);
        turnA.NewTurn(turnA);
        player1.cardPlay(card3,turnA);
        player1.passivepowerPlay(hero1,turnA);
        turnB.NewTurn(turnB);
        playerReference.cardPlay(cardReference,turnB);


    }
}