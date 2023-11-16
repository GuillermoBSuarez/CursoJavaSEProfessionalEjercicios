package service;

import java.util.ArrayList;

import model.Ciudad;

public class CiudadesService {
	ArrayList<Ciudad> ciudades = new ArrayList<>();
	
	public void guardarCiudad(String nombre, int habitantes, String pais) {
		ciudades.add(new Ciudad(nombre, habitantes, pais));
	}
	
	public Ciudad ciudadMasPoblada() {
		int habitantesMax = 0;
		Ciudad ciudad = null;
		for(Ciudad c:ciudades) {
			if(c.getHabitantes() > habitantesMax) {
				habitantesMax = c.getHabitantes();
				ciudad = c;
			}
		}
		return ciudad;
	}
	
	public ArrayList<Ciudad> ciudadesPorPais(String pais) {
		ArrayList<Ciudad> aux = new ArrayList<>();
		for(Ciudad c:ciudades) {
			if(pais.equals(c.getPais())){			// Si la ciudad es del pais buscado...
				aux.add(c);							// ...la añadimos a la nueva lista
			}
		}
		return aux;
	}
	
	public void eliminarCiudad(String nombre) {
		for(int i = 0; i < ciudades.size(); i++) {
			if(nombre.equals(ciudades.get(i).getNombre())) {
				ciudades.remove(i);
				break;
			}
		}
	}
}