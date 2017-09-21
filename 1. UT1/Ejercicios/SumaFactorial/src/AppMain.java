
public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if (args.length == 0) {
			System.out.println("Faltan argumentos");
		}else {
			Thread sm = new Suma(Integer.parseInt(args[0]));
	        sm.start();
	        
	        Thread fc = new Factorial(Integer.parseInt(args[0]));
	        fc.start();
	        System.out.println("Fin del hilo main");
	        
		}
		
		
		

	}

}
