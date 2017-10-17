import java.util.Random;

/**
 * 
 * El programa ejecuta dos hilos que depositan dinero en la misma cuenta
 * bancaria
 */
public class TestCuenta {

	public static void main(String[] args) {
		// Se crea un objeto de la clase CuentaBancaria
		CuentaBancaria cuenta = new CuentaBancaria();

		// Se crean dos hilos
		Thread hiloUno = new Thread(new TareaDeposito(cuenta, 1000));
		Thread hiloDos = new Thread(new TareaDeposito(cuenta, 1000));

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
		
		// Mostramos el fin del hilo principal
		System.out.println("Fin del hilo main");

	}
}
