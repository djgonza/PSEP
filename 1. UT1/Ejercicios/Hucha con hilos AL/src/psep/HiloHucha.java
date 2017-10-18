package psep;

public class HiloHucha extends Thread {

	// tiene un atributo hucha que se inicializar� en el constructor
	private Hucha hucha;

	/*
	 * Constructor de la clase HiloHucha
	 */
	public HiloHucha(Hucha hucha) {
		super();
		this.hucha = hucha;
	}

	// el hilo simular� hacer 100 veces a�adir 2 euros a la hucha. Duerme el hilo 30
	// msg
	// despu�s de cada operaci�n sobre la hucha
	public void run() {

		try {
			for (int i = 0; i < 100; i++) {
				//A�adir 2� a la hucha
				this.hucha.add(2);
			}
			// Se duerme el hilo.
			this.currentThread().sleep(30);
			// System.out.println("Fin del hilo => " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
