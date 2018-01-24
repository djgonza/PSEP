import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

public class ServerSaludoAplicacion {	
	//Puerto en el que escucha el servidor
	final static int PUERTO = 5000;
	static ServerSocket servidor;
	static Socket socket;
	static OutputStream os;
	static DataOutputStream out;
	static String dia;
	static String mes;
	static String año;
	static String nombreCliente;
	static InputStream is;
	static DataInputStream input;
	
	public static void crearServidor() throws IOException {
		servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor conectado en el puerto " + PUERTO);
		System.out.println("Esperando una conexión de cliente");
		System.out.println();
		
	}
	
	public static void cerrarServidor() throws IOException {
		servidor.close();
	}
	
	public static void crearSocket() throws IOException {
		// esperar y aceptar conexión
		socket = servidor.accept();
		String ipCliente = socket.getInetAddress().getHostAddress();
		System.out.println("Conexión aceptada desde " + ipCliente);	
	}
	
	public static void cerrarSocket() throws IOException {
		socket.close();
	}
	
	public static void crearFlujo() throws IOException {
		os = socket.getOutputStream();
		out = new DataOutputStream(os);
	}
	
	public static void enviarCerrarFlujo(String nombreCliente) throws IOException {
		// enviar saludo al cliente
		out.writeUTF("Hola " + nombreCliente + " Hoy es " + dia + " - " + mes + " - " + año);
		out.close();
	}
	
	public static void obtenerFlujo() throws IOException {
		is = socket.getInputStream();
		input = new DataInputStream(is);
		nombreCliente = input.readUTF();		
	}
	
	public static void cerrarFlujoObtenido() throws IOException {
		is.close();
		input.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//Listado meses
				String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto"," ;Septiembre"
			            ,"Octubre","Noviembre","Diciembre"};
				
				// registrar el servicio en el puerto 5000
				
				try {
					crearServidor();					
					crearSocket();						
					
					// obtener flujo de escritura asociado al socket
					crearFlujo();
					
					//Obtener la fecha actual
					Calendar c1 = Calendar.getInstance();
					dia = Integer.toString(c1.get(Calendar.DATE));
					mes = meses[c1.get(Calendar.MONTH)];
					año = Integer.toString(c1.get(Calendar.YEAR));
					
					// enviar saludo al cliente
					obtenerFlujo();
					enviarCerrarFlujo(nombreCliente);
					cerrarFlujoObtenido();
							
					cerrarSocket();
					cerrarServidor();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		

	}

}
