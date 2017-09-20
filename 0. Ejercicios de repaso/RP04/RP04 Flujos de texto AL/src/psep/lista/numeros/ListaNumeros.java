package psep.lista.numeros;
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
 *  lista de números enteros
 *  
 */
public class ListaNumeros
{
    // define la colección
    private ArrayList<Integer> lista;

    /**
     * Constructor  - instancia la colección
     */
    public ListaNumeros()
    {
        lista = new ArrayList<Integer>();
    }

    /**
     *  añade un número a la colección
     */
    public void add(int numero)
    {
        lista.add(numero);
    }

    /**
     * borrar todos los elementos de la lista, dejadla vacía
     */
    public void borrarLista()
    {
        lista.clear();
    }

    /**
     *  Crea un fichero de texto  cuyo nombre se
     *  pasa como argumento
     *  Para crear el fichero recorreremos la colección y
     *  guardaremos cada nº de la lista en el fichero 
     *  
     *  
     *  
     *  Captura las excepciones que se puedan producir
     */
    public void salvarEnFicheroDeTexto(String nombre) 
    {
        try
        {
            File f = new File(nombre);
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            // a completar
            
            
            
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    /**
     *  lee de un fichero de texto cuyo nombre se pasa
     *  como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     *  Se usa la clase BufferedReader
     *  Al acabar se cierra el fichero
     *  
     *   
     *  
     *  Captura las excepciones que se puedan producir
     */
    public void leerFicheroDeTextoConBufferedReader(String nombre)  
    {
         
        try
        {
            File f = new File(nombre);
            BufferedReader entrada = new BufferedReader(new FileReader(f));
            // a completar
            
            
            
            
            
            

        }
        catch (IOException e)
        {
             e.printStackTrace();
           

        }
    }
    
    /**
     *  lee de un fichero de texto cuyo nombre se pasa
     *  como argumento una serie de nºs enteros y cada nº lo guarda en la lista.
     *  Se usa la clase Scanner
     *  Al acabar se cierra el fichero
     *  
     *   
     *  
     *  Captura las excepciones que se puedan producir
     */
    public void leerFicheroDeTextoConScanner(String nombre)  
    {
         
        try
        {
            File f = new File(nombre);
            Scanner entrada = new Scanner(f);
             
            
            
            
            
            

        }
        catch (IOException e)
        {
             e.printStackTrace();
           

        }
    }
    
    
    /**
     * Representación textual de la colección
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Lista:  ");
        for (Integer n : lista)
        {
            sb.append(n + " ");
        }
        return sb.toString();
    }

    /**
     * Muestra la lista en pantalla
     */
    public void mostrarLista()
    {
        System.out.println(this.toString());
    }

}
