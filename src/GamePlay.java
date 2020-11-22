
/**
*[H1]Thisi is a GamePlay class[/H1]
*It has playerCount cardRemaining round mode Array Card and Player
 */
import java.util.Scanner;

public class GamePlay {

    private final Card[] card = new Card[52];
    private final Player[] player = new Player[17];
    private int playerCount = 2;
    private int cardRemaining;
    private int round;
    private Mode mode;
    Scanner sc = new Scanner(System.in);

    public GamePlay() {
        this.mode = Mode.dealer;
        cardGennarate();
    }
/**this method is use to describe card face as char
@return nothing
 */
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
        cardRemaining = 52;
    }
/**this method is use when returns the char value of card.
 * decrease card remaining when use getCard
*@param player is the player who draw the card
*@return int value of card face
 */
    public Card drawCard(int player) {
        if (cardRemaining > 0) {
            int cardGet = randomCard();
            String cardRealyGet = getCard(cardGet);
            cardRemaining--;
            
            Card[] newDeck = new Card[cardRemaining];
            for (int i = 0; i < cardRemaining + 1; i++) {
                if (i < cardGet) {
                    newDeck[i] = card[i];
                } else if (i > cardGet) {
                    newDeck[i - 1] = card[i];
                } else {
                }
            }
            System.arraycopy(newDeck, 0, card, 0, cardRemaining);
            
            return card[cardGet];
        } else {
            return this.player[player].getHandCard(2) != null ? this.player[player].getHandCard(2) : this.player[player].getHandCard(1) != null ? this.player[player].getHandCard(1) : this.player[player].getHandCard(0);
        }

    }
/**returns the char value of card.
*@return int number value of cardRemaining
 */
    private int randomCard() {
        return (int) ((Math.random() * cardRemaining));
    }

/**returns the char value of card face and number value of card.
 * @param index is parameter that add to getCard
*@return int This return the sum of cardNumber and cardFace
 */
    public String getCard(int index) {
        return card[index].getCardNumber() + " " + card[index].getCardFace()/*+" "+card[index].points+" "+card[index].points2*/;
    }

/**This method use to print game menu and set your name
 */
    public void first() {
        String name;
        do {
            System.out.println("||========================================||");
            System.out.println("||      WelCome to Fantastic CardGame     ||");
            System.out.println("||                                        ||");
            System.out.println("||             Insert Your Name           ||");
            System.out.println("||========================================||");
            System.out.print("Your name not more than 35 character: ");
            name = sc.nextLine();
        } while (name.length() > 34);
        player[0] = new Player(1, name);
        for (int i = 1; i < 17; i++) {
            player[i] = new Player(i, "Bot" + i);
        }
        home();
    }
