import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Recurso compartido - Debe utilizarse en exclusi�n mutua. Los hilos
 * consumidores acceder�n a �l para tomar un elemento, el hilo productor para
 * a�adir un elemento
 * 
 */
public class Buffer
{
	private final int TAM = 10; // el tama�o m�ximo de la lista, el n� m�ximo de
	// elementos que se podr�n a�adir a ella
	private List<Integer> lista;

	public Buffer()
	{
		lista = new ArrayList<Integer>();
	}

	/**
	 * 
	 * a�adir un valor a la lista
	 * si la lista est� llena el productor  deber� esperar
	 * Despu�s de a�adir un valor se escribe el nombre del hilo y el valor a�adido
	 * y se avisa a los hilos que est�n esperando
	 * @throws InterruptedException 
	 */
	public synchronized void insertar(int valor) throws InterruptedException
	{
		//si la lista est� llena el productor  deber� esperar 
		while(lista.size() == TAM)
			 wait();
		
		//A�adir valor a la lista
		lista.add(valor);
		
		//Mensaje
		System.out.println(Thread.currentThread().getName() + " A�adido valor " + valor);
		
		//Notificar al resto de hilos
		notifyAll();	
	}

	/**
	 * 
	 * borrar un valor de la lista (siempre el primero)
	 * si la lista est� vac�a el consumidor deber� esperar
	 * Despu�s de borrar un valor se escribe el nombre del hilo y el valor borrado
	 * y se avisa a los hilos que est�n esperando
	 * @throws InterruptedException 
	 */
	public synchronized void borrar() throws InterruptedException
	{
		//si la lista est� vacia el productor  deber� esperar 
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
