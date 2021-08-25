package TDALista;

import java.util.Iterator;

/**
 * Lista Doblemente enlazada sin Nodos centinelas.
 * Los atributos Header y Trailer apuntan al primer y ultimo elemento de la lista
 * Contiene casos especiales en los que el header y trailer apuntan al mismo nodo.
 * @author Navarro y Dupre
 *
 * @param <E> Clase de elementos que encapsulara la Lista.
 */
public class ListaEnlazada<E> implements PositionList<E> {

	//atributos
	private DNodo<E> header;
	private DNodo<E> trailer;
	private int size;
	
	/**
	 * Constructor de la lista. Inicializa variables
	 */
	public ListaEnlazada() {
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
	public Position<E> first() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException("first():: Lista Vacia");
		return header;
	}

	@Override
	public Position<E> last() throws EmptyListException {
		if(isEmpty())
			throw new EmptyListException("last():: Lista Vacia");
		return trailer;
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		if(isEmpty())
			throw new InvalidPositionException("next():: Lista contiene 1 sola posicion");
		if(checkPosition(p) == trailer)
			throw new BoundaryViolationException("next():: Ultima posicion no tiene next");
		DNodo<E> toReturn = checkPosition(p).getNext();
		return toReturn;
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> aux = checkPosition(p);
		if(aux == header)
			throw new BoundaryViolationException("prev():: Primera Posicion");
		DNodo<E> toReturn = aux.getPrev();
		return toReturn;
	}

	@Override
	public void addFirst(E element) {
		if(size==0) {//el tamanio es 0 por lo tanto header y trailer apuntaran a este nodo
			DNodo<E> nuevo = new DNodo<E>(element);
			header = nuevo;
			trailer = nuevo;
			size++;
		}
		else {
			DNodo<E> nuevo = new DNodo<E>(element,null,header);
			header.setPrev(nuevo);
			header = nuevo;
			size++;
		}
	}

	@Override
	public void addLast(E element) {
		if(size == 0) { // tamanio es 0 por lo tanto header y trailer apuntan al mismo objeto
			DNodo<E> nuevo = new DNodo<E>(element);
			header = nuevo;
			trailer = nuevo;
			size++;
		}
		else {
			DNodo<E> nuevo = new DNodo<E>(element,trailer,null);
			trailer.setNext(nuevo);
			trailer = nuevo;
			size++;
		}
	}

	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		if(pos == trailer) {
			DNodo<E> nuevo = new DNodo<E>(element,trailer,null);
			trailer.setNext(nuevo);
			trailer = nuevo;
			size++;
		}
		else {
			DNodo<E> nuevo = new DNodo<E>(element,pos,pos.getNext());
			pos.getNext().setPrev(nuevo);
			pos.setNext(nuevo);
			size++;
		}
	}

	@Override
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		if(pos == header) {
			DNodo<E> nuevo = new DNodo<E>(element,null,header);
			header.setPrev(nuevo);
			header = nuevo;
			size++;
		}
		else{
			DNodo<E> nuevo = new DNodo<E>(element,pos.getPrev(),pos);
			pos.getPrev().setNext(nuevo);
			pos.setPrev(nuevo);
			size++;
		}
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		if(isEmpty()) 
			throw new InvalidPositionException("remove():: Lista vacia");
		DNodo<E> pos = checkPosition(p);
		E toReturn = pos.element();
		if(pos != header && pos != trailer) {//la posicion no esta en el trailer ni el header
			pos.getNext().setPrev(pos.getPrev());
			pos.getPrev().setNext(pos.getNext());
		}
		else {// la posicion esta O en header O en trailer O en AMBOS
			if(pos == header && pos == trailer) {
				header = null;
				trailer = null;
			}
			else {
				if(pos == header) {//la pos apunta al header
					header = pos.getNext();
				}
				else {//la pos apunta al trailer
					trailer = pos.getPrev();
				}
			}
		}
		pos.setElement(null);
		size--;
		return toReturn;
	}

	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> viejo = checkPosition(p);
		E elem = viejo.element();
		viejo.setElement(element);
		return elem;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> p = new ListaEnlazada<Position<E>>();
		Position<E> ult;
		if(!isEmpty()) {
			try {
				ult = last();
				if (size != 0) {
					Position<E> pos = header;
					while (pos != ult) {
						p.addLast(pos);
						pos = next(pos);
				} 
				p.addLast(pos);
				}
			} catch (EmptyListException e) {e.printStackTrace();
			} catch (InvalidPositionException e) {e.printStackTrace();
			} catch (BoundaryViolationException e) {e.printStackTrace();
			}
		}
		return p;
	}

	/**
	 * Se encarga de validar que una posicion no sea nula, no se haya eliminado, y pertenezca a la lista.
	 * 
	 * @param p Posicion que se quiere checkear
	 * @return DNodo perteneciente a la posicion p
	 * @throws InvalidPositionException
	 */
	public DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try {
			if(p == null)
				throw new InvalidPositionException("Posicion Nula");
			if(p.element() == null)
				throw new InvalidPositionException("p eliminada previamente");
			return (DNodo<E>)p;
		}catch(ClassCastException e) {
			throw new InvalidPositionException("p no es un nodo de lista");
		}
	}
}
