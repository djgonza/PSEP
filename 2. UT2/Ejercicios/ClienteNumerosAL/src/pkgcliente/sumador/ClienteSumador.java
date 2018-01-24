package pkgcliente.sumador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteSumador {

	static int puerto;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (args.length != 2) {
			System.out.println("El número de argumentos incorrecto: <host> <puerto>");
			System.exit(0);
		}

		// TODO Auto-generated method stub
		String host = args[0];
		int puerto = Integer.parseInt(args[1]);
		// crear socket y conectar con el servidor
		Socket cliente;
		try {
			cliente = new Socket(host, puerto);
			System.out.println("Conectado al servidor " + cliente.getInetAddress());

			// obtener flujo de entrada y leer los datos recibidos desde el servidor
			InputStream is = cliente.getInputStream();
			DataInputStream input = new DataInputStream(is);
			String strSaludo = input.readUTF();
			System.out.println("Desde el servidor - " + strSaludo);
			
			OutputStream os = cliente.getOutputStream();
			DataOutputStream out = new DataOutputStream(os);
			
			Scanner teclado = new Scanner(System.in);
			
			int num = -1;
			
			while(true) {
				if (num != 0) {
					System.out.println("Dame número para enviar al servidor, 0 terminar: ");
					String texto = teclado.next();
					try {
						num = Integer.parseInt(texto);	
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("El puerto debe ser numérico");
						}
					out.write(num);
				}
				else
				{
					teclado.close();
					break;
				}				
			}		
			
			String mensaje = input.readUTF();
			System.out.println("Desde el servidor - " + mensaje);
			mensaje = input.readUTF();
			System.out.println("Desde el servidor - " + mensaje);
			mensaje = input.readUTF();
			System.out.println("Desde el servidor - " + mensaje);
			// cerra flujos y conexión
			out.close();
			is.close();
			input.close();
			cliente.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
