package TDAPila;

public class PilaEnlazada<E> implements Stack<E>{
	//atributos de instancia
		protected Nodo<E> head;
		protected int tamaño;
		
		public PilaEnlazada() {
			head = null;
			tamaño = 0;
		}
		
		@Override
		public int size() { //O(1)
			return tamaño;
		}

		@Override
		public boolean isEmpty() { //O(1)
			return tamaño == 0;
		}

		@Override
		public E top() throws EmptyStackException { //O(1)
			if(isEmpty()) {
				throw new EmptyStackException("Pila Vacia");
			}
			return head.getElemento();
		}

		@Override
		public void push(E element) { //O(1)
			Nodo<E> aux = new Nodo<E>(element,head);
			head = aux;
			tamaño++;
		}

		@Override
		public E pop() throws EmptyStackException { //O(1)
			if(isEmpty()) {
				throw new EmptyStackException("Pila Vacia");
			}
			E aux = head.getElemento();
			head = head.getSiguiente();
			tamaño--;
			return aux;
		}
		

}
