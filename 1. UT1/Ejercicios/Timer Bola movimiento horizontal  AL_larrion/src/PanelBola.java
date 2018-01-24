import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelBola extends JPanel implements ActionListener
{
	private final static int ANCHO = 400; // ancho del panel
	private final static int ALTO = 300; // alto del panel
	private final static int DELAY = 100; // retardo del timer, cada cuánto
											// genera un evento ActionEvent
	private final static int POSX1 = 350; // posici�n x de la l�nea 1 (la
											// vertical)
	private final static int POSY1 = 0; // posici�n y de la l�nea 1 (la
										// vertical)
	private final static int POSX2 = 0; // posici�n x de la l�nea 1 (la
										// horizontal)
	private final static int POSY2 = 250; // posici�n y de la l�nea 1 (la
											// horizontal)
	private final static int DIAMETRO = 30;
	private int x; // coordenada x de la bola
	private int y; // coordenada y de la bola

	private Timer timer;

	private boolean derecha; // indica si la bola va hacia la derecha o hacia la
								// izquierda

	/**
	 * Constructor
	 */
	public PanelBola()
	{
		//Se establece el color del BackGround
		this.setBackground(Color.black);
		
		// establecer tama�o del panel
		this.setPreferredSize(new Dimension(ANCHO, ALTO));
		
		// establecer posici�n inicial de la bola, crear e iniciar el timer
		x = POSX2;
		y = POSY2 - DIAMETRO;
		this.timer = new Timer(DELAY, this);
		this.timer.start();
		
		// la bola al principio va hacia la derecha		
		this.derecha = true;
	}

	/**
     *   
     *       
     */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// dibujar la l�nea vertical y la horizontal en color verde
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
	 * se ejecuta cada vez que el timer produce un evento actualizar coordenadas
	 * de la bola y volver a dibujar el panel
	 * 
	 * 
	 */
	public void actionPerformed(ActionEvent e)
	{
		actualizar();
		repaint();		
	}

	/**
	 * m�todo privado de ayuda que modifica las coordenadas de la bola
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

}
