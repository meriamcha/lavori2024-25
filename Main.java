package sincrocoppie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di thread: ");
        int t = scanner.nextInt();
        
        if (t % 2 != 0) {
            System.out.println("Il numero di thread deve essere pari.");
            return;  // Uscire se il numero di thread non è divisibile per 2
        }

        System.out.print("Inserisci il numero massimo: ");
        int n = scanner.nextInt();

        Thread[] threads = new Thread[t];
        
        // Numero di coppie
        int numCoppie = t / 2;

        for (int i = 0; i < numCoppie; i++) {
            // Ogni coppia ha il proprio contatore
            Contatore contatore = new Contatore();  
            
            // Creiamo due thread per ogni coppia che lavorano sullo stesso contatore
            ThreadCreatore threadcreatore1 = new ThreadCreatore(contatore, n);
            ThreadCreatore threadcreatore2 = new ThreadCreatore(contatore, n);
            
            // Creazione e assegnazione ai thread
            threads[2 * i] = new Thread(threadcreatore1);
            threads[2 * i + 1] = new Thread(threadcreatore2);
        }

        // Avvia i thread
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        // Attendere che tutti i thread completino l'esecuzione
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
