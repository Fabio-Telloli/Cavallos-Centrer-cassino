package Roulette;
import java.util.Random;

public class ColoreRoulet {
    private int colore;
    private String coloreVincente;

    public String determinaColore() {
        Random random = new Random();
        colore = random.nextInt(2);

        if(colore == 0) {
            coloreVincente = "nero";
        } else {
            coloreVincente = "rosso";
        }

        return coloreVincente;
    }
}

