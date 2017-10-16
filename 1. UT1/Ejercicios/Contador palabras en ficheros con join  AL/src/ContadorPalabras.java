import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 
public class ContadorPalabras extends Thread
{
     private String nombreFichero;
     private int totalPalabras;  // el total de palabras contadas
     
   /**
    *  @param nombreFichero  el nombre del fichero del que contar
   */
   public ContadorPalabras(String nombreFichero)
   {
      this.nombreFichero = nombreFichero;
      totalPalabras = 0;
   }

   /**
    * se cuentan las palabras del fichero con Scanner
    */
   public void run()
   {
	   //Creamos un objeto de la clase File con el nombre del archivo que se le pasa como argumento en el constructor
	   File fil = new File(nombreFichero);	  
	   try {
		   //Creamos un obejto de la clase Scanner con el objeto de la clase File creado anteriormente
		   Scanner sc = new Scanner(fil);
		   //Nos permite ir leyendo linea a linea hasta el final del documento.
		   while(sc.hasNextLine()) {
			   //Con este paso contamos las palabras que hay en la linea creando un array a partir de split. Por ultimo ponemos length para saber la longitud del array generado.
			   totalPalabras += sc.nextLine().split(" ").length;
		   } 
		   
		   System.out.println("Fin del hilo => " + Thread.currentThread().getName() + " => Palabras en fichero " + nombreFichero + ": " + getTotalPalabras());
		   sc.close();
	   } catch (FileNotFoundException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }  
   }

   /**
    * acesor para el total de palabras contadas
    */
   public int getTotalPalabras()
   {
       return totalPalabras;
   }
}
