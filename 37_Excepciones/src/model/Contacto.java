package model;

public class Contacto {
	private String nombre;
	private String email;
	private int edad;
	private int telefono;
	
	public Contacto(String nombre, String email, int edad, int telefono) {		// Constructor
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.telefono = telefono;
	}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public int getEdad() { return edad; }
	public void setEdad(int edad) { this.edad = edad; }

	public int getTelefono() { return telefono; }
	public void setTelefono(int telefono) { this.telefono = telefono; }	
}