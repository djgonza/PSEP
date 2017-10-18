/**
 *  Una tarea que hace depósitos periódicos en la cuenta
 *  después de cada ingreso el hilo duerme TIEMPO
 */
class TareaDeposito implements Runnable 
{
    private CuentaBancaria cuenta;
    private double cantidad;

    private static final int INGRESOS = 10;  // nº ingresos que hace el hilo
    private static final int TIEMPO = 1000;  // tiempo que dormirá el hilo

    /**

     */
    public TareaDeposito(CuentaBancaria cuenta, double cantidad)
    {
         this.cuenta = cuenta;
         this.cantidad = cantidad;
    }

    public void run()
    {    	
    	try {    		
    		// n� de ingresos que hace el hilo
    		for(int i = 0; i < INGRESOS; i++) {
    			//Se realiza el dep�sito
        		this.cuenta.depositar(cantidad);
    		}    		
    		//Se deja dormir el hilo
			Thread.sleep(TIEMPO);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

 