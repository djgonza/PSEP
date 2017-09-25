
/**
 * 
 * 
 * @author  
 * @version  
 */
public class TestLectorEscritor
{

    /**
     *  Lanza a ejecución los dos hilos y muestra el mensaje de final del hilo main
     *  
     */
    public static void main(String[] args)
    {
    	Thread cervantes = new Thread(new EscritorNumeros());
        cervantes.start();
        
        Thread lecto = new Thread(new LectorNumeros("numeros.txt"));
        lecto.start();          
        
    }
}
