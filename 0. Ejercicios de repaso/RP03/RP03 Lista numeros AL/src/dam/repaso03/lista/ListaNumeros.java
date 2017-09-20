package dam.repaso03.lista;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Modela una lista de números no repetidos sobre la que
 * se pueden añadir nºs, mostrar la lista.
 */
public class ListaNumeros
{

    private List<Integer> lista;

    /**
     * Constructor  
     */
    public ListaNumeros()
    {
        lista = new ArrayList<Integer>();
    }

    /**
     *  Se añade solo si no está el núemro ya en la lista
     */
    public void add(int n)
    {
        if (!lista.contains(n))
            lista.add(n);
    }

    /**
     *  devuelve la cantidad de nºs en la lista
     * 
     */
    public int totalNumeros()
    { 
        return lista.size();
    }

    /**
     *  devuelve la suma de los nºs de la lista
     * 
     */
    public int sumar()
    { 
        int suma = 0;
        int i = 0;
        while (i < lista.size())
        {
            suma += lista.get(i);
            i++;
        }
        return suma;
    }

    /**
     *  guarda los números en un fichero (flujo) binario
     *  Se capturan las excepciones
     * 
     */
    public void guardarEnFichero(String nombre)
    { 
        
            DataOutputStream dout = null;
			try {
				dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nombre)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            for (Integer n: lista)
            {
                try {
					dout.writeInt(n);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            try {
				dout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }

    /**
     *  lee los números de un fichero (flujo)  binario
     *  y los guarda en la lista
     *  Se capturan las excepciones
     * 
     */
    public void leerDeFichero(String nombre)
    { 
        DataInputStream din = null;
        try
        {
            din = new DataInputStream(new BufferedInputStream(new FileInputStream(nombre)));
            boolean terminado = false;
            while (!terminado)
            {
                int n = din.readInt();
                lista.add(n);

            }

        }
        catch (EOFException ex)
        {
                System.out.println("Fin del fichero");
                try 
                {
                    din.close();
                } 
                catch (IOException ignored)
                {
                }
            
        }
        catch (IOException ex)
        {
            System.out.println("Error en operación de E/S" + ex.getMessage());
        }

    }
    /**
     *  Representación textual de la lista
     * 
     */
    public String toString()
    { 
        StringBuilder sb = new StringBuilder("Lista ");
        for (Integer n: lista)
        {
            sb.append(n + " ");
        }
        return sb.toString();
    }

}
