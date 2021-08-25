package TDAMapeo;

public class Entrada<K, V> implements Entry<K, V> {

	private K k;
	private V v;
	
	/**
	 * Construcor de Entrada
	 * @param key Clave
	 * @param value Valor
	 */
	public Entrada(K key, V value) {
		k = key;
		v = value;
	}
	
	@Override
	public K getKey() {
		return k;
	}

	@Override
	public V getValue() {
		return v;
	}

	/**
	 * Setea la clave a la pasada por parametros
	 * @param key nueva clave
	 */
	public void setKey(K key) {
		k = key;
	}

	/**
	 * Setea el valor al pasado por parametros
	 * @param value Nuevo valor
	 * @return Valor anterior
	 */
	public V setValue(V value) {
		V old = v;
		v = value;
		return old;
	}
	


}
