/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class Player {
    private int playerId;
    private String playerName;
    private int playerPoints;
    private int playerScore;
    
    
    public Player(){}

    public Player(int playerId, String playerName, int playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerScore = playerScore;
    }
    
    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getPlayerScore() {
        return playerScore;
    }
    
    
    
}
