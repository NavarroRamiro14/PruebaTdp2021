package Persona;


/**
 * Modela una persona en el problema.
 * @author Navarro Dupre
 *
 */
public class Persona {
	//Atributos de instancia
	private String name;
	private String surname;
	private int risk;
	private int dni;
	
	//Constructor
	public Persona(String name , String  surname, int dni , int risk){
		this.name	 = name;
		this.surname = surname;
		this.dni 	 = dni;
		this.risk 	 = risk;
	}
	
	/**
	 * Devuelve el nombre de la persona
	 * @return String con nombre de la persona
	 */
	public String getName() {return name;}
	
	/**
	 * Devuelve el apellido de la Persona
	 * @return
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Devuelve el DNI de la persona
	 * @return Integer con el DNI de la persona
	 */
	public int getDNI() {return dni;}
	
	/**
	 * Devuelve el Riesgo de la persona, escala de 5 a 1 siendo 5 el maximo y 1 el minimo riesgo
	 * @return Integer con el Riesgo de la persona
	 */
	public int getRisk() {return risk;}
	
	
	/**
	 * Devuelve un String con todos los datos de la Persona
	 */
	public String toString() {
		return "Nombre "+name+" "+surname+" DNI: "+dni+" Riesgo: "+risk;
	}




	
	
	
	
}
