
public class Card {

    private String cardNumber;
    private String cardFace;
    private int points;
    private int points2;
    
    public Card(){}
    public Card(String cardNumber, String cardFace, int points, int points2) {
        this.cardNumber = cardNumber;
        this.cardFace = cardFace;
        this.points = points;
        this.points2 = points2;
    }

   

    public String getCardFace() {
        return cardFace;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCard(int index) {
        return cardNumber + " " +cardFace /*+" "+card[index].points+" "+card[index].points2*/;
    }
    
    
    
    @Override
    public String toString() {
        
        return cardNumber + " " +cardFace;
    }
}
