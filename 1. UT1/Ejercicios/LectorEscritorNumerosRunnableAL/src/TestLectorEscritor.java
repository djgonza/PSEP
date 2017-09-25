
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
    	EscritorNumeros cervantes = new EscritorNumeros();
        cervantes.run();
        
        LectorNumeros lecto = new LectorNumeros("numeros.txt");
        lecto.run();          
        
    }
}