/**This method is use to show your name
 * and display choices and get your selection from keyboard
 */
    public void home() {

        boolean exit = false;
        do {
            System.out.println();
            System.out.println("||========================================||");
            System.out.println("||      WelCome to Fantastic CardGame     ||");
            System.out.println("||                                        ||");
            printPlayerName(0);
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
/**this method use to show the choices for u
 * and get the choice from your keyboard
 */
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

/**this method use to show the choice between dealer and player
 */
    public void option() {
        String markDealer = "|DEALER|";
        String markPlayer = " PLAYER ";
        boolean exit = false;
        do {
            switch (mode) {
                case dealer:
                    markDealer = "|DEALER|";
                    markPlayer = " PLAYER ";
                    break;
                case player:
                    markPlayer = "|PLAYER|";
                    markDealer = " DEALER ";
                    break;
            }

/**this method use to show result choice which you select
 */
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName(0);
            System.out.println("||            1.EDIT PLAYER NAME          ||");
//            System.out.println("||                                        ||");
            System.out.println("||                You are now             ||");
            System.out.println("||         " + markDealer + "        " + markPlayer + "       ||");
//            System.out.println("||                                        ||");
            System.out.println("||             2.Play as dealer           ||");
            System.out.println("||             3.Play as player           ||");
            System.out.println("||              4.Bot setting             ||");
            System.out.println("||              Prees 0 to EXIT           ||");
            System.out.println("||========================================||");
            switch (getNumberFromKeyboard()) {
                case 1:
                    editPlayerName();
                    break;
                case 2:
                    this.mode = Mode.dealer;
                    player[playerCount - 1].setPlayerName("Bot" + playerCount + 1);
                    break;
                case 3:
                    this.mode = Mode.player;
                    player[playerCount - 1].setPlayerName("DealerBot");
                    break;
                case 4:
                    botSetting();
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

/**this method use to set amount of bot player
 */
    public void botSetting() {
        boolean exit = false;
        do {
            System.out.println("||========================================||");
            System.out.println("||                Bot amount              ||");
            System.out.println("||                   <" + (playerCount - 1 >= 10 ? playerCount - 1 + "> " : playerCount - 1 + ">  ") + "                ||");
            System.out.println("||              1.Increase Bot            ||");
            System.out.println("||              2.Decrease Bot            ||");
            System.out.println("||              Prees 0 to EXIT           ||");
            System.out.println("||========================================||");
            switch (getNumberFromKeyboard()) {
                case 1:
                    if (playerCount < 17) {
                        playerCount++;
                    }
                    break;
                case 2:
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
    
/**this method use to get input from keyboard to change the name
 */
    public void editPlayerName() {
        sc.nextLine();
        String name;
        do {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName(0);
            System.out.println("||           INSERT NAME TO CHANGE        ||");
            System.out.println("||========================================||");
            System.out.print("Inset your name not more than 34 character: ");
            name = sc.nextLine();
        } while (name.length() > 34);
        player[0].setPlayerName(name);
    }

/**this method use to tell the card you get in first phase
 * and ask if you want to get more card or not
 */
    public void start() {

        for (int player = 0; player < playerCount; player++) {
            this.player[player].drawHand(drawCard(player));
        }

        for (int player = 0; player < playerCount; player++) {
            this.player[player].drawHand(drawCard(player));
        }
        boolean exit = false;
        do {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName(0);
            System.out.println("||                 You got a              ||");
            printCardMiddle(player[0], 0);
            printCardMiddle(player[0], 1);
            System.out.println("||                                        ||");
            if (mode == Mode.dealer) {
                if (player[0].getAllPoints() == 8 || player[0].getAllPoints() == 9) {
                } else {
                    System.out.println("||Press 1 If you want to draw a third card||");
                }
            } else if (mode == Mode.player) {
                if (player[playerCount - 1].getAllPoints() == 8 || player[playerCount - 1].getAllPoints() == 9) {
                } else {
                    System.out.println("||Press 1 If you want to draw a third card||");
                }
            }
            if (mode == Mode.dealer) {
                if (player[0].getAllPoints() == 8 || player[0].getAllPoints() == 9) {
                    System.out.println("||            You have " + player[0].getAllPoints() + " Points           ||");
                    System.out.println("||    Press anything to show your card    ||");
                    result();
                    break;
                } else {
                    System.out.println("||   Press 0 If you do not want to draw   ||");
                }
            } else if (mode == Mode.player) {
                if (player[playerCount - 1].getAllPoints() == 8 || player[playerCount - 1].getAllPoints() == 9) {
                    System.out.println("||         A Dealer have " + player[1].getAllPoints() + " Points         ||");
                    System.out.println("||    Press anything to show your card    ||");
                    result();
                    break;
                } else {
                    System.out.println("||   Press 0 If you do not want to draw   ||");
                }
            }
            System.out.println("||========================================||");
            System.out.print("");
            switch (getNumberFromKeyboard()) {
                case 1:
                    if (mode == Mode.dealer) {
                        if (player[0].getAllPoints() == 8 || player[0].getAllPoints() == 9) {
                        } else {
                            this.player[0].drawHand(drawCard(0));
                        }
                    }
                    if (mode == Mode.player) {
                        if (player[playerCount - 1].getAllPoints() == 8 || player[playerCount - 1].getAllPoints() == 9) {
                        } else {
                            this.player[0].drawHand(drawCard(0));
                        }
                    }
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

/**this method show your card if you draw
 */
    public void phase2() {

        sc.nextLine();
        botDraw();
        if (player[0].getHandCard(2) != null) {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName(0);
            System.out.println("||                 You got a              ||");
            printCardMiddle(player[0], 0);
            printCardMiddle(player[0], 1);
            printCardMiddle(player[0], 2);
            System.out.println("||                                        ||");
            System.out.println("||    Press anything to show your card    ||");
            System.out.println("||========================================||");
        } else {
            System.out.println();
            System.out.println("||========================================||");
            printPlayerName(0);
            System.out.println("||                 You got a              ||");
            printCardMiddle(player[0], 0);
            printCardMiddle(player[0], 1);
            System.out.println("||                                        ||");
            System.out.println("||    Press anything to show your card    ||");
            System.out.println("||========================================||");
        }
        System.out.print("");
        System.out.print("Press anything here: ");
        sc.nextLine();
        result();
    }

/**This method is use for reset everything and return to home
 */
    public void result() {

        System.out.println();
        System.out.println("||========================================||");
        printPlayerName(0);
        printCardMiddle(player[0], 0);
        printCardMiddle(player[0], 1);
        if (player[0].getHandCard(2) != null) {
            printCardMiddle(player[0], 2);
        }
        System.out.println("||^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^||");
        resultCheck();
        System.out.println("||    Press anything to return to home    ||");
        System.out.println("||========================================||");
        System.out.print("Press anything here: ");
        sc.nextLine();
        reset();

    }

/**This method use to show if you lose or win as a dealer
 */
    public void resultCheck() {
        int head = 1;
        if (mode == Mode.dealer) {

            dealerWinLose();
        } else {
            playerWinLose();

        }
        if (player[0].getWinWho(0) != null) {
            System.out.println("||||||||||||||||||||You win|||||||||||||||||");
            for (int i = 0; i < player[0].getWinHead(); i++) {
                printBot(player[0].getWinWho(i));
                printCardMiddle(player[0].getWinWho(i), 0);
                printCardMiddle(player[0].getWinWho(i), 1);
                if (player[0].getWinWho(i).getHandCard(2) != null) {
                    printCardMiddle(player[0].getWinWho(i), 2);
                }
            }
            System.out.println("||^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^||");
        }
        if (player[0].getLoseWho(0) != null) {
            System.out.println("|||||||||||||||||||You lose|||||||||||||||||");
            for (int i = 0; i < player[0].getLoseHead(); i++) {
                printBot(player[0].getLoseWho(i));
                printCardMiddle(player[0].getLoseWho(i), 0);
                printCardMiddle(player[0].getLoseWho(i), 1);
                if (player[0].getLoseWho(i).getHandCard(2) != null) {
                    printCardMiddle(player[0].getLoseWho(i), 2);
                }
            }
            System.out.println("||^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^||");
        }
        if (player[0].getDrawWho(0) != null) {
            System.out.println("||||||||||||||||||You draw||||||||||||||||||");
            for (int i = 0; i < player[0].getDrawHead(); i++) {
                printBot(player[0].getDrawWho(i));
                printCardMiddle(player[0].getDrawWho(i), 0);
                printCardMiddle(player[0].getDrawWho(i), 1);
                if (player[0].getDrawWho(i).getHandCard(2) != null) {
                    printCardMiddle(player[0].getDrawWho(i), 2);
                }
            }
            System.out.println("||^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^||");
        }
    }

/**This method is show that dealer win or lose 
 */
    public void dealerWinLose() {
        for (int i = 1; i < playerCount; i++) {
            if (player[0].getAllPoints() < player[i].getAllPoints()) {
                player[0].lose(player[i]);
            } else if (player[0].getAllPoints() > player[i].getAllPoints()) {
                player[0].win(player[i]);
            } else {
                player[0].draw(player[i]);
            }
        }
    }

/**this method is show if players win or lose
 */
    public void playerWinLose() {
        if (player[0].getAllPoints() < player[1].getAllPoints()) {
            player[0].lose(player[1]);
        } else if (player[0].getAllPoints() > player[1].getAllPoints()) {
            player[0].win(player[1]);
        } else {
            player[0].draw(player[1]);
        }
    }

/**returns int number value of getNumber.
 * @return int number value of getNumber.
 */
    public int getNumberFromKeyboard() {
        int getNumber = 0;
        System.out.print("Enter an integer: ");
        while (!sc.hasNextInt()) {
            System.out.print("It's not integer please enter an integer: ");
            sc.next();
        }
        getNumber = sc.nextInt();
        return getNumber;
    }
/**
 *@param who is a parameter that represent player
 */
    public void printPlayerName(int who) {

        int j = 17;

        if (getPlayerName(who).length() % 2 == 0) {
            j = 18;
        }
        if (getPlayerName(who).length() == 34) {
            j = 16;
        }
        System.out.print("||");
        for (int i = 0; i < j - (getPlayerName(who).length() / 2); i++) {
            System.out.print(" ");
        }
        System.out.print("<< " + getPlayerName(who) + " >>");
        for (int i = 0; i < 16 - (getPlayerName(who).length() / 2); i++) {
            System.out.print(" ");
        }
        System.out.println("||");

    }
/**this method is represent to bot
 *@param who is represent to bot player
 */
    public void printBot(Player who) {

        int j = 17;

        if (who.getPlayerName().length() % 2 == 0) {
            j = 18;
        }
        if (who.getPlayerName().length() == 34) {
            j = 16;
        }
        System.out.print("||");
        for (int i = 0; i < j - (who.getPlayerName().length() / 2); i++) {
            System.out.print("-");
        }
        System.out.print("<< " + who.getPlayerName() + " >>");
        for (int i = 0; i < 16 - (who.getPlayerName().length() / 2); i++) {
            System.out.print("-");
        }
        System.out.println("||");

    }

/**This method is use to print card on players hand to mid
 */
    public void printCardMiddle(Player who, int cardHand) {
        int j = 15;
        if (who.getHandCard(cardHand).toString().length() % 2 == 0) {
            j = 16;
        }
        System.out.print("||");
        for (int i = 0; i < j - (who.getHandCard(cardHand).toString().length() / 2); i++) {
            System.out.print(" ");
        }
        System.out.print("   < " + who.getHandCard(cardHand).toString() + " >   ");
        for (int i = 0; i < 14 - (who.getHandCard(cardHand).toString().length() / 2); i++) {
            System.out.print(" ");
        }
        System.out.println("||");
    }

/**this method is return all card to deck
 */
    public void returnAllCard() {
        for (int i = 0; i < playerCount; i++) {
            player[i].returnAllCard();
        }
    }

/**returns the number value of card remaining.
*@return int amount of card remain
 */
    public int getCardRemaining() {
        return cardRemaining;
    }

/**returns the char value of player name.
*@return int value of all player name refer to char of playername
 */
    public String getPlayerName(int i) {
        return player[i].getPlayerName();
    }

/**this method is reset card on hand and reset deck
 */
    public void printAllCard() {
        System.out.println("==Genarate Deck==");
        cardGennarate();
        returnAllCard();
        cardRemaining = 52;
        for (int i = 0; i < cardRemaining; i++) {
            System.out.println(card[i]);
        }
        System.out.println("==Genarate Deck==");
    }

/**this method is use to reset win and lose
 */
    public void reset() {
        cardGennarate();
        returnAllCard();
        player[0].resetWinLoseDraw();
        printAllCard();
        System.out.println(player[1].getAllPoints());
    }

/**this method is use when bot draw a card
 * when they has point below or equal to 5
 */
    public void botDraw() {
        for (int player = 1; player < playerCount; player++) {
            if (this.player[player].getAllPoints() <= 5) {
                this.player[player].drawHand(drawCard(player));
            }
        }
    }
}
