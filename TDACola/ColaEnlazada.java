package TDACola;

/**
 * Cola simplemente enlazada con referencia a la cabeza y el rabo de la cola.
 * 
 * @author Navarro y Dupre
 *
 * @param <E> Tipo de clase que almacena la cola
 */
public class ColaEnlazada<E> implements Queue<E>{

	//atributos
	Nodo<E> header;
	Nodo<E> trailer;
	int size;
	
	/**
	 * Construcotr de la cola, inicializa los atributos de instancia.
	 */
	public ColaEnlazada() {
		header = null;
		trailer = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E front() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("front()::Lista Vacia");
		return  header.getElement();
	}

	@Override
	public void enqueue(E element) {
		if(isEmpty()) {
			header = new Nodo<E>(element);						
			size++;
		}
		else {
			if(trailer == null) {
				trailer = new Nodo<E>(element);
				header.setNext(trailer);
				size++;				
			}
			else {
				Nodo<E> nuevo = new Nodo<E>(element);
				trailer.setNext(nuevo);
				trailer = nuevo;
				size++;
			}
		}
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException("dequeue()::Lista Vacia");
		if(header.getNext() == null) {     // caundo tengo un elemento
			E element = header.getElement();   // que en este caso seria la head no la tail
			header = null;
			size--;
			return element;
		}
		else {
			if(header.getNext() == trailer) { // Cuando tengo dos elementos
				E element = header.getElement();
				header = header.getNext(); // me queda el header solo sin la cola. Paso de 
				trailer = null; 		   // esto [E]--->[E] a esto = [E]
				size--;		    		   //      head   tail         head
				return element;
			}
			else {
				E element = header.getElement(); // Cuando tengo mas de dos elementos
				header = header.getNext();
				size--;
				return element;
			}
		}
	}
	
}
