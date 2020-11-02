
import java.util.Scanner;

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

    public Card drawCard(int player, int hand) {
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
            return card[cardGet];
        } else {
            return this.player[player].getHandCard(hand);
        }

    }

    private int randomCard() {
        return (int) ((Math.random() * cardRemaining));
    }

    public String getCard(int index) {
        return card[index].getCardNumber() + " " + card[index].getCardFace()/*+" "+card[index].points+" "+card[index].points2*/;
    }

    public void first() {
        System.out.println("||========================================||");
        System.out.println("||      WelCome to Fantastic CardGame     ||");
        System.out.println("||                                        ||");
        System.out.println("||             Insert Your Name           ||");
        System.out.println("||========================================||");
        System.out.print("Your name: ");
        String name = sc.nextLine();
        player[0] = new Player(1, name, null, null, null);
        for (int i = 1; i < 17; i++) {
            player[i] = new Player(i, "Bot" + i, null, null, null);
        }
        home();
    }

    public void home() {

        boolean exit = false;
        do {
            System.out.println();
            System.out.println("||========================================||");
            System.out.println("||      WelCome to Fantastic CardGame     ||");
            System.out.println("||                                        ||");
            System.out.println("||             Press 1 to PLAY            ||");
            System.out.println("||          Prees 0 to LEAVE GAME         ||");
            System.out.println("||========================================||");
            switch (getNumberFromKeyboard()) {
                case 1:
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
            System.out.println();
            System.out.println("||========================================||");
            System.out.println("||             Press 1 to START           ||");
            System.out.println("||             Press 2 to OPTION          ||");
            System.out.println("||             Prees 0 to EXIT            ||");
            System.out.println("||========================================||");
            switch (getNumberFromKeyboard()) {
                case 1:
                    start();
                    break;
                case 2:
                    option();
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

    public void option() {

        boolean exit = false;
        do {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName();
            System.out.println("||            1.EDIT PLAYER NAME          ||");
            System.out.println("||                Bot amount              ||");
            System.out.println("||                   <" + (playerCount - 1 >= 10 ? playerCount - 1 + "> " : playerCount - 1 + ">  ") + "                ||");
            System.out.println("||              2.Increase Bot            ||");
            System.out.println("||              3.Decrease Bot            ||");
            System.out.println("||              Prees 0 to EXIT           ||");
            System.out.println("||========================================||");
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
        ;
        sc.nextLine();
        System.out.println();
        System.out.println("||========================================||");
        printPlayerName();
        System.out.println("||           INSERT NAME TO CHANGE        ||");
        System.out.println("||========================================||");
        System.out.print("Inset your name: ");
        player[0] = new Player(1, sc.nextLine(), null, null, null);

    }

    public void start() {

        for (int player = 0; player < playerCount; player++) {
            this.player[player].drawHand1(drawCard(player, 1));
        }

        for (int player = 0; player < playerCount; player++) {
            this.player[player].drawHand2(drawCard(player, 2));
        }
        boolean exit = false;
        do {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName();
            System.out.println("||                 You got a              ||");
            printCardMiddle(1);
            printCardMiddle(2);
            System.out.println("||                                        ||");
            System.out.println("||Press 1 If you want to draw a third card||");
            System.out.println("||   Press 0 If you do not want to draw   ||");
            System.out.println("||========================================||");
            System.out.print("");
            switch (getNumberFromKeyboard()) {
                case 1:
                    this.player[0].drawHand3(drawCard(0, 3));
                    phase2();
                    exit = true;
                    break;
                case 0:
                    exit = true;
                    phase2();
                    break;
                default:
                    System.out.println("");
                    break;
            }
        } while (!exit);

    }

    public void phase2() {
        
        sc.nextLine();
        if (player[0].getHandCard(3) != null) {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName();
            System.out.println("||                 You got a              ||");
            printCardMiddle(1);
            printCardMiddle(2);
            printCardMiddle(3);
            System.out.println("||                                        ||");
            System.out.println("||    Press anything to show your card    ||");
            System.out.println("||========================================||");
        } else {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName();
            System.out.println("||                 You got a              ||");
            printCardMiddle(1);
            printCardMiddle(2);
            System.out.println("||                                        ||");
            System.out.println("||    Press anything to show your card    ||");
            System.out.println("||========================================||");
        }
        System.out.print("");
        System.out.print("Press anything here: ");
        sc.nextLine();
        System.out.println("==Genarate Deck==");
        cardGennarate();
        cardRemaining = 52;
        for (int i = 0; i < cardRemaining; i++) {
            System.out.println(card[i]);
        }
        System.out.println("==Genarate Deck==");
        System.out.println();
    }

    public int getNumberFromKeyboard() {
        System.out.print("Enter an integer: ");
        int getNumber = sc.nextInt();
        return getNumber;
    }
    public void printPlayerName(){
        int j=15;
        if(getPlayerName().length()%2==0){j=16;}
        System.out.print("||");
        for(int i=0;i<j-(getPlayerName().length()/2);i++){System.out.print(" ");}
        System.out.print(" =<< "+getPlayerName()+" >>= ");
        for(int i=0;i<14-(getPlayerName().length()/2);i++){System.out.print(" ");}
        System.out.println("||");
    }
    
    public void printCardMiddle(int cardHand){
        int j=15;
        if(player[0].getHandCard(cardHand).toString().length()%2==0){j=16;}
        System.out.print("||");
        for(int i=0;i<j-(player[0].getHandCard(cardHand).toString().length()/2);i++){System.out.print(" ");}
        System.out.print("   < "+player[0].getHandCard(cardHand).toString()+" >   ");
        for(int i=0;i<14-(player[0].getHandCard(cardHand).toString().length()/2);i++){System.out.print(" ");}
        System.out.println("||");
    }
    
    public int getCardRemaining() {
        return cardRemaining;
    }

    public String getPlayerName() {
        return player[0].getPlayerName();
    }

}
