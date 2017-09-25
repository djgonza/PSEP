import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Tarea que implementa Runnable para leer números enteros desde un fichero de
 * texto cuyo nombre se pasa al constructor Cada línea del fichero contiene un
 * solo número.
 * 
 * Al terminar muestra el total de números leídos y su suma
 * 
 * Lee el fichero con BufferedReader ...
 */
public class LectorNumeros implements Runnable {

	private String nombre; // el nombre del fichero
	private int total = 0;
	private int suma = 0;

	/**
	 * Constructor
	 */
	public LectorNumeros(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * La tarea que se ejecuta de forma concurrente Se capturan las excepciones de
	 * entrada salida y las de conversión de formato Al terminar muestra un mensaje
	 * indicando el final del hilo Después de tratar un nº y antes de leer el
	 * siguiente el hilo duerme 300 milisegundos
	 */
	public void run() {

		try {
			FileReader fr = new FileReader(this.nombre);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				this.total += 1;
				int num = Integer.parseInt(linea);
				this.suma += num;
				linea = br.readLine();
				System.out.println("N�mero leido: " + num);
				Thread.sleep(300);

			}
			br.close();
			System.out.println("Total N�meros leidos: " + this.total + " Suma:" + this.suma);
			System.out.println("Fin del hilo lector");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
