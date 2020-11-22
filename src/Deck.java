/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class Deck {
    private final Card[] card = new Card[52];
    private int cardRemaining;
    
    public Deck(){
    cardGennarate();
    }
    
    public void cardGennarate() {
        int count = 0;
        for (int num = 1; num <= 13; num++) {
            for (int face = 1; face <= 4; face++) {
                card[count] = new Card(num == 1 ? "Ace" : num == 11 ? "Jack" : num == 12 ? "Queen" : num == 13 ? "King" : Integer.toString(num),
                        face == 1 ? "Clubs" : face == 2 ? "Diamonds" : face == 3 ? "Hearts" : "Spades",
                        num > 10 ? 0 : num, face);
                count++;
            }
        }
        cardRemaining = 52;
    }
    
     private int randomCard() {
        return (int) ((Math.random() * cardRemaining));
    }
     public String getCard(int index) {
        return card[index].getCardNumber() + " " + card[index].getCardFace();
    }
     public Card drawCard(int player) {
        if (cardRemaining > 0) {
            int cardGet = randomCard();
            String cardRealyGet = getCard(cardGet);
            cardRemaining--;
            Card[] newDeck = new Card[cardRemaining];
            for (int i = 0; i < cardRemaining + 1; i++) {
                if (i < cardGet) {
                    newDeck[i] = card[i];
                } else if (i > cardGet) {
                    newDeck[i - 1] = card[i];
                } else {
                }
            }
            System.arraycopy(newDeck, 0, card, 0, cardRemaining);
            return card[cardGet];
        } else {
            return null;
        }

    }
       public void printAllCard() {
        System.out.println("==Genarate Deck==");
        cardGennarate();
        cardRemaining = 52;
        for (int i = 0; i < cardRemaining; i++) {
            System.out.println(card[i]);
        }
        System.out.println("==Genarate Deck==");
    }
}
