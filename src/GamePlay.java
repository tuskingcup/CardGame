
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
    Player player= new Player();
    int maxPlayer;
    int playerCount = 2;
    Scanner sc = new Scanner(System.in);

    private int round;
    private Player winner;

    public GamePlay() {
        first();
//        System.out.print("insert amount of player: ");
//        this.maxPlayer = sc.nextInt();
//        System.out.println(sc.nextLine());
//        for (int i = 0; i < maxPlayer; i++) {
//            System.out.print("insert P" + playerCount+1 + " Name: ");
//            addPlayer(sc.nextLine());
//        }
    }
    public void first(){
        System.out.println("||=======================================||");
        System.out.println("||=====WelCome to Fantastic CardGame=====||");
        System.out.println("||=======================================||");
        System.out.println("||============Insert Your Name===========||");
        System.out.println("||=======================================||");
        player.setPlayerName(sc.nextLine());
        home();
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
        System.out.println("||============Press 2 to OPTION==========||");
        System.out.println("||============Prees 0 to EXIT============||");
        System.out.println("||=======================================||");
        switch (getNumberFromKeyboard()) {
            case 1:
                break;
            case 2:
                option();
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

    public void option() {
        System.out.println("||=======================================||");
        System.out.println("                     "+getPlayerName());
        System.out.println("||===========1.EDIT PLAYER NAME==========||");
        System.out.println("||===============Bot amount==============||");
        System.out.println("||================= <" + (playerCount - 1 >= 10 ? playerCount - 1 + "> " : playerCount - 1 + "> =") + "================||");
        System.out.println("||=============2.Increase Bot============||");
        System.out.println("||=============3.Decrease Bot============||");
        System.out.println("||=============Prees 0 to EXIT===========||");
        System.out.println("||=======================================||");
        switch (getNumberFromKeyboard()) {
            case 1:
                editPlayerName();
                break;
            case 2:
                if (playerCount < 17) {
                    playerCount++;
                }
                option();
                break;
            case 3:
                if (playerCount > 2) {
                    playerCount--;
                }
                option();
                break;
            case 0:
                play();
                break;
            default:
                System.out.println();
                option();
                break;
        }
    }
    
    public void start(){
        String draw =drawCard();
        System.out.println("||=======================================||");
        System.out.println("||================You got a==============||");
        System.out.println("||=======================================||");
        System.out.println("||============="+draw+"============||");
        System.out.println("||=============2.Decrease Bot============||");
        System.out.println("||=============Prees 0 to EXIT===========||");
        System.out.println("||=======================================||");
        
        
    }
    
    public void editPlayerName(){}

//    private void addPlayer(String name) {
//        player[playerCount] = new Player(playerCount, name, 0);
//    

    public String drawCard() {
        return card.drawCard();
    }

    public int getCardRemaining() {
        return card.getCardRemaining();
    }

    public int getNumberFromKeyboard() {
        int getNumber = sc.nextInt();
//       while(!sc.hasNextInt() )
//        {
//            System.out.print("Invalid value!: ");
//
//            getNumber = sc.nextInt();
//        }
        return getNumber;
    }

    public String getPlayerName() {
        return player.getPlayerName();
    }

}
