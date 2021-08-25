package TDAPila;

/**
 * Excepcion lanzada cuando una Pila esta vacia.
 * @author Navarro Dupre
 *
 */
@SuppressWarnings("serial")
public class EmptyStackException extends Exception{
	public EmptyStackException(String msg){
		super(msg);
	}
}
