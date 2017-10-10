
/**
 * Esta tarea cuenta los valores pares en un array
 */
public class TareaContarPares implements Runnable {
	private int[] array;
	private int desde;
	private int hasta;
	private int pares; // la cantidad de pares que se han contado

	/**
	 * Constructor
	 * 
	 * @param array
	 *            el array que contiene los números
	 * @param desde
	 *            posición del array desde la que se van a contar pares
	 * @param hasta
	 *            posición del array hasta la que se van a contar pares (exclusive)
	 */
	public TareaContarPares(int[] array, int desde, int hasta) {		
		pares = 0;
		this.array = array;
		this.desde = desde;
		this.hasta = hasta;
	}

	public void countPares() {

		for (int i = desde; i < hasta; i++) {

			if (array[i] % 2 == 0) {
				pares += 1;
			}

		}

	}

	/**
	 * devuelve la cantidad de pares
	 * 
	 */
	public int getPares() {
		return pares;
	}

	/**
	 * contar los pares. En cada iteración el hilo duerme 500 msg Al final se
	 * escribe un mensaje indicando el nomre del hilo y su finalización
	 * 
	 */
	public void run() {

		try {
			for (int i = desde; i < hasta; i++) {
				if (array[i] % 2 == 0) {					
					pares += 1;
					Thread.currentThread().sleep(500);
				}
			}
			System.out.println("Fin del hilo => " + Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
