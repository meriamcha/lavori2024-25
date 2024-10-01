package sincro;

public class Contatore {
	private int n;//creo la variabile del conto
	
	public Contatore() {
		n=0; //inizializzo il conto
	}
	
	public synchronized int numero() {
		n++;
		return n;
		
	}
}
