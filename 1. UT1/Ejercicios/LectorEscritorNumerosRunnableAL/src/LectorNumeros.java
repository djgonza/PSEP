import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class LectorNumeros extends Thread implements Runnable  {

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
		Scanner sc = new Scanner(this.nombre);

		while (sc.hasNextLine()) {
			this.total += 1;
			System.out.println(sc.nextLine());
			int num = Integer.parseInt(sc.nextLine());
			this.suma += num;
			System.out.println("N�mero le�do: " + num);
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		System.out.println("Total N�meros leidos: " + this.total + " Suma:" + this.suma);
		System.out.println("Fin del hilo lector");
		sc.close();
	}
}
