
/**
 *  
 */
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GuiBola extends JFrame{

    private PanelBola pnlBola;
    
    /**
     * Constructor  
     */
    public GuiBola( )
    {
        crearGui();
        mostrarGui();

    }
    private void crearGui()
    {
        pnlBola = new PanelBola();
        this.getContentPane().add(pnlBola);
    }

    private void mostrarGui()
    {

        this.setTitle("Bola movimiento horizontal ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(200, 100);
        this.setResizable(true);  
        this.pack();
        this.setVisible(true);
 
    }
    public static void main(String[] args)
    {
         GuiBola bola = new GuiBola();
    }

}