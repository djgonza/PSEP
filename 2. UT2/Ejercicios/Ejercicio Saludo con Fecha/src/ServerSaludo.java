import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

public class ServerSaludo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Listado meses
		String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto"," ;Septiembre"
	            ,"Octubre","Noviembre","Diciembre"};
		
		//Puerto en el que escucha el servidor
		final int PUERTO = 5000;
		
		// registrar el servicio en el puerto 5000
		ServerSocket servidor;
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor conectado en el puerto " + PUERTO);
			System.out.println("Esperando una conexión de cliente");
			System.out.println();
			
			// esperar y aceptar conexión
			Socket socket = servidor.accept(); 
			
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce un nombre: ");
			String nombreCliente = teclado.next();
			
			String ipCliente = socket.getInetAddress().getHostAddress();
			System.out.println("Conexión aceptada desde " + ipCliente);		
			
			// obtener flujo de escritura asociado al socket
			OutputStream os = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(os);
			
			//Obtener la fecha actual
			Calendar c1 = Calendar.getInstance();
			String dia = Integer.toString(c1.get(Calendar.DATE));
			String mes = meses[c1.get(Calendar.MONTH)];
			String año = Integer.toString(c1.get(Calendar.YEAR));
			
			// enviar saludo al cliente
			out.writeUTF("Hola " + nombreCliente + " Hoy es " + dia + " - " + mes + " - " + año);
			out.close();
					
			socket.close();
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
