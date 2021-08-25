package TDALista;

/**
 * Excepcion lanzada al verificar una lista vacia
 * @author Navarro y Dupre
 *
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception {
	public EmptyListException(String msg){
		super(msg);
	}
}
