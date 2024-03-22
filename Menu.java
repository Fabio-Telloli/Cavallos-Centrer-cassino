import java.util.Scanner;

public class Menu {
    Scanner scanner;
    int scel;

    Menu() {
        scanner = new Scanner(System.in);
    }

    public int scelta() {
        System.out.println("####################");
        System.out.println("#   1. Registrati  #");
        System.out.println("#   2. Accedi      #");
        System.out.println("#                  #");
        System.out.println("#   0. ESCI        #");
        System.out.println("####################");

        System.out.println("\n cosa vuoi fare? ");
        return scel = scanner.nextInt();
    }
}
