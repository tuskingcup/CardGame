/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class Card {

    private String cardNumber;
    private String cardFace;
    private int points;
    private int points2;
    
//    public Card[] card = new Card[52];

//    public Card() {
//    }
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
