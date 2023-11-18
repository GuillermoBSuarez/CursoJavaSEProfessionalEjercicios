package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Ciudad;

public class CiudadesService {
	
	List<Ciudad> ciudades = new ArrayList<>();
	
	public boolean altaCiudad(String nombre, String pais, long habitantes, Double temperaturaMedia) {
		if (ciudades.stream()
				.noneMatch(( c -> c.getNombre().equals(nombre)		// Comprueba que no exista. En tal caso...
							   && c.getPais().equals(pais)))) {
																	// ... la añade y devuelve true.
			return ciudades.add(new Ciudad(nombre, pais, habitantes, temperaturaMedia));
		}
		return false;												// Si ya existe, no graba y devuelve false.
	}
	
	public int totalCiudadesPais(String pais) {
		return (int) ciudades.stream()
				.filter( c -> c.getPais().equals(pais) )
				.count();
		/* Count devuelve un long pero la función lo castea y devuelve int, porque no tiene
		sentido usar una variable tan grande para este cálculo, no va a haber millones de ciudades
		en un único país. */
	}
	
	public int totalPaises() {
		return (int) ciudades.stream()
				.map( c -> c.getPais() )
				.distinct()
				.count();
	}
	
	// Indica si hay alguna ciudad con temperatura media inferior a la media.
	public boolean temperaturaInferior (double temperaturaMedia) {
		return ciudades.stream()
				.anyMatch( c -> c.getTemperaturaMedia() < temperaturaMedia );
	}
	
	public Ciudad buscaCiudad(String nombre) {
		return ciudades.stream()
				.filter( c -> c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);	/* Null porque la función devolverá lo que devuelva orElse,
								y debe ser un objeto Ciudad... o null si no existe. */
	}
	
	public Ciudad ciudadMasPoblada() {
		return ciudades.stream()
				.max( (a, b) -> Long.compare(a.getHabitantes(), b.getHabitantes()) )	// Devuelve Optional<Ciudad>
				.orElse(new Ciudad());
	}
	
	public double mediaHabitantesCiudadesPais(String pais) {
		return ciudades.stream()								// Stream<Ciudad>
				.filter( c -> c.getPais().equals(pais) )		// Stream<Ciudad>
				.mapToLong( c -> c.getHabitantes() )			// LongStream
				.average()										// OptionalDouble
				.orElse(0);										// double
	}
	
	public double temperaturaMasAlta() {
		return ciudades.stream()
				.mapToDouble( c -> c.getTemperaturaMedia() )
				.max()
				.orElse(0);
	}
}