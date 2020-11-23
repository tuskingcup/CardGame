
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

    public Deck() {
        cardGennarate();
    }

    /**
     * this method is use to describe card face as char
     *
     * @return nothing
     */
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

    /**
     * returns the char value of card.
     *
     * @return integer value of cardRemaining
     */
    private int randomCard() {
        return (int) ((Math.random() * cardRemaining));
    }

    /**
     * returns the char value of card face and number value of card.
     *
     * @param index is parameter that add to getCard
     * @return integer This return the sum of cardNumber and cardFace
     */
    public String getCard(int index) {
        return card[index].getCardNumber() + " " + card[index].getCardFace();
    }

    /**
     * this method is use when returns the char value of card. decrease card
     * remaining when use getCard
     *
     * @param player is the player who draw the card
     * @return integer value of card face
     */
    public Card drawCard(int player) {
        if (cardRemaining > 0) {
            int cardGet = randomCard();
            Card cardRealyGet = card[cardGet];
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
            return cardRealyGet;
        } else {
            return null;
        }

    }

    /**
     * this method is reset card on hand and reset deck
     */
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
