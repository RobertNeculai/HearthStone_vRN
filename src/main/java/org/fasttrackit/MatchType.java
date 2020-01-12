package org.fasttrackit;

import java.util.ArrayList;

public class MatchType {
   private String typeName;
   private boolean online;
   private int playerNumber;

    public static ArrayList<MatchType> getModes() {
        return modes;
    }

    public static ArrayList<MatchType> modes = new ArrayList<MatchType>();

    public MatchType(String typeName, boolean online, int playerNumber) {
        this.typeName = typeName;
        this.online = online;
        this.playerNumber = playerNumber;
        modes.add(this);
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
