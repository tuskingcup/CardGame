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
    private Card handCard1 = new Card();
    private Card handCard2= new Card();
    private Card handCard3= new Card();

    public Player(int playerId, String playerName, Card handCard1, Card handCard2, Card handCard3) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.handCard1 = handCard1;
        this.handCard2 = handCard2;
        this.handCard3 = handCard3;

    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Card getHandCard1() {
        return handCard1;
    }

    public Card getHandCard2() {
        return handCard2;
    }

    public Card getHandCard3() {
        return handCard3;
    }


}
