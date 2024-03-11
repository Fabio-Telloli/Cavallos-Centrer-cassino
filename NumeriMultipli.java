public class NumeriMultipli {
    private boolean haiVinto = false;

    public void NumeriMultiploVincente(int[] array, int numeroVincente) {
        for (int i = 0; i < array.length; i++) {
            haiVinto = numeroVincente == array[i];
            if (haiVinto) {
                break;
            }
        }   
    }

    public void getNumeroVincente() {
        if (haiVinto) {
            System.out.println("HAI VINTO!!!!");
        } else {
            System.out.println("HAI PERSO :(");
        }
    }
}
