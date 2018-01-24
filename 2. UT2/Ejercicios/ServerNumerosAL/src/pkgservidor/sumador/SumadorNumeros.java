package pkgservidor.sumador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SumadorNumeros {
	static int puerto;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		if(args.length != 1)
		{
			System.out.println("El número de argumentos incorrecto: <puerto>");
			System.exit(0);
		}
		
		try {
			puerto = Integer.parseInt(args[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("El puerto debe ser numérico");
			}			
		
		try {			
			ServerSocket servidor;
			servidor = new ServerSocket(puerto);
			System.out.println("Servicio de suma, cálculo del máximo y la media.");
			System.out.println("Servidor esperando conexiones en el puerto " + puerto);
			System.out.println();
			
			// esperar y aceptar conexión
			Socket socket = servidor.accept(); 		
			
			String ipCliente = socket.getInetAddress().getHostAddress();
			System.out.println("Aceptada conexión del cliente desde " + ipCliente);		
			
			// obtener flujo de escritura asociado al socket
			OutputStream os = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(os);
			
			out.writeUTF("Bienvenid@ al sumador de números \nEspero tu envío de números hasta el 0");
			
			InputStream is = socket.getInputStream();
			DataInputStream input = new DataInputStream(is);			
			int suma = 0;
			int cont = 0;
			double media = 0.0;
			int max = Integer.MIN_VALUE;
			int numero = -1;
			
			while (true){
				if (numero != 0) {
					numero = input.read();
					System.out.println("Recibido desde cliente " + numero);
					
					suma += numero;
					cont++;
					
					if (numero > max)
						max = numero;
				}
				else {
					break;
				}
			}
			
			if (cont != 0)
				media = suma / cont;			
			
			String mensajeSuma = "La suma es " + suma;
			String mensajeMedia = "La media es " + media;
			String mensajeMax = "El máximo es " + max;
			
			// enviar saludo al cliente
			System.out.println("Enviando suma, máximo y media....");
			out.writeUTF(mensajeSuma);
			out.writeUTF(mensajeMedia);
			out.writeUTF(mensajeMax);
			out.close();
			System.out.println("Todo enviado....");
					
			socket.close();
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}	
	
}
