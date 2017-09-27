/**
 * Se crean objetos ContadorPalabras para contar las palabras en un fichero Un
 * hilo por cada fichero
 * 
 * Lanza tres hilos de ejecución para contar las palabars de 3 ficheros de texto
 * recorre los argumentos del main con un for
 * 
 * Ej - java ContadorPalabras fichero1.txt fichero2.txt fichero3.txt
 */
public class TestContadorPalabras {

	public static void main(String args[]) {

		// Creamos los objetos que representas los hilos
		Thread trUno = new Thread(new ContadorPalabras("fichero1.txt"));
		Thread trDos = new Thread(new ContadorPalabras("fichero2.txt"));
		Thread trTres = new Thread(new ContadorPalabras("fichero3.txt"));

		// Iniciamos los hilos
		trUno.start();
		trDos.start();
		trTres.start();

		// Mostramos el fin del hilo principal
		System.out.println("Fin del hilo main");

	}
}
