package service;

import java.util.HashMap;

public class AgendaService {
	
	public HashMap<String, String> contactos = new HashMap<>();
	
	public boolean nuevo(String email, String nombre){
		if (!contactos.containsKey(email)) {
			contactos.put(email, nombre);
			return true;
		}
		return false;
	}
	
	public String busca(String email) {
		if (contactos.containsKey(email)) {
			return contactos.get(email);		// Devuelve el nombre: clave-email - valor-nombre
		}
		return null;
	}
	
	public boolean borra(String email) {
		if (contactos.containsKey(email)) {
			contactos.remove(email);
			return true;
		}
		return false;
	}
	
	public String[] listar(){
		return contactos.values().toArray(new String[0]);
	}
}