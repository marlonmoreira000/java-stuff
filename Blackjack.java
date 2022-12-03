import java.util.Scanner;

public class Blackjack {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // welcome message
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see. Press anything to begin!");
        scan.nextLine();

        // get player cards
        int playerCard1 = drawRandomCard();
        int playerCard2 = drawRandomCard();
        int playerTotal = Math.min(playerCard1, 10) + Math.min(playerCard2, 10);
        System.out.println("\nYou get a \n" + cardString(playerCard1) + "\nand a \n" + cardString(playerCard2));
        System.out.println("your total is: " + playerTotal);

        // get dealer cards
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);
        System.out.println(
                "\nThe dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("The dealer's total is hidden.");

        // player's turn
        while (true) {
            String choice = hitOrStay();
            if (choice.equals("stay")) {
                break;
            }
            int newCard = drawRandomCard();
            playerTotal += Math.min(newCard, 10);
            System.out.println("\nYou get a \n" + cardString(newCard));
            System.out.println("Your total is: " + playerTotal);
            if (playerTotal > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
        }

        // dealer's turn
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are \n" + cardString(dealerCard1)
                + "\n and a \n" + cardString(dealerCard2));
        System.out.println("Dealer's total is " + dealerTotal);
        while (dealerTotal < 17) {
            int newCard = drawRandomCard();
            dealerTotal += Math.min(newCard, 10);
            System.out.println("\nDealer gets a \n" + cardString(newCard));
            System.out.println("Dealer's total is: " + dealerTotal);
        }

        // determine winner
        if (dealerTotal > 21) {
            System.out.println("Bust! Dealer loses");
            System.exit(0);
        }
        if (dealerTotal > playerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("Player wins!");
        }
    }

    // returns a random number between 1 and 13
    public static int drawRandomCard() {
        int randomCard = (int) (13 * Math.random() + 1);
        return randomCard;
    }

    // ask use to hit or stay
    public static String hitOrStay() {
        System.out.println("Would you like hit or stay?");
        String ans = scan.nextLine().toLowerCase();
        while (!ans.equals("hit") && !ans.equals("stay")) {
            System.out.println("Please write hit or stay");
            ans = scan.nextLine().toLowerCase();
        }
        return ans;
    }

    // print the dealers card face down to hide it from player
    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    // return a card depending on the number parameter passed in
    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";
            default:
                return "Not possible.";
        }
    }
}
