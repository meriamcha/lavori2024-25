package sincro;

public class ThreadCreatore implements Runnable {
	
	Contatore c;
	int max;

	public ThreadCreatore(Contatore c, int max){
		
		this.c = c;
		this.max = max;
	}
	
	public void run() {
	    int n = 0;
	    while(n < max) {
	        n = c.numero();
	        System.out.println("conto: " + n + " contato da: " + Thread.currentThread().getName());
	    }
	}
}