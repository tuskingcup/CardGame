
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
    int playerCount = 2;
    Scanner sc = new Scanner(System.in);

    private int round;
    private Player winner;

    public GamePlay() {
        home();
//        System.out.print("insert amount of player: ");
//        this.maxPlayer = sc.nextInt();
//        System.out.println(sc.nextLine());
//        for (int i = 0; i < maxPlayer; i++) {
//            System.out.print("insert P" + playerCount+1 + " Name: ");
//            addPlayer(sc.nextLine());
//        }
    }

    public void home() {
        System.out.println("||=======================================||");
        System.out.println("||=====WelCome to Fantastic CardGame=====||");
        System.out.println("||=======================================||");
        System.out.println("||=============Press 1 to PLAY===========||");
        System.out.println("||==========Prees 0 to LEAVE GAME========||");
        System.out.println("||=======================================||");
        switch (getNumberFromKeyboard()) {
            case 1:
                System.out.println();
                play();
                break;
            case 0:
                break;
            default:
                System.out.println();
                home();
                break;
        }
    }

    public void play() {
        System.out.println("||=======================================||");
        System.out.println("||============Press 1 to START===========||");
        System.out.println("||=========Press 2 to EDIT PLAYER========||");
        System.out.println("||============Prees 0 to EXIT============||");
        System.out.println("||=======================================||");
        switch (getNumberFromKeyboard()) {
            case 1:
                break;
            case 2:
                editPlayer();
                break;
            case 0:
                System.out.println();
                home();
                break;
            default:
                System.out.println();
                play();
                break;
        }
    }

    public void editPlayer() {
        System.out.println("||=======================================||");
        System.out.println("||===============Bot amount==============||");
        System.out.println("||================= <" + (playerCount - 1 >= 10 ? playerCount - 1 + "> " : playerCount - 1 + "> =") + "================||");
        System.out.println("||=============1.Increase Bot============||");
        System.out.println("||=============2.Decrease Bot============||");
        System.out.println("||=============Prees 0 to EXIT===========||");
        System.out.println("||=======================================||");
        switch (getNumberFromKeyboard()) {
            case 1:
                if (playerCount < 17) {
                    playerCount++;
                }
                editPlayer();
                break;
            case 2:
                if (playerCount > 2) {
                    playerCount--;
                }
                editPlayer();
                break;
            case 0:
                play();
                break;
            default:
                editPlayer();
                break;
        }
    }
    
    public void start(){
    }

    private void addPlayer(String name) {
        player[playerCount] = new Player(playerCount, name, 0);
    }

    public String drawCard() {
        return card.drawCard();
    }

    public int getCardRemaining() {
        return card.getCardRemaining();
    }

    public int getNumberFromKeyboard() {
        return sc.nextInt();
    }

}
