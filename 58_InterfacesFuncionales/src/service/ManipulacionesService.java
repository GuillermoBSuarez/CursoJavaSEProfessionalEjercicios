package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ManipulacionesService {
	
	public int sumaPares(List<Integer> numeros) {		// Suma los pares.
		int suma = 0;
		for (Integer n:numeros) {
			if (n % 2 == 0) suma += n;
		}
		return suma;
	}

	public int sumaPositivos(List<Integer> numeros) {	// Suma los positivos.
		int suma = 0;
		for (Integer n:numeros) {
			if (n > 0) suma += n;
		}
		return suma;
	}
	
	/* Interfaz PREDICATE
	Método que suma los números de la colección que cumplan el criterio que también se pasa
	como parámetro y que es una clase que implementa el método funcional -test- de Predicate. */ 
	public int sumarCriterio(List<Integer> numeros, Predicate<Integer> criterio) {
		int suma = 0;
		for (Integer n:numeros) {
			if (criterio.test(n)) suma += n;
		}
		return suma;
	}
	
	/* Interfaz PREDICATE
	Método que recibe una colección de cadenas y devuelve una lista con las que cumplan
	con el predicado recibido como parámetro. */
	public List<String> obtenerCadenasCriterio(Collection<String> cadenas, Predicate<String> criterio) {
		List<String> datos = new ArrayList<>();
		for (String s:cadenas) {
			if (criterio.test(s)) datos.add(s);
		}
		return datos;
	}
	
	/* Interfaz CONSUMER
	Método que recibe una lista de enteros y hace con ellos lo indicado en la implementación de
	consumer.accept definida en la clase que implementa la interfaz Consumer. */
	public void procesaLista(List<Integer> numeros, Consumer<Integer> consumer) {
		for (Integer n:numeros) {
			consumer.accept(n);
		}
	}
		
	/* Interfaces COLLECTION, PREDICATE y CONSUMER
	Método que recibe lista de enteros, los filtra aplicándoles el Predicate recibido
	y con el resultado hace lo indicado por el Consumer recibido. */
	public void procesaEnteros (Collection<Integer> numeros,
								Predicate<Integer> criterio,
								Consumer<Integer> consumer) {
		for (Integer n:numeros) {
			if (criterio.test(n)) consumer.accept(n);
		}
	}
	
	/* Interfaz FUNCTION
	Método que recibe una colección de enteros y devuelve la suma de sus cuadrados,
	que es lo definido en la clase que implementa UnaryOperator y su método funcional apply. */
	public int sumaTransformacion(Collection<Integer> numeros, UnaryOperator<Integer> fun) {
		int suma = 0;
		for (Integer n:numeros ) {
			suma += fun.apply(n); // se acumula el resultado de operar el número
		}
		return suma;
	}
}