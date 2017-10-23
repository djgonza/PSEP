/**
 * Cuenta bancaria con un balance que puede ser modificado con ingresos y
 * reintegros - es el recurso que se comparte Este objeto se utilziar� en
 * exclusi�n mututa y adem�s los hilos que lo utilicen se coordinar�n de tal
 * forma que un hilo que quiere sacar de la cuenta dinero no lo pueda hacer si
 * �sta est� vac�a
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
	 * depositar dinero en la cuenta siempre se puede a�adir a la cuenta dinero no
	 * hay ninguna condici�n que haya que cumplir para que un hilo pueda ejecutar
	 * este c�digo cuando se a�ade se avisa a los hilos que esperan para poder sacar
	 * 
	 * Muestra mensajes que indiquen la cantidad que se deposita y el nuevo balance
	 * 
	 * @param cantidad
	 *            la cantidad a ingresar
	 */
	public synchronized void depositar(double cantidad) {

		// Mensaje DEP�SITO
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
	 * ejecutar el c�digo tendr� que esperar Muestra mensajes que indiquen la
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