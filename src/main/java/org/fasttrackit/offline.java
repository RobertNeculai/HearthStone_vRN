package org.fasttrackit;

public class offline extends MatchType {
String type;
String difficulty;


    public offline(String typeName, boolean online, int playerNumber, String type, String difficulty) {
        super(typeName, online=false, playerNumber=1);
        this.type = type;
        this.difficulty = difficulty;
    }
}
