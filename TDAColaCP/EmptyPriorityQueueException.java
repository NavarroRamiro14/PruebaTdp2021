package TDAColaCP;

/**
 * Excepcion lanzada cuando la Cola Con Prioridad esta vacia.
 * @author Navarro y Dupre
 *
 */
@SuppressWarnings("serial")
public class EmptyPriorityQueueException extends Exception {
	public EmptyPriorityQueueException(String msg) {
		super(msg);
	}
}
