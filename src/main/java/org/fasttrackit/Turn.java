package org.fasttrackit;

import java.util.Date;

public class Turn {
   private int time = 30;
   private int mana = 0;
   private int tnumber = 0;
   private int healthRemaining = 30;
   private Card cardPlayed;
   Date startDate;
   Date endDate;

    public Turn(int mana, int tnumber, int healthRemaining) {
        this.mana = mana;
        this.tnumber = tnumber;
        this.healthRemaining = healthRemaining;
    }
    public void EndTurn(Turn turn)
    {
       while(time!=0)
       {
           if(time%5==0)
           System.out.println((time)+" seconds left until turn ends");
               time--;
       }
        if(time==0)
        {
            System.out.println("This turn has ended ");
            NewTurn(turn);
        }
    }
    public void NewTurn(Turn turn) {
        if (turn.mana == 0 && turn.tnumber == 0) {
            turn.mana = 1;
            turn.tnumber = 1;
        }
         if(turn.tnumber<10) {
            turn.tnumber++;
            turn.mana = turn.tnumber;
        }
         else if (turn.tnumber >= 10) {
                turn.tnumber++;
                turn.mana = 10;
        }
        System.out.println("New Turn: "+turn.tnumber+" Mana Available: "+turn.mana);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getTnumber() {
        return tnumber;
    }

    public void setTnumber(int tnumber) {
        this.tnumber = tnumber;
    }

    public int getHealthRemaining() {
        return healthRemaining;
    }

    public void setHealthRemaining(int healthRemaining) {
        this.healthRemaining = healthRemaining;
    }

    public Card getCardPlayed() {
        return cardPlayed;
    }

    public void setCardPlayed(Card cardPlayed) {
        this.cardPlayed = cardPlayed;
    }
}
    // healthRemaining se refera la viata eroului care porneste de la 30 inceputul meciului si care poate varia in functie de modul de match ales
    // cartile pot ataca eroii adversari,cat timp nu exista o carte care sa interfereze cu aceasta actiune
