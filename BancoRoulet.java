import java.util.Scanner;

public class BancoRoulet {
    private int scelta;
    private Scanner scanner;
    private NumeriRoulet numeroBanco;
    private ColoreRoulet coloreBanco;
    private PuntataUser numeroUser;
    private PuntataUser coloreUser;
    private NumeriMultipli numeriMultipli;


    BancoRoulet(NumeriRoulet numeriBanco, ColoreRoulet coloreBanco, PuntataUser numeroUser, PuntataUser coloreUser, NumeriMultipli numeriMultipli) {
        this.numeroBanco = numeriBanco;
        this.coloreBanco = coloreBanco;
        this.numeroUser = numeroUser;
        this.coloreUser  = coloreUser;
        this.numeriMultipli = numeriMultipli;
        this.scanner = new Scanner(System.in);
    }

    public void play(Utente utente) {
        
        do {
            System.out.println("");
            System.out.println("");
            System.out.println("SEI ENTRATO NELLA ROULETTE' \n");
            System.out.println("########################");
            System.out.println("# 0) ESCI DAL CASINO'  #");
            System.out.println("# 100) esci dal tavolo #");
            System.out.println("########################");
            System.out.println("");
            System.out.println("");
            System.out.println("scegli su cosa scommettere");
            System.out.println(" 1) numeri precisi    ");
            System.out.println(" 2) gioca colore      ");
            System.out.println(" 3) TO1               ");
            System.out.println(" 4) TO2               ");
            System.out.println(" 5) TO3               ");
            System.out.println(" 6) 1rd TWELVE        ");
            System.out.println(" 7) 2rd TWELVE        ");
            System.out.println(" 8) 3rd TWELVE        ");
            System.out.println(" 9) 1-18              ");
            System.out.println(" 10) EVEN             ");
            System.out.println(" 11) ODD              ");
            System.out.println(" 12) 19-36            ");
            System.out.println("##############################################################################");
            System.out.println("#                                                                            #");
            System.out.println("#     ------------------------------------------------------------------     #");
            System.out.println("#     |TO1| 36 | 33 | 30 | 27 | 24 | 21 | 18 | 15 | 12 | 9 | 6 | 3 |   |     #");
            System.out.println("#     |------------------------------------------------------------|   |     #");
            System.out.println("#     |TO2| 35 | 32 | 29 | 26 | 23 | 20 | 17 | 14 | 11 | 8 | 5 | 2 | 0 |     #");
            System.out.println("#     |------------------------------------------------------------|   |     #");
            System.out.println("#     |TO3| 34 | 31 | 28 | 25 | 22 | 19 | 16 | 13 | 10 | 7 | 4 | 1 |   |     #");
            System.out.println("#     ------------------------------------------------------------------     #");
            System.out.println("#         |     3rd TWELVE    |     2rd TWELVE    |   1rd TWELVE   |         #");
            System.out.println("#         |--------------------------------------------------------|         #");
            System.out.println("#         |  19-36  |   ODD   |  NERO  |   ROSSO  |  EVEN  |  1-18 |         #");
            System.out.println("#         |--------------------------------------------------------|         #");
            System.out.println("#                                                                            #");
            System.out.println("##############################################################################");
            System.out.println("");
            System.out.println("");

            scelta = scanner.nextInt();
            
            int numeroVincente = this.numeroBanco.getNumeroVincente();

            switch (scelta) {
                case 1:
                    if (this.numeroUser.sceltaNumero() == numeroVincente) {
                        System.out.println("numero del banco: " + numeroVincente);
                        utente.setCrediti(utente.getCrediti() + 50);
                        System.out.println("");
                        System.out.println("HAI VINTO!!!!  i crediti sono: " + utente.getCrediti());
                        System.out.println("");
                        System.out.println("");
                    } else {
                        System.out.println("numero del banco: " + numeroVincente);
                        utente.setCrediti(utente.getCrediti() - 50);
                        System.out.println("");
                        System.out.println("HAI PERSO :(   i crediti sono: " + utente.getCrediti());
                        System.out.println("");
                        System.out.println("");
                    }
                break;
    
                case 2:
                    String coloreVincente = this.coloreBanco.determinaColore();
                    if (this.coloreUser.sceltaColore().equals(coloreVincente)) {
                        System.out.println("colore del banco: " + coloreVincente);
                        utente.setCrediti(utente.getCrediti() + 50);
                        System.out.println("");
                        System.out.println("HAI VINTO!!!!  i crediti sono: " + utente.getCrediti());
                        System.out.println("");
                        System.out.println("");
                    } else {
                        System.out.println("colore del banco: " + coloreVincente);
                        utente.setCrediti(utente.getCrediti() - 50);
                        System.out.println("");
                        System.out.println("HAI PERSO :(   i crediti sono: " + utente.getCrediti());
                        System.out.println("");
                        System.out.println("");
                    }
                break;

                case 3:
                    int[] to1 = {36, 33, 30, 27, 24, 21, 18, 15, 12, 9, 6, 3};

                    this.numeriMultipli.NumeriMultiploVincente(to1, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;


                case 4:
                    int[] to2 = {35, 32, 29, 26, 23, 20, 17, 14, 11, 8, 5, 2};

                    this.numeriMultipli.NumeriMultiploVincente(to2, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;

                case 5:
                    int[] to3 = {34, 31, 28, 25, 22, 19, 16, 13, 10, 7, 4, 1};

                    this.numeriMultipli.NumeriMultiploVincente(to3, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;

                case 6:
                    int[] t1rdTwelve = {10, 7, 4, 1, 11, 8, 5, 2, 12, 9, 6, 3};

                    this.numeriMultipli.NumeriMultiploVincente(t1rdTwelve, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;

                case 7:
                    int[] t2rdTwelve = {22, 19, 16, 13, 23, 20, 17, 14, 24, 21, 18, 15};

                    this.numeriMultipli.NumeriMultiploVincente(t2rdTwelve, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;

                case 8:
                    int[] t3rdTwelve = {34, 31, 28, 25, 35, 32, 29, 26, 36, 33, 30, 27};

                    this.numeriMultipli.NumeriMultiploVincente(t3rdTwelve, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;

                case 9:
                    int[] oneTo18 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

                    this.numeriMultipli.NumeriMultiploVincente(oneTo18, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                    break;
                    
                case 10:
                    int[] even = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};

                    this.numeriMultipli.NumeriMultiploVincente(even, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);
                    
                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;
                
                case 11:
                    int[] odd = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
                    
                    this.numeriMultipli.NumeriMultiploVincente(odd, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");
                break;
                
                case 12:
                    int[] nineteenTo36 = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

                    this.numeriMultipli.NumeriMultiploVincente(nineteenTo36, numeroVincente);
                    this.numeriMultipli.getNumeroVincente(utente);

                    System.out.println("Numero del banco: " + numeroVincente);
                    System.out.println("");               
                break;
    
            } 
        } while (scelta != 0);
    }
} 