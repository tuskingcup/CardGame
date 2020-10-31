/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class CardGame {
    public static void main(String[] args) {
        Card card =new Card();
        for(int loop=0;loop<53;loop++){
       System.out.println(card.getCardRemaining());
        System.out.println(card.drawCard()); 
        }
    }
}
