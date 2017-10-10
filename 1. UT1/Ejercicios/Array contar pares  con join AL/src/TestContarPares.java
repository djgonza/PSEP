
/**
 *  Se van a utilizar 3 hilos para contar los
 *  valores pares que hay en un array de un determinado tama√±o
 *  Cada hilo cuenta los pares en una parte del array. Cuando
 *  los tres hilos terminan se muestra el total de pares que hab√≠a en al array inicial
 *  
 */
public class TestContarPares
{ 
    public static void main(String[] args) throws InterruptedException
    {
        final int MAX = 15; // el tamaÒo del array
        int[] array = new int[MAX];
        // inicializar el array con valores aleatorios entre 1 y 20 con Math.random()
        for(int i=0;i<MAX;i++) {
        	array[i] = (int) (Math.random()*20 + 1);
        }  
        // escribir el array inicial
        System.out.println("Array inicial");
        for(int i=0;i<MAX;i++) {
        	System.out.print(array[i] + " ");
        } 
        System.out.println();
        
        // crear e iniciar los tres hilos 
        
        //CREACI”N DE HILOS
        //el primer hilo los 5 primeros elementos
        TareaContarPares run1 = new TareaContarPares(array, 0, 4);
        Thread hiloOne = new Thread(run1);
        //Thread hiloOne = new Thread( new TareaContarPares(array, 0, 4));
        //Creando el hilo como en la linea aqui encima comentada, no nos permite acceder al mÈtodo getPares() que contiene la clase TareaContarPares.
                
        //el segundo hilo los 5 elementos siguientes
        TareaContarPares run2 = new TareaContarPares(array, 5, 9);
        Thread hiloTwo = new Thread(run2);
        //Thread hiloTwo = new Thread(new TareaContarPares(array, 5, 9));
        
        //el tercer hilo los 5 ˙ltimos elementos
        TareaContarPares run3 = new TareaContarPares(array, 10, 14);
        Thread hiloThree = new Thread(run3);
        //Thread hiloThree = new Thread(new TareaContarPares(array, 10, 14));
        
        //INICIO DE HILOS
        System.out.println("Iniciando los hilos");
        hiloOne.start();        
        hiloTwo.start();
        hiloThree.start();
                
        // hacer que el hilo main espere a que terminen los hilos anteriores     
        hiloOne.join();       
        hiloTwo.join();
        hiloThree.join();
        
        //Se vuelve al hilo MAIN
        System.out.println("Otra vez en el hilo main()");
        
        int total = 0;
        total = run1.getPares() + run2.getPares() + run3.getPares();
        System.out.println("Total pares en el array: " + total);
        
        System.out.println("AquÌ≠ acaba el hilo MAIN() ");    
        
    }
}