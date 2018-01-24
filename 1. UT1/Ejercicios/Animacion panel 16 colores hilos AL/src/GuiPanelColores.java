/** 
 * 
 *  
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
 

public class GuiPanelColores extends JFrame
{
    private PanelColor panel;
    /**
     * Constructor de la clase GuiPrueba
     */
    public GuiPanelColores()
    {
        crearGui();
        mostrarGui();

    }

    /**
     *   Se crean 16 paneles, cada uno con un color aleatorio
     */
    private void crearGui()
    {
    	String titulo = "Creación de 16 panels con color  aleatorio  en cada panel - \nCada panel lo ejecuta un hilo";
        this.setTitle(titulo);
        this.setLayout(new GridLayout(4, 4));
        for (int f = 1; f <= 4; f++)
        {
            for (int c = 1; c <= 4; c++)
            {
                this.add(new PanelColor());
            }
        }

    }

    /**
     *   
     */
    private void mostrarGui()
    {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }

    /**
     * Cada panel es una clase interna
     * Será la tarea Runnable
     */
    private class PanelColor extends JPanel implements Runnable
    {
        private Thread th;
        private Color color;

        /**
         * Constructor 
         * crea el hilo de ejecución y lo inicia
         */
        public PanelColor()
        {
        	 color = generarColor();
        	// a completar
        	 //Crear el hilo llamandose as� mismo
        	this.th = new Thread(this);
        	
        	//Iniciar el hilo.
        	this.th.start();

        }

        /**
         *  
         * Se ejecuta cada vez que el panel necesita ser dibujado
         *      
         */
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);     
            setBackground(color);   
            setBorder(BorderFactory.createLineBorder(Color.black));

        }

        /**
         * ejecutar indefinidamente 
         * se obtienen un color aleatorio para el panel con el método generarColor(),
         * se dibuja el panel y se duerme el hilo una cantidad de milisegundos
         */        
        public void run()
        {
        	// a completar
        	while(true){    			
    			try {
    				//Establecer el color de nuevo
    				color = generarColor(); 
    				
    				//Dormir hilo 500 milisegundos
					Thread.sleep(500);
					
					//Repintar el panel
					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}

        }
        /**
         *  
         * Obtiene un color aleatorio de entre 6 colores
         *      
         */
        private Color generarColor()
        {
            // definir un array colores con 6 colores diferentes            
            Color colores[] = {Color.red, Color.blue, Color.green, Color.orange, Color.yellow, Color.pink};
            
            // devolver un color aleatorio de entre los 6        	  
            return colores[(int)(Math.random() * 6)];

        }

    }
    
    /**
     * Punto de entrada a la aplicación
     */
    public  static void main(String[] args)
    {
          SwingUtilities.invokeLater(new Runnable()
                                {
                                     public void run()
                                     {
                                         new GuiPanelColores();
                                     }
                                }
                                );
    }

}