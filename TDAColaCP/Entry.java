package TDAColaCP;

public interface Entry<K, V> {
	//public methods of the Entry interface
	/**
	 * Consulta la Clave de la entrada
	 * @return Clave
	 */
	public K getKey();
	
	/**
	 * Consulta el Valor de la entrada
	 * @return Valor
	 */
	public V getValue();
}
