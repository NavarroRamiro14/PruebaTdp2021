package TDALista;

/**
 * Excepcion lanzada al verificar que una posicion no es valida
 * @author Navarro Dupre
 *
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	public InvalidPositionException(String msg){
		super(msg);
	}
}
