
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
   
    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    
    public void drawHand(Card drawHand){
        if(handCard[0]==null){this.handCard[0]=drawHand;}
        else if(handCard[1]==null){this.handCard[1]=drawHand;}
        else if(handCard[2]==null){this.handCard[2]=drawHand;}
        else{}
        
    }
    
    public void returnAllCard(){
    this.handCard[0] = null;
    this.handCard[1] = null;
    this.handCard[2] = null;}
    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public int getAllPoints(){
        int allPoints = 0 ;
    if(handCard[0]!=null&&handCard[1]!=null&&handCard[2]!=null){allPoints= this.handCard[0].getPoints()+this.handCard[1].getPoints()+this.handCard[2].getPoints();}
    else if(handCard[0]!=null&&handCard[1]!=null&&handCard[2]==null){allPoints= this.handCard[0].getPoints()+this.handCard[1].getPoints();}
    else if(handCard[0]!=null&&handCard[1]==null&&handCard[2]==null){allPoints= this.handCard[0].getPoints();}
    else{return 0;}
    
    return allPoints%10;
    }
    
    public Card getHandCard(int hand) {
        return hand==0?handCard[0]:hand==1?handCard[1]:handCard[2];
    }

    public void win(Player who) {
        winWho[winHead] = who;
        winHead++;
    }
     public void lose(Player who) {
        loseWho[loseHead] = who;
        loseHead++;
    }
      public void draw(Player who) {
        drawWho[drawHead] = who;
        drawHead++;
    }

    public Player getWinWho(int i) {
        return winWho[i];
    }

    public Player getLoseWho(int i) {
        return loseWho[i];
    }
      public Player getDrawWho(int i) {
        return drawWho[i];
    }

    public int getWinHead() {
        return winHead;
    }

    public int getLoseHead() {
        return loseHead;
    }

    public int getDrawHead() {
        return drawHead;
    }
    public void resetWinLoseDraw(){
    winHead=0;
    loseHead=0;
    drawHead=0;
}
      
      
}
