package TDACola;

/**
 * Excepcion lanzada al encontrar una Cola vacia en ciertos casos
 * @author Navarro Dupre
 *
 */
@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	public EmptyQueueException(String msg){
		super(msg);
	}
}
