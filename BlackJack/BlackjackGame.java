package BlackJack;
import java.util.*;

import Utente.Utente;

public class BlackjackGame {
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

    public int menu() {
        int scel;

        System.out.println("\n################");
        System.out.println("#   0. ESCI    #");
        System.out.println("#   1. GIOCA   #");
        System.out.println("################");

        System.out.println("Cosa vuoi fare?");
        return scel = scanner.nextInt();
    }

    public void play(Utente utente) {
        System.out.println("Benvenuto al Blackjack!");

        int scelta = menu();

        while (scelta != 0) {
            scanner.nextLine();

            playerHand = new Hand();
            dealerHand = new Hand(); 

            playerHand.addCard(deck.drawCard());
            dealerHand.addCard(deck.drawCard());
            playerHand.addCard(deck.drawCard());
            dealerHand.addCard(deck.drawCard());

            System.out.println("\nLe carte del banco sono:");
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
                    utente.setCrediti(utente.getCrediti() + 50);
                    System.out.println("Hai vinto! crediti: " + utente.getCrediti());

                } else if (playerScore < dealerScore) {
                    utente.setCrediti(utente.getCrediti() - 50);

                    System.out.println("Il banco ha vinto. crediti attuali: " + utente.getCrediti());
                    

                } else {
                    System.out.println("Pareggio.");
                }
            } else {

                utente.setCrediti(utente.getCrediti() - 50);
                System.out.println("Hai sballato. Il banco vince. crediti attuali: " + utente.getCrediti());
            }

            utente.salvaCrediti();

            scelta = menu();
        }
        
    }
}
