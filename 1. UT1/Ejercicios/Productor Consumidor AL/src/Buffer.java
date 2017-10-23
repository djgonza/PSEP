import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Recurso compartido - Debe utilizarse en exclusión mutua. Los hilos
 * consumidores accederán a él para tomar un elemento, el hilo productor para
 * añadir un elemento
 * 
 */
public class Buffer
{
	private final int TAM = 10; // el tamaño máximo de la lista, el nº máximo de
	// elementos que se podrán añadir a ella
	private List<Integer> lista;

	public Buffer()
	{
		lista = new ArrayList<Integer>();
	}

	/**
	 * 
	 * añadir un valor a la lista
	 * si la lista está llena el productor  deberá esperar
	 * Después de añadir un valor se escribe el nombre del hilo y el valor añadido
	 * y se avisa a los hilos que están esperando
	 * @throws InterruptedException 
	 */
	public synchronized void insertar(int valor) throws InterruptedException
	{
		//si la lista está llena el productor  deberá esperar 
		while(lista.size() == TAM)
			 wait();
		
		//Añadir valor a la lista
		lista.add(valor);
		
		//Mensaje
		System.out.println(Thread.currentThread().getName() + " Añadido valor " + valor);
		
		//Notificar al resto de hilos
		notifyAll();	
	}

	/**
	 * 
	 * borrar un valor de la lista (siempre el primero)
	 * si la lista está vacía el consumidor deberá esperar
	 * Después de borrar un valor se escribe el nombre del hilo y el valor borrado
	 * y se avisa a los hilos que están esperando
	 * @throws InterruptedException 
	 */
	public synchronized void borrar() throws InterruptedException
	{
		//si la lista está vacia el productor  deberá esperar 
		while(lista.size() == 0)
			 wait();
		
		//Obtener el primer valor de la lista
		int valor = lista.get(0);
		
		//Borrar primer valor de la lista
		lista.remove(0);
		
		//Mensaje
		System.out.println(Thread.currentThread().getName() + " Consumido valor " + valor);
		
		//Notificar al resto de hilos
		notifyAll();
	}

}
