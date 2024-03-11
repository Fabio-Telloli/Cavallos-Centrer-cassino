import java.util.*;

class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private Scanner scanner;

    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        dealerHand = new Hand();
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Benvenuto al Blackjack!");
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());

        System.out.println("Le carte del banco sono:");
        dealerHand.display();
        System.out.println("Il tuo punteggio è: " + playerHand.calculateValue());

        while (playerHand.calculateValue() < 21) {
            System.out.println("Vuoi pescare un'altra carta? (s/n)");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("s")) {
                playerHand.addCard(deck.drawCard());
                playerHand.display();
                System.out.println("Il tuo punteggio è: " + playerHand.calculateValue());
            } else {
                break;
            }
        }

        if (playerHand.calculateValue() <= 21) {
            while (dealerHand.calculateValue() < 17) {
                dealerHand.addCard(deck.drawCard());
            }

            System.out.println("Le carte del banco sono:");
            dealerHand.display();
            System.out.println("Il punteggio del banco è: " + dealerHand.calculateValue());

            int playerScore = playerHand.calculateValue();
            int dealerScore = dealerHand.calculateValue();

            if (dealerScore > 21 || playerScore > dealerScore) {
                System.out.println("Hai vinto!");
            } else if (playerScore < dealerScore) {
                System.out.println("Il banco ha vinto.");
            } else {
                System.out.println("Pareggio.");
            }
        } else {
            System.out.println("Hai sballato. Il banco vince.");
        }
    }
}
