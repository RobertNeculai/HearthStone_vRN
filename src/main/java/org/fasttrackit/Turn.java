package org.fasttrackit;

public class Turn {
    int time = 30;
    int mana = 0;
    int tnumber = 0;
    int healthRemaining = 30;
    Card cardPlayed;

    public Turn(int mana, int tnumber, int healthRemaining) {
        this.mana = mana;
        this.tnumber = tnumber;
        this.healthRemaining = healthRemaining;
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
        System.out.println("New Turn: "+turn.tnumber);
    }
}
    // healthRemaining se refera la viata eroului care porneste de la 30 inceputul meciului si care poate varia in functie de modul de match ales
    // cartile pot ataca eroii adversari,cat timp nu exista o carte care sa interfereze cu aceasta actiune
