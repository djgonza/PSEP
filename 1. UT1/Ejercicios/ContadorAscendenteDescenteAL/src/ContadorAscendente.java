
/**
 *  Hilo que cuenta hacia arriba  
 */
public class ContadorAscendente extends Thread
{
    private int hasta;

    /**
     * Constructor  
     * @param hasta límite de la cuenta
     */
    public ContadorAscendente(int hasta)
    {
    	this.hasta = hasta;
    }

    /**
     *  
     *  Código a ejecutar por el hilo
     *  Cuenta de forma ascendente  y escribe cada valor del contador junto con el nombre del hilo
     * 
     */
    public void run()
    {
    	
    	for (int i = 0; i<= this.hasta; i++) {
    		System.out.println(this.getName() + " " + i);
    		Thread.yield();
    	}
        
    }
}
