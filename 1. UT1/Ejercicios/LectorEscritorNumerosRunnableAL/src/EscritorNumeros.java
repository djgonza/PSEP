import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Tarea que implementa Runnable - escribe números aleatorios (entre 1 y 100)
 * en el fichero de texto "salida.txt", un nº en cada línea
 * 
 */
public class EscritorNumeros implements Runnable {

	/**
	 * Constructor
	 */
	public EscritorNumeros() {

	}

	/**
	 * La tarea que se ejecuta de forma concurrente Se capturan las excepciones de
	 * entrada salida Después de escribir un nº el hilo duerme 300 milisegundos
	 * 
	 * Al terminar muestra un mensaje indicando el final del hilo
	 */
	public void run() {
		for (int i = 0; i <= 10; i++) {
			int num = (int) (Math.random() * 100) + 1;
			try {
				FileWriter fw = new FileWriter("numeros.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(num +"");
				bw.newLine();
				System.out.println("N�mero escrito: " + num);
				Thread.sleep(300);
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Fin del hilo escritor");		
	}
}
