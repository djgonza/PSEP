/*
 * Ejemplo:
 * https://www.youtube.com/watch?v=7G1KzKOodao
 * 
 * En el ejemplo también implementa sillas pero como no es lógico que
 * los filósofos tengan que estar cambiándose de silla cada vez que
 * quieran comer, hemos decidido no seguir con el final del ejemplo.
 * 
 * También hemos visto que otra opción valida es mediante el uso de
 * semáforos pero como no hemos visto su funcionamiento en clase, 
 * seguimos tratando de encontrar otra solución para el ejercicio.
 * 
 * Se adjuntan dentro del fichero zip los accesos a las distintas webs
 * donde hemos ido obteniendo la información tanto para el código aqui 
 * utilizado como para los diagramas de clases, estados y secuencia.
 * 
 */

public class TestCena {
	public static void main(String[] args) {

		Tenedor[] tenedores = new Tenedor[5];

		for (int i = 0; i < tenedores.length; i++) {
			tenedores[i] = new Tenedor(i);
		}

		Filosofo[] filosofos = new Filosofo[5];

		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % 5]);
		}

		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i].start();

		}
	}
}
