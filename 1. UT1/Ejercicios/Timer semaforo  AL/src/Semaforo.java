import java.awt.Color;
/**
 * Modela un Semaforo  
 *  
 */
public class Semaforo
{

    private Color c;

    /**
     * Constructor de la clase Semaforo
     */
    public Semaforo()
    {
        c = Color.red;
    }

    /**
     *  
     * Obtener el color del semáforo
     */
    public Color getColor()
    {
        return c;
    }

    /**
     * 
     *  Actualizar color del semaforo
     */
    public void avanzar()
    {
    	/**
    	 * Comprueba el color: 
    	 * Si el color es rojo, lo cambia por verde.
    	 * Si es verde, lo cambia por amarillo.
    	 * Si es amarillo, lo cambia por rojo
    	 */
    	if(c == Color.red) {
    		this.setColor(Color.green);
    	}
    	else if (c == Color.green) {
    		this.setColor(Color.yellow);
    	}
    	else if (c == Color.yellow) {
    		this.setColor(Color.red);
    	}  
    }
 

    /**
     * 
     *  Cambiar el color   
     */
    public void setColor(Color c)
    {
        this.c = c;
    }
    
    /**
     *   
     */
    public String toString()
    {
        return c.toString();
    }
    
}
