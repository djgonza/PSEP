package psep.timer.ej01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelContador extends JPanel implements ActionListener
{
	public final static int ANCHO = 400; // ancho del panel
	public final static int ALTO = 300; // alto del panel
	private final static int DELAY = 500; // retardo del timer, cada cuánto
											// genera un evento ActionEvent
	private final static int POS_X = ANCHO / 3; // posición x del contador
	private final static int POS_Y = ALTO / 3; // posición y del contador
	private int x;
	private int y;
	private int contador;
	private Timer timer;

	/**
	 * Constructor
	 */
	public PanelContador()
	{
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(ANCHO, ALTO));
		x = POS_X;
		y = POS_Y;
		contador = 0;
		// a completar
		this.timer = new Timer(DELAY, this);
	}

	/**
     *   
     *       
     */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// a completar
		
		//Establecemos el fondo de color negro
		this.setBackground(Color.black);
		
		//Se establece la fuente y el color de la fuente para el texto de arriba.
		g.setFont(new Font("ARIAL", Font.BOLD, 16));
		g.setColor(Color.yellow);
		
		g.drawString("Click para iniciar/continuar" , 20, 50);
		
		//Establece la fuente para el contador.
		g.setFont(new Font("ARIAL", Font.BOLD, 24));
		
		//Establecemos donde se va a colocar el contador en el panel.
        g.drawString("" + contador + "", x, y);
	}

	public void mousePressed(MouseEvent e)
	{
	};

	public void mouseReleased(MouseEvent e)
	{
	};

	public void mouseClicked(MouseEvent e)
	{
		// a completar

	};

	public void mouseEntered(MouseEvent e)
	{
	};

	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	};

}
