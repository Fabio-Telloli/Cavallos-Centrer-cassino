package Roulette;
import java.util.Random;

public class NumeriRoulet {
    private int numeroVincente;

    public int getNumeroVincente() {
        Random random = new Random();
        numeroVincente = random.nextInt(37);
         return numeroVincente;
    }
}
