
import java.util.Scanner;

/**
*[H1]This is a CardGame class[/H1]
 */

public class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GamePlay game = new GamePlay();
        Player tus = new Player(0, "dd");

        game.first();
    }
}
