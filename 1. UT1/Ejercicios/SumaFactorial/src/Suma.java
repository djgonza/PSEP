
public class Suma extends Thread {

	private int numero;
	
	
	public Suma(int numero) {
		super();
		this.numero = numero;
	}


	public void run () {
		int sum = 0;
		for (int n = 1; n <= numero; n++) {
			
			sum += n;			
			
		}
		
		System.out.println("La suma de " + this.numero + " es: " + sum);
		System.out.println("Fin del hilo suma");
	}
	
}
