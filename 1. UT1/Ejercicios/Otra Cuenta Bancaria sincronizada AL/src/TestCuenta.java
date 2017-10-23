
/**
 * Aquí se crea la cuenta compartida y dos hilos, uno que ingresa y otro que
 * saca. Se ingresa 100€ y se saca 50€. Esperamos a que los hilos terminen y
 * mostramos el balance de la cuenta
 * 
 */
public class TestCuenta {

	public static void main(String[] args) throws InterruptedException {
		// Se crea un objeto de la clase CuentaBancaria
		CuentaBancaria cuentita = new CuentaBancaria();

		// Se crean dos hilos: 1 HiloDeposito y 1 HiloReintegro
		HiloDeposito hiloUno = new HiloDeposito(cuentita, 100);
		HiloReintegro hiloDos = new HiloReintegro(cuentita, 50);

		// Se ejecutan los dos hilos
		hiloUno.start();
		hiloDos.start();

		// Se paran los dos hilos. La app nos obliga meterlos en un try catch
		try {
			hiloUno.join();
			hiloDos.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Mensaje final
		System.out.println("Estoy en el main - La cuenta tiene un saldo de " + cuentita.getBalance());

		// Mostramos el fin del hilo principal
		System.out.println("Fin del hilo main");
	}
}
