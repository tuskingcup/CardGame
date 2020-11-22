/**
*[H1]This is a Player class[/H1]
*It has a playerId playerName winHead loseWho drawHead and array of handCard loseWho drawWho
 */

public class Player {

    private final int playerId;
    private String playerName;
    private Card[] handCard = new Card[3];
    private Player[] winWho  = new Player[17];
    private int winHead;
    private Player[] loseWho = new Player[17];
    private int loseHead;
    private Player[] drawWho = new Player[17];
    private int drawHead;

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }
   
/**returns the number of player id.
*@return int number value of playerId
 */   
    public int getPlayerId() {
        return playerId;
    }

/**returns the char of player name.
*@return String char of playerName
 */
    public String getPlayerName() {
        return playerName;
    }

/**this method use to descripe cards on hand 
*@param drawHand this is the parameter for drawHand
 */    
    public void drawHand(Card drawHand){
        if(handCard[0]==null){this.handCard[0]=drawHand;}
        else if(handCard[1]==null){this.handCard[1]=drawHand;}
        else if(handCard[2]==null){this.handCard[2]=drawHand;}
        else{}
    }

/**this method use to reset cards on hand
 */    
    public void returnAllCard(){
    this.handCard[0] = null;
    this.handCard[1] = null;
    this.handCard[2] = null;}
    
/**this method use to set platername
 * @param playerName is parameter in setPlayerName use to get new player name
 */    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

/**returns the number value of all card point.
*@return int number value of allPoints
 */    
    public int getAllPoints(){
        int allPoints = 0 ;
    if(handCard[0]!=null&&handCard[1]!=null&&handCard[2]!=null){allPoints= this.handCard[0].getPoints()+this.handCard[1].getPoints()+this.handCard[2].getPoints();}
    else if(handCard[0]!=null&&handCard[1]!=null&&handCard[2]==null){allPoints= this.handCard[0].getPoints()+this.handCard[1].getPoints();}
    else if(handCard[0]!=null&&handCard[1]==null&&handCard[2]==null){allPoints= this.handCard[0].getPoints();}
    else{return 0;}
    
    return allPoints%10;
    }
    
/**returns the char value of card in player hand.
*@param hand is parameter in getHandCard use as card on hand
*@return int number value of card on hand if not have any return null
 */    
    public Card getHandCard(int hand) {
        if(handCard[hand]!=null) return handCard[hand];
        else return null;
    }
    
/**this method use to get the name of winner
*@param who is parameter in win as a name of winner
 */
    public void win(Player who) {
        winWho[winHead] = who;
        winHead++;
    }

/**this method use to het the name of loser
*@param who use to get the name of loser 
 */    
     public void lose(Player who) {
        loseWho[loseHead] = who;
        loseHead++;
    }

/**this method is use when there is no winner
*@param who is parameter in draw when no winner
 */    
      public void draw(Player who) {
        drawWho[drawHead] = who;
        drawHead++;
    }

/**returns the char value of player win who.
*@param i is parameter use to refer to winner
*@return int of the winner
 */
    public Player getWinWho(int i) {
        return winWho[i];
    }

/**returns the char value of player lose who.
*@param i is parameter use to refer to loser
*@return int of theloser
 */
    public Player getLoseWho(int i) {
        return loseWho[i];
    }

 /**returns the char value of player draw who.
*@param i is parameter use to refer to no winner
*@return int of the draw
 */  
      public Player getDrawWho(int i) {
        return drawWho[i];
    }

/**returns the number value of win head.
**@return int when the dealer win 
 */
    public int getWinHead() {
        return winHead;
    }

/**returns the number value of lose head.
*@return int when the dealer lose
 */
    public int getLoseHead() {
        return loseHead;
    }

/**returns the number value of draw head.
*@return int when the dealer draw
 */
    public int getDrawHead() {
        return drawHead;
    }

/**this method use to reset Win/Lose of the dealer
 */    
    public void resetWinLoseDraw(){
    winHead=0;
    loseHead=0;
    drawHead=0;
}
      
      
}
