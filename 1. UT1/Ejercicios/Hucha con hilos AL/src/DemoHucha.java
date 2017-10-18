import psep.HiloHucha;
import psep.Hucha;

public class DemoHucha {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Array que alojará a los 100 hilos.
		Thread hilos[] = new Thread[100];
		
		//Hucha sobre la que se va a hacer todas las operaciones
		Hucha hucha = new Hucha();
		
		// Mostramos el principio del hilo principal
		System.out.println("Principio del hilo main");
		
		//Bucle encargado de crear 100 hilos, añadir al array, iniciar y parar cada uno de los hilos
		for(int i = 0; i < hilos.length; i++) {
			hilos[i] = new HiloHucha(hucha);
			hilos[i].start();
			hilos[i].join();
		}		
		
		//Muestra el total de la hucha
		System.out.println("El total de la hucha es: " + hucha.getTotal());		
		
		// Mostramos el fin del hilo principal
		System.out.println("Fin del hilo main");

	}
	

}
