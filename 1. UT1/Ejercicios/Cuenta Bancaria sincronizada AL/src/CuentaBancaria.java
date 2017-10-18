/**
   Cuenta bancaria con un balance que puede ser modificado
   con ingresos  - el recurso que se comparte
*/
public class CuentaBancaria
{
     private double balance;
     
   /**
      Construct   
   */
   public CuentaBancaria()
   {
      balance = 0;
   }

   /**
      depositar dinero en la cuenta
      @param cantidad la cantidad a ingresar
      
   */
   public synchronized void  depositar(double cantidad)
   {
      //Al principio no estaba synchronized y lo hace mal. 
	   System.out.println("Depositando " + cantidad);
      double nuevoBalance = balance + cantidad;
      System.out.println(", nuevo balance es " + nuevoBalance);
      balance = nuevoBalance;
   }
   
     
   /**
      
      @return el balance actual de la cuenta
   */
   public double  getBalance()
   {
      return balance;
   }
   
  
}