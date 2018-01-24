import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClienteSaludoFechaAL {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		final int PUERTO = 5000;
		// crear socket y conectar con el servidor
		Socket cliente = new Socket("localhost", PUERTO);
		System.out.println("Cliente conectado a servidor de IP " + cliente.getInetAddress());
		
		// obtener flujo de entrada y leer los datos recibidos desde el servidor
		InputStream is = cliente.getInputStream();
		DataInputStream input = new DataInputStream(is);
		String strSaludo = input.readUTF();
		System.out.println("Recibido del servidor: " + strSaludo);
		
		// cerra flujos y conexión
		is.close();
		input.close();
		cliente.close();
	}


}
