
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        Card card = new Card();
        GamePlay game = new GamePlay();
        game.getNumberFromKeyboard();
//        for (int loop = 0; loop < 53; loop++) {
//            System.out.println(game.getCardRemaining());
//            System.out.println(game.drawCard());
//        }
//        System.out.println(card);
    }
}
