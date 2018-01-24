import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteCalculadoraAL {
	static Socket cliente;
	
	public static void conectarCliente() throws IOException {
		String host = "localhost";
		int puerto = 6000;
		cliente = new Socket(host, puerto);
		System.out.println("CLiente conectado al servidor de IP " + host);		
	}
	
	public static void desconectarServer() throws IOException {
		cliente.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
