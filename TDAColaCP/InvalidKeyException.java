package TDAColaCP;

/**
 * Excepcion lanzada al encontra una Clave invalida
 * @author Navarro y Dupre
 *
 */
@SuppressWarnings("serial")
public class InvalidKeyException extends Exception {
	public InvalidKeyException(String msg) {
		super(msg);
	}
}
