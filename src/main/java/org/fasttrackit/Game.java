package org.fasttrackit;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private List<Card>[] inHandCards = new ArrayList<Card>().toArray(new List[10]);
    private Deck[] playerDeck;
    private int boardLimit = 7;
    private int index = 0;
    private Hero[] playerHero = new Hero[8];
    private Player[] players = new Player[8];
    private Hero playerh;
    private Card[][] activeCards = new Card[8][8];
    private MatchType match;
    private Turn[] turn=new Turn[8];
    private Turn turnA=new Turn(0,0);
    int osd=0,p;

    Scanner sc = new Scanner(System.in);

    public void start() throws InterruptedException {
        System.out.println("Starting Game ");
         p = playerNumber();
        playerDeck = new Deck[30];
        for (int i = 0; i < p; i++) {
            inHandCards[i] = new ArrayList<Card>();
            players[i] = playerInit(i);
            playerHero[i] = HeroSelector(players[i]);
            playerDeck[i] = deckSelector();
        }
        gameSelect();
        System.out.println("Matchmaking . . .");
        for (int i = 0; i < p; i++)
            turn[i] = new Turn(0, 0);
        firstHand(p);
        for (int i = 0; i < p; i++) {
            turn[i].setTnumber(+1);
            turn[i].setMana(+1);
        }
        int c=gameStarter(p);
        playerChoice(c,playerHero[c], inHandCards[c], turn[c]);
        while (!win(p)) {
            for (int j = 0; j < p; j++) {
                    do
                        playerChoice(j,playerHero[j], inHandCards[j], turn[j]);
                    while (turn[j].getTnumber() == turnA.getTnumber());
                }
            }
        }
    private boolean win(int p)
    {
        boolean k=false;
        for(int i=0;i<p;i++) {
            if (playerHero[i].getHealthRemaining() <= 0)
                k=true;
            else
                k=false;
        }
        return k;
    }
    private void playerChoice(int j,Hero hero, List<Card> list,Turn turn) {
        System.out.println("Turn "+turn.getTnumber()+" Mana available "+turn.getMana());
        System.out.println(hero.getName()+"'s turn");
        System.out.println("Press 1 for Player Choice menu / 2 for Endturn");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if(a==1)
                {
                System.out.println("You have entered Player Choice menu");
                System.out.println("1 for Play Menu/ 2 for Passive menu /3 for Exit to menu");
                Scanner sc1 = new Scanner(System.in);
                int b = sc1.nextInt();
                if(b==1)
                {
                System.out.println("1 for Play Card/ 2 for Attack /3 for Exit to menu");
                Scanner sc2 = new Scanner(System.in);
                int s = sc2.nextInt();
                if (s == 1) {
                    cardDisplay(list);
                    int k = sc.nextInt() - 1;
                    if(hero.cardPlay(list.get(k), turn)) {
                        for(int i=0;i<boardLimit;i++)
                            if(activeCards[j][i]!=null)
                                continue;
                            else
                                if (list.get(k).getName()=="The coin")
                                    continue;
                                else {
                                    activeCards[j][i] = list.get(k);
                                    break;
                                }
                        list.remove(k);
                    }
                    if (turn.getMana() >= 0)
                        playerChoice(j,hero,list,turn);
                } else if (s == 2) {
                    cardChoice(j,p,hero);

                } else if (s == 3) {
                    System.out.println("you will exit to main menu");
                    playerChoice(j,hero,list,turn);
                }
            }
          else  if(b==2)
            {
                System.out.println("You have entered Passive menu"+"\n"+"1 for Play Passive power / 2 for Exit to menu");
                Scanner sc3=new Scanner(System.in);
                int t=sc3.nextInt();
                if(t==1)
                    hero.passivepowerPlay(hero,turn);
                else if(t==2)
                    playerChoice(j,hero,list,turn);
            }
          else if(b==3) {
                    System.out.println("You will exit to menu");
                    playerChoice(j, hero, list, turn);
                }

        }
        else if(a==2) {
            turnA.setTnumber(turn.getTnumber());
            turn.NewTurn(turn);
        }
    }
    private int gameStarter(int p)
    {
        int a=0;
        for(int i=0;i<p;i++)
            for(Card card: inHandCards[i])
                if(card.getName()!="The coin")
                    a=i;
                return a;
    }
    private void cardChoice(int j,int p,Hero hero){
        int k=j;
        String h;
        Scanner s=new Scanner(System.in);
        System.out.println("Choose card to use: ");
        displayActive(j);
        int c=s.nextInt()-1;
        System.out.println("Card chosen: "+activeCards[j][c].getName());
        for(int a=0;a<k;a++) {
            if (a != j) {
                displayActive(a);
                int t = checkTaunt(a);
                if (osd == 0) {
                    System.out.println("No active cards for your opponent. Attack Hero? y for Yes or n for No");
                    h = s.nextLine();
                    if (h.compareToIgnoreCase("y") == 0)
                        for (int i = 0; i < p; i++)
                            if (hero != playerHero[i])
                                if (playerHero[i].getPassive().getDefense() > 0) {
                                    int aux = activeCards[j][c].getCardEffect().getAttack() - playerHero[i].getPassive().getDefense();
                                    playerHero[i].setHealthRemaining((aux - playerHero[i].getHealthRemaining()) * (-1));
                                    System.out.println("Opponent Hero has " + playerHero[i].getHealthRemaining() + " health remaining");
                                } else {
                                    playerHero[i].setHealthRemaining(activeCards[j][c].getCardEffect().getAttack() - playerHero[i].getHealthRemaining());
                                    System.out.println("Opponent Hero has " + playerHero[i].getHealthRemaining() + " health remaining");
                                }

                } else {
                    System.out.println("Choose Target: ");
                    int tar = s.nextInt();
                    if (t == 1) {
                        if (activeCards[a][tar].getCardEffect().isTaunt())
                            Attack(activeCards[j][c], activeCards[a][tar]);
                        else
                            System.out.println("There is a Taunt minion defending " + "");
                    }
                }
            }
        }
    }
    private int checkTaunt(int a)
    {
        int ok=0;
        for(int i=0;i<boardLimit;i++)
        {
            if (activeCards[a][i].getCardEffect().isTaunt())
                ok=ok+1;
        }
        return ok;
    }
    private void displayActive(int j) {
        osd=0;
        for (int i = 0; i < boardLimit; i++) {
            if (activeCards[j][i] == null)
                break;
            else {
                System.out.println("Active cards are: " + (i + 1) + " " + activeCards[j][i].getName());
                osd++;
            }
        }
    }
    private void firstHand(int p) {
        int c=0;
        for (int j = 0; j < p; j++) {
            while(c!=1) {
                if (startingPlayer(players[j]) == 1) {
                    inHandCards[j].add(0, new Card("The coin", "", new Type("No type"), new Expansion("Classic"), new CardEffect("Gain 1 mana crystal this round", 0, 0, 0, 0
                            , false)));
                    c = 1;
                }
            }
            if (turn[j].getTnumber() == 0) {
                System.out.println(players[j].getName()+" draws cards");
                for (int i = 1; i <= 4; i++) {
                    inHandCards[j].add(i-1,playerDeck[j].getDecklist().get(i - 1));
                    System.out.println(i+" "+inHandCards[j].get(i-1).getName());
                }
            }
        }
    }
    private void cardDisplay(List<Card> list)
    {
        int c=0;
        for(Card card: list)
        {
            c++;
            if(card!=null)
            System.out.println(c+" "+card.getName());
                else
                    continue;

        }
    }
    private void gameDisplay()
    {
        int ind=0;
        System.out.println("Play modes:");
        for(MatchType matchType: MatchType.getModes())
        {
            System.out.println((ind+1)+" Name: "+matchType.getTypeName()+" for "+matchType.getPlayerNumber()+" players");
            ind++;

            if (ind >=MatchType.getModes().size())
                ind = 0;
        }
    }
    private MatchType gameSelect()
    {
        System.out.println("Select Game Mode: ");
        gameDisplay();
        int j = sc.nextInt();
        match=MatchType.getModes().get(j-1);
        System.out.println("You have selected "+match.getTypeName());
        return MatchType.getModes().get(j-1);

    }
    private Deck deckSelector()
    {
        System.out.println("Deck name: ");
        Deck deck=new Deck(sc.next());
        deck.deckCreator();
        return deck;
    }
    private void heroDisplay() {
        System.out.println("Heroes: ");
        for (Hero hero : Hero.allHeroes) {
            System.out.println((index + 1) + " " + hero.getName() + " Class: " + hero.getHeroClass() + " ,HeroPower: " + hero.getPassive().getName() +
                    " ,Cost: " + hero.getPassive().getCost() + " ,Effect: " + hero.getPassive().getEfect());
            index++;
            if (index >= Hero.allHeroes.size())
                index = 0;
        }
    }
    private Hero HeroSelector(Player a) {
            System.out.println("Select Hero: ");
            heroDisplay();
            int j = sc.nextInt();
            playerh=Hero.allHeroes.get(j-1);
        System.out.println("You have selected "+playerh.getName());
            return Hero.allHeroes.get(j-1);
    }
    private Player playerInit(int i)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter "+(i+1)+" player's Name , Region , Level and Rank");
        Player player=new Player(scanner.nextLine(),scanner.nextLine(),scanner.nextInt(),scanner.nextInt());
        return player;
    }
    private int playerNumber()
    {
        System.out.println("Please Enter PLayer Number: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

    public void cardDestoyed(Card a) {
        if (a.getCardEffect().getDefense() <= 0) {
            System.out.println(a.getName() + " has been destoyed");
            a.setActive(false);
        }
    }
    public void Attack(Card a,Card b) {
        if (a.getCardEffect().getAttack()> 0) {
            a.getCardEffect().setDefense(a.getCardEffect().getDefense()  - b.getCardEffect().getAttack());
            b.getCardEffect().setDefense( b.getCardEffect().getDefense() - a.getCardEffect().getAttack());
            System.out.println(a.getName()+" has attacked "+b.getName());
            System.out.println(b.getName()+" has "+b.getCardEffect().getDefense()+" health left");
            System.out.println(a.getName()+" has "+a.getCardEffect().getDefense()+" health left");
            cardDestoyed(a);
            cardDestoyed(b);
        } else
            System.out.println(a.getName() + " can't attack");
    }
    private int startingPlayer(Player a){
        double x=ThreadLocalRandom.current().nextDouble(0,1);
        if(x<=0.50) {
            System.out.println("Player " + a.getName() + " starts the game");
            return 0;
        }
        else
            {
                System.out.println("Sorry "+a.getName()+ " your opponent starts the game,but you get [The Coin]");
                return 1;
            }
    }
    Player playerReference = new Player("Robert","Europe",60,24);
    Player player1 = new Player("John","North America",47,8);
    Passive passive1= new Passive("Armor up!","Gain 2 Armor",0,2,0,0,2);
    Passive passive2= new Passive("Force of the Elements","Summon a basic totem",0,0,0,0,2);
    Hero heroReference = new Hero("Garrosh","Warrior",passive1);
    Hero hero1 = new Hero("Thrall","Shaman",passive2);
    Type Dragon=new Type("Dragon");
    Type Human=new Type("Human");
    Type DeathKnight=new Type("Death Knight");
    Type GM=new Type("GM");
    Expansion expansion= new Expansion("Classic");
    Expansion expansion1=new Expansion("Old Gods");
    Expansion expansion2=new Expansion("Frozen Knights");
    CardEffect GmEffect=new CardEffect("Invincible",1000,100,1000,1000,true);
    CardEffect cardEffect1=new CardEffect("Deathrattle: After this minion dies summon all Dragon type cards in your Hand",10,12,12,0,false);
    CardEffect cardEffect2=new CardEffect("Battlecry; Destroy a minion with 7 or more attack",5,4,2,0,false);
    CardEffect cardEffect3=new CardEffect("End of turn effect: At the end of your turn gain 1 Death Knight Card",8,8,8,0,true);
    CardEffect cardEffect4=new CardEffect("Turns now only last 15s",8,8,8,0,false);
    Card card4=new Card("Nozdormu,Aspect of Time","Legendary",Dragon,expansion,cardEffect4);
    Card cardReference= new Card("Deathwing Dragonlord","Epic",Dragon,expansion1,cardEffect1);
    Card card2= new Card("Big Game Hunter","Epic",Human,expansion,cardEffect2);
    Card card3=new Card("The Lich King","Legendary",DeathKnight,expansion2,cardEffect3);
    Deck deck1=new Deck("Deck1");
    MatchType match1=new MatchType("Standard",true,2);
    Offline offline1=new Offline("Offline",false,1,"Story","Hard");
    MatchType match2=new MatchType("Battleground",true,8);
    OnlineRanked rank1= new OnlineRanked("Ranked",true,1,true,"Lepper Gnome",24);


    }


