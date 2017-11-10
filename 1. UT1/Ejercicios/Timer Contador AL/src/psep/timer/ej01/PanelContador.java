package psep.timer.ej01;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelContador extends JPanel implements MouseListener
{
	public final static int ANCHO = 400; // ancho del panel
	public final static int ALTO = 300; // alto del panel
	private final static int DELAY = 500; // retardo del timer, cada cuÃ¡nto
											// genera un evento ActionEvent
	private final static int POS_X = ANCHO / 3; // posiciÃ³n x del contador
	private final static int POS_Y = ALTO / 3; // posiciÃ³n y del contador
	private int x;
	private int y;
	private int contador;
	private Timer timer;
	//Añadido, texto de los mensajes que aparecen en el panel.
	private String texto;
	//Variable para controlar si el contador debe subir o bajar
	private Boolean sube;

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
		//Establecemos el valor del atributo texto con el texto "Click para iniciar/continuar"		
		this.texto = "Click para iniciar/continuar";
		//Establecemos el valor true para que el contador sea ascendente
		this.sube = true;
		
		//Añadimos el MouseListener para que detecte las acciones que hacemos con el raton sobre el panel.
		this.addMouseListener(this);
		//Añadimos un objeto de la clase TIME pasandole por defecto la constante DELAY 
		//y un objeto de la clase ActionListener
		this.timer = new Timer(DELAY, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Comprueba que contador sea mayor o igual que cero y que "sube" sea TRUE.
				//Si cumple la condición, incrementa el contador en 1.
				if(contador >= 0 && sube) {
					contador++;
					//Si llega el contador a 10, "sube" cambia a FALSE
					if(contador == 10)
						sube = false;
				}else if(contador <= 10 && !sube) {
					//Comprueba que contador sea menor o igual que diez y que "sube" sea FALSE.	
					//Si lo cumple, decrementa contador en 1.
					contador--;
					//Si llega el contador a 0, "sube" cambia a TRUE
					if(contador == 0)
						sube = true;
				}
				//Te vuelve a imprimir la pantalla para que te muestre todo actualizado en el panel.
				repaint();
			}
			
		});
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
		
		g.drawString(this.texto , 20, 50);
		
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
		//Comprueba que el timer esté en funcionamiento. Si no lo está, inicia el timer,
		//establece el valor de texto a "Toca la pantalla para parar" y muestra un mensaje
		//de Timer iniciado.
		if(!this.timer.isRunning()) {
			this.timer.start();
			texto = "Toca la pantalla para parar";
			System.out.println("Timer iniciado");
		}
		//Si está el timer iniciado, para el timer,
		//establece el valor de texto a "Click para iniciar/continuar" y muestra un mensaje
		//de Timer parado.
		else {
			this.timer.stop();
			texto = "Click para iniciar/continuar";
			repaint();
			System.out.println("Timer parado");
		}
		
	};

	public void mouseEntered(MouseEvent e)
	{
	};

	public void mouseExited(MouseEvent e)
	{
	}	

}
