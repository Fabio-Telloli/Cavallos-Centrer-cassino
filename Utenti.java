import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Utenti {
    Scanner scanner;
    FileWriter write;
    BufferedReader read;

    Utenti(String nomeFile) {
        try {
            scanner = new Scanner(System.in);
            write = new FileWriter(nomeFile, true);
            read = new BufferedReader(new FileReader(nomeFile));
        } catch (Exception e) {
            System.out.println("non è stato possibile scrivere sul file");
        }
    }
    
    public void gestione() {
        Menu menu = new Menu();
        int scel;

        scel = menu.scelta();

        while (scel != 0) {
            if (scel == 1) {
                registrati();
                scel = menu.scelta();

            } else if (scel == 2) {
                accedi();

                scel = menu.scelta();

            } else {
                System.out.println("scelta non valida, riprova!! \n\n");
                scel = menu.scelta();
            }
        }

        System.err.println("\n\n© byDesign");
    }

    public void registrati() {
        String email, password;
        int crediti = 1000000;
        
        System.out.println("\ninserisci la tua email: ");
        email = scanner.nextLine();

        System.out.println("\ninserisci la tua password: ");
        password = scanner.nextLine();

        try {
            write.write(email + " " + password + " " + crediti +"\n");
        } catch (Exception e) {
            System.out.println("Non è stato possibile scrivere sul file");
        }

        try {
            write.close();
        } catch (Exception e) {
            System.out.println("Errore durante la CHIUSURA del file");
        }

        System.out.println("ciao " + email + " i tuoi crediti sono: " + crediti);

    }

    public void accedi() {
        String emailInput, passwordInput;
        
        System.out.println("\ninserisci l'email: ");
        emailInput = scanner.nextLine();

        System.out.println("\ninserisci la password");
        passwordInput = scanner.nextLine();

        try {
            String riga;
            boolean autenticazione = false;

            while ((riga = read.readLine()) != null) {
                
                String[] parti = riga.split(" ");
                
                String email = parti[0];
                String password = parti[1];

                if (email.equals(emailInput) && password.equals(passwordInput)) {
                    autenticazione = true;
                    break;
                }
            }

            if (autenticazione) {
                System.out.println("\n\nCiao " + emailInput + " è un piacere rivederti");

                Casino roulette = new Casino();
                roulette.sceltaGioco();
            } else {
                System.out.println("\n\nCredenziali non valide, riprovare");
            }
        } catch (Exception e) {
            System.out.println("Errore durante la lettura del file");
        }

        try {
            read.close();
        } catch (Exception e) {
            System.out.println("Errore durante la CHIUSURA del read");
        }
    }

    public static void main(String[] args) {
        Utenti utenti = new Utenti("prova.txt");

        utenti.gestione();
    }
}
