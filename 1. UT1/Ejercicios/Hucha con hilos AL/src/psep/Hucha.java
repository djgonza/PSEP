package psep;

public class Hucha
{
	private int total;
	
	public Hucha()
	{
		total = 0;
	}

	public int getTotal()
	{
		return total;
	}

	public synchronized void add(int valor)
	{
		this.total += valor;
	}
	
	
}
