package TDALista;

/**
 * Nodo Doblemente Enlazado
 * @author Navarro y Dupre.
 *
 * @param <E> Clase del elemento que mantiene el nodo
 */
public class DNodo<E> implements Position<E> {

	@Override
	public E element() {
		return elemento;
	}
	
	//atributos
	private E elemento;
	private DNodo<E> previo, siguiente;
	
	//constructor
	/**
	 *  Crea un nodo, orden de los params: Elem, Prev, Sig
	 * @param element Elemento del nodo
	 * @param prev Nodo Previo
	 * @param sig Nodo siguiente
	 */
	public DNodo(E element, DNodo<E> prev, DNodo<E> sig) {
		elemento = element;
		previo = prev;
		siguiente = sig;
	}
	
	/**
	 * Crea un nodo, sin enlaces a sus nodos adyacentes
	 * @param element
	 */
	public DNodo(E element) {
		elemento = element;
		previo = null;
		siguiente = null;
	}
	
	//metodos
	
	/**
	 * Devuelve el nodo Previo del que recibe el mensaje
	 * @return DNodo anterior a this
	 */
	public DNodo<E> getPrev(){
		return previo;
	}
	
	/**
	 * Devuelve el siguiente nodo del que recibe el mensaje
	 * @return DNodo Siguiente a this.
	 */
	public DNodo<E> getNext(){
		return siguiente;
	}
	
	/**
	 * Setea el elemento del nodo al pasado por parametros
	 * @param e Nuevo elemento
	 */
	public void setElement(E e) {
		elemento = e;
	} 
	
	/**
	 * Setea el Nodo Previo al que recibe el mensaje.
	 * @param p Nuevo DNodo previo
	 */
	public void setPrev(DNodo<E> p) {
		previo = p;
	}
	
	/**
	 * Setea el Siguiente nodo al que recibe el mensaje.
	 * @param n Nuevo DNodo Siguiente
	 */
	public void setNext(DNodo<E> n) {
		siguiente = n;
	}
	
	
}
