import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** 
 * 
 *  
 */

public class Espacio  extends JFrame
{
  
    private PanelEspacio  panel;

    /**
     * Constructor  
     */
    public Espacio ()
    {
        crearGui();
        mostrarGui();

    }

    /**
     *   
     */
    private void crearGui()
    {
        this.setTitle("Espacio con globos ");       

        panel = new PanelEspacio();
        panel.setPreferredSize(new Dimension(700, 600));
        this.add(panel, BorderLayout.CENTER);


    }

    /**
     *   
     */
    private void mostrarGui()
    {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }

   public static void main(String[] args)
   {
       SwingUtilities.invokeLater(new Runnable()
                                {
                                     public void run()
                                     {
                                         new Espacio();
                                     }
                                }
                                );
    }
}