import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCalculadoraAL {
	final static int PUERTO = 6000;
	static ServerSocket servidor;
	static Socket socket;
	
	static OutputStream os;
	static DataOutputStream out;
	
	static InputStream is;
	static DataInputStream input;
	
	static Calculadora calculadora;
	static String mensajeCliente;
	static String mensaje;
	
	public static void conectarServer() throws IOException {
		servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor conectado al puerto local " + PUERTO);
		System.out.println("- Esperando una conexión de cliente ...");
		System.out.println();
		socket = servidor.accept();
		String ipCliente = socket.getInetAddress().getHostAddress();
		System.out.println("Aceptada conexión de cliente desde IP " + ipCliente);
	}
	
	public static void desconectarServer() throws IOException {
		servidor.close();
	}
	
	public static void recibirMensaje() throws IOException {
		is = socket.getInputStream();
		input = new DataInputStream(is);
		mensajeCliente = input.readUTF();
	}
	
	public static void closeRecibirMensaje() throws IOException {
		is.close();
		input.close();
	}
	
	public static void enviarMensaje() throws IOException {
		os = socket.getOutputStream();
		out = new DataOutputStream(os);
	}
	
	public static void closeEnviarMensaje(String mensaje) throws IOException {
		out.writeUTF(mensaje);
		out.close();
	}
	
	public static void operar() throws IOException {		
		String[] partes = mensajeCliente.split(":");
		
		String operacion = partes[0];
		int num1 = Integer.parseInt(partes[1]);
		int num2 = Integer.parseInt(partes[2]);
		calculadora = new Calculadora(num1, num2);
		int resultado = 0;
		String mensaje = "";
		
		switch (operacion) {
        case "+":  
        			resultado = calculadora.sumar();
        			mensaje = "La suma es " + resultado;
                 break;
        case "-":  
        			resultado = calculadora.restar();
        			mensaje = "La resta es " + resultado;
                 break;
        case "*":  
        			resultado = calculadora.multiplicar();
        			mensaje = "La multiplicar es " + resultado;
                 break;
        case "/":  
        			resultado = calculadora.dividir();
        			mensaje = "La división es " + resultado;
                 break;       
        case "QUIT":  			
					mensaje = "Fin de Operaciones";
					closeEnviarMensaje(mensaje);
					desconectarServer();
				break;				
		}
		closeEnviarMensaje(mensaje);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Crear y conectar el servidor
		conectarServer();
		
		//Recibir mensajes por parte del cliente
		recibirMensaje();
		
		//Preparar el mensaje que se envia al cliente.
		enviarMensaje();
		
		
		
		//Enviar mensaje al cliente
		closeEnviarMensaje(mensaje);		
		
		//Cerrar recibir mensajes del cliente
		closeRecibirMensaje();
		
		//Cerrar el servidor
		desconectarServer();
	}

}
