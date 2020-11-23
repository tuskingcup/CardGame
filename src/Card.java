/**
*[H1] Card Class[/H1]
*It has cardNumber cardFace point1 and point2
*/

public class Card {

    private String cardNumber;
    private String cardFace;
    private int points;
    private int dPoints;
    
    public Card(){}
    public Card(String cardNumber, String cardFace, int points, int dPoints) {
        this.cardNumber = cardNumber;
        this.cardFace = cardFace;
        this.points = points;
        this.dPoints = this.dPoints;
    }

   

    public String getCardFace() {
        return cardFace;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCard(int index) {
        return cardNumber + " " +cardFace /*+" "+card[index].points+" "+card[index].dPoints*/;
    }

    public int getPoints() {
        return points;
    }
    
    
    
    @Override
    public String toString() {
        
        return cardNumber + " " +cardFace;
    }
}
