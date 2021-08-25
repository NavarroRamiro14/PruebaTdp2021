package TDAColaCP;

public class Comparador<E> implements java.util.Comparator<E> {

	/**
	 * Comparador dado por la catedra, lo utiliza el tester.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(E o1, E o2) {
		
		return ((Comparable<E>) o1).compareTo(o2);
	}
	
	

}