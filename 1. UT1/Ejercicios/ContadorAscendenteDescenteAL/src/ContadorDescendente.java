
/**
 *  Hilo que cuenta hacia abajo  
 */
public class ContadorDescendente extends Thread
{
    private int desde;

    /**
     * Constructor  
     * @param desde inicio de la cuenta
     */
    public ContadorDescendente(int desde)
    {
        this.desde = desde;
    }

    /**
     *  
     *  Código a ejecutar por el hilo
     *  Cuenta de forma descendente  y escribe cada valor del contador junto con el nombre del hilo
     * 
     */
    public void run()
    {

    	for (int i = 0; i<= this.desde; i++) {
    		System.out.println(this.getName() + " " + i);
    		Thread.yield();
    	}
    	
    }
}
