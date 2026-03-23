package ie.atu.serialization;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 2L;

    private String playerName;
    private double score;
    private int level;
    private int playTime;

    public Game(String playerName, double score, int level){
        this.playerName = playerName;
        this.score = score;
        this.level = level;
        this.playTime = 0;
    }

    public Game(String playerName, double score, int level, int playTime) {
        this.playerName = playerName;
        this.score = score;
        this.level = level;
        this.playTime = playTime;
    }


    @Override
    public String toString() {
        return "Game State: {name='" + playerName + "', level=" + level + ", score="+score+", playTime=" + playTime + " }";
    }
}
