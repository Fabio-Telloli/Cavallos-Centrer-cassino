package Roulette;
import java.util.Scanner;

public class PuntataUser {
    private int numeroUser;
    private String coloreUser;
    private Scanner scanner;

    public PuntataUser() {
        this.numeroUser = 0;
        this.coloreUser = "";
        this.scanner = new Scanner(System.in);
    }

    public int sceltaNumero() {
        System.out.print("Inserire il numero desiderato --> ");
        numeroUser = scanner.nextInt();

        System.out.println("Hai inserito il numero: " + numeroUser);

        return numeroUser;
    }

    public String sceltaColore() {
        System.out.print("Inserire il colore (rosso o nero) --> ");
        coloreUser = scanner.next();

        System.out.println("Hai inserito il colore: " + coloreUser);

        return coloreUser;
    }
}

