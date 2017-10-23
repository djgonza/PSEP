
public class AppProductorConsumidor {

	public static void main(String[] args) {
		
		System.out.println("Comienzo del HILO MAIN");
		
		//Creación del Buffer
		Buffer buffer = new Buffer();
		
		//crear un hilo productor y dos consumidores,
		HiloProductor hilProd = new HiloProductor("Productor", buffer);
		HiloConsumidor hilCon1 = new HiloConsumidor("Consumidor 1", buffer);
		HiloConsumidor hilCon2 = new HiloConsumidor("Consumidor 2", buffer);
		
		//Iniciar los 3 hilos
		hilProd.start();
		hilCon1.start();
		hilCon2.start();
		
		//Parar los 3 hilos
		try {
			hilProd.join();
			hilCon1.join();
			hilCon2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		System.out.println("Fin del HILO MAIN");
	}

}
