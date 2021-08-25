package TDALista;

/**
 * Excepcion lanzada al salirse de los limites de la lista.
 * @author Navarro y Dupre
 *
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception {
	public BoundaryViolationException(String msg){
		super(msg);
	}
}
