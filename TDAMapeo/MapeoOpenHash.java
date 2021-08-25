package TDAMapeo;

import TDALista.*;

public class MapeoOpenHash<K,V> implements Map<K,V> {
	
	//atributos
	private int N;
	private int n;
	private PositionList<Entry<K, V>>[] A;
	

	//constructor
	@SuppressWarnings("unchecked")
	public MapeoOpenHash() {
		N = 13;
		n = 0;
		A = new ListaEnlazada[N];
		for(int i = 0; i<N ; i++) {
			A[i] = new ListaEnlazada<Entry<K,V>>();
		}
	}
	
	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public V get(K key) throws InvalidKeyException {
		if(key == null)
			throw new InvalidKeyException("put():: Key Nula");
		V toReturn = null;
		int i = h(key);
		PositionList<Entry<K,V>> L = A[i];
		for(Position<Entry<K,V>> p : L.positions()) {
			Entry<K,V> e = p.element();
			if(e.getKey().equals(key))
				toReturn = e.getValue();
		}
		return toReturn;
	}

	@Override
	public V put(K key, V value) throws InvalidKeyException {
		if(key == null)
			throw new InvalidKeyException("put():: Key Nula");
		if((n/N) >0.9)
			rehash();
		int i = h(key);
		V toRet = null;
		PositionList<Entry<K,V>> L = A[i];
		for(Position<Entry<K,V>> p : L.positions()) {
			Entrada<K,V> e = (Entrada<K, V>) p.element();
			if(e.getKey().equals(key)) {
				toRet = e.getValue();
				e.setValue(value);
			}
		}
		if(toRet == null) {
			L.addLast(new Entrada<K,V>(key,value));
			n++;
		}
		return toRet;
	}

	@Override
	public V remove(K key) throws InvalidKeyException {
		if(key == null) {
			throw new InvalidKeyException("remove():: Key nula");
		}
		int i = h(key);
		V toReturn = null;
		for(Position<Entry<K,V>> pos : A[i].positions()) {
			Entry<K,V> e = pos.element();
			if(e.getKey().equals(key)) {
				toReturn = e.getValue();
				try {
					A[i].remove(pos);
					n--;
				} catch (InvalidPositionException e1) {e1.printStackTrace();}
			}
		}
		return toReturn;
	}

	@Override
	public Iterable<K> keys() {
		PositionList<K> p = new ListaEnlazada<K>();
		for(int i = 0; i<N ; i++) {
			for(Position<Entry<K,V>> pos : A[i].positions()) {
				p.addLast(pos.element().getKey());
			}
		}
		return p;
	}

	@Override
	public Iterable<V> values() {
		PositionList<V> p = new ListaEnlazada<V>();
		for(int i = 0 ;i<N;i++) {
			for(Position<Entry<K,V>> pos : A[i].positions()) {
				p.addLast(pos.element().getValue());
			}
		}
		return p;
	}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> p = new ListaEnlazada<Entry<K,V>>();
		for(int i = 0; i<N;i++) {
			for(Position<Entry<K,V>> pos : A[i].positions()) {
				p.addLast(pos.element());
			}
		}
		return p;
	}
	
	/**
	 * Si una insercion, es decir un put, causa el incremento del factor de carga (n/N)
	 * sea mayor a 0.9, se necesita hacer un rehash
	 * rehash() Se encarga de agrandar la tabla y re-insertar los elementos que pertenecian al
	 * arreglo original.
	 * 
	 * Utiliza nextPrime(num) para buscar el proximo primo.
	 */
	@SuppressWarnings("unchecked")
	private void rehash() {
		int oldSize = N;
		N = nextPrime(N*2); // Se cambia el valor de N por el siguiente primo al doble de N
		PositionList<Entry<K,V>>[] An = new ListaEnlazada[N]; //Se genera un nuevo arreglo
		for(int i = 0; i<N ; i++) {								//Bucle for inicializa las listas del nuevo arreglo
			An[i] = new ListaEnlazada<Entry<K,V>>();
		}
		for(int i = 0; i<oldSize; i++) {			//Se re insertan los elementos viejos
			for(Position<Entry<K,V>> pos : A[i].positions()) {
				Entry<K,V> e = (Entrada<K, V>) pos.element();
				int j = h(e.getKey());
				An[j].addLast(e);
			}
		}
		A = An;  //Se actualiza el atributo que mantiene el arreglo.
	}
	
	/**
	 * Busca el primo siguiente al doble del numero pasado por parametro
	 * @param num Es el numero del cual parte la busqueda
	 * @return toRet es el primo mas proximo a num*2
	 */
	private int nextPrime(int num) {
		int toRet = num++;
	    for (int i = 2; i < toRet; i++) {
	    	if(toRet%i == 0) {//si el numero es divisible por el indice, el indice se reinicia y se avanza al siguiente num
	            toRet++;
	            i=2;
	        } else {
	            continue;
	        }
	    }
	    return toRet;
	}
	
	/**
	 * Devuelve el codigo hash
	 * @param key Clave del objeto
	 * @return Integer con clave hash
	 */
	private int h(K key) {
		int i = Math.abs(key.hashCode() % N) ;
		return i ;
	}
	
}
