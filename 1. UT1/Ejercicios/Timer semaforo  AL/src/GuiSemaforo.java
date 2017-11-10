
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
 

public class GuiSemaforo  extends JFrame
{
    private JButton btnIniciarParar;
    
    private PanelSemaforo  panelSemaforo;
    private Semaforo semaforo; // el modelo

    /**
     * Constructor  
     */
    public GuiSemaforo()
    {
        this.semaforo = new Semaforo();
        crearGui();
        mostrarGui();

    }

    /**
     *   
     */
    private void crearGui()
    {
        this.setTitle("Uso de un timer para simular  un sem·foro ");
        JPanel pnlSur = new JPanel();
        pnlSur.setBorder(new TitledBorder("Iniciar Semaforo / Parar Sem·foro"));

        btnIniciarParar = new JButton("Iniciar");
      
        pnlSur.add(btnIniciarParar);
        this.add(pnlSur, BorderLayout.SOUTH);

        panelSemaforo = new PanelSemaforo();
        this.add(panelSemaforo, BorderLayout.CENTER);
        btnIniciarParar.addActionListener(panelSemaforo);
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
     * el panel es una clase interna
     */

    private class PanelSemaforo extends JPanel implements ActionListener  
    {
        private final int DELAY = 400;
        private Timer timer; 
        private int x; //Posicion X del rectangulo de los colores del rectangulo
        private int y; //Posicion Y del rectangulo de los colores del rectangulo
        private int alto; //Alto del rectangulo 
        private int ancho; //Ancho del rectangulo 
        
        /**
         * Constructor 
         */
        public PanelSemaforo()
        {
        	// a completar
            setBackground(Color.black);      	
            x = 0;
            y = 0;
            alto = 100;
            ancho = 400;
            timer = new Timer(DELAY, this);
        }
        /**
         *  
         * Se ejecuta cada vez que el panel necesita ser dibujado
         *      
         */
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            // a completar 
            
            //Se dibuja el rectangulo donde ir· el sem·foro            
            g.setColor(semaforo.getColor());
            g.fillRect(x, y, ancho, alto);
         
        }
     
     
        /**
         *  este m√©todo se ejecutar√° cuando el timer genere un evento y cuando se haga
         *  click en el bot√≥n de inicio y en el de parada
         */
        public void actionPerformed(ActionEvent ev)
		{
        	// a completar
        	if(ev.getSource() == btnIniciarParar) {        		
        		//Cambiar texto al botÛn        		
        		//Cambiar estado del timer
        		if(!this.timer.isRunning()) {
        			this.timer.start();
        			btnIniciarParar.setText("Parar");
        			System.out.println("Timer iniciado");
        		}
            	else {
        			this.timer.stop(); 
        			btnIniciarParar.setText("Iniciar");
        			System.out.println("Timer parado");
        		}
        	}
        	else {
        		//avanzar el sem·foro, cambiar la posiciÛn
        		semaforo.avanzar();
        		y -= 100;
        		if(y < 0) {
        			y = 200;
        		}
        		repaint();
        	}        	
		}   

    }
    
    public static void main(String[] args)
    {
        new GuiSemaforo();
 
    }
}