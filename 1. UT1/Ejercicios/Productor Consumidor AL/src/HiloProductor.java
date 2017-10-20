
public class HiloProductor extends Thread{

	//Atributos de la clase HiloProductor
	private String nombre;
	private Buffer buffer;
	
	/*
	 * Constructor de la clase HiloProductor con 2 par�metros: nombre del hilo y un objeto de la clase Buffer
	 */
	public HiloProductor(String nombre, Buffer buffer) {
		this.nombre = nombre;
		this.buffer = buffer;
	}
	
	/*
	 * M�todo RUN encargado de generar 20 n�meros aleatorios entre 1 y 70.
	 * El jilo una vez insertado un n�mero, duerme 30msg
	 * */
	public void run() {
		
		for(int i = 0; i < 20; i++) {
			int numAleatorio = (int) (Math.random()*70 + 1); 
			try {
				buffer.insertar(numAleatorio);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
