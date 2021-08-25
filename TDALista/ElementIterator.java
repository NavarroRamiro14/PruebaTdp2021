package TDALista;

import java.util.*;


public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list;	//Lista a iterar
	protected Position<E> cursor;	//Posicion del elemento corriente
	
	public ElementIterator (PositionList<E> l) {
		list = l;	//Guardo la referencia a la lista a iterar
		if(list.isEmpty()) cursor = null; //Si la lista esta vacia la posicion corriente es nula
		else
			try {
				cursor = list.first();//sino la posicion corriente es la primerea de la lista
			} catch (EmptyListException e) {e.printStackTrace();}
	}
	
	@Override
	public E next() throws NoSuchElementException{
		if(cursor == null) 												//Si el cursor es null, el cliente no testeo que hasNext fuera true
			throw new NoSuchElementException("Error: No hay siguiente");
		E toReturn = cursor.element(); 									//salvo el elemento corriente
		try {
			cursor = (cursor == list.last()) ? null : list.next(cursor);
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {e.printStackTrace();} 	//avanzo a la siguiente poscion
		return toReturn; 												//retorno el elemento salvado
	}
	
	@Override
	public void remove() { /* No lo haremos. */ }
	/* De hacerlo: Remueve el último ítem retornado por next(), no se puede llamar a remove() hasta
	que no se haya ejecutado otro next(). Hay que agregar más control en las otras operaciones. */

	@Override
	public boolean hasNext() {
		return cursor != null;
	}
}
