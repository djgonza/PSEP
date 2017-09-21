
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloHora extends Thread{
			
	public void run() {
		
		
		
		for(int i=0;i <=5; i++) {			
			
			try {
				System.out.print("Mensaje nº: ");
				System.out.print(i);
				System.out.print(" Nombre: ");
				System.out.print(this.currentThread());
				System.out.print(" Hora: ");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				System.out.print(dateFormat.format(date));
				System.out.println();
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
