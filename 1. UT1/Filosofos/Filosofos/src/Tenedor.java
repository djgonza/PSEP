
public class Tenedor {
	
	private boolean enUso;
	private int posi;
	
	public Tenedor(int posi) {
		this.enUso = false;
		this.posi = posi;
	}
	
	public void usar() {
		this.enUso = true;		
	}
	
	public void dejar() {
		this.enUso = false;
	}
	
	public boolean estaEnUso() {
		return this.enUso;
	}
}
