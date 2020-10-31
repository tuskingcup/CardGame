
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
public class GamePlay {

    Card card = new Card();
    Player[] player;
    int maxPlayer;
    int playerCount = 0;
    Scanner sc = new Scanner(System.in);

    private int round;
    private Player winner;

    public void GamePlay() {
        System.out.println("insert amount of player: ");
        maxPlayer = sc.nextInt();
        for (int i = 0; i < maxPlayer; i++) {
            System.out.println("insert P" + playerCount + " Name");
            addPlayer(sc.nextLine());
        }
    }

    private void addPlayer(String name) {
        player[playerCount] = new Player(playerCount, name, 0);
    }

}
