package dam.repaso03.lista;

import java.io.File;
/**
 * La demo permite añadir nºs a la lista o mostrar la lista.
 * Se elige a través de un comando introducido en la línea de comandos
 * 
 * Usage: java DemoLista INSERTAR 3  4 55  4  2  6 ...
 * Usage: java DemoLista SUMAR
 */
public class DemoLista
{

    /**
     *  Comprobamos únicamente que el nº de argumentos no sea cero
     *  Si es correcto:
     *      - creamos un objeto ListaNumeros
     *      - si existe el fichero numeros.dat lo leemos y cargamos sobre la lista
     *      - analizamos el argumento del main
     *        . si es SUMAR mostramos la suma de los números de la lista
     *        . si es INSERTAR  recogemos el resto de argumentos, los añadimos a la lista y guardamos
     *        la lista en el fichero
     *        . si no es ninguno de los dos anteriores escribimos "comando desconocido"
     */
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            System.out.println("Error en nº de argumentos\n Usage: java DemoLista INSERTAR <n1> <n2> ....\n " +
                "Usage: java DemoLista SUMAR");
            return;
        }
        ListaNumeros lista = new ListaNumeros();
        File f = new File("numeros.dat");
        if (f.exists())
            lista.leerDeFichero("numeros.dat");
            
        String comando = args[0];
        if (comando.equalsIgnoreCase("SUMAR"))
        {
            System.out.println("La suma es " + lista.sumar());
        }
        else if (comando.equalsIgnoreCase("INSERTAR"))
        {
           // a completar
        	for (int i = 1; i < args.length; i++) {
				lista.add(Integer.parseInt(args[i]));
			}
        	lista.guardarEnFichero("numeros.dat");

        }
        else
        {
            System.out.println("Comando desconocido");
        }

    }
}
