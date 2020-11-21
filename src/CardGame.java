
import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay game = new GamePlay();
        Player tus = new Player(0, "dd");

        game.first();
//        for (int loop = 0; loop < 53; loop++) {0
//            System.out.println(game.getCardRemaining());
//            System.out.println(game.drawCard(loop, loop));
//        }
//        for(int i=0;i<game.getCardRemaining();i++){
//            System.out.println(game.getCard(i));
//        }
    }
}
