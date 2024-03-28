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
        
        System.out.println("\ninserisci la tua email: ");
        email = scanner.nextLine();

        System.out.println("\ninserisci la tua password: ");
        password = scanner.nextLine();

        Utente utente = new Utente(email, password, 1000000);

        try {
            write.write(utente +"\n");
            write.flush();    //svuota il buffer e scrive SUBITO sul file
        } catch (Exception e) {
            System.out.println("Non è stato possibile scrivere sul file");
        }

        try {
            write.close();
        } catch (Exception e) {
            System.out.println("Errore durante la CHIUSURA del file");
        }

        System.out.println("ciao " + email + " i tuoi crediti sono: " + utente.getCrediti());

    }

    public void accedi() {
        String emailInput, passwordInput;
        
        System.out.println("\ninserisci l'email: ");
        emailInput = scanner.nextLine();

        System.out.println("\ninserisci la password");
        passwordInput = scanner.nextLine();

        BufferedReader readerAnother = null;

        try {
            readerAnother = new BufferedReader(new FileReader("prova.txt"));

            String riga;
            boolean autenticazione = false;
            Utente utente = null;

            while ((riga = readerAnother.readLine()) != null) {
                
                String[] parti = riga.split(" ");

                utente = new Utente(parti[0], parti[1],Integer.parseInt(parti[2]));

                if (utente.getEmail().equals(emailInput) && utente.getPassword().equals(passwordInput)) {
                    autenticazione = true;
                    break;
                }
            }

            if (autenticazione) {
                System.out.println("\n\nCiao " + emailInput + " è un piacere rivederti");

                Casino casino = new Casino(utente);
                casino.sceltaGioco();
            } else {
                System.out.println("\n\nCredenziali non valide, riprovare");
            }

            System.out.println(utente.getCrediti());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore durante la lettura del file");

        } finally {
            try {
                if (readerAnother != null) {
                    readerAnother.close();
                }
            } catch (Exception e) {
                System.out.println("Errore nella chiusura del reader");
            }
        }      
    }

    public void chiudiRead() {
        try {
            read.close();
        } catch (Exception e) {
            System.out.println("errore nella chiusura del reader");
        }
    }


    public static void main(String[] args) {
        Utenti utenti = new Utenti("prova.txt");

        utenti.gestione();

        utenti.chiudiRead();
    }
}
