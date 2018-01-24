import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteSaludoAplicacion {
	//Puerto en el que escucha el servidor
	final static int PUERTO = 5000;
	static Socket cliente;
	static InputStream is;
	static DataInputStream input;
	static DataOutputStream out;
	static OutputStream os;
	
	public static void crearSocket() throws UnknownHostException, IOException{
		// crear socket y conectar con el servidor
		cliente = new Socket("localhost", PUERTO);
		System.out.println("Cliente conectado a servidor de IP " + cliente.getInetAddress());
	}
	
	public static void cerrarSocket() throws IOException {
		cliente.close();
	}
	
	public static void obtenerFlujo() throws IOException {
		is = cliente.getInputStream();
		input = new DataInputStream(is);
		String strSaludo = input.readUTF();
		System.out.println("Recibido del servidor: " + strSaludo);
	}
	
	public static void cerrarFlujo() throws IOException {
		is.close();
		input.close();
	}
	
	public static void enviarNombreFlujo(String nombreCliente) throws IOException {
		os = cliente.getOutputStream();
		out = new DataOutputStream(os);
		out.writeUTF(nombreCliente);		
	}
	
	public static void cerrarNombreFLujo() throws IOException {
		out.close();
	}
	
	public static String nombre() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un nombre: ");
		String nombreCliente = teclado.next();
		return nombreCliente;		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub		
		crearSocket();		
		
		String nombreCliente = nombre();
		enviarNombreFlujo(nombreCliente);
		
		// obtener flujo de entrada y leer los datos recibidos desde el servidor		
		obtenerFlujo();	
		cerrarNombreFLujo();
		
		// cerrar flujos y conexión
		cerrarFlujo();
		cerrarSocket();
	}


}
