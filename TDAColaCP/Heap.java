package TDAColaCP;

import java.util.Comparator;
public class Heap<K, V> implements PriorityQueue<K, V> {

	
	//atributos
	protected Entry<K,V>[] elems;
	protected Comparator<K> comp;
	protected int size;
	
	@SuppressWarnings("unchecked")
	/**
	 * Construcor de la cola con prioridad programada con un Heap
	 * @param comp Comparador que le da comportamiento de orden a la CCP
	 */
	public Heap(Comparator<K> comp) {
		elems = (Entrada<K,V> []) new Entrada[41];
		this.comp = comp;
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
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if(isEmpty())
			throw new EmptyPriorityQueueException("min():: Cola vacia");
		return elems[1];
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if(key == null) 
			throw new InvalidKeyException("insert():: Clave nula");
		if(size == elems.length-1)
			reSize();
		Entry<K,V> elemento = new Entrada<K,V>(key,value);
		elems[++size] = elemento;
		bubbleUp();
		return elemento;
	}

	@Override
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(isEmpty())
			throw new EmptyPriorityQueueException("removeMin():: Cola vacia");
		Entry<K,V> toRet = min();
		if(size==1) {
			elems[1] = null;
			size = 0;
		}
		else {
			elems[1] = elems[size];
			elems[size] = null;
			size--;
			bubbleDown();
			
		}
		return toRet;
	}
	
	@SuppressWarnings("unchecked")
	private void reSize() {
		Entry<K,V>[] aux = (Entrada<K,V> []) new Entrada[elems.length*2];
		for(int i = 1; i<elems.length;i++)
			aux[i] = elems[i];
		elems = aux;
	}

	/**
	 * Metodo Privado Utilizado en removeMin() para factorizar codigo.
	 * Al remover un nodo, se empuja al ultimo agregado hacia arriba del todo (posicion 1)
	 * Lo que hace este metodo es empujar hacia abajo este nodo a su lugar correspondiente.
	 */
	private void bubbleDown() {
		int i = 1;
		boolean seguir = true;
		int hi;
		int hd;
		int m = 0;// en m se guardara el menor de los hijos
		while(seguir) {
			//caclulculo la posicion del hijo izquierdo y derecho de i, y veo si realmente existen
			hi = i*2;
			hd = (i*2)+1;
			boolean tieneHijoIzquierdo = hi<=size();
			boolean tieneHijoDerecho = hd<=size();
			if(!tieneHijoIzquierdo)
				seguir = false;
			else {
				if(tieneHijoDerecho) {
					//calcular el menor
					if(comp.compare(elems[hi].getKey(), elems[hd].getKey())<0)
						m = hi;
					else
						m = hd;
				}
				else
					m = hi;
			}
			if(seguir && comp.compare(elems[i].getKey(), elems[m].getKey())>0) {
				Entry<K,V> aux = elems[i];
				elems[i] = elems[m];
				elems[m] = aux;
				i = m;
			}
			else
				seguir = false;
		}
	}

	/**
	 * Metodo privado utilizado en insert() para factorizar codigo
	 * Al insertar un nodo se lo inserta en la primera posicion abajo a la izquierda disponible.
	 * El objetivo de este metodo es burbujear el ultimo insertado a una posicion que corresponda.
	 */
	private void bubbleUp() {
		int i = size;
		boolean seguir = true;
		while(i>1 && seguir) {
			Entry<K,V> elemActual = elems[i];
			Entry<K,V> elemPadre = elems[i/2];
			if(comp.compare(elemActual.getKey(),elemPadre.getKey())<0) {
				Entry<K,V> aux = elems[i];
				elems[i] = elems[i/2];
				elems[i/2] = aux;
				i/=2;
			}
			else
				seguir = false;
		}
	}

}
