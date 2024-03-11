import java.util.Scanner;

public class Casino {
    private int scelta;
    private Scanner scanner;

    Casino() {
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("SEI ENTRATO NEL CASINO' \n");
        System.out.println("scegli una delle seguenti opzioni");
        System.out.println("#######################");
        System.out.println("# 1) roulet           #");
        System.out.println("# 2) black jack       #");
        System.out.println("# 0) ESCI             #");
        System.out.println("#######################");
    }

    public void sceltaGioco() {
        menu();
        scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                NumeriRoulet numeriBanco = new NumeriRoulet();
                ColoreRoulet coloreBanco = new ColoreRoulet();
                PuntataUser numeroUtente = new PuntataUser();
                PuntataUser coloreUtente = new PuntataUser();
                NumeriMultipli numeriMultipli = new NumeriMultipli();
            
    
                BancoRoulet roulette = new BancoRoulet(numeriBanco, coloreBanco, numeroUtente, coloreUtente, numeriMultipli);
                roulette.inizializazioneGame();
            break;
        
            case 2:
                BlackjackGame game = new BlackjackGame();
                game.play();
            break;

            case 0:
                System.out.println("sei uscito dal casino' ");
            break;
        }
    }
}