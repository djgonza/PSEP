import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EscaneadorPuertos {
	static Socket cliente;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = "";
		int desde = 0;
		int hasta = 0;
		
		if(args.length != 3)
		{
			System.out.println("El n�mero de argumentos incorrecto: <host> <desde> <hasta>");
			System.exit(0);
		} 
		else
		{
			//Tomamos el valor del host del primer argumento que se le pasa.
			host = args[0];
			
			//Comprobaci�n de que el puerto <desde> sea un valor num�rico
			try {				
				desde = Integer.parseInt(args[1]);				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("El puerto <desde> debe ser num�rico");
				}
			
			//Comprobaci�n de que el puerto <hasta> sea un valor num�rico
			try {				
				hasta = Integer.parseInt(args[2]);				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("El puerto <hasta> debe ser num�rico");
				}
			
			//Comprobamos que el puerto <hasta> sea mayor que el puerto <desde>
			//En caso de no cumplirlo, cierra la aplicaci�n
			if(hasta < desde) {
				System.out.println("El puerto <hasta> debe ser mayor que el puerto <desde>");
				System.exit(0);
			}
		}
		
		//Bucle for que empieza desde el atributo "desde" y termina en el atributo "hasta"
		for(int i=desde; i<=hasta; i++) {
			try {
				//Se crea el socket cliente con el atributo host y el puerto cuyo valor es la i del bucle
				cliente = new Socket(host, i);
				
				//Impresion del mensaje cuando el puerto est� abierto y se puede acceder a �l.
				System.out.println("Conexi�n establecida en el puerto " + i + " - Puerto abierto");
				cliente.close();
			} catch (BindException e) {
				//error cuando se intenta iniciar el servidor en un puerto ya en uso
				System.out.println("El puerto ya est� en uso");
			}catch (UnknownHostException e) {
				//Cuando no se encuentra conexi�n al host facilitado
				System.out.println("No se encuentra la conexi�n al host.");
			} catch (ConnectException e) {
				//Mensaje cuando se rechaza la conexi�n al puerto indicado.
				System.out.println("Conexi�n no establecida en el puerto " + i + " - Puerto cerrado");
			} catch (NoRouteToHostException e) {
				//Mensaje cuando el tiempo de conexi�n ha expirado.
				System.out.println("El tiempo de establecimiento de la conexi�n ha expirado");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
