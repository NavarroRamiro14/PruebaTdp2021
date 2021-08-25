package Servicios;
import TDAMapeo.Map;
import TDAMapeo.MapeoOpenHash;
import TDAPila.PilaEnlazada;
import TDAPila.Stack;

import Persona.*;
import TDAColaCP.*;

/**
 * Clase que mantiene la logica del programa.
 * @author Navarro y Dupre
 *
 */
public class Programa {
	private PriorityQueue<Integer, Persona> CCP;//Se guardan todos los pacientes
	private Map<Integer,Persona> mapeo;//Solo se guardan pacientes una vez eliminados
	
	/**
	 * Constructor De la Aplicacion Logica
	 * Inicializa la Cola con Prioridad, con su comparador, y el mapeo.
	 */
	public Programa() {
		ComparadorPersona<Integer> comp = new ComparadorPersona<Integer>();
		CCP = new Heap<Integer,Persona>(comp);
		mapeo = new MapeoOpenHash<Integer,Persona>();
	}
	
	
	/**
	 * Inserta una nueva persona en la Cola con Prioridades
	 * @param name Es el nombre de la Persona que se va a insertar.
	 * @param surname Es el apellido de la Persona que se va a insertar.
	 * @param dni Es el Numero de Documento de la Persona que se va a insertar.
	 * @param risk Es el nivel de Riesgo de la Persona que se va a insertar.
	 */
	public void insert(String name, String surname, int dni, int risk) {
		Persona paciente = new Persona(name,surname,dni,risk);
		try {
			CCP.insert(paciente.getRisk(), paciente);
		} catch (InvalidKeyException e) {e.printStackTrace();}
	}
	
	/**
	 * Devuelve un String con los datos del paciente mas Riesgoso.
	 * Si la cola esta vacia devuelve un mensaje indicando esto.
	 * @return String con datos del paciente mas riesgoso.
	 */
	public String pacienteMasRiesgoso() {
		String s = "";
		Persona riesgosa = null;
		if(CCP.isEmpty())
			s = "Cola Vacia, no contiene paciente mas riesgoso";
		else {
			try {
				riesgosa = CCP.min().getValue();
			} catch (EmptyPriorityQueueException e) {e.printStackTrace();}
			s = riesgosa.toString();
		}
		return s;
	} 
	

	
	/**
	 * Devuelve un String en formato HTML con los datos de todos los
	 * pacientes registrados en la CCP de forma decreciente.
	 * @return String con datos de todos los pacientes.
	 */
	public String listarPacientes() {
		String s = "";
		Heap<Integer, Persona> colaAux = new Heap<Integer,Persona>(new ComparadorPersona<Integer>());
		if(CCP.isEmpty())
			s = "Cola Vacia, no hay pacientes registrados.";
		else {
			while(!CCP.isEmpty()) {
				try {
					s+=CCP.min().getValue().toString() + "<p>";
					colaAux.insert(CCP.min().getKey(), CCP.removeMin().getValue());
				} catch (EmptyPriorityQueueException | InvalidKeyException e) {e.printStackTrace();}
			}
			CCP = colaAux;
		}
		return s;
	}
	
	/**
	 * Devuelve un String en formato HTML con los datos de todos los
	 * pacientes registrados en la CCP de forma creciente.
	 * @return String con datos de todos los pacientes en forma creciente.
	 */
	public String listarPacientesInvertidos() {
		String s="";
		Stack<Persona> pila = new PilaEnlazada<Persona>();
		if(CCP.isEmpty())
			s += "Cola vacia:: No hay pacientes para listar.";
		else {
			while(!CCP.isEmpty()) {
				try {
					pila.push(CCP.removeMin().getValue());
				} catch (EmptyPriorityQueueException e) {e.printStackTrace();}
			}
			while(!pila.isEmpty()) {
				try {
					s+= pila.top().toString() + "<p>";
					CCP.insert(pila.top().getRisk(), pila.pop());
				}catch(TDAPila.EmptyStackException | TDAColaCP.InvalidKeyException e) {e.printStackTrace();}
			}
		}
		return s;
	}
	
	
	/**
	 * Elimina de la CCP el paciente que tenga DNI igual al param num pasado por parametro.
	 * El paciente eliminado se agrega al mapeo.
	 * @param num DNI de la persona que se quiere eliminar.
	 * @return True en caso de que el paciente se pudo eliminar, False en caso contrario
	 */
	public boolean eliminarPaciente(Integer num) {
		boolean esta = false;
		Heap<Integer,Persona> colaAux = new Heap<Integer,Persona>(new ComparadorPersona<Integer>());
		while(!CCP.isEmpty()) {
			try {
				if(CCP.min().getValue().getDNI() == num) {
					mapeo.put(CCP.min().getValue().getDNI(),CCP.removeMin().getValue());
					esta = true;
				}
				else {
					colaAux.insert(CCP.min().getKey(), CCP.removeMin().getValue());
				}
			} catch (EmptyPriorityQueueException | InvalidKeyException | TDAMapeo.InvalidKeyException e) {e.printStackTrace();}
		}
		CCP = colaAux;
		return esta;
	}
	
	/**
	 * Devuelve un String en formato HTML con la lista de los pacientes que hayan sido eliminados.
	 * @return String Con los Datos de los pacientes que hayan sido eliminados.
	 */
	public String pacientesHistoricos() {
		String s = "";
		if(mapeo.isEmpty())
			s = "No se han eliminado/dado de alta pacientes.";
		else {
			for(TDAMapeo.Entry<Integer,Persona> elem : mapeo.entries()) {
				s+=elem.getValue().toString() + "<p>";
			}
		}
		return s;
	}
}
