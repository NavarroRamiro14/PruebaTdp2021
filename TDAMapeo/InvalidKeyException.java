package TDAMapeo;

/**
 * Excepcion lanzada al detectar una clave nula
 * @author Navarro y Dupre
 *
 */
@SuppressWarnings("serial")
public class InvalidKeyException extends Exception {
	public InvalidKeyException(String msg) {
		super(msg);
	}
}
