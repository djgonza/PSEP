
public class HiloConsumidor extends Thread {

	private String nombre;
	private Buffer buffer;

	public HiloConsumidor(String nombre, Buffer buffer) {
		this.nombre = nombre;
		this.buffer = buffer;
	}

	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				buffer.borrar();
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
