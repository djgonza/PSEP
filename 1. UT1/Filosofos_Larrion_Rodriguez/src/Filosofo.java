
public class Filosofo extends Thread {
	private int id;
	private Tenedor izda, dcha;

	public Filosofo(int id, Tenedor izda, Tenedor dcha) {
		this.id = id;
		this.izda = izda;
		this.dcha = dcha;
	}

	public void comer() throws InterruptedException {
		izda.coger(this.id);
		dcha.coger(this.id);
		System.out.println("El filosofo " + this.id + " está comiendo");
		Thread.sleep(500);
		dcha.dejar(this.id);
		izda.dejar(this.id);

	}

	public void pensar() throws InterruptedException{
		System.out.println("El filosofo " + this.id + " está pensando");
		Thread.sleep(500);
	}

	public void run() {
		while (true) {
			try {
				this.pensar();
				this.comer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
