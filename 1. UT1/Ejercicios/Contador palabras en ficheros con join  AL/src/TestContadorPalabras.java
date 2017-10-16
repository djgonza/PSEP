/**
 * Se crean objetos ContadorPalabras para contar las palabras en un fichero
 * Un hilo por cada fichero 
 * Despu√©s de que finaliza el √∫ltimo hilo  se escribe el total de palabras entre todos los ficheros
 * 
 *Ej - java TestContadorPalabras fichero1.txt fichero2.txt  fichero3.txt
 */
public class TestContadorPalabras
{

    public static void main(String args[])
    {
        // comprobar que el n∫ de arguemntos es correcto
    	if (args.length == 0) { //si no hay par·metros
            System.out.println("Error en argumentos");
            System.out.println("Sintaxis: java TestContadorPalabras nombre1 nombre2 ........");
        }     	
    	else {
    		// definir un array de tipo ContadorPalabras con tantos elementos como nombres de fichero se hayan pasado
        	ContadorPalabras[] contadorcete = new ContadorPalabras[args.length];    	
        	        
            // con un bucle recoger los nombres de ficheros desde l√≠nea de comandos y crear e
            // iniciar los hilos
            
        	for(int i = 0; i < contadorcete.length;i++){
        		contadorcete[i] = new ContadorPalabras(args[i]);
        		contadorcete[i].start();
        	}
            
            // con un bucle recorre el array de hilos anterior e indicar que
            // el main espere a que todos acaben
        	for(int i = 0; i < contadorcete.length;i++){
        		try {
    				contadorcete[i].join();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}
            // con un bucle calcular el total de palabras contadas entre todos los hilos
            int total = 0;
            for(int i = 0; i < contadorcete.length;i++){
            	ContadorPalabras conta = contadorcete[i];
            	total += conta.getTotalPalabras();
            }
        	
            System.out.println("Total palabras en todos los ficheros: " + total);
    	}
    	
    }
}
