package psep.lista.palabras;

import java.io.IOException;

/**
 *  Esta clase nos servirá para probar 
 *  los métodos de la clase ListaPalabras
 */
public class AppListaPalabras
{

    /**
     * @throws IOException 
     *  
     *  
     */
    public static void main(String[] args) throws IOException
    {
        // define y crea un objeto lista
        ListaPalabras lista = new ListaPalabras();
        
        
        // lee desde el fichero de texto la lista y la muestra en pantalla
        lista.leerFicheroDeTextoConScanner("palabras.txt");
        System.out.println("Lista leída de fichero texto con Scanner");
        lista.mostrarLista();
        lista.leerFicheroDeTextoConBufferedReader("palabras.txt");
        System.out.println("Lista leída de fichero texto con BufferedReader");
        lista.mostrarLista();
        lista.guardarEnFicheroTexto(args[0]);

    }
}
