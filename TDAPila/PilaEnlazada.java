package TDAPila;

public class PilaEnlazada<E> implements Stack<E>{
	//atributos de instancia
		protected Nodo<E> head;
		protected int tama�o;
		
		public PilaEnlazada() {
			head = null;
			tama�o = 0;
		}
		
		@Override
		public int size() { //O(1)
			return tama�o;
		}

		@Override
		public boolean isEmpty() { //O(1)
			return tama�o == 0;
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
			tama�o++;
		}

		@Override
		public E pop() throws EmptyStackException { //O(1)
			if(isEmpty()) {
				throw new EmptyStackException("Pila Vacia");
			}
			E aux = head.getElemento();
			head = head.getSiguiente();
			tama�o--;
			return aux;
		}
		

}
