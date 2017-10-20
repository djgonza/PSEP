
public class AppProductorConsumidor {

	public static void main(String[] args) {
		
		//Creación del Buffer
		Buffer buffer = new Buffer();
		
		//crear un hilo productor y dos consumidores,
		HiloProductor hilProd = new HiloProductor("Productor", buffer);
		HiloConsumidor hilCon1 = new HiloConsumidor("Consumidor 1", buffer);
		HiloConsumidor hilCon2 = new HiloConsumidor("Consumidor 2", buffer);
		

	}

}
