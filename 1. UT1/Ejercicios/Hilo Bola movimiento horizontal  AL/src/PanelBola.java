import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelBola extends JPanel implements Runnable
{
	private final static int ANCHO = 400; // ancho del panel
	private final static int ALTO = 300; // alto del panel
	private final static int DELAY = 100;
											// genera un evento ActionEvent
	private final static int POSX1 = 350; // posiciï¿½n x de la lï¿½nea 1 (la
											// vertical)
	private final static int POSY1 = 0; // posiciï¿½n y de la lï¿½nea 1 (la
										// vertical)
	private final static int POSX2 = 0; // posiciï¿½n x de la lï¿½nea 1 (la
										// horizontal)
	private final static int POSY2 = 250; // posiciï¿½n y de la lï¿½nea 1 (la
											// horizontal)
	private final static int DIAMETRO = 30;
	
	private int x; // coordenada x de la bola
	private int y; // coordenada y de la bola

	private Timer timer;

	private boolean derecha; // indica si la bola va hacia la derecha o hacia la
								// izquierda
	private Thread hilo;
	/**
	 * Constructor
	 */
	public PanelBola()
	{
		//Se establece el color del BackGround
		this.setBackground(Color.black);
		
		// establecer tamaï¿½o del panel
		this.setPreferredSize(new Dimension(ANCHO, ALTO));
		
		// establecer posiciï¿½n inicial de la bola, crear e iniciar el timer
		x = POSX2;
		y = POSY2 - DIAMETRO;
		
		// la bola al principio va hacia la derecha		
		this.derecha = true;

		// Creamos un nuevo hilo pasandole como argumento el mismo ya que implementa Runnable y lo
		// iniciamos.
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	/**
     *   
     *       
     */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// dibujar la lï¿½nea vertical y la horizontal en color verde
		//Vertical
		g.setColor(Color.green);
		g.drawLine(POSX1, POSY1, POSX1, ALTO);
		
		//Horizontal
		g.drawLine(POSX2, POSY2, ANCHO, POSY2);
		//g.setColor(Color.green);
		
		// dibujar la bola de color rojo		
		g.setColor(Color.red);
		g.fillOval(this.x, this.y, DIAMETRO, DIAMETRO);

	}
	

	/**
	 * mï¿½todo privado de ayuda que modifica las coordenadas de la bola
	 * dependiendo de si va hacia la derecha o izquierda
	 */
	private void actualizar()
	{
		if(derecha) {
			x += 5;
			if(x == POSX1 - DIAMETRO) 
				derecha = false;						
		}
		else {
			x -= 5;
			if(x == POSX2) 
				derecha = true;
		}
			
	}

	/**
	 * Dentro del método run() se implementará el bucle de animación en el que se actualizará
	 * las coordenadas de la bola adecuadamente teniendo en cuenta que:
		➢ si va hacia la derecha la coordenada x se incrementa en 5. El tope lo marca la línea vertical. Si la bola toca esta línea cambiará de dirección
		➢ si va hacia la izquierda x se decrementa en 5. El tope lo marca el borde izquierdo del panel. Si la bola lo toca cambia otra vez de dirección
		➢ para saber la dirección de la bola utiliza una variable booleana direccion
		➢ usa los métodos privados actualizar() y pausa()
	 */
	public void run() {
		// TODO Auto-generated method stub		
		while(true){
			actualizar();
			pausa();
			repaint();	
		}
	}
	
	/**
	 * Dormir el hilo los msg indicados por la constante DELAY
	 */
	private void pausa() {
		//Dormir el hilo durante X minutos.
		try {
			hilo.sleep(DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
