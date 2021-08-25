package Persona;

public class ComparadorPersona<E> implements java.util.Comparator<E> {

	/**
	 * @author Navarro Dupre
	 * Compara o2, y o1 de manera que la persona con numero mas alto de riesgo se la prioriza.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(E o1, E o2) {
		return ((Comparable<E>) o2).compareTo(o1);
	}

}
