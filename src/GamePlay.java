
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

    private Card[] card = new Card[52];
    private Player[] player = new Player[17];
    private int playerCount = 2;
    private int cardRemaining = 52;
    private int round;
    private Player winner;
    Scanner sc = new Scanner(System.in);

    public GamePlay() {
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
    }

    public String drawCard() {
        if (cardRemaining > 0) {
            int cardGet = randomCard();
            String cardRealyGet = getCard(cardGet);
            cardRemaining--;
            //เอาการ์ดออก-----------------------------------
            Card[] newDeck = new Card[cardRemaining];
            for (int i = 0; i < cardRemaining + 1; i++) {
                if (i < cardGet) {
                    newDeck[i] = card[i];
                } else if (i > cardGet) {
                    newDeck[i - 1] = card[i];
                } else {
                }
            }
            for (int j = 0; j < cardRemaining; j++) {
                card[j] = newDeck[j];
            }
            //เอาการ์ดออก------------------------------------
            return cardRealyGet;
        } else {
            return "No card to draw now";
        }
    }

    private int randomCard() {
        return (int) ((Math.random() * cardRemaining));
    }

    public String getCard(int index) {
        return card[index].getCardNumber() + " " + card[index].getCardFace()/*+" "+card[index].points+" "+card[index].points2*/;
    }

    public void first() {
        System.out.println("||=======================================||");
        System.out.println("||=====WelCome to Fantastic CardGame=====||");
        System.out.println("||=======================================||");
        System.out.println("||============Insert Your Name===========||");
        System.out.println("||=======================================||");
        System.out.print("Your name: ");
        String name = sc.nextLine();
        player[0] = new Player(1, name, null, null, null);
        for (int i = 1; i < 17; i++) {
            player[i] = new Player(i, "Bot" + i, null, null, null);
        }
        System.out.println("");
        home();
    }

    public void home() {
        boolean exit = false;
        do {
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
                    exit = true;
                    break;
                default:
                    System.out.println();

                    break;
            }
        } while (!exit);
    }

    public void play() {
        boolean exit = false;
        do {
            System.out.println("||=======================================||");
            System.out.println("||============Press 1 to START===========||");
            System.out.println("||============Press 2 to OPTION==========||");
            System.out.println("||============Prees 0 to EXIT============||");
            System.out.println("||=======================================||");
            switch (getNumberFromKeyboard()) {
                case 1:
                    start();
                    break;
                case 2:
                    option();
                    break;
                case 0:
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println();
                    break;
            }
        } while (!exit);
    }

    public void option() {
        boolean exit = false;
        do {
            System.out.println("||=======================================||");
            System.out.println("                     " + getPlayerName());
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
                    break;
                case 3:
                    if (playerCount > 2) {
                        playerCount--;
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println();
                    break;
            }
        } while (!exit);
    }

    public void editPlayerName() {
        System.out.println("||=======================================||");
        System.out.println("                     " + getPlayerName());
        System.out.println("||==========INSERT NAME TO CHANGE========||");
        System.out.println("||=======================================||");
        System.out.println("Inset your name: ");
        player[0] = new Player(1, sc.nextLine(), null, null, null);
    }

    public void start() {
        
    }

    public int getNumberFromKeyboard() {
        System.out.print("Enter an integer: ");
        int getNumber = sc.nextInt();
        return getNumber;
    }

    public int getCardRemaining() {
        return cardRemaining;
    }

    public String getPlayerName() {
        return player[0].getPlayerName();
    }

}
