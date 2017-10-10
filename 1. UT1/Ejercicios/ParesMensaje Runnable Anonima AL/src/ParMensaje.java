
/**
 * 2 Hilos, uno escribe  pares desde el 2 hasta el 20 y
 * otro escribe 20 veces el mensaje "Ejemplo con join()"
 *  
 */
public class ParMensaje
{

    /**
     *  
     *  
     */
    public static void main(String[] args) throws InterruptedException
    {
    	// crear un hilo que implemente Runnable con clase an√≥nima que escriba los
        // pares entre 2 y 20 junto con el nombre del hilo
        Thread hiloP = new Thread(new Runnable() {
        	public void run(){
        		Thread ct = Thread.currentThread();
        		for(int i=2;i<=20;i+=2){
        			System.out.println(ct.getName() + " -> " + i);
        			//Pasamos el control al planificador
        			ct.yield();
        		}
        		System.out.println("FIN DE HILO " + ct.getName());
        	}
        });
        
        // crear un hilo que implemente Runnable con clase an√≥nima que muestre
        // el mensaje "ejemplo con join()" 10 veces junto con el nombre del hilo 
        Thread hiloM = new Thread(new Runnable() {
        	public void run(){
        		Thread ct = Thread.currentThread();
        		for(int i=0;i<=9;i++){
        			System.out.println(ct.getName() + " ejemplo con join()");
        			//Pasamos el control al planificador
        			ct.yield();
        		}
        		System.out.println("FIN DE HILO " + ct.getName());
        	}
        });
       
        // iniciar hilos
        hiloP.start();
        hiloM.start();       
        
        // hacer que el hilo main espere a que los dos hilos anteriores terminen
        hiloP.join();
        hiloM.join(); 
        
        System.out.println("AquÌ≠ acaba el hilo main() "); 
    }
}
