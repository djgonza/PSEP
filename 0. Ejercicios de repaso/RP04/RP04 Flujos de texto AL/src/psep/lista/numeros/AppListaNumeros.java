package psep.lista.numeros;

/**
 *  Esta clase nos servirá para probar 
 *  los métodos de la clase ListaNumeros
 */
public class AppListaNumeros
{

    /**
     *  
     *  
     */
    public static void main(String[] args)
    {
        // define y crea un objeto lista
        ListaNumeros lista = new ListaNumeros();

        // añade varios números a la lista y muestra la lista
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        System.out.println("Mostrar la lista antes de leer del fichero");
        lista.mostrarLista();
        // guarda la lista en el fichero "numeros.txt"
        lista.salvarEnFicheroDeTexto("numeros.txt");
        
        // vacía la lista
        lista.borrarLista();
        // lee desde el fichero otra vez sobre la lista y
        // muestra la lista
        lista.leerFicheroDeTextoConBufferedReader("numeros.txt");
        System.out.println("Mostrar la lista después de leer del fichero de texto con BufferedReader");
        lista.mostrarLista();
         
        lista.borrarLista();
        lista.leerFicheroDeTextoConScanner("numeros.txt");
        System.out.println("Mostrar la lista después de leer del fichero de texto con Scanner");
        lista.mostrarLista();
         
        

    }
}
