
import java.util.Scanner;


public class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay game = new GamePlay();
        
        game.cardGennarate();
        game.first();
        
//        for (int loop = 0; loop < 53; loop++) {
//            System.out.println(game.getCardRemaining());
//            System.out.println(game.drawCard());
//        }
//        for(int i=0;i<game.getCardRemaining();i++){
//            System.out.println(game.getCard(i));
//        }
    }
}
