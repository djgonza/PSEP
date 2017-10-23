/**
 *  El hilo que saca cantidades de la cuenta
 *  despuéss de cada reintegro el hilo duerme TIEMPO
 */
class HiloReintegro extends Thread 
{
    private CuentaBancaria cuenta;
    private double cantidad;

    private static final int REINTEGROS = 10;  // nº reintegros que hace el hilo
    private static final int TIEMPO = 100;  // tiempo que dormirá el hilo

    /**

     */
    public HiloReintegro(CuentaBancaria cuenta, double cantidad)
    {
        this.cuenta = cuenta;
        this.cantidad =  cantidad;
    }

    public void run()
    {
    	for(int i = 0; i < REINTEGROS;i++){
    		//Reintegrar la cantidad en la cuenta
    		cuenta.reintegrar(cantidad);
    		try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}
