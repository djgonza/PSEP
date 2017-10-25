
public class Filosofo extends Thread {
	private String nombre;
	
	public Filosofo(String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		Thread.currentThread().setName(nombre);
	}
	
	public synchronized void comer(Tenedor tenedor1, Tenedor tenedor2) {
		
	}
	
	public synchronized void pensar(Tenedor tenedor1, Tenedor tenedor2) {
		//Dejar de usar los tenedores.
		tenedor1.dejar();
		tenedor2.dejar();
		
		//Mensaje de pensar.
		System.out.println("El filósofo " + this.nombre + " está pensando.");
	}
	
	public void run() {
		
	}
}
