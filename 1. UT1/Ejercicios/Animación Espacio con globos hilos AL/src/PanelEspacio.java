import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * Sobre el panel dibujaremos estrellas que se moverán en puntos aleatorios del
 * espacio
 * 
 */

public class PanelEspacio extends JPanel implements Runnable {
	private static final int MILISEGUNDOS = 500;
	private static final int ESTRELLAS = 300;
	private static final int MAX = 10;
	private Point[] estrellas; // array de puntos donde se ubicarán las
								// estrellas
	private Thread th;

	/**
	 * Constructor
	 */
	public PanelEspacio() {
		setBackground(Color.black);
		// crear las estrellas - primero crear el array y luego generar los
		// puntos con ayuda del método generarPuntosEstrellas()
		this.estrellas = new Point[ESTRELLAS];
		generarPuntosEstrellas();

		// crear e iniciar el hilo
		this.th = new Thread(this);
		this.th.start();

	}

	/**
	 * 
	 * Se ejecuta cada vez que el panel necesita ser dibujado se establece color
	 * blanco para las estrellas y se llama a dibujarEstrellas()
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// dibujar las estrellas llamando al método dibujarEstrellas()
		this.dibujarEstrellas(g);
	}

	/**
	 * Da valores a cada elemento del array estrellas. Cada estrella está
	 * representada por un punto Point (consulta la API) Las coordenadas x e y del
	 * punto serán valores aleatorios: para la x un valor desde 0 hasta el ancho
	 * del panel - 1 y para la y desde 0 hasta el alto del panel - 1
	 * 
	 */
	private void generarPuntosEstrellas() {
		for (int i = 0; i < ESTRELLAS; i++) {
			int x = (int) (Math.random() * (this.getWidth() - 1));
			int y = (int) (Math.random() * (this.getHeight() - 1));
			Point star = new Point(x, y);
			estrellas[i] = star;
		}
	}

	/**
	 * dibuja las estrellas. Habrá que recorrer el array de estrellas y dibujar
	 * cada una como un óvalo de anchura 2
	 */
	private void dibujarEstrellas(Graphics g) {
		// dibujar las estrellas de color blanco
		g.setColor(Color.white);

		// recorrer el array de puntos y dibujar cada
		// estrella como un óvalo de tamaño 2
		for (int i = 0; i < ESTRELLAS; i++) {
			Point star = estrellas[i];
			g.drawOval(star.x, star.y, 2, 2);
		}

	}

	/**
	 * dibuja las los globos. Habrá que recorrer la colección de globos y dibujar
	 * cada uno (le pediremos a cada globo que se dibuje a sí mismo)
	 */
	private void dibujarGlobos(Graphics g) {
		// dibujar los globos, es decir, recorre la colección y dibuja cada globo

	}

	/**
	 * el hilo que se ejecuta indefinidamente en cada ciclo de animación se generan
	 * nuevas estrellas, se dibuja el panel y se duerme el hilo
	 */
	public void run() {
		while (true) {
			try {
				generarPuntosEstrellas();
				repaint();
				Thread.sleep(MILISEGUNDOS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Si la colección tiene menos de MAX globos se crea un nuevo globo y lo añade
	 * a la colección de globos La posición x en la que se crea el globo es
	 * aleatoria y es un valor entre 0 y el ancho del panel - 1 La posición y en la
	 * que se crea el globo es aleatoria y es un valor entre 0 y la cuarta parte del
	 * alto del panel y es un valor negativo (esto hará que cuando se dibuje por
	 * primera vez no se vea)
	 */
	private void crearGlobo() {

	}

	/**
	 * 
	 * También recorre la colección de globos y aumenta el valor de la coordenada
	 * y en 15. Si al aumentar la coordenada y ésta supera la altura del panel
	 * (desparece de la vista el globo lo borramos de la colección y se crea uno
	 * nuevo OJO! No recorras con for la colección porque se va a borrar
	 */
	public void actualizarGlobos() {

	}

}