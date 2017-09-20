package psep.lista.palabras;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
 
import java.io.IOException;
/**
 *  La clase guarda en una colección ArrayList una
 *  lista de palabras
 *  
 */
public class ListaPalabras
{
    // define la colección
    private ArrayList<String> lista;

    /**
     * Constructor  - instancia la colección
     */
    public ListaPalabras()
    {
        lista = new ArrayList<String>();
    }

    /**
     *  añade un número a la colección
     */
    public void add(String palabra)
    {
        lista.add(palabra);
    }

    /**
     * borrar todos los elementos de la lista, dejadla vacía
     */
    public void borrarLista()
    {
        lista.clear();
    }

    

    /**
     *  lee de un fichero de texto cuyo nombre se pasa
     *  como argumento una serie de palabras
     *  Usa como ayuda el método parsearLinea()   
     *  
     *  Captura las excepciones que se puedan producir
     */
    public void leerFicheroDeTextoConScanner(String nombre) throws IOException  
    {
         
        File f = new File(nombre);
        Scanner sc =  new Scanner(f);
        while (sc.hasNext()) {
            this.parsearLinea(sc.next());
        }
        
    }
    
    /**
     * Parsea la línea recibida extrayendo cada palabra y añadiéndola a la lista
     * @param linea
     */
    private  void parsearLinea(String linea)
    {
        String[] palabras = linea.split(":");
        for (String palabra : palabras) {
            this.add(palabra);
        }
    }
    

    /**
     *  lee de un fichero de texto cuyo nombre se pasa
     *  como argumento una serie de palabras y las añade a la lista
     *  Usa como ayuda el método parseraLinea()     *   
     *  
     *  Captura las excepciones que se puedan producir
     */
    public void leerFicheroDeTextoConBufferedReader(String nombre) throws IOException  
    {
         
        FileReader f = new FileReader(nombre);
        BufferedReader br = new BufferedReader(f);
        String line;
        while ((line = br.readLine()) != null) { // while loop begins here
            this.parsearLinea(line);
        }
        
    }
    
    /**
     * Representación textual de la colección
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Lista: ");
        for (String palabra : lista)
        {
            sb.append(palabra + " ");
        }
        return sb.append("\n").toString();
    }

    /**
     * Muestra la lista en pantalla
     */
    public void mostrarLista()
    {
        System.out.println(this.toString());
    }
    
    public void guardarEnFicheroTexto(String nombre) throws IOException {
            
            FileWriter file = new FileWriter("resultado.txt");
            file.write(nombre);
            file.close();
        
    }

}
