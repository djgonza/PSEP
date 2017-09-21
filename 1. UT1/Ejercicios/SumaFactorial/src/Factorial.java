
public class Factorial extends Thread {

	private int numero;
	
	
	public Factorial(int numero) {
		super();
		this.numero = numero;
	}


	public void run () {
		int fac = 1;
		for (int n = 1; n <= numero; n++) {
			
			fac *= n;			
			
		}
		
		System.out.println("El factorial de " + this.numero + " es: " + fac);
		System.out.println("Fin del hilo factorial");
	}
	
}
