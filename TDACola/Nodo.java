package TDACola;

public class Nodo<E> {
	private E elemento;
	private Nodo<E> siguiente;
	
	//constructores
	public Nodo(E item, Nodo<E> sig) {
		elemento = item;
		siguiente = sig;
	}
	
	public Nodo(E item) {
		this(item,null);
	}
	
	//setters
	public void setElement(E elemento) {
		this.elemento = elemento;
	}
	
	public void setNext(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}
	
	//getters
	public E getElement() {return elemento;} 
	
	/**
	 * Devuelve el siguiente nodo
	 * @return Siguiente nodo
	 */
	public Nodo<E> getNext(){return siguiente;}
}
