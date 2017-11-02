
public class Tenedor {

	private int id;
	private boolean libre = true;

	public Tenedor(int id) {
		this.id = id;
	}

	public synchronized void coger(int idFilosofo) throws InterruptedException {
		while (!libre) {
			wait();
		}
		System.out.println("Filosofo " + idFilosofo + " coge tenedor " + this.id);
		this.libre = false;
	}

	public synchronized void dejar(int idFilosofo) {
		this.libre = true;
		System.out.println("Filosofo " + idFilosofo + " deja tenedor " + this.id);
		notifyAll();
	}

}
