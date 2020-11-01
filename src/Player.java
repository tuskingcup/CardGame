
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

    
    public void drawHand1(Card drawHand1){
    this.handCard1=drawHand1;
    }
    
    public void drawHand2(Card drawHand2){
    this.handCard2=drawHand2;
    }
    
    public void drawHand3(Card drawHand3){
    this.handCard3=drawHand3;
    }

    public Card getHandCard(int hand) {
        return hand==1?handCard1:hand==2?handCard2:handCard3;
    }


}
