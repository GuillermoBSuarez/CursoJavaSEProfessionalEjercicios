package service;

import java.util.HashMap;

import model.Contacto;

public class AgendaService {
	HashMap<String,Contacto> agenda = new HashMap<String, Contacto>();
	
	public boolean agregar(String email, String nombre,int edad, int telefono) {
		if(!agenda.containsKey(email)) {
			Contacto contacto = new Contacto(nombre, email, edad, telefono);
			agenda.put(email, contacto);
			return true;
		}
		return false;
	}
	
	public boolean eliminar(String email) {
		if(agenda.containsKey(email)) {
			agenda.remove(email);
			return true;
		}
		return false;
	}
	
	public Contacto buscar(String email) {
		return agenda.get(email);
	}
	
	public Contacto[] contactos() {
		return agenda.values().toArray(new Contacto[0]);
	}	
}