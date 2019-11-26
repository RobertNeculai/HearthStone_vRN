package org.fasttrackit;

public class MatchType {
    String typeName;
    boolean online;
    int playerNumber;

    public MatchType(String typeName, boolean online, int playerNumber) {
        this.typeName = typeName;
        this.online = online;
        this.playerNumber = playerNumber;
    }
}
