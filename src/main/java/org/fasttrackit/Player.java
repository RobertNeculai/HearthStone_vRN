package org.fasttrackit;

import java.util.Scanner;

public class Player {
    private String name;
    private String region;
    private int level;
    private int rank;
    public Player(String name, String region, int level,int rank) {
        this.name = name;
        this.region = region;
        this.level = level;
        this.rank= rank;
    }
    private String getPlayerNameFromUser()
    {
        System.out.println("Please Enter Player Name: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
