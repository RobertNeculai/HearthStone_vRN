package org.fasttrackit;

public class Offline extends MatchType {
private String type;
private String difficulty;


    public Offline(String typeName, boolean online, int playerNumber, String type, String difficulty) {
        super(typeName, online=false, playerNumber=1);
        this.type = type;
        this.difficulty = difficulty;
    }
}
