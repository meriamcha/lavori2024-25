package sincro;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	       
	        System.out.print("Inserisci il numero di thread: ");
	        int t = scanner.nextInt();

	        System.out.print("Inserisci il numero massimo: ");
	        int n = scanner.nextInt();
	        
	        
		Contatore contatore = new Contatore();
		Thread[]thread = new Thread[t];
		
		for(int i = 0; i < thread.length; i++) {
		    ThreadCreatore threadcreatore = new ThreadCreatore(contatore, n);  // Passa 'n' come massimo
		    thread[i] = new Thread(threadcreatore);
			
		}
		for (int i=0; i<thread.length; i++) {
			thread[i].start();
		}
	}

}
