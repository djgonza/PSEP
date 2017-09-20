package psep.repaso2.test;

import psep.repaso2.modelo.SaludoModulo;

public class AppSaludo
{

	/**
	 *  
	 */
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Error en argumentos, Usage: java AppSaludo <nombre>  <horas>");
			return ;
		}
		String nombre = args[0];
		int horas = Integer.parseInt(args[1]);
		SaludoModulo s = new SaludoModulo(nombre, horas);
		System.out.println(s.toString());
	}

}
