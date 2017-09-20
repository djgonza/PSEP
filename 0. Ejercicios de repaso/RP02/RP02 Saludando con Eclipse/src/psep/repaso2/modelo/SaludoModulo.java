package psep.repaso2.modelo;

/**
 * Un objeto de esta clase da la bienvenida a un m�dulo
 *  de un nombre y n� horas determinado
 */
public class SaludoModulo
{
     
    private String nombre;
	private int horas;

    /**
     * Constructor  
     */
    public SaludoModulo(String nombre, int horas)
    {
         this.nombre = nombre;
         this.horas = horas;
    }

    /**
     *  Acccesor para el nombre
     */
    public String getNombre()
    {
         return nombre;
    }
    
    /**
     *  Mutador para el nombre
     */
    public void setNombre(String nombre)
    {
         this.nombre = nombre;
    }
    
	 /**
     *  Acccesor para las horas
     */
    public int getHoras()
    {
         return horas;
    }
	
	 /**
     *  Mutador para las horas
     */
    public void setHoras(int horas)
    {
         this.horas = horas;
    }
    
	
    /**
     *  Representaci�n textual del objeto
     * 
     */
    public String toString()
    { 
        return " Bienvenido/a al m�dulo " + nombre + " de " + horas + " horas" ;
    }

}