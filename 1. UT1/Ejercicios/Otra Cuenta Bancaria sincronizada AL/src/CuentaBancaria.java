/**
 * Cuenta bancaria con un balance que puede ser modificado con ingresos y
 * reintegros - es el recurso que se comparte Este objeto se utilziará en
 * exclusión mututa y además los hilos que lo utilicen se coordinarán de tal
 * forma que un hilo que quiere sacar de la cuenta dinero no lo pueda hacer si
 * ésta está vacía
 */
public class CuentaBancaria {
	private double balance;

	/**
	 * Constructor
	 */
	public CuentaBancaria() {
		balance = 0;
	}

	/**
	 * depositar dinero en la cuenta siempre se puede añadir a la cuenta dinero no
	 * hay ninguna condición que haya que cumplir para que un hilo pueda ejecutar
	 * este código cuando se añade se avisa a los hilos que esperan para poder sacar
	 * 
	 * Muestra mensajes que indiquen la cantidad que se deposita y el nuevo balance
	 * 
	 * @param cantidad
	 *            la cantidad a ingresar
	 */
	public synchronized void depositar(double cantidad) {

		// Mensaje DEPÓSITO
		System.out.println("Depositando " + cantidad);

		// Variable local
		double nuevoBalance = balance + cantidad;

		// Mensaje del nuevo Balance
		System.out.println(", nuevo balance es " + nuevoBalance);

		// Cambiamos el valor de Balance
		balance = nuevoBalance;

		// Notificar al resto de hilos
		notifyAll();

	}

	/**
	 * reintegrar dinero de la cuenta no se puede sacar de la cuenta si hay menos
	 * dinero del que se quiere reintegrar. Si ocurre esto el hilo que intenta
	 * ejecutar el código tendrá que esperar Muestra mensajes que indiquen la
	 * cantidad que se saca y el nuevo balance
	 * 
	 * @param cantidad
	 *            la cantidad a reintegrar
	 */
	public synchronized void reintegrar(double cantidad) {

		if(cantidad > this.balance)
			try {
				//Esperar
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
		{
			// Mensaje REINTEGRO
			System.out.println("Sacando " + cantidad);

			// Variable local
			double nuevoBalance = balance - cantidad;

			// Mensaje del nuevo Balance
			System.out.println(", nuevo balance es " + nuevoBalance);

			// Cambiamos el valor de Balance
			balance = nuevoBalance;

			// Notificar al resto de hilos
			notifyAll();
		}		

	}

	/**
	 * @return devuelve el balance actual de la cuenta
	 */
	public double getBalance() {
		return balance;
	}

}