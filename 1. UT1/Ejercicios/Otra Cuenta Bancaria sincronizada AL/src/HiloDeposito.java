/**
 *  El hilo que hace ingresos peri�dicos en la cuenta
 *  el hilo duerme TIEMPO despu�s de cada ingreso
 */
public class HiloDeposito extends Thread  
{
    private CuentaBancaria cuenta;
    private double cantidad;

    private static final int INGRESOS = 10;  // n� ingresos que hace el hilo
    private static final int TIEMPO = 1000;  // tiempo que dormir� el hilo

    /**

     */
    public HiloDeposito(CuentaBancaria cuenta, double cantidad)
    {
        this.cuenta = cuenta;
        this.cantidad =  cantidad;
    }

    public void run()
    {
    	for(int i = 0; i < INGRESOS;i++){
    		//Depositar la cantidad en la cuenta
    		cuenta.depositar(cantidad);
    		try {
				Thread.sleep(TIEMPO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}

 