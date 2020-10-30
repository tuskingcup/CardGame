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
    private Card[] card = new Card[52];

    public Card() {
        cardGennarate();
    }

    public Card(String cardNumber, String cardFace) {
        this.cardFace = cardFace;
        this.cardNumber = cardNumber;
    }

    public void cardGennarate() {
        int count = 0;
        for (int num = 1; num <= 13; num++) {
            for (int face = 1; face <= 4; face++) {
                card[count] = new Card(num == 1 ? "Ace" : num == 11 ? "Jack" : num == 12 ? "Queen" : num == 13 ? "King" : Integer.toString(num), face == 1 ? "Clubs" : face == 2 ? "Diamonds" : face == 3 ? "Hearts" : "Spades");
                count++;
            }
        }
    }

    public String getCardFace() {
        return cardFace;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCard(int index) {
        
        return card[index].cardNumber+" "+card[index].cardFace;
    }

    @Override
    public String toString() {
        String allCard = "";
        for (int i = 0; i < card.length; i++) {
            allCard += getCard(i)+"\n";
        }
        return allCard;
    }
}
