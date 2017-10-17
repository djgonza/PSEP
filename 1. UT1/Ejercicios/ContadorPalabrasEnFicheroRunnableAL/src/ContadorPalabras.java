import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tarea que cuenta las palabras que hay en el fichero de texto xuyo nobre se
 * pasa como parámetro al constructor
 */
public class ContadorPalabras implements Runnable {
	private String nombreFichero;

	/**
	 * @param nombreFichero
	 *            el nombre del fichero a contar
	 */
	public ContadorPalabras(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}

	/**
	 * tarea que se ejecuta de forma concurrente La lectura del fichero se hace con
	 * Scanner Al terminar el hilo se muestra el nombre del fichero y total de
	 * palabras contadas
	 */
	public void run() {

		try {
			Integer totalPalabras = 0;
			Scanner sc = new Scanner(new File(this.nombreFichero));
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				totalPalabras += linea.split(" ").length;
			}
			sc.close();
			System.out.println("Fichero "+this.nombreFichero+": "+totalPalabras);
			Thread.yield();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
