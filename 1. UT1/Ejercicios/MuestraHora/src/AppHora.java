
public class AppHora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		HiloHora[] horas = new HiloHora[10];
		
		for (int i = 0; i<=10; i++) {
			horas[i] = new HiloHora();
			horas[i].start();
		}
		
		
	}

}
