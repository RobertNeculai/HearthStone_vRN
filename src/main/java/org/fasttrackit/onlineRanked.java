package org.fasttrackit;

public class onlineRanked extends MatchType {
    boolean rankType;
    String rankName;
    int RankNumber;

    public onlineRanked(String typeName, boolean online, int playerNumber, boolean rankType, String rankName, int rankNumber) {
        super( typeName,online, playerNumber);
        this.rankType = rankType;
        this.rankName = rankName;
        RankNumber = rankNumber;
    }

    public void Check(boolean rankType) {
        if(rankType==false);
        System.out.println("Not ranked Game");
    }
}
