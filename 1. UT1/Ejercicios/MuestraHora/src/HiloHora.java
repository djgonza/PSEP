
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloHora extends Thread{
			
	public void run() {		
		
		for(int i=0;i <=5; i++) {			
			
			try {
				String cadena = "";
				cadena += "Mensaje nº: ";
				cadena += i;
				cadena += " Nombre: ";
				cadena += this.currentThread();
				cadena += " Hora: ";
				DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				Date date = new Date();
				cadena += dateFormat.format(date);
						
				System.out.println(cadena + " Fin!");				
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
