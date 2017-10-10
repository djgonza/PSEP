/**
 * Hilo simple con una clase anÃ³nima
 */
public class EjemploHiloAnonima 
{
    public static void main(String[] args)
    {
        // crea el hilo como clase anÃ³nima - dentro del mÃ©todo run() el hilo 
        // esribe dies nÃºmeros en la misma lÃ­nea y luego muestra las propiedades del hilo
        //  nombre del hilo, prioridad, id del hilo, estado, si estÃ¡ vivo, si es un demonio
         // a completar
    	
    	//Se crear la clase anónima SegundoHilo e implementa la interface Runnable
    	Thread segundoHilo =  new Thread( new Runnable  () {
        	
    		//El método run escribe números de 1 al 10
    		//También se encarga de mostrar información del hilo.
    		public void run() {
        		for (int i = 1; i<= 10; i++){
        			System.out.print(i + " ");
        		}
        		System.out.println("");
        		Thread t = Thread.currentThread ();
        		//Muestra el nombre del hilo
        		System.out.println("Nombre: "+t.getName());        		
        		//Muestra la prioridad del hilo
                System.out.println("Prioridad: "+t.getPriority());
                //Muestra el id asignado la hilo
                System.out.println("Id: "+t.getId());
                //Nos muestra si el hilo está vivo o no
                System.out.println("Esta vivo: "+t.isAlive());
                //Nos muestra si es dominio o no
                System.out.println("Es dominio: "+t.isDaemon());
                System.out.println("Fin de run alcanzado en segundo hilo");
        	}
        });
        
         
        
        //Mostramos los datos del hilo MAIN
        //Utiliza los mismos meteodos explicados anteriormente.
        Thread t = Thread.currentThread ();        
        System.out.println("Propiedades del hilo MAIN.");
        System.out.println("Nombre: "+t.getName());
        System.out.println("Prioridad: "+t.getPriority());
        System.out.println("Id: "+t.getId());
        System.out.println("Esta vivo: "+t.isAlive());
        System.out.println("Es dominio: "+t.isDaemon());  

        if(!segundoHilo.isAlive())
        {
            System.out.println("Segundo hilo todavía no vivo.");
        }
        // Ahora inicia segundoHilo
         // a completar
        
        segundoHilo.start();
        
        if(segundoHilo.isAlive())
        {
            System.out.println("Segundo hilo ahora vivo.");
        }
        // Ceder control al segundo hilo
        Thread.yield();
        if(!segundoHilo.isAlive())
        {
            System.out.println("Segundo hilo ya no estÃ¡ vivo.");
        }
        // Ahora vamos  a escribir las propiedades del main
        // nombre del hilo, prioridad, id del hilo, estado, si estÃ¡ vivo, si es un demonio
       
        // a completar
        System.out.println("Primer hilo - MAIN - finalizado");
    }
}

