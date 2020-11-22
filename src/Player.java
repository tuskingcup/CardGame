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
*@return number of playerId
 */   
    public int getPlayerId() {
        return playerId;
    }

/**returns the char of player name.
*@return char of playerName
 */
    public String getPlayerName() {
        return playerName;
    }

/**returns 
*@param drawHand of the Card value
 */    
    public void drawHand(Card drawHand){
        if(handCard[0]==null){this.handCard[0]=drawHand;}
        else if(handCard[1]==null){this.handCard[1]=drawHand;}
        else if(handCard[2]==null){this.handCard[2]=drawHand;}
        else{}
    }

/**returns the char value of all cards.
 */    
    public void returnAllCard(){
    this.handCard[0] = null;
    this.handCard[1] = null;
    this.handCard[2] = null;}
    
/**returns the char value of player name.
 */    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

/**returns the number value of all card point.
*@return number value of allPoints
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
*@param hand of number value
*@return char value of handCard or return null
 */    
    public Card getHandCard(int hand) {
        if(handCard[hand]!=null) return handCard[hand];
        else return null;
    }
    
/**returns the char value of player who player won.
*@param who of the Player value 
 */
    public void win(Player who) {
        winWho[winHead] = who;
        winHead++;
    }

/**returns the char value of player who player lose.
*@param who of the Player value 
 */    
     public void lose(Player who) {
        loseWho[loseHead] = who;
        loseHead++;
    }

/**returns the char value of player who player draw.
*@param who of the Player value 
 */    
      public void draw(Player who) {
        drawWho[drawHead] = who;
        drawHead++;
    }

/**returns the char value of player win who.
*@param i of the number value
*@return char value of who player won
 */
    public Player getWinWho(int i) {
        return winWho[i];
    }

/**returns the char value of player lose who.
*@param i of the number value
*@return char value of who player lose
 */
    public Player getLoseWho(int i) {
        return loseWho[i];
    }

 /**returns the char value of player draw who.
*@param i of the number value
*@return char value of who player draw
 */   
      public Player getDrawWho(int i) {
        return drawWho[i];
    }

/**returns the number value of win head.
**@return number value of winHead  
 */
    public int getWinHead() {
        return winHead;
    }

/**returns the number value of lose head.
*@return number value of loseHead
 */
    public int getLoseHead() {
        return loseHead;
    }

/**returns the number value of draw head.
*@return number value of drawHead
 */
    public int getDrawHead() {
        return drawHead;
    }

/**returns the number value of win lose draw.
*@return the number value of winHead loseHead drawnHead = 0
 */    
    public void resetWinLoseDraw(){
    winHead=0;
    loseHead=0;
    drawHead=0;
}
      
      
}
