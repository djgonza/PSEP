
/**
 * El hilo main crea los dos hilos, uno que cuenta hacia arriba y otro hacia abajo
 * Después el hilo main() muestra  un mensaje indicando que ha terminado
 *    
 */
public class AppMain
{

    /**
     *  El contador ascendente cuenta hasta 10 y el descendente desde 8
     *  
     */
    public static void main(String[] args)
    {
         
        ContadorAscendente ca = new ContadorAscendente(10);
        ca.start();
        
        ContadorDescendente cd = new ContadorDescendente(8);
        cd.start();
        
    }
}
